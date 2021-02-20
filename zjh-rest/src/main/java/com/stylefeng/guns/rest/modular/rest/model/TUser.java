package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelColumn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Description</p>
 * <p>个人基础信息表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/12
 */
@TableName("t_user")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 6082421693479664990L;
    // 主键id
    @ExcelColumn(value = "主键id", col = 1)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //创建时间
    @ExcelColumn(value = "创建时间", col = 2)
    private String create_time;
    //更新时间
    @ExcelColumn(value = "更新时间", col = 3)
    private String update_time;
    //用户姓名
    @ExcelColumn(value = "姓名", col = 4)
    @NotBlank(message = "姓名不能为空")
    private String name;
    //用户性别
    @NotNull(message = "性别不能为空")
    private Integer sex;
    @TableField(exist = false)
    @ExcelColumn(value = "性别", col = 5)
    private String sexName;
    //所属公司
    @ExcelColumn(value = "公司名称", col = 6)
    private String company;
    //职位
    @ExcelColumn(value = "职位", col = 7)
    private String job;
    //手机号码
    @ExcelColumn(value = "电话号码", col = 8)
    @NotBlank(message = "电话号码不能为空")
    private String phone;
    //电子邮箱
    @ExcelColumn(value = "电子邮箱", col = 9)
    private String email;
    //是否有跟随人员（0： 无  1：有）
    @NotNull(message = "跟随人员不能为空")
    private Integer follow;
    @TableField(exist = false)
    @ExcelColumn(value = "是否有跟随人员", col = 10)
    private String followName;
    //跟随人员姓名
    @ExcelColumn(value = "跟随人员姓名", col = 11)
    private String follow_name;
    //嘉宾对接人姓名
    @ExcelColumn(value = "嘉宾接待人姓名", col = 12)
    private String pick_up_user;
    //身份证类型（0：身份证   1：护照   2：港粤通行证）
    @NotNull(message = "证件类型")
    private Integer certificates;
    @ExcelColumn(value = "证件类型", col = 13)
    @TableField(exist = false)
    private String certificatesName;
    //是否需要陪同（0： 无  1：有）
    @NotNull(message = "是否需要陪同不能为空")
    private Integer accompany;
    @ExcelColumn(value = "是否需要陪同", col = 14)
    @TableField(exist = false)
    private String accompanyName;
    //是否需要翻译（0： 无  1：有）
    @NotNull(message = "是否需要翻译不能为空")
    private Integer translate;
    @ExcelColumn(value = "是否需要翻译", col = 15)
    @TableField(exist = false)
    private String translateName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
    }

    public String getCertificatesName() {
        return certificatesName;
    }

    public void setCertificatesName(String certificatesName) {
        this.certificatesName = certificatesName;
    }

    public String getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String translateName) {
        this.translateName = translateName;
    }

    public String getAccompanyName() {
        return accompanyName;
    }

    public void setAccompanyName(String accompanyName) {
        this.accompanyName = accompanyName;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", company='" + company + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", follow=" + follow +
                ", followName='" + followName + '\'' +
                ", follow_name='" + follow_name + '\'' +
                ", pick_up_user='" + pick_up_user + '\'' +
                ", certificates=" + certificates +
                ", certificatesName='" + certificatesName + '\'' +
                ", accompany=" + accompany +
                ", accompanyName='" + accompanyName + '\'' +
                ", translate=" + translate +
                ", translateName='" + translateName + '\'' +
                '}';
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
