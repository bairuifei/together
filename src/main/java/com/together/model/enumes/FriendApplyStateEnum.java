package com.together.model.enumes;

/**
 * Created by BRF on 2017-04-10.
 */
public enum FriendApplyStateEnum {
    UNDONE(0,"未处理"),
    ACCEPT(1,"接受"),
    REFUSE(2,"拒绝");

    private int code;
    private String name;
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    FriendApplyStateEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
