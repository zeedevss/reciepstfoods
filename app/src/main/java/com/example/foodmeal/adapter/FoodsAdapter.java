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
import com.example.foodmeal.Foods;
import com.example.foodmeal.R;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder> {

    private ArrayList<Foods> dataList;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public FoodsAdapter(ArrayList<Foods> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public FoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_food, parent, false);
        return new FoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodsViewHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getFoodName());
        holder.textCategory.setText(dataList.get(position).getFoodCategory());
        Glide.with(holder.itemView.getContext())
                .load(dataList.get(position).getFoodImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.ivPhoto);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(dataList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class FoodsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, textCategory;
        private ImageView ivPhoto;
        public FoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_name_food);
            textCategory = itemView.findViewById(R.id.tv_category_food);
            ivPhoto = itemView.findViewById(R.id.img_food);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Foods data);
    }
}
