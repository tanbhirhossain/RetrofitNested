package com.example.retrofitnested;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/contacts/")
    Call<ApiResult> getMovies();
}
