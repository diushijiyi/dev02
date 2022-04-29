package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
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
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVO resultVO;
        List<MessageBoard> messageBoards;
        DataVO<MessageBoard> dataVO;
        if(id!=null){
            messageBoards=new ArrayList<>();
            MessageBoard messageBoard = messageBoardMapper.selectByPrimaryKey(id);

            if (messageBoard==null){

                dataVO=new DataVO<>(0L,messageBoards,pageNum,pageSize);
                resultVO=new ResultVO(4000,"查无此留言板",false,dataVO);

            }else {
                messageBoards.add(messageBoard);
                dataVO=new DataVO<>(1L,messageBoards,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该留言板",true,dataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            messageBoards= messageBoardMapper.selectByExample(null);
            PageInfo<MessageBoard> pageInfo = new PageInfo<>(messageBoards);
            dataVO=new DataVO<>(pageInfo.getTotal(),messageBoards,pageNum,pageSize);
            resultVO=new ResultVO(200,"留言板查询成功！！！",true,dataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(MessageBoardWithBLOBs messageBoard) {
        ResultVO vo;
        if(messageBoard.getCreateTime()==null){
            messageBoard.setCreateTime(new Date());
        }
        int affectedRows = messageBoardMapper.insertSelective(messageBoard);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加留言板成功",true,messageBoard);
        }else {
            vo=new ResultVO(5000,"添加留言板失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除留言板成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除留言板失败",false,null);
        }
        return vo;
    }
}
