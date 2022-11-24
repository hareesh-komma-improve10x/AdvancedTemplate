package com.improve10x.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplateActivity extends AppCompatActivity {
    public ArrayList<Template> template;
    public RecyclerView templateRv;
    public TemplateAdapter templateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        getSupportActionBar().setTitle("Template");
        setUpData();
        setUpTemplateList();
        fetchTasks();
    }

    private void fetchTasks() {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<List<Template>> call = templatesService.fetchTasks();
        call.enqueue(new Callback<List<Template>>() {
            @Override
            public void onResponse(Call<List<Template>> call, Response<List<Template>> response) {
                List<Template> templates = response.body();
                templateAdapter.setData(templates);

            }

            @Override
            public void onFailure(Call<List<Template>> call, Throwable t) {
                Toast.makeText(TemplateActivity.this, "Wrong", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void setUpTemplateList() {
        templateRv = findViewById(R.id.template_rv);
        templateRv.setLayoutManager(new LinearLayoutManager(this));
        templateAdapter = new TemplateAdapter();
        templateAdapter.setData(template);
        templateRv.setAdapter(templateAdapter);
    }

    private void setUpData() {
        template = new ArrayList<>();
        Template template1 = new Template();
        template1.title = "Power star";
        template1.message = "Craze ka Baap";
        template.add(template1);

        Template template2 = new Template();
        template2.title = "Ramcharan";
        template2.message = "Mega Power Star Ramcharan";
        template.add(template2);
    }
}