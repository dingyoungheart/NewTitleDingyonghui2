package com.dingyonghui.newtitledingyonghui.bean;

/**
 * Created by lx on 2017/2/23.
 */

public class VideoBean {


        /**
         * topicImg : http://vimg1.ws.126.net/image/snapshot/2017/2/T/8/VCC0MHMT8.jpg
         * videosource : 新媒体
         * mp4Hd_url : null
         * topicDesc : 直击心灵的音乐作品

         * topicSid : VCC0MHMT4
         * cover : http://vimg1.ws.126.net/image/snapshot/2017/2/Q/T/VCD1L9AQT.jpg
         * title : 街头修鞋匠改唱祁隆《等你等了那么久》感动无数人
         * playCount : 135
         * replyBoard : video_bbs
         * videoTopic : {"alias":"直击心灵的音乐作品","tname":"温柔耳边声","ename":"T1486735914446","tid":"T1486735914446","topic_icons":"http://img2.cache.netease.com/m/newsapp/topic_icons/T1486735914446.png"}
         * sectiontitle :
         * replyid : CB527HTI008535RB
         * description :
         * mp4_url : http://flv2.bn.netease.com/tvmrepo/2017/1/O/3/ECARHRKO3/SD/ECARHRKO3-mobile.mp4
         * length : 134
         * playersize : 1
         * m3u8Hd_url : null
         * vid : VCB527HTI
         * m3u8_url : http://flv2.bn.netease.com/tvmrepo/2017/1/O/3/ECARHRKO3/SD/movie_index.m3u8
         * ptime : 2017-01-27 09:03:00
         * topicName : 温柔耳边声
         */

        private String topicImg;
        private String videosource;
        private Object mp4Hd_url;
        private String topicDesc;
        private String topicSid;
        private String cover;
        private String title;
        private int playCount;
        private String replyBoard;
        private VideoTopicBean videoTopic;
        private String sectiontitle;
        private String replyid;
        private String description;
        private String mp4_url;
        private int length;
        private int playersize;
        private Object m3u8Hd_url;
        private String vid;
        private String m3u8_url;
        private String ptime;
        private String topicName;

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public Object getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(Object mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public Object getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(Object m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public static class VideoTopicBean {
            /**
             * alias : 直击心灵的音乐作品
             * tname : 温柔耳边声
             * ename : T1486735914446
             * tid : T1486735914446
             * topic_icons : http://img2.cache.netease.com/m/newsapp/topic_icons/T1486735914446.png
             */

            private String alias;
            private String tname;
            private String ename;
            private String tid;
            private String topic_icons;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }
        }
    }

