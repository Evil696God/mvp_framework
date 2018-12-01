package com.wcx.framework.mvpproject.common.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public interface Api {
    @GET("")
    Observable<List> search(@Query("") String query);
}
