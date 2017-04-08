package com.together.model.vo;

public class PersonVo {
    private Integer id;

    private String niCheng;

    private String touXiang;

    private Integer thirdId;

    private String mobile;

    private Integer age;

    private Integer sex;

    private String aiHao;

    private String sign;

    private Integer online;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNiCheng() {
        return niCheng;
    }

    public void setNiCheng(String niCheng) {
        this.niCheng = niCheng == null ? null : niCheng.trim();
    }

    public String getTouXiang() {
        return touXiang;
    }

    public void setTouXiang(String touXiang) {
        this.touXiang = touXiang == null ? null : touXiang.trim();
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAiHao() {
        return aiHao;
    }

    public void setAiHao(String aiHao) {
        this.aiHao = aiHao == null ? null : aiHao.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}