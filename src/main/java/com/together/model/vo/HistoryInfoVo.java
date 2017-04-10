package com.together.model.vo;

import java.util.Date;
import java.util.Set;

public class HistoryInfoVo {
    private Integer id;

    private String content;

    private String location;

    private Date createtime;

    private Set<InfoPicVo> pics;

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
}