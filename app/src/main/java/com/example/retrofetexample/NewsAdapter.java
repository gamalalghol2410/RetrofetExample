package com.example.retrofetexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
List<News.Article> newsList;

    public NewsAdapter(List<News.Article> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);
        NewsViewHolder newsViewHolder=new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News.Article article=newsList.get(position);
        holder.title.setText(article.getTitle());
        holder.auther.setText(article.getAuthor());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView title,auther;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            auther=itemView.findViewById(R.id.auther);

        }
    }
}
