package com.example.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.AttentionAdapter;
import com.example.base.BaseActivity;
import com.example.bean.Attention;
import com.example.mybanner.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AttentionActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mLeft_back;
    private TextView mTitle_bar;
    private TextView mSee_more;
    private RecyclerView mInterested_users_rlv;
    private RecyclerView mAttention_users_rlv;

    @Override
    protected int setLayout() {
        return R.layout.activity_attention;
    }

    @Override
    protected void setListener() {
        mLeft_back.setOnClickListener(this);
        mSee_more.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        String json = getJson("attention.json", this);
        Gson gson = new Gson();
        Attention attention = gson.fromJson(json, Attention.class);
        List<Attention.AttentionBean> list = attention.getAttention();
        mTitle_bar.setText("我的关注");

        LinearLayoutManager ll = new LinearLayoutManager(this);
        LinearLayoutManager ll1 = new LinearLayoutManager(this);
        AttentionAdapter adapter = new AttentionAdapter(list, this);
        mInterested_users_rlv.setLayoutManager(ll);
        mAttention_users_rlv.setLayoutManager(ll1);
        mInterested_users_rlv.setAdapter(adapter);
        mAttention_users_rlv.setAdapter(adapter);

    }

    @Override
    protected void initView() {
        mLeft_back = (ImageView) findViewById(R.id.left_back);
        mTitle_bar = (TextView) findViewById(R.id.title_bar);
        mSee_more = (TextView) findViewById(R .id.see_more);
        mInterested_users_rlv = (RecyclerView) findViewById(R.id.interested_users_rlv);
        mAttention_users_rlv = (RecyclerView) findViewById(R.id.attention_users_rlv);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                CloseActivity();
                break;
            case R.id.see_more:
                break;
            default:
                break;
        }
    }

    public String getJson(String fileName, Context context) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            AssetManager assets = context.getAssets();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assets.open(fileName)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
