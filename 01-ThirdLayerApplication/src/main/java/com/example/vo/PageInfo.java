package com.example.vo;

import javax.sound.sampled.Line;
import java.util.List;

public class PageInfo<T> {
    private int pageCount;
    private int totalCount;
    private int pageSize;
    private int pageNo;
    private List<T> list;
    public PageInfo(){
    }
    public PageInfo(int totalCount,int pageSize,int pageNo,List<T> list){
        this.totalCount=totalCount;
        this.pageSize=pageSize;
        this.pageNo=pageNo;
        this.list=list;

        if (totalCount%pageSize==0){
            this.pageCount=totalCount/pageSize;
        }else {

        }
    }
}
