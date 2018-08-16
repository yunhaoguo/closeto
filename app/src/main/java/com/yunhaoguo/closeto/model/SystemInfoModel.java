package com.yunhaoguo.closeto.model;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.model
 * 文件名:     SystemInfoModel
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/16 下午4:09
 * 描述:      系统信息模型
 */


public class SystemInfoModel {

    private int type;

    private String title;

    private String textKey;

    private String textValue;

    private String buttonKey;

    private String buttonValue;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextKey() {
        return textKey;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getButtonKey() {
        return buttonKey;
    }

    public void setButtonKey(String buttonKey) {
        this.buttonKey = buttonKey;
    }

    public String getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
    }
}
