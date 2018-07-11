package com.example.comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.mybanner.R;

import java.util.List;

/**
 * author:王庆
 * date：On 2018/7/11
 */
public class MyItem2Adapter extends RecyclerView.Adapter<MyItem2Adapter.MyHolder> {

    private List<Bean.CommentBean.ReplyBean> list;
    private Context context;

    public MyItem2Adapter(List<Bean.CommentBean.ReplyBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.comment_item2, viewGroup, false);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        Bean.CommentBean.ReplyBean replyBean = list.get(i);
        RequestOptions options = new RequestOptions().transform(new CircleCrop());
        Glide.with(context)
                .load(replyBean.getPicUrl())
                .apply(options)
                .into(myHolder.mHeadPortrait);
        myHolder.mNickName.setText(replyBean.getUser());
        myHolder.mContent.setText(replyBean.getTitle());
        myHolder.mTime.setText(replyBean.getTime());
        myHolder.mPraiseCount.setText(replyBean.getPraise());
        String user = replyBean.getUser();
        String time = replyBean.getTime();
        String praise = replyBean.getPraise();
        String title = replyBean.getTitle();
        String picUrl = replyBean.getPicUrl();

        Log.e("WQ", "user:" + user + ",time:" + time + ",praise:" + praise + ",title:" + title + ",picUrl:" + picUrl);
        myHolder.mReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "回复" + i, Toast.LENGTH_SHORT).show();
            }
        });
        myHolder.mPraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点赞" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final ImageView mHeadPortrait;
        private final ImageView mPraise;
        private final TextView mNickName;
        private final TextView mContent;
        private final TextView mTime;
        private final TextView mReply;
        private final TextView mPraiseCount;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mHeadPortrait = itemView.findViewById(R.id.headPortrait);
            mPraise = itemView.findViewById(R.id.praise);
            mNickName = itemView.findViewById(R.id.nickName);
            mContent = itemView.findViewById(R.id.content);
            mTime = itemView.findViewById(R.id.time);
            mReply = itemView.findViewById(R.id.reply);
            mPraiseCount = itemView.findViewById(R.id.praiseCount);
        }
    }
}
