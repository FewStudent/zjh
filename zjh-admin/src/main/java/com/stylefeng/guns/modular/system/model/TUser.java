package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.modular.system.util.ExcelColumn;

import java.io.Serializable;

/**
 * <p>
 * 个人信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@TableName("t_user")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private String updateTime;
    /**
     * 用户姓名
     */
    @ExcelColumn(value = "用户名", col = 1)
    private String name;
    /**
     * 性别（0：男  1：女）
     */
    @ExcelColumn(value = "性别（0：男  1：女）", col = 2)
    private Integer sex;
    /**
     * 性别名称.
     */
    @TableField(exist = false)
    private String sexName;
    /**
     * 公司/单位
     */
    @ExcelColumn(value = "公司单位", col = 3)
    private String company;
    /**
     * 职务
     */
    @ExcelColumn(value = "公司职务", col = 4)
    private String job;
    /**
     * 电话号码
     */
    @ExcelColumn(value = "电话号码", col = 5)
    private String phone;
    /**
     * 邮件
     */
    @ExcelColumn(value = "邮箱", col = 6)
    private String email;
    /**
     * 是否有跟随人员（ 0：否    1：是）
     */
    @ExcelColumn(value = "是否有跟随人员（ 0：否  1：是）", col = 7)
    private Integer follow;
    /**
     * 跟随人员姓名
     */
    @ExcelColumn(value = "跟随人姓名", col = 8)
    @TableField("follow_name")
    private String followName;
    /**
     * 嘉宾对接人姓名
     */
    @ExcelColumn(value = "嘉宾对接人", col = 9)
    @TableField("pick_up_user")
    private String pickUpUser;
    /**
     * 证件类型（0：贵宾证 1：嘉宾证  2：参观证）
     */
    @ExcelColumn(value = "证件类型（0：贵宾证 1：嘉宾证  2：参观证）", col = 10)
    private Integer certificates;
    /**
     * 证件类型名称（辅助字段）
     */
    @TableField(exist = false)
    private String certificatesName;
    /**
     * 是否需要陪同（  0：否    1：是）
     */
    @ExcelColumn(value = "是否需要陪同（0：否 1：是）", col = 11)
    private Integer accompany;
    /**
     * 陪同名称（辅助字段）
     */
    @TableField(exist = false)
    private String accompanyName;
    /**
     * 是否需要翻译（   0：否     1：是）
     */
    @ExcelColumn(value = "是否需要翻译（0：否 1：是）", col = 12)
    private Integer translate;

    /**
     * 是否需要翻译
     */
    @TableField(exist = false)
    private String translateName;

    @TableField("create_by")
    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
    }

    public String getPickUpUser() {
        return pickUpUser;
    }

    public void setPickUpUser(String pickUpUser) {
        this.pickUpUser = pickUpUser;
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

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", name=" + name +
                ", sex=" + sex +
                ", company=" + company +
                ", job=" + job +
                ", phone=" + phone +
                ", email=" + email +
                ", follow=" + follow +
                ", followName=" + followName +
                ", pickUpUser=" + pickUpUser +
                ", certificates=" + certificates +
                ", accompany=" + accompany +
                ", translate=" + translate +
                "}";
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getCertificatesName() {
        return certificatesName;
    }

    public void setCertificatesName(String certificatesName) {
        this.certificatesName = certificatesName;
    }

    public String getAccompanyName() {
        return accompanyName;
    }

    public void setAccompanyName(String accompanyName) {
        this.accompanyName = accompanyName;
    }

    public String getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String translateName) {
        this.translateName = translateName;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}
