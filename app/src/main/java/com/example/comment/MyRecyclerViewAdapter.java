package com.example.comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
 * date：On 2018/7/10
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolderType1> {

    private List<Bean.CommentBean> list;
    private Context context;

    public MyRecyclerViewAdapter(List<Bean.CommentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolderType1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.comment_item1, viewGroup, false);
        ViewHolderType1 viewHolder = new ViewHolderType1(inflate);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderType1 holder, final int i) {
        Bean.CommentBean commentBean = list.get(i);
        List<Bean.CommentBean.ReplyBean> reply = commentBean.getReply();
        RequestOptions options = new RequestOptions().transform(new CircleCrop());
        Glide.with(context)
                .load(commentBean.getPicUrl())
                .apply(options)
                .into(holder.mHeadPortrait);
        String praise = commentBean.getPraise();
        String time = commentBean.getTime();
        String title = commentBean.getTitle();
        String user = commentBean.getUser();
        Log.e("TAG", praise + time + title + user);

        holder.mNickName.setText(commentBean.getUser());
        holder.mContent.setText(commentBean.getTitle());
        holder.mTime.setText(commentBean.getTime());
        holder.mPraiseCount.setText(commentBean.getPraise() + "");
        MyItem2Adapter adapter = new MyItem2Adapter(reply, context);
        LinearLayoutManager ll = new LinearLayoutManager(context);
        holder.mRlv.setLayoutManager(ll);
        holder.mRlv.setAdapter(adapter);

        holder.mReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "回复" + i, Toast.LENGTH_SHORT).show();
            }
        });
        holder.mPraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点赞" + i, Toast.LENGTH_SHORT).show();
            }
        });

    }

//    @Override
//    public int getItemViewType(int position) {
//        for (int i = 0; i < list.size(); i++) {
//            List<Bean.CommentBean.ReplyBean> reply = list.get(i).getReply();
//            if (reply != null) {
//                return Type.TYPE1.ordinal();
//            } else {
//                return Type.TYPE2.ordinal();
//            }
//        }
//        return -1;
//    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolderType1 extends RecyclerView.ViewHolder {

        private final ImageView mHeadPortrait;
        private final ImageView mPraise;
        private final TextView mNickName;
        private final TextView mContent;
        private final TextView mTime;
        private final TextView mReply;
        private final TextView mPraiseCount;
        private final RecyclerView mRlv;

        public ViewHolderType1(@NonNull View itemView) {
            super(itemView);
            mHeadPortrait = itemView.findViewById(R.id.headPortrait);
            mPraise = itemView.findViewById(R.id.praise);
            mNickName = itemView.findViewById(R.id.nickName);
            mContent = itemView.findViewById(R.id.content);
            mTime = itemView.findViewById(R.id.time);
            mReply = itemView.findViewById(R.id.reply);
            mPraiseCount = itemView.findViewById(R.id.praiseCount);
            mRlv = itemView.findViewById(R.id.rlv);
        }
    }

}
