package com.deverdie.restaurant.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuRes {

    /**
     * return : true
     * message :
     * data : [{"id":"1","code":"BO0001","desc":"แกงจืดเต้าหู้ข่","price":"50","photo":"http://pubmodule.space/admin/api/menu/photos/BO0001.jpg"},{"id":"2","code":"PU0001","desc":"ข้าวผัดหมู","price":"40","photo":"http://pubmodule.space/admin/api/menu/photos/PU0001.jpg"},{"id":"3","code":"PU0002","desc":"ข้าวผัดไก่","price":"40","photo":"http://pubmodule.space/admin/api/menu/photos/PU0002.jpg"}]
     */

    @SerializedName("return")
    private boolean returnX;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * code : BO0001
         * desc : แกงจืดเต้าหู้ข่
         * price : 50
         * photo : http://pubmodule.space/admin/api/menu/photos/BO0001.jpg
         */

        private String id;
        private String code;
        private String desc;
        private String price;
        private String photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
