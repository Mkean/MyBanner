package com.example.comment;

import java.util.List;

/**
 * author:王庆
 * date：On 2018/7/10
 */
public class Bean {

    /**
     * code : 200
     * msg : success
     * comment : [{"id":0,"user":"大花","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_4e1ed310e8b3553d266bd619949ec01c3-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":8,"reply":[{"replyId":0,"user":"小欢欢","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d458e312c6ff6ca3126749ecd922dbf6-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":2,"commentID":0,"replayTo":0},{"replyId":1,"user":"小溪溪","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_2411c2dfab27e4411a27c16f4f87dd22-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":10,"commentID":0,"replayTo":1},{"replyId":2,"user":"小鱼鱼","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d6070ae4aa5f54ab6b544b5ad0c05e92-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":5,"commentID":0,"replayTo":2}]},{"id":1,"user":"大花","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_c319e31fd34fb215d17644f5b58a7734-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":10,"reply":[]},{"id":2,"user":"大花","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/05/m.xxxiao.com_e7e731faf790487ccaf90d11774fae6b-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":9,"reply":[]}]
     */

    private String code;
    private String msg;
    private List<CommentBean> comment;

    public Bean() {
    }

    public Bean(String code, String msg, List<CommentBean> comment) {
        this.code = code;
        this.msg = msg;
        this.comment = comment;
    }

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

    public List<CommentBean> getComment() {
        return comment;
    }

    public void setComment(List<CommentBean> comment) {
        this.comment = comment;
    }


    public static class CommentBean {
        /**
         * id : 0
         * user : 大花
         * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_4e1ed310e8b3553d266bd619949ec01c3-760x500.jpg
         * title : 我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭
         * time : 昨天 11:15
         * praise : 8
         * reply : [{"replyId":0,"user":"小欢欢","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d458e312c6ff6ca3126749ecd922dbf6-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":2,"commentID":0,"replayTo":0},{"replyId":1,"user":"小溪溪","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_2411c2dfab27e4411a27c16f4f87dd22-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":10,"commentID":0,"replayTo":1},{"replyId":2,"user":"小鱼鱼","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d6070ae4aa5f54ab6b544b5ad0c05e92-760x500.jpg","title":"我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭","time":"昨天 11:15","praise":5,"commentID":0,"replayTo":2}]
         */

        private String id;
        private String user;
        private String picUrl;
        private String title;
        private String time;
        private String praise;
        private List<ReplyBean> reply;

        public CommentBean() {
        }

        public CommentBean(String id, String user, String picUrl, String title, String time, String praise, List<ReplyBean> reply) {
            this.id = id;
            this.user = user;
            this.picUrl = picUrl;
            this.title = title;
            this.time = time;
            this.praise = praise;
            this.reply = reply;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public List<ReplyBean> getReply() {
            return reply;
        }

        public void setReply(List<ReplyBean> reply) {
            this.reply = reply;
        }

        public static class ReplyBean {
            /**
             * replyId : 0
             * user : 小欢欢
             * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_d458e312c6ff6ca3126749ecd922dbf6-760x500.jpg
             * title : 我就是喝的同款灰人，外加两颗美白片一个月已经完美逆袭
             * time : 昨天 11:15
             * praise : 2
             * commentID : 0
             * replayTo : 0
             */

            private String replyId;
            private String user;
            private String picUrl;
            private String title;
            private String time;
            private String praise;
            private String commentID;
            private String replayTo;

            public ReplyBean() {
            }

            public ReplyBean(String replyId, String user, String picUrl, String title, String time, String praise, String commentID, String replayTo) {
                this.replyId = replyId;
                this.user = user;
                this.picUrl = picUrl;
                this.title = title;
                this.time = time;
                this.praise = praise;
                this.commentID = commentID;
                this.replayTo = replayTo;
            }

            public String getReplyId() {
                return replyId;
            }

            public void setReplyId(String replyId) {
                this.replyId = replyId;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getPraise() {
                return praise;
            }

            public void setPraise(String praise) {
                this.praise = praise;
            }

            public String getCommentID() {
                return commentID;
            }

            public void setCommentID(String commentID) {
                this.commentID = commentID;
            }

            public String getReplayTo() {
                return replayTo;
            }

            public void setReplayTo(String replayTo) {
                this.replayTo = replayTo;
            }
        }
    }
}
