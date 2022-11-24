package com.improve10x.advancedtemplate;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TemplatesApi {
    public TemplatesService createTemplatesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TemplatesService templatesService = retrofit.create(TemplatesService.class);
        return templatesService;
    }
}
