package com.tangmo.xizhu.customer.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chamber
 * @date 2019/3/13.
 * @Description
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Page implements Serializable{

    private final static long serialVersionUID = 1L;
    private final static String ORDER_DESC = "desc";

    /** 页码, 从1开始 */
    protected Integer pageNum = 1;
    /** 每页大小 */
    protected Integer pageSize = 10;
    /** 总数 */
    protected Long total;
    /** 排序字段 */
    private String orderColumn;
    /** 排序方式 */
    private String orderDir = ORDER_DESC;
    /** 搜索内容 */
    private String searchValue;

    private List dataList;


    public Page(Integer pageNum, Integer pageSize){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    public Page(Integer pageNum, Integer pageSize, String orderColumn){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderColumn = orderColumn;
    }
    public Page(Integer pageNum, Integer pageSize, String orderColumn, String orderDir){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderColumn = orderColumn;
        this.orderDir = orderDir;
    }

    public void startPage() {
        if(this.orderDir != null && this.orderColumn != null){
            PageHelper.startPage(this.pageNum, this.pageSize, this.orderColumn + " " + this.orderDir);
        }else{
            PageHelper.startPage(this.pageNum, this.pageSize);
        }
    }


    /**
     * 如果分页查询的结果直接返回，则调用此方法
     *
     * @param list
     */
    public void setResult(List list) {
        PageInfo page = new PageInfo(list);
        setTotal(page.getTotal());
        setDataList(list);
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", orderColumn='" + orderColumn + '\'' +
                ", orderDir='" + orderDir + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", " + super.toString() +
                '}';
    }
}
