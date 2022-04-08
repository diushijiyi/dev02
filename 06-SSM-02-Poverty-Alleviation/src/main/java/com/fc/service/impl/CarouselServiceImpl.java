package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.entity.User;
import com.fc.service.CarouselService;
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
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Integer id) {
        ResultVO resultVO;
        List<Carousel> carousels;
        DataVO<Carousel> carouselDataVO;

        if(id!=null){
            carousels=new ArrayList<>();
            Carousel carousel = carouselMapper.selectByPrimaryKey(id);

            if (carousel==null){

                carouselDataVO=new DataVO<>(0L,carousels,pageNum,pageSize);
                resultVO=new ResultVO(4000,"查无此图",false,carouselDataVO);

            }else {
                carousels.add(carousel);
                carouselDataVO=new DataVO<>(1L,carousels,pageNum,pageSize);
                resultVO=new ResultVO(200,"查到了该图",true,carouselDataVO);
            }

        }else {
            PageHelper.startPage(pageNum,pageSize);
            carousels= carouselMapper.selectByExample(null);
            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
            carouselDataVO=new DataVO<>(pageInfo.getTotal(),carousels,pageNum,pageSize);
            resultVO=new ResultVO(200,"轮播图查询成功！！！",true,carouselDataVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(Carousel carousel) {
        ResultVO vo;
        if(carousel.getAvailable()==null){
            carousel.setAvailable(false);
        }
        int affectedRows = carouselMapper.insertSelective(carousel);
        if(affectedRows>0){
            vo=new ResultVO(1000,"添加图片成功",true,carousel);
        }else {
            vo=new ResultVO(5000,"添加图片失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO update(Carousel carousel) {
        int affectedRows = carouselMapper.updateByPrimaryKeySelective(carousel);
        ResultVO vo;
        if(affectedRows>0){
            carousel=carouselMapper.selectByPrimaryKey(carousel.getId());

            vo=new ResultVO(1000,"修改图片成功",true,carousel);
        }else {
            vo=new ResultVO(5000,"修改图片失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO delete(Integer id) {
        int affectedRows = carouselMapper.deleteByPrimaryKey(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"删除图片成功",true,null);
        }else {
            vo=new ResultVO(5000,"删除图片失败",false,null);
        }
        return vo;
    }

    @Override
    public ResultVO changeStatus(Integer id) {

        Integer affectedRows=carouselMapper.changeStatus(id);
        ResultVO vo;
        if(affectedRows>0){
            vo=new ResultVO(1000,"修改当前的状态成功",true,null);
        }else {
            vo=new ResultVO(5000,"修改当前的状态失败",false,null);
        }
        return vo;
    }
}
