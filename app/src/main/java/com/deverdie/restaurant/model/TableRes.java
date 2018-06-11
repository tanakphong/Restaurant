package com.deverdie.restaurant.model;

public class TableRes {

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

    public TableRes(String code, String desc, String photo_path) {
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
