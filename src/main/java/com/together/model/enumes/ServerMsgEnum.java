package com.together.model.enumes;

/**
 * Created by BRF on 2017-04-11.
 */
public enum ServerMsgEnum {
    //系统级别
    SUCCESS(0,"成功"),
    FAIL(-1,"系统正忙，请稍后重试"),
    FILTER_ERROR(-2,"数据被篡改"),

    //运行级别
    //图片上传相关
    UPLOADED(1,"上传成功"),
    UNUPLOAD(2,"上传失败"),

    //邀请相关
    INVITESAVED(53,"邀请已发出"),
    INVITEUNSAVE(54,"邀请未能成功发出"),
    INVITECANCELED(55,"邀请成功取消"),
    INVITEUNCANCEL(56,"邀请未能成功取消"),
    INVITEJOINED(57,"成功参加邀请"),
    INVITEUNJOIN(58,"未能成功参加邀请"),
    INVITEUNJOINED(59,"成功拒绝邀请"),
    INVITEUNUNJOIN(60,"未能成功拒绝邀请"),


    //个人相关
    PERSONSAVED(100,"注册成功"),
    PERSONUNSAVE(101,"注册失败"),
    PERSONUPDATED(102,"个人信息更新成功"),
    PERSONUNUPDATE(103,"个人信息更新失败"),
    HISTORYSAVED(104,"历史状态保存成功"),
    HISTORYUNSAVE(105,"历史状态保存失败"),
    RELATIONSAVED(106,"成功建立好友关系"),
    RELATIONUNSAVE(107,"建立好友关系失败"),
    RELATIONDELED(108,"成功解除好友关系"),
    RELATIONUNDEL(109,"解除好友关系失败"),
    APPLYSAVED(110,"好友申请发送成功"),
    APPLYUNSAVED(111,"好友申请发送失败"),
    LOGINED(112,"登陆成功"),
    UNLOGIN(113,"登陆失败"),
    PERSONEXIST(114,"手机号已注册，请修改后重试！"),





    ;

    private int serverCode;
    private String serverMsg;

    public int getServerCode() {
        return serverCode;
    }

    public String getServerMsg() {
        return serverMsg;
    }

    ServerMsgEnum(int serverCode, String serverMsg) {
        this.serverCode = serverCode;
        this.serverMsg = serverMsg;
    }
}
