package com.dingyonghui.newtitledingyonghui.bean;

import java.util.List;

/**
 * Created by cj on 2017/2/14.
 */

public class JokeBean {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"何师傅气呼呼的找到老板说：\u201c你看人家别的厂，工资、福利年年都长，你再看我们，这些年什么也没长！\u201d老板招了招手，示意让何师傅坐下，然后语重心长的跟何师傅说：\u201c何师傅哇！这怎么可能呢，你看你哈，这些年是年龄长了脾气也长了。。。\u201d","hashId":"26ff612688e2c80b27a6bc7142a8b1cb","unixtime":1487034230,"updatetime":"2017-02-14 09:03:50"},{"content":"小侄女不知为啥在哭，懒得理她，所以就坐在一边微信聊天。老妈走过来：宝宝哭听不到吗？聊得这么欢，是不是谈对象了？正在哭着的小侄女插嘴了：奶奶，一看就知道叔叔没有谈对象呢！老妈：小丫头片子，你懂什么啊？你怎么知道叔叔没有谈对象？小侄女：看到女孩子哭都不知道哄，能有对象？","hashId":"01468dd50bf4203de760f86b3979c514","unixtime":1487034230,"updatetime":"2017-02-14 09:03:50"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * content : 何师傅气呼呼的找到老板说：“你看人家别的厂，工资、福利年年都长，你再看我们，这些年什么也没长！”老板招了招手，示意让何师傅坐下，然后语重心长的跟何师傅说：“何师傅哇！这怎么可能呢，你看你哈，这些年是年龄长了脾气也长了。。。”
             * hashId : 26ff612688e2c80b27a6bc7142a8b1cb
             * unixtime : 1487034230
             * updatetime : 2017-02-14 09:03:50
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
