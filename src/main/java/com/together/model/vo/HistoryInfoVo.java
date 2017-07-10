package com.together.model.vo;

import java.util.Date;
import java.util.Set;

public class HistoryInfoVo {
    private Integer id;

    private Integer myId;

    private String content;

    private String location;

    private Date createtime;

    private Set<InfoPicVo> pics;

    private String niCheng;

    private String touXiang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Set<InfoPicVo> getPics() {
        return pics;
    }

    public void setPics(Set<InfoPicVo> pics) {
        this.pics = pics;
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

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }
}