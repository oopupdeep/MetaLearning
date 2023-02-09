package com.metalearning.base.model;
import lombok.Data;
import lombok.ToString;
import lombok.extern.java.Log;

@Data
@ToString
public class PageParams {
    public static final long DEFAULT_PAGE_CURRENT = 1L;
    public static final long DEFAULT_PAGE_SIZE = 10L;
    //当前页码
    private Long pageNo = DEFAULT_PAGE_CURRENT;
    //每页记录数默认值
    private Long pageSize = DEFAULT_PAGE_SIZE;
    public PageParams(){
    }
    public PageParams(long pageNo,long pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
