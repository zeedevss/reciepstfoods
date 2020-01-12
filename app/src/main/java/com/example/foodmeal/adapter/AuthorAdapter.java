package com.example.foodmeal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodmeal.Author;
import com.example.foodmeal.R;

import java.util.ArrayList;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    private ArrayList<Author> dataList;

    public AuthorAdapter(ArrayList<Author> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_author, parent, false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getNameAuthor());
        holder.txtEmail.setText(dataList.get(position).getEmailAuthor());
        holder.txtIg.setText(dataList.get(position).getIgAuthor());
//        Glide.with(holder.itemView.getContext())
//                .load(Author.getImageAuthor())
//                .apply(new RequestOptions().override(55, 55))
//                .into(holder.imgAuthor);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class AuthorViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtEmail, txtIg;
        //private ImageView imgAuthor;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_author_name);
            txtEmail = itemView.findViewById(R.id.tv_author_email);
            txtIg = itemView.findViewById(R.id.tv_author_ig);
            //imgAuthor = itemView.findViewById(R.id.img_author);
        }
    }
}