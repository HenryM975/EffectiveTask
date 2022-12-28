package com.example.effectivetask;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;



import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;


public interface TestRetrofit {
    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")//"https://run.mocky.io/"https://run.mocky.io/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149"
    Call<QR3Data> getList();
}
