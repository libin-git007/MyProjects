package com.li.org.entity;

/*请求参数封装类*/
public class RequestData<T> {
    /*每页数量*/
    private String pageSize;
    /*当前页*/
    private String pageNum;
    /*请求参数*/
    private T requestData;

    public String getPageSize() {
        return pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public T getRequestData() {
        return requestData;
    }

    public RequestData(T requestData,String pageSize,String pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.requestData = requestData;
    }
}
