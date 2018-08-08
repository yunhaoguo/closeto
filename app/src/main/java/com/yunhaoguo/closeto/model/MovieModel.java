package com.yunhaoguo.closeto.model;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.model
 * 文件名:     MovieModel
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/8 下午4:14
 * 描述:      主页电影模板
 */


import java.util.List;

public class MovieModel {

    /**
     * res : 0
     * data : {"id":"111","title":"危城","indexcover":"http://image.wufazhuce.com/Fj-7h07feacvFMScpboXXHEbQ5zD","detailcover":"http://image.wufazhuce.com/FgJrW4-aUCxYoBWn02nLqus1dJtH","video":"http://music.wufazhuce.com/lhRDhmuf3pwDSFxp5_hnt1zupEgK","verse":"","verse_en":"","score":"68","revisedscore":"0","review":"当前用户评分：68","keywords":"死国可乎;乱世英豪录;阵容颇豪华;一座城的生与死;打打打炸炸炸","movie_id":"258875130","info":"导演: 陈木胜\r\n编剧: 陈木胜\r\n主演: 刘青云/古天乐/彭于晏/吴京/袁泉/江疏影/廖启智/释彦能\r\n类型: 动作/武侠/古装\r\n制片国家/地区: 中国内地/中国香港","officialstory":"时值国家内战、军阀割据的乱世时代，军阀少帅曹少璘（古天乐饰）因杀害三条人命，被普城保卫团团长杨克难（刘青云饰) 绳之于法。可曹家财雄势大，以强权震慑居民，曹家上校张亦（吴京饰）得悉事件后，赶来普城取人，在城中遇上多年不见师弟马锋（彭于晏饰），马锋是位武功高强的浪人，路见不平欲拔刀相助，可是却面临正义与兄弟情之抉择。","hide_flag":"0","charge_edt":"（责任编辑：朱洪）","web_url":"http://m.wufazhuce.com/movie/111","praisenum":0,"sort":"0","releasetime":"2016-08-12 00:00:00","scoretime":"2016-08-13 00:00:00","maketime":"2016-08-09 21:00:00","last_update_date":"2016-08-09 17:04:24","read_num":"72800","directors":"","editor_email":"","related":"","directors_id":"","start_video":"","media_type":"2","poster":"","photo":["http://image.wufazhuce.com/FtpTH9E9isOQ_bu8rNH4iTsJHJq6","http://image.wufazhuce.com/FkvKmY6uhJa1gn4YUpCQKTSTHzPh","http://image.wufazhuce.com/Ft8ZixFdnKnKO9aFuXnY7ymCaZER","http://image.wufazhuce.com/FrU5tcZFLOmZKKJAy8d11qjUinmg","http://image.wufazhuce.com/Ft-f_kiuo_WrdpREnZQt8hZeMjdE","http://image.wufazhuce.com/FjLdgpHUcmxaFdNTjGL8V_Tgt5DH","http://image.wufazhuce.com/Frjk1AYTXBUotWIUAyaTnzq-3hK2","http://image.wufazhuce.com/Fhz_ZI0RH6byVvsxsdro9fXOptAI","http://image.wufazhuce.com/FlYLS6iOMgKHkGZkZYMPT6nSn1bd","http://image.wufazhuce.com/FrHUTi3P-3-kZqTvKLysQjL0ORg2"],"next_id":"112","previous_id":"110","tag_list":[],"share_list":{"wx":{"title":"电影 | 建一座城，等一个人","desc":"文/肉山大魔王 \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=singlemessage","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""},"wx_timeline":{"title":"电影 | 建一座城，等一个人","desc":"文/肉山大魔王 \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=timeline","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""},"weibo":{"title":"ONE一个《电影 | 建一座城，等一个人》 文/肉山大魔王： \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便是人们生存的那些城。城不叫\u201c城市\u2026 阅读全文：http://m.wufazhuce.com/movie/111?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874","desc":"","link":"http://m.wufazhuce.com/movie/111?channel=weibo","imgUrl":"","audio":""},"qq":{"title":"建一座城，等一个人","desc":"\n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=qq","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}},"sharenum":91,"commentnum":204,"servertime":1533715061}
     */

