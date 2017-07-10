package com.together.model.vo;

public class FriendApplyVo {
    private Integer id;

    private Integer toId;

    private Integer fromId;

    private String node;

    private Integer state;

    private String niCheng;

    private String touXiang;

    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNiCheng() {
        return niCheng;
    }

    public void setNiCheng(String niCheng) {
        this.niCheng = niCheng;
    }

    public String getTouXiang() {
        return touXiang;
    }

    public void setTouXiang(String touXiang) {
        this.touXiang = touXiang;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}