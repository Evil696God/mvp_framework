package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.recyclerinterface;

/**
 * @author wangchenxing
 * @data 1/12/2018 4:07 PM
 * @description 列表item点击接口
 */
public interface RecyclerViewOnItemClickListener<DataType> {
    public abstract void onClick(DataType dataType);
}
