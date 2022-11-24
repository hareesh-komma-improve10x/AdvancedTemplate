package com.improve10x.advancedtemplate;

import com.google.gson.annotations.SerializedName;

public class Template {
    public String title;
    @SerializedName("description")
    public String message;
}
