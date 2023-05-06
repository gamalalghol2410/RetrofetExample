package com.example.retrofetexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.retrofetexample.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Retrofit retrofit;
ApiInterFace apiInterFace;
ActivityMainBinding binding;
final String API_KEY="65e0acaf02e946d5ab9a8076ffafd2de";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String baseUrl="https://newsapi.org/v2/";

        retrofit = new  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();


        apiInterFace=retrofit.create(ApiInterFace.class);

        apiInterFace.getNews("eg","health",API_KEY).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
              News news=  response.body();
              List<News.Article> articlesArray=news.getArticles();
                NewsAdapter newsAdapter=new NewsAdapter(articlesArray);
                RecyclerView.LayoutManager linearLayout=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
                binding.news.setLayoutManager(linearLayout);
                binding.news.setAdapter(newsAdapter);


                for (int i=0;i<articlesArray.size();i++){
                    News.Article article=articlesArray.get(i);
                }

            }
            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(MainActivity.this, "فشل جلب الاخبار", Toast.LENGTH_SHORT).show();
            }
        });

    }
}