package com.example.retrofetexample;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterFace {
    @GET("top-headlines")
    Call<News> getNews(@Query("country") String country,
                       @Query("category") String category,
                               @Query("apiKey")String apiKey);

 /*@GET("users/4")
Call<ResponseBody> getUser();
 @GET("users")
    Call<ResponseBody> getPage(@Query("page") int page);
    @GET("users/{id}")
    Call<ResponseBody> getUser(@Path("id") int id);
  */
    /*
    @GET("users/{id}")
    Call<ResponseBody> getUser(@Path("id") int id);
    @GET("users/{id}")
    Call<User> getUser(@Path("id") int id);
@GET("users")
Call<ResponseBody> getPage(@Query("page") int page);*/
}
