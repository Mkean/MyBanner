package com.example.comment;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * author:王庆
 * date：On 2018/7/10
 */
public class JsonArray {
    private List<Bean.CommentBean> commentList = new ArrayList<>();
    private List<Bean.CommentBean.ReplyBean> replyBeanList = new ArrayList<>();

    public Bean returnBean(Context context) {
        String json = getJson("Comment.json", context);
        try {
            JSONObject jsonObject = new JSONObject(json);
            int code = jsonObject.optInt("code");
            String msg = jsonObject.optString("msg");

            JSONArray jsonArray = jsonObject.optJSONArray("comment");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject Object = jsonArray.optJSONObject(i);
                int id = Object.optInt("id");
                String user = Object.optString("user");
                String picUrl = Object.optString("picUrl");
                String title = Object.optString("title");
                String time = Object.optString("time");
                int praise = Object.optInt("praise");


                JSONArray reply = Object.optJSONArray("reply");
                for (int j = 0; j < reply.length(); j++) {
                    JSONObject replyJSONObject = reply.optJSONObject(j);
                    int replyId = replyJSONObject.optInt("replyId");
                    String replyUser = replyJSONObject.optString("replyUser");
                    String replyPicUrl = replyJSONObject.optString("replyPicUrl");
                    String replyTitle = replyJSONObject.optString("replyTitle");
                    String replyTime = replyJSONObject.optString("replyTime");
                    int replyPraise = replyJSONObject.optInt("replyPraise");
                    int replyCommentID = replyJSONObject.optInt("replyCommentID");
                    int replayTo = replyJSONObject.optInt("replayTo");
                    Bean.CommentBean.ReplyBean replyBean = new Bean.CommentBean.ReplyBean(String.valueOf(replyId), replyUser, replyPicUrl, replyTitle, replyTime, String.valueOf(replyPraise), String.valueOf(replyCommentID), String.valueOf(replayTo));
                    replyBeanList.add(replyBean);
                }

                Bean.CommentBean commentBean = new Bean.CommentBean(String.valueOf(id), user, picUrl, title, time, String.valueOf(praise), replyBeanList);

                commentList.add(commentBean);
            }

            Bean bean = new Bean(String.valueOf(code), msg, commentList);
            if (bean != null) {
                return bean;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
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
