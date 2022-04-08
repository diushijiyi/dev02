package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
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
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerMapper;
    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if(lastClickTime==null){
            lastClickTime=new Date();
        }
        Integer affectedRows=volunteerMapper.click(id,lastClickTime);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"扶贫志愿者招聘浏览量加1成功",true,null);
        }else {
            vo=new ResultVO(5000,"扶贫志愿者招聘浏览量加1失败",false,null);
        }
        return vo;

    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVO resultVO;
        List<VolunteerRecruitment> volunteers;
        DataVO<VolunteerRecruitment> volunteerDataVO;
        if(id!=null){
            volunteers=new ArrayList<>();
            VolunteerRecruitment volunteer = volunteerMapper.selectByPrimaryKey(id);

            if (volunteer==null){

                volunteerDataVO=new DataVO<>(0L,volunteers,pageNum,pageSize);
                resultVO=new ResultVO(4000,"没有这条志愿者招聘信息",false,volunteerDataVO);

            }else {
                click(volunteer.getId(),null);
                volunteer.setClickNum(volunteer.getClickNum()+1);
                volunteers.add(volunteer);
                volunteerDataVO=new DataVO<>(1L,volunteers,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该招聘信息",true,volunteerDataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            volunteers= volunteerMapper.selectByExampleWithBLOBs(null);

            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>();
            volunteerDataVO=new DataVO<>(pageInfo.getTotal(),volunteers,pageNum,pageSize);
            resultVO=new ResultVO(200,"志愿者招聘信息查询成功！！！",true,volunteerDataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(VolunteerRecruitment volunteer) {
        ResultVO vo;
        if(volunteer.getCreateTime()==null){
            volunteer.setCreateTime(new Date());
        }
        volunteer.setClickNum(0);
        volunteer.setLastClickTime(null);
        int affectedRows = volunteerMapper.insertSelective(volunteer);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加志愿者招聘信息成功",true,volunteer);
        }else {
            vo=new ResultVO(5000,"添加志愿者招聘信息失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO update(VolunteerRecruitment volunteer) {
        int affectedRows = volunteerMapper.updateByPrimaryKeySelective(volunteer);
        ResultVO vo;
        if(affectedRows>0){
            volunteer=volunteerMapper.selectByPrimaryKey(volunteer.getId());

            vo=new ResultVO(1000,"修改志愿者招聘信息成功",true,volunteer);
        }else {
            vo=new ResultVO(5000,"修改志愿者招聘信息失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = volunteerMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除志愿者招聘信息成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除志愿者招聘信息失败",false,null);
        }
        return vo;
    }
}
