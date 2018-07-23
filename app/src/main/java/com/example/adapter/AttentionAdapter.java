package com.example.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bean.Attention;
import com.example.mybanner.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author:王庆
 * date：On 2018/7/20
 */
public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.AttentionHolder> {
    private List<Attention.AttentionBean> list;
    private Context context;

    public AttentionAdapter(List<Attention.AttentionBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AttentionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.attention_item, viewGroup, false);
        AttentionHolder attentionHolder = new AttentionHolder(inflate);
        return attentionHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttentionHolder holder, int i) {
        holder.attention_item_interested_users_1_img.setImageURI(list.get(i).getPicUrl());
        holder.attention_item_interested_users_1_name1.setText(list.get(i).getNickName());
        holder.attention_item_interested_users_1_article1.setText(list.get(i).getArticleCount() + "篇文章");
        holder.attention_item_interested_users_1_fans1.setText(list.get(i).getFansCount() + "个粉丝");

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class AttentionHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView attention_item_interested_users_1_img;
        private final TextView attention_item_interested_users_1_name1;
        private final TextView attention_item_interested_users_1_fans1;
        private final TextView attention_item_interested_users_1_article1;
        private final Button attention_item_interested_users_1_attention1;

        public AttentionHolder(@NonNull View itemView) {
            super(itemView);
            attention_item_interested_users_1_img = itemView.findViewById(R.id.attention_item_interested_users_1_img);
            attention_item_interested_users_1_name1 = itemView.findViewById(R.id.attention_item_interested_users_1_name1);
            attention_item_interested_users_1_article1 = itemView.findViewById(R.id.attention_item_interested_users_1_article1);
            attention_item_interested_users_1_fans1 = itemView.findViewById(R.id.attention_item_interested_users_1_fans1);
            attention_item_interested_users_1_attention1 = itemView.findViewById(R.id.attention_item_interested_users_1_attention1);
        }
    }
}
