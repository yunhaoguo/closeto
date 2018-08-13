package com.yunhaoguo.closeto.entity;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.entity
 * 文件名:     Constant
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/1 下午4:49
 * 描述:      常量
 */


public class Constant {

    //闪屏页跳转到主页的handler所需的code
    public static final int SPLASH_DELAY_CODE = 1001;

    //主页中精选接口
    public static final String HOME_SELECT_URL = "http://v3.wufazhuce.com:8000/api/hp/more/0";

    //音乐列表
    public static final String HOME_MUSIC_LIST_URL = "http://v3.wufazhuce.com:8000/api/music/idlist/0";

    //歌曲详情 后面需要加上歌曲id
    public static final String HOME_MUSIC_MORE_URL = "http://v3.wufazhuce.com:8000/api/music/detail/";

    //电影列表
    public static final String HOME_MOVIE_LIST_URL = "http://v3.wufazhuce.com:8000/api/channel/movie/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";

    //电影详情 111处为电影id
    //public static final String HOME_MOIVE_MORE_URL = "http://v3.wufazhuce.com:8000/api/movie/detail/111/?channel=wdj&source=channel_movie&source_id=9240&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";

    //天气BaseUrl
    public static final String WEATHER_BASE_URL = "https://free-api.heweather.com/";

    //和风天气key
    public static final String WEATHER_KEY = "996a2aec4bf34ea2a300a8cf58a35d30";

    public static final String DB_USER_ACCOUNT = "account.db";
}
