package com.deverdie.restaurant.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableRes {

    /**
     * return : true
     * message :
     * data : [{"id":"1","code":"1","desc":"โต๊ะกินข้าวไม้สไตล์โมเดิร์นที่คุณต้องอยากได้","photo_path":"http://pubmodule.space/admin/api/table/photos/1.jpg"},{"id":"2","code":"2","desc":"โต๊ะกินข้าวไม้แบบคลาสสิค","photo_path":"http://pubmodule.space/admin/api/table/photos/2.jpg"},{"id":"3","code":"3","desc":"โต๊ะกินข้าวโมเดิร์นแบบไม้และเหล็กผสมกัน","photo_path":"http://pubmodule.space/admin/api/table/photos/3.jpg"},{"id":"4","code":"4","desc":"โต๊ะกินข้าวไม้แบบทรงกรม","photo_path":"http://pubmodule.space/admin/api/table/photos/4.jpg"},{"id":"5","code":"5","desc":"โต๊ะกินข้าวโมเดิร์นแบบไม้เทียม","photo_path":"http://pubmodule.space/admin/api/table/photos/5.jpg"},{"id":"6","code":"6","desc":"โต๊ะกินข้าวไม้แบบยาวหรือแบบสี่เหลี่ยมผืนผ้า","photo_path":"http://pubmodule.space/admin/api/table/photos/6.jpg"}]
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
         * code : 1
         * desc : โต๊ะกินข้าวไม้สไตล์โมเดิร์นที่คุณต้องอยากได้
         * photo_path : http://pubmodule.space/admin/api/table/photos/1.jpg
         */

        private String id;
        private String code;
        private String desc;
        private String photo_path;

        public DataBean(String id, String code, String desc, String photo_path) {
            this.id = id;
            this.code = code;
            this.desc = desc;
            this.photo_path = photo_path;
        }

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

        public String getPhoto_path() {
            return photo_path;
        }

        public void setPhoto_path(String photo_path) {
            this.photo_path = photo_path;
        }
    }
}
