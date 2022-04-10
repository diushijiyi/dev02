package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if(lastClickTime==null){
            lastClickTime=new Date();
        }
        Integer affectedRows=poorMapper.click(id,lastClickTime);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"播放量加1成功",true,null);
        }else {
            vo=new ResultVO(5000,"播放量加1失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVO resultVO;
        List<Poor> poors;
        DataVO<Poor> dataVO;
        if(id!=null){
            poors=new ArrayList<>();
            Poor poor = poorMapper.selectByPrimaryKey(id);

            if (poor==null){

                dataVO=new DataVO<>(0L,poors,pageNum,pageSize);
                resultVO=new ResultVO(4000,"没有这条贫困户信息",false,dataVO);

            }else {
                click(poor.getId(),null);
                poor.setClickNum(poor.getClickNum()+1);
                poors.add(poor);
                dataVO=new DataVO<>(1L,poors,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该信息",true,dataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            poors= poorMapper.selectByExample(null);

            PageInfo<Poor> pageInfo = new PageInfo<>();
            dataVO=new DataVO<>(pageInfo.getTotal(),poors,pageNum,pageSize);
            resultVO=new ResultVO(200,"贫困户信息查询成功！！！",true,dataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(PoorWithBLOBs poor) {
        ResultVO vo;
        if(poor.getCreateTime()==null){
            poor.setCreateTime(new Date());
        }
        poor.setClickNum(0);
        poor.setLastClickTime(null);
        int affectedRows = poorMapper.insertSelective(poor);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加信息成功",true,poor);
        }else {
            vo=new ResultVO(5000,"添加信息失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO update(PoorWithBLOBs poor) {
        int affectedRows = poorMapper.updateByPrimaryKeySelective(poor);
        ResultVO vo;
        if(affectedRows>0){
            poor=poorMapper.selectByPrimaryKey(poor.getId());

            vo=new ResultVO(1000,"修改信息成功",true,poor);
        }else {
            vo=new ResultVO(5000,"修改信息失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = poorMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除信息成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除信息失败",false,null);
        }
        return vo;
    }
}
