package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.NoteService;
import com.fc.vo.NoteVO;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper noteMapper;
    @Override
    public NoteVO findById(Integer id) {
        return noteMapper.findById(id);
    }

    @Override
    public ResultVO update(TbNote note) {
        ResultVO vo=new ResultVO();
        if (note.getPubTime()==null){
            note.setPubTime(new Date());
        }
        int affectedRows = noteMapper.updateByPrimaryKeyWithBLOBs(note);
        if (affectedRows>0){
            vo.setCode(1);
            vo.setSuccess(true);
        }else {
            vo.setCode(0);
            vo.setSuccess(false);
            vo.setMessage("更新日记失败");
            vo.setData(note);
        }
        return vo;
    }

    @Override
    public ResultVO add(TbNote note) {
        ResultVO resultVO=new ResultVO();
        note.setPubTime(new Date());
        int affectedRows = noteMapper.insertSelective(note);
        if (affectedRows>0){
            resultVO.setCode(1);
            resultVO.setSuccess(true);
            resultVO.setMessage("添加成功");
        }else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("添加失败");
            resultVO.setData(note);
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Integer id) {
        ResultVO vo=new ResultVO();
        int affectedRows = noteMapper.deleteByPrimaryKey(id);
        if (affectedRows>0){
            vo.setCode(1);
        }else {
            vo.setCode(0);
        }
        return vo;
    }
}
