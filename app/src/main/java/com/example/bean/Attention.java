package com.example.bean;

import java.util.List;

/**
 * author:王庆
 * date：On 2018/7/20
 */
public class Attention {


    /**
     * code : 200
     * msg : success
     * attention : [{"id":"0","nickName":"大卫船长","picUrl":"http://image.hnol.net/c/2017-02/17/21/201702172156117381-5460615.jpg","articleCount":"101","fansCount":"2012","state":"0"},{"id":"1","nickName":"沙海","picUrl":"http://image.hnol.net/c/2017-02/18/11/201702181120536541-1876615.jpg","articleCount":"101","fansCount":"2012","state":"0"},{"id":"2","nickName":"小鱼儿","picUrl":"http://image.hnol.net/c/2017-02/18/11/201702181135372911-5459938.jpg","articleCount":"101","fansCount":"2012","state":"0"},{"id":"3","nickName":"Alina","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_36c5f34ae18312e8e70df822a73558bd-683x1024.jpg","articleCount":"101","fansCount":"2012","state":"1"},{"id":"4","nickName":"王维","picUrl":"http://image.hnol.net/c/2017-02/27/15/20170227151846451-1876615.jpg","articleCount":"101","fansCount":"2012","state":"1"},{"id":"5","nickName":"吴邪","picUrl":"http://image.hnol.net/c/2016-04/05/14/20160405140325571-2089977.jpg","articleCount":"101","fansCount":"2012","state":"1"}]
     */

    private String code;
    private String msg;
    private List<AttentionBean> attention;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<AttentionBean> getAttention() {
        return attention;
    }

    public void setAttention(List<AttentionBean> attention) {
        this.attention = attention;
    }

    public static class AttentionBean {
        /**
         * id : 0
         * nickName : 大卫船长
         * picUrl : http://image.hnol.net/c/2017-02/17/21/201702172156117381-5460615.jpg
         * articleCount : 101
         * fansCount : 2012
         * state : 0
         */

        private String id;
        private String nickName;
        private String picUrl;
        private String articleCount;
        private String fansCount;
        private String state;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getArticleCount() {
            return articleCount;
        }

        public void setArticleCount(String articleCount) {
            this.articleCount = articleCount;
        }

        public String getFansCount() {
            return fansCount;
        }

        public void setFansCount(String fansCount) {
            this.fansCount = fansCount;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
