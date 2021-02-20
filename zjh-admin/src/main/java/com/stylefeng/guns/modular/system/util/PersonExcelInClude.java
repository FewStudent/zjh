package com.stylefeng.guns.modular.system.util;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/17
 */
public class PersonExcelInClude {

    /*---------------------- 基础用户信息  ./start-----------------------*/
    @ExcelColumn(value = "姓名", col = 1)
    private String name;
    //用户性别
    @ExcelColumn(value = "性别（0：女 1：男）", col = 2)
    private Integer sex;
    //所属公司
    @ExcelColumn(value = "公司名称", col = 3)
    private String company;
    //职位
    @ExcelColumn(value = "职位", col = 4)
    private String job;
    //手机号码
    @ExcelColumn(value = "电话号码", col = 5)
    private String phone;
    //电子邮箱
    @ExcelColumn(value = "电子邮箱", col = 6)
    private String email;
    //是否有跟随人员（0： 无  1：有）
    @ExcelColumn(value = "是否有跟随人员（0：无  1：有）", col = 7)
    private Integer follow;
    //跟随人员姓名
    @ExcelColumn(value = "跟随人员姓名", col = 8)
    private String follow_name;
    //嘉宾对接人姓名
    @ExcelColumn(value = "嘉宾接待人姓名", col = 9)
    private String pick_up_user;
    //身份证类型（0：身份证   1：护照   2：港粤通行证）
    @ExcelColumn(value = "证件类型（0：贵宾证 1：嘉宾证  2：参观证）", col = 10)
    private Integer certificates;
    //是否需要陪同（0： 无  1：有）
    @ExcelColumn(value = "是否需要陪同（0：否 1：是）", col = 11)
    private Integer accompany;
    //是否需要翻译（0： 无  1：有）
    @ExcelColumn(value = "是否需要翻译（0：否 1：是）", col = 12)
    private Integer translate;
    /*---------------------- 基础用户信息  ./end-----------------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public String getFollow_name() {
        return follow_name;
    }

    public void setFollow_name(String follow_name) {
        this.follow_name = follow_name;
    }

    public String getPick_up_user() {
        return pick_up_user;
    }

    public void setPick_up_user(String pick_up_user) {
        this.pick_up_user = pick_up_user;
    }

    public Integer getCertificates() {
        return certificates;
    }

    public void setCertificates(Integer certificates) {
        this.certificates = certificates;
    }

    public Integer getAccompany() {
        return accompany;
    }

    public void setAccompany(Integer accompany) {
        this.accompany = accompany;
    }

    public Integer getTranslate() {
        return translate;
    }

    public void setTranslate(Integer translate) {
        this.translate = translate;
    }
}
