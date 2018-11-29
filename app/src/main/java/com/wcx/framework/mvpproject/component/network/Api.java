package com.wcx.framework.mvpproject.component.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("")
    Observable<?> search(@Query("") String query);
}
