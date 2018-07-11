package com.example.comment;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.mybanner.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private ImageView mLeftBack;
    private TextView mTitle;
    private RecyclerView mRlv;
    private ImageView mHeadPortrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        initData();
    }

    private void initData() {

        RequestOptions options = new RequestOptions().transform(new CircleCrop());
        Glide.with(this)
                .load("http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_4e1ed310e8b3553d266bd619949ec01c3-760x500.jpg")
                .apply(options)
                .into(mHeadPortrait);
        String json = getJson("Comment.json", this);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(json, Bean.class);
        if (bean.getCode().equals("200")) {
            List<Bean.CommentBean> list = bean.getComment();
            MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(list, this);
            LinearLayoutManager ll = new LinearLayoutManager(this);
            mRlv.setLayoutManager(ll);
            mRlv.setAdapter(adapter);
        }
    }

    private void initView() {
        mLeftBack = (ImageView) findViewById(R.id.left_back);
        mTitle = (TextView) findViewById(R.id.title);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mHeadPortrait = (ImageView) findViewById(R.id.headPortrait);
    }


    public static String getJson(String fileName, Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
