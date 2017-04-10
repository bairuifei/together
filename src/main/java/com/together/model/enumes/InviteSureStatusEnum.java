package com.together.model.enumes;

/**
 * Created by BRF on 2017-04-10.
 */
public enum InviteSureStatusEnum {
    UNKNOW(0,"未确认"),
    JOINED(1,"参加"),
    UNJOIN(2,"不参加");

    private int code;
    private String nane;

    public int getCode() {
        return code;
    }

    public String getNane() {
        return nane;
    }

    InviteSureStatusEnum(int code, String nane) {
        this.code = code;
        this.nane = nane;
    }
}
