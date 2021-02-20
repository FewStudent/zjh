package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelColumn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Description</p>
 * <p>管理员表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/13
 */
@TableName("sys_admin")
public class SysAdmin extends Model<SysAdmin> {

    // 序列号
    private static final long serialVersionUID = 168093248067404192L;
    //主键id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //创建时间
    private String create_time;
    //更新时间
    private String update_time;
    //性别（0：女  1：男）
    @ExcelColumn(value = "性别", col = 1)
    @NotNull(message = "性别不能为空")
    private Integer sex;
    //部门名称
    @ExcelColumn(value = "部门名称", col = 2)
    private String department;
    //职位
    @ExcelColumn(value = "职位", col = 3)
    private String job;
    //联系人手机号码
    @ExcelColumn(value = "手机号码", col = 4)
    private String phone;
    //账号
    @NotBlank(message = "账号不能为空")
    @ExcelColumn(value = "账号", col = 5)
    private String account;
    //密码
    @NotBlank(message = "密码不能为空")
    @ExcelColumn(value = "密码", col = 6)
    private String password;
    //加密盐
    private String salt;
    //是否录入员（0：不是  1：是）
    @ExcelColumn(value = "是否录入员", col = 7)
    @NotNull(message = "是否录入员不能为空")
    private Integer enter;
    //是否审核员（0：不是   1:是）
    @NotNull(message = "是否执行员不能为空")
    @ExcelColumn(value = "是否执行员", col = 8)
    private Integer examine;
    // 是否操作员（0：不是  1：是）
    @ExcelColumn(value = "是否操作员", col = 9)
    @NotNull(message = "是否操作员不能为空")
    private Integer operation;
    // 是否执行员（0：不是  1：是）
    @ExcelColumn(value = "是否执行员", col = 10)
    @NotNull(message = "是否执行员不能为空")
    private Integer implement;
    // 是否拥有菜单权限（0：不是  1：是）
    @ExcelColumn(value = "是否有住房菜单权限", col = 11)
    @NotNull(message = "是否有住房权限不能为空")
    private Integer house;
    //是否拥有用餐权限（0：不是  1：是）
    @ExcelColumn(value = "是否有用餐菜单权限", col = 12)
    @NotNull(message = "是否有用餐权限不能为空")
    private Integer meals;
    // 是否拥有用车权限（0：不是  1：是）
    @ExcelColumn(value = "是否有用车菜单权限", col = 13)
    @NotNull(message = "是否有用车权限不能为空")
    private Integer car;
    //是否是超级管理员（0：不是  1：是）
    @ExcelColumn(value = "是否超级管理员", col = 14)
    private Integer admin;
    //姓名
    @NotBlank(message = "姓名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnter() {
        return enter;
    }

    public void setEnter(Integer enter) {
        this.enter = enter;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getImplement() {
        return implement;
    }

    public void setImplement(Integer implement) {
        this.implement = implement;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getMeals() {
        return meals;
    }

    public void setMeals(Integer meals) {
        this.meals = meals;
    }

    public Integer getCar() {
        return car;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "SysAdmin{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", sex=" + sex +
                ", department='" + department + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", enter=" + enter +
                ", examine=" + examine +
                ", operation=" + operation +
                ", implement=" + implement +
                ", house=" + house +
                ", meals=" + meals +
                ", car=" + car +
                ", admin=" + admin +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
