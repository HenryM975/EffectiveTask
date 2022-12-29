package com.example.effectivetask;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfaceQR4 {
    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    Single<QR4Data> getList(); //Single for rx
}
