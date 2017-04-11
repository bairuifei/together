package com.together.model;

/**
 * Created by BRF on 2017-04-11.
 */
public class ResultInfo {
    private boolean result;
    private int serverCode;
    private String serverMsg;
    private Object data;

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    public void setServerMsg(String serverMsg) {
        this.serverMsg = serverMsg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public int getServerCode() {
        return serverCode;
    }

    public String getServerMsg() {
        return serverMsg;
    }

    public Object getData() {
        return data;
    }

    public ResultInfo(boolean result, int serverCode, String serverMsg, Object data) {
        this.result = result;
        this.serverCode = serverCode;
        this.serverMsg = serverMsg;
        this.data = data;
    }

    public ResultInfo() {
    }
}
