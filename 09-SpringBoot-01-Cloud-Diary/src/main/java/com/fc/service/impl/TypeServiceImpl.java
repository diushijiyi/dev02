package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteExample;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.TypeService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper typeMapper;
    @Autowired
    private TbNoteMapper noteMapper;
    @Override
    public List<TbNoteType> getTypes(Integer id) {
        TbNoteTypeExample example = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return typeMapper.selectByExample(example);
    }

    @Override
    public ResultVO add(TbNoteType type) {
        ResultVO vo = new ResultVO();
        int affectedRows = typeMapper.insertSelective(type);
        if (affectedRows>0){
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setMessage("添加成功");
            vo.setData(type.getId());
        }else {
            vo.setCode(0);
            vo.setSuccess(false);
            vo.setMessage("添加失败");
        }
        return vo;
    }

    @Override
    public ResultVO update(TbNoteType type) {
        ResultVO vo = new ResultVO();
        int affectedRows = typeMapper.updateByPrimaryKeySelective(type);
        if (affectedRows>0){
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setMessage("修改成功");
            vo.setData(type.getId());
        }else {
            vo.setCode(0);
            vo.setSuccess(false);
            vo.setMessage("修改失败");
        }
        return vo;
    }

    @Override
    public int delete(Integer id) {
        int result=0;
        TbNoteExample example = new TbNoteExample();
        TbNoteExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(id);
        List<TbNote> notes = noteMapper.selectByExample(example);
        if (notes.size()>0){
            result=-1;
        }
        int affectedRows = typeMapper.deleteByPrimaryKey(id);
        if (affectedRows>0){
            result=1;
        }
        return result;
    }
}
