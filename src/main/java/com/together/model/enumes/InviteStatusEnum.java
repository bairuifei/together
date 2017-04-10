package com.together.model.enumes;

/**
 * Created by BRF on 2017-04-10.
 */
public enum InviteStatusEnum {
    SENDED(0,"已发出"),
    DOING(1,"进行中"),
    DONE(2,"已结束"),
    CANCELED(3,"已取消");

    private int code;
    private String name;
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    InviteStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
