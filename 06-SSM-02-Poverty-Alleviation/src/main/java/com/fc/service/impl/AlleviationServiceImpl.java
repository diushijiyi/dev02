package com.fc.service.impl;

import com.fc.controller.AlleviationController;
import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.User;
import com.fc.service.AlleviationService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVO resultVO;
        List<Alleviation> alleviations;
        DataVO<Alleviation> alleviationDataVO;
        if(id!=null){
            alleviations=new ArrayList<>();
            Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);

            if (alleviation==null){

                alleviationDataVO=new DataVO<>(0L,alleviations,pageNum,pageSize);
                resultVO=new ResultVO(4000,"没有这条扶贫政策",false,alleviationDataVO);

            }else {
                click(alleviation.getId(),null);
                alleviation.setClickNum(alleviation.getClickNum()+1);
                alleviations.add(alleviation);
                alleviationDataVO=new DataVO<>(1L,alleviations,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该政策",true,alleviationDataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            alleviations= alleviationMapper.selectByExample(null);

            PageInfo<Alleviation> pageInfo = new PageInfo<>();
            alleviationDataVO=new DataVO<>(pageInfo.getTotal(),alleviations,pageNum,pageSize);
            resultVO=new ResultVO(200,"扶贫政策查询成功！！！",true,alleviationDataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(Alleviation alleviation) {
        ResultVO vo;
        if(alleviation.getCreateTime()==null){
            alleviation.setCreateTime(new Date());
        }
        alleviation.setClickNum(0);
        alleviation.setLastClickTime(null);
        int affectedRows = alleviationMapper.insertSelective(alleviation);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加政策成功",true,alleviation);
        }else {
            vo=new ResultVO(5000,"添加政策失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO update(Alleviation alleviation) {
        int affectedRows = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        ResultVO vo;
        if(affectedRows>0){
            alleviation=alleviationMapper.selectByPrimaryKey(alleviation.getId());

            vo=new ResultVO(1000,"修改政策成功",true,alleviation);
        }else {
            vo=new ResultVO(5000,"修改政策失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = alleviationMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除政策成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除政策失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if(lastClickTime==null){
            lastClickTime=new Date();
        }
        Integer affectedRows=alleviationMapper.click(id,lastClickTime);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"播放量加1成功",true,null);
        }else {
            vo=new ResultVO(5000,"播放量加1失败",false,null);
        }
        return vo;

    }
}
