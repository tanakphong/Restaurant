package com.deverdie.restaurant.model;

import com.google.gson.annotations.SerializedName;

public class LoginRes {

    /**
     * return : true
     * message :
     * data : {"usr_id":"6","usr_code":"CMR-18050002","guid":"28f49889e9177da7ae4875d7a46a878b"}
     */

    @SerializedName("return")
    private boolean returnX;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public boolean isReturnX() {
        return returnX;
    }

    public void setReturnX(boolean returnX) {
        this.returnX = returnX;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * usr_id : 6
         * usr_code : CMR-18050002
         * guid : 28f49889e9177da7ae4875d7a46a878b
         */

        @SerializedName("usr_id")
        private String usr_id;
        @SerializedName("usr_code")
        private String usr_code;
        @SerializedName("guid")
        private String guid;

        public String getUsr_id() {
            return usr_id;
        }

        public void setUsr_id(String usr_id) {
            this.usr_id = usr_id;
        }

        public String getUsr_code() {
            return usr_code;
        }

        public void setUsr_code(String usr_code) {
            this.usr_code = usr_code;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }
    }
}
