package com.together.model.po;

public class Relation {
    private Integer id;

    private Integer myId;

    private Integer friendId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Relation() {
    }

    public Relation(Integer myId, Integer friendId) {
        this.myId = myId;
        this.friendId = friendId;
    }
}