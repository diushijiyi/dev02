package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.entity.User;
import com.fc.service.CollectionService;
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
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVO resultVO;
        List<Collection> collections;
        DataVO<Collection> dataVO;
        if(id!=null){
            collections=new ArrayList<>();
            Collection collection = collectionMapper.selectByPrimaryKey(id);

            if (collection==null){

                dataVO=new DataVO<>(0L,collections,pageNum,pageSize);
                resultVO=new ResultVO(4000,"查无此收藏表",false,dataVO);

            }else {
                collections.add(collection);
                dataVO=new DataVO<>(1L,collections,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该收藏表",true,dataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            collections= collectionMapper.selectByExample(null);
            PageInfo<Collection> pageInfo = new PageInfo<>(collections);
            dataVO=new DataVO<>(pageInfo.getTotal(),collections,pageNum,pageSize);
            resultVO=new ResultVO(200,"收藏表查询成功！！！",true,dataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(Collection collection) {
        ResultVO vo;
        if(collection.getCreateTime()==null){
            collection.setCreateTime(new Date());
        }
        int affectedRows = collectionMapper.insertSelective(collection);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加收藏表成功",true,collection);
        }else {
            vo=new ResultVO(5000,"添加收藏表失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO update(Collection collection) {
        int affectedRows = collectionMapper.updateByPrimaryKeySelective(collection);
        ResultVO vo;
        if(affectedRows>0){
            collection=collectionMapper.selectByPrimaryKey(collection.getId());

            vo=new ResultVO(1000,"修改收藏表成功",true,collection);
        }else {
            vo=new ResultVO(5000,"修改收藏表失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = collectionMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除收藏表成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除收藏表失败",false,null);
        }
        return vo;
    }
}
