package com.durga.balaji66.signupusingretrofitpostrequest.Models;

import com.durga.balaji66.signupusingretrofitpostrequest.User;
import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    public DefaultResponse()
    {

    }
    @SerializedName("error")
    private boolean err;
    @SerializedName("message")
    private String msg;
    @SerializedName("user")
    private User user;
    public DefaultResponse(boolean error, String message, User user)
    {
        this.err =error;
        this.msg =message;
        this.user =user;
    }

    public boolean isError() {
        return err;
    }

    public String getMessage() {
        return msg;
    }

    public User getUser() {
        return user;
    }
}
