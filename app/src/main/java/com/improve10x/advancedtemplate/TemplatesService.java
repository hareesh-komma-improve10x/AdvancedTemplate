package com.improve10x.advancedtemplate;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface TemplatesService {
    @GET("templates")
    Call<List<Template>> fetchTasks();
}