    private int res;
    private DataBean data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 111
         * title : 危城
         * indexcover : http://image.wufazhuce.com/Fj-7h07feacvFMScpboXXHEbQ5zD
         * detailcover : http://image.wufazhuce.com/FgJrW4-aUCxYoBWn02nLqus1dJtH
         * video : http://music.wufazhuce.com/lhRDhmuf3pwDSFxp5_hnt1zupEgK
         * verse :
         * verse_en :
         * score : 68
         * revisedscore : 0
         * review : 当前用户评分：68
         * keywords : 死国可乎;乱世英豪录;阵容颇豪华;一座城的生与死;打打打炸炸炸
         * movie_id : 258875130
         * info : 导演: 陈木胜
         编剧: 陈木胜
         主演: 刘青云/古天乐/彭于晏/吴京/袁泉/江疏影/廖启智/释彦能
         类型: 动作/武侠/古装
         制片国家/地区: 中国内地/中国香港
         * officialstory : 时值国家内战、军阀割据的乱世时代，军阀少帅曹少璘（古天乐饰）因杀害三条人命，被普城保卫团团长杨克难（刘青云饰) 绳之于法。可曹家财雄势大，以强权震慑居民，曹家上校张亦（吴京饰）得悉事件后，赶来普城取人，在城中遇上多年不见师弟马锋（彭于晏饰），马锋是位武功高强的浪人，路见不平欲拔刀相助，可是却面临正义与兄弟情之抉择。
         * hide_flag : 0
         * charge_edt : （责任编辑：朱洪）
         * web_url : http://m.wufazhuce.com/movie/111
         * praisenum : 0
         * sort : 0
         * releasetime : 2016-08-12 00:00:00
         * scoretime : 2016-08-13 00:00:00
         * maketime : 2016-08-09 21:00:00
         * last_update_date : 2016-08-09 17:04:24
         * read_num : 72800
         * directors :
         * editor_email :
         * related :
         * directors_id :
         * start_video :
         * media_type : 2
         * poster :
         * photo : ["http://image.wufazhuce.com/FtpTH9E9isOQ_bu8rNH4iTsJHJq6","http://image.wufazhuce.com/FkvKmY6uhJa1gn4YUpCQKTSTHzPh","http://image.wufazhuce.com/Ft8ZixFdnKnKO9aFuXnY7ymCaZER","http://image.wufazhuce.com/FrU5tcZFLOmZKKJAy8d11qjUinmg","http://image.wufazhuce.com/Ft-f_kiuo_WrdpREnZQt8hZeMjdE","http://image.wufazhuce.com/FjLdgpHUcmxaFdNTjGL8V_Tgt5DH","http://image.wufazhuce.com/Frjk1AYTXBUotWIUAyaTnzq-3hK2","http://image.wufazhuce.com/Fhz_ZI0RH6byVvsxsdro9fXOptAI","http://image.wufazhuce.com/FlYLS6iOMgKHkGZkZYMPT6nSn1bd","http://image.wufazhuce.com/FrHUTi3P-3-kZqTvKLysQjL0ORg2"]
         * next_id : 112
         * previous_id : 110
         * tag_list : []
         * share_list : {"wx":{"title":"电影 | 建一座城，等一个人","desc":"文/肉山大魔王 \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=singlemessage","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""},"wx_timeline":{"title":"电影 | 建一座城，等一个人","desc":"文/肉山大魔王 \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=timeline","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""},"weibo":{"title":"ONE一个《电影 | 建一座城，等一个人》 文/肉山大魔王： \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便是人们生存的那些城。城不叫\u201c城市\u2026 阅读全文：http://m.wufazhuce.com/movie/111?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874","desc":"","link":"http://m.wufazhuce.com/movie/111?channel=weibo","imgUrl":"","audio":""},"qq":{"title":"建一座城，等一个人","desc":"\n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=qq","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}}
         * sharenum : 91
         * commentnum : 204
         * servertime : 1533715061
         */

        private String id;
        private String title;
        private String indexcover;
        private String detailcover;
        private String video;
        private String verse;
        private String verse_en;
        private String score;
        private String revisedscore;
        private String review;
        private String keywords;
        private String movie_id;
        private String info;
        private String officialstory;
        private String hide_flag;
        private String charge_edt;
        private String web_url;
        private int praisenum;
        private String sort;
        private String releasetime;
        private String scoretime;
        private String maketime;
        private String last_update_date;
        private String read_num;
        private String directors;
        private String editor_email;
        private String related;
        private String directors_id;
        private String start_video;
        private String media_type;
        private String poster;
        private String next_id;
        private String previous_id;
        private ShareListBean share_list;
        private int sharenum;
        private int commentnum;
        private int servertime;
        private List<String> photo;
        private List<?> tag_list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIndexcover() {
            return indexcover;
        }

        public void setIndexcover(String indexcover) {
            this.indexcover = indexcover;
        }

        public String getDetailcover() {
            return detailcover;
        }

        public void setDetailcover(String detailcover) {
            this.detailcover = detailcover;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVerse() {
            return verse;
        }

        public void setVerse(String verse) {
            this.verse = verse;
        }

        public String getVerse_en() {
            return verse_en;
        }

        public void setVerse_en(String verse_en) {
            this.verse_en = verse_en;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getRevisedscore() {
            return revisedscore;
        }

        public void setRevisedscore(String revisedscore) {
            this.revisedscore = revisedscore;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getMovie_id() {
            return movie_id;
        }

        public void setMovie_id(String movie_id) {
            this.movie_id = movie_id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getOfficialstory() {
            return officialstory;
        }

        public void setOfficialstory(String officialstory) {
            this.officialstory = officialstory;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public void setHide_flag(String hide_flag) {
            this.hide_flag = hide_flag;
        }

        public String getCharge_edt() {
            return charge_edt;
        }

        public void setCharge_edt(String charge_edt) {
            this.charge_edt = charge_edt;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getReleasetime() {
            return releasetime;
        }

        public void setReleasetime(String releasetime) {
            this.releasetime = releasetime;
        }

        public String getScoretime() {
            return scoretime;
        }

        public void setScoretime(String scoretime) {
            this.scoretime = scoretime;
        }

        public String getMaketime() {
            return maketime;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public String getRead_num() {
            return read_num;
        }

        public void setRead_num(String read_num) {
            this.read_num = read_num;
        }

        public String getDirectors() {
            return directors;
        }

        public void setDirectors(String directors) {
            this.directors = directors;
        }

        public String getEditor_email() {
            return editor_email;
        }

        public void setEditor_email(String editor_email) {
            this.editor_email = editor_email;
        }

        public String getRelated() {
            return related;
        }

        public void setRelated(String related) {
            this.related = related;
        }

        public String getDirectors_id() {
            return directors_id;
        }

        public void setDirectors_id(String directors_id) {
            this.directors_id = directors_id;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public String getMedia_type() {
            return media_type;
        }

        public void setMedia_type(String media_type) {
            this.media_type = media_type;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getNext_id() {
            return next_id;
        }

        public void setNext_id(String next_id) {
            this.next_id = next_id;
        }

        public String getPrevious_id() {
            return previous_id;
        }

        public void setPrevious_id(String previous_id) {
            this.previous_id = previous_id;
        }

        public ShareListBean getShare_list() {
            return share_list;
        }

        public void setShare_list(ShareListBean share_list) {
            this.share_list = share_list;
        }

        public int getSharenum() {
            return sharenum;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public int getServertime() {
            return servertime;
        }

        public void setServertime(int servertime) {
            this.servertime = servertime;
        }

        public List<String> getPhoto() {
            return photo;
        }

        public void setPhoto(List<String> photo) {
            this.photo = photo;
        }

        public List<?> getTag_list() {
            return tag_list;
        }

        public void setTag_list(List<?> tag_list) {
            this.tag_list = tag_list;
        }

        public static class ShareListBean {
            /**
             * wx : {"title":"电影 | 建一座城，等一个人","desc":"文/肉山大魔王 \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=singlemessage","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}
             * wx_timeline : {"title":"电影 | 建一座城，等一个人","desc":"文/肉山大魔王 \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=timeline","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}
             * weibo : {"title":"ONE一个《电影 | 建一座城，等一个人》 文/肉山大魔王： \n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便是人们生存的那些城。城不叫\u201c城市\u2026 阅读全文：http://m.wufazhuce.com/movie/111?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874","desc":"","link":"http://m.wufazhuce.com/movie/111?channel=weibo","imgUrl":"","audio":""}
             * qq : {"title":"建一座城，等一个人","desc":"\n以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便\u2026","link":"http://m.wufazhuce.com/movie/111?channel=qq","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","audio":""}
             */

            private WxBean wx;
            private WxTimelineBean wx_timeline;
            private WeiboBean weibo;
            private QqBean qq;

            public WxBean getWx() {
                return wx;
            }

            public void setWx(WxBean wx) {
                this.wx = wx;
            }

            public WxTimelineBean getWx_timeline() {
                return wx_timeline;
            }

            public void setWx_timeline(WxTimelineBean wx_timeline) {
                this.wx_timeline = wx_timeline;
            }

            public WeiboBean getWeibo() {
                return weibo;
            }

            public void setWeibo(WeiboBean weibo) {
                this.weibo = weibo;
            }

            public QqBean getQq() {
                return qq;
            }

            public void setQq(QqBean qq) {
                this.qq = qq;
            }

            public static class WxBean {
                /**
                 * title : 电影 | 建一座城，等一个人
                 * desc : 文/肉山大魔王
                 以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便…
                 * link : http://m.wufazhuce.com/movie/111?channel=singlemessage
                 * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
                 * audio :
                 */

                private String title;
                private String desc;
                private String link;
                private String imgUrl;
                private String audio;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getAudio() {
                    return audio;
                }

                public void setAudio(String audio) {
                    this.audio = audio;
                }
            }

            public static class WxTimelineBean {
                /**
                 * title : 电影 | 建一座城，等一个人
                 * desc : 文/肉山大魔王
                 以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便…
                 * link : http://m.wufazhuce.com/movie/111?channel=timeline
                 * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
                 * audio :
                 */

                private String title;
                private String desc;
                private String link;
                private String imgUrl;
                private String audio;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getAudio() {
                    return audio;
                }

                public void setAudio(String audio) {
                    this.audio = audio;
                }
            }

            public static class WeiboBean {
                /**
                 * title : ONE一个《电影 | 建一座城，等一个人》 文/肉山大魔王：
                 以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便是人们生存的那些城。城不叫“城市… 阅读全文：http://m.wufazhuce.com/movie/111?channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874
                 * desc :
                 * link : http://m.wufazhuce.com/movie/111?channel=weibo
                 * imgUrl :
                 * audio :
                 */

                private String title;
                private String desc;
                private String link;
                private String imgUrl;
                private String audio;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getAudio() {
                    return audio;
                }

                public void setAudio(String audio) {
                    this.audio = audio;
                }
            }

            public static class QqBean {
                /**
                 * title : 建一座城，等一个人
                 * desc :
                 以前看诸如《三国演义》《水浒传》之类的古装电视剧，觉得最无法理解的便…
                 * link : http://m.wufazhuce.com/movie/111?channel=qq
                 * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
                 * audio :
                 */

                private String title;
                private String desc;
                private String link;
                private String imgUrl;
                private String audio;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getAudio() {
                    return audio;
                }

                public void setAudio(String audio) {
                    this.audio = audio;
                }
            }
        }
    }
}
