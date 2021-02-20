package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelColumn;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description</p>
 * <p>个人用餐表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/13
 */
@TableName("t_user_eat")
public class TUserEat extends Model<TUserEat> {
    private static final long serialVersionUID = 7689319030636928841L;
    // 主键id
    @ExcelColumn(value = "主键", col = 1)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //创建时间
    @ExcelColumn(value = "创建时间", col = 2)
    private String create_time;
    //更新时间
    @ExcelColumn(value = "更新时间", col = 3)
    private String update_time;
    //所属用户id
    private Integer user_id;
    @TableField(exist = false)
    @ExcelColumn(value = "用户名", col = 4)
    private String userName;
    //餐饮
    @ExcelColumn(value = "餐饮", col = 5)
    private String restaurant;
    //用餐时间
    @ExcelColumn(value = "用餐时间", col = 6)
    private String restaurant_date;
    //用餐人数
    @ExcelColumn(value = "用餐人数", col = 7)
    private Integer restaurant_peoples;
    //用餐注意事项
    @ExcelColumn(value = "用餐注意事项", col = 8)
    private String restaurant_attention;
    //费用承担方式（0：自费   1：公费）
    @ExcelColumn(value = "支付方式（0：自费  1：公费）", col = 9)
    private Integer pay_type;
    //审核状态（int   0：未审核   1：已审核   2：未审核）
    @ExcelColumn(value = "审核状态（0：未审核 1：已审核  2：未通过）", col = 10)
    private Integer s_status;
    //审核备注id
    private String s_remark;
    @TableField(exist = false)
    private List<TRemark> sremarks;
    //用餐备注id
    private String eat_remark;
    // 是否结束  0：否  1：是
    @ExcelColumn(value = "是否结束（0：否  1:是）", col = 11)
    private Integer end;
    // 备注信息
    @TableField(exist = false)
    private List<TRemark> remarks;

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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getRestaurant_date() {
        return restaurant_date;
    }

    public void setRestaurant_date(String restaurant_date) {
        this.restaurant_date = restaurant_date;
    }

    public Integer getRestaurant_peoples() {
        return restaurant_peoples;
    }

    public void setRestaurant_peoples(Integer restaurant_peoples) {
        this.restaurant_peoples = restaurant_peoples;
    }

    public String getRestaurant_attention() {
        return restaurant_attention;
    }

    public void setRestaurant_attention(String restaurant_attention) {
        this.restaurant_attention = restaurant_attention;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getS_status() {
        return s_status;
    }

    public void setS_status(Integer s_status) {
        this.s_status = s_status;
    }

    public String getS_remark() {
        return s_remark;
    }

    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }

    public String getEat_remark() {
        return eat_remark;
    }

    public void setEat_remark(String eat_remark) {
        this.eat_remark = eat_remark;
    }

    @Override
    public String toString() {
        return "TUserEat{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", user_id=" + user_id +
                ", restaurant='" + restaurant + '\'' +
                ", restaurant_date='" + restaurant_date + '\'' +
                ", restaurant_peoples=" + restaurant_peoples +
                ", restaurant_attention='" + restaurant_attention + '\'' +
                ", pay_type=" + pay_type +
                ", s_status='" + s_status + '\'' +
                ", s_remark='" + s_remark + '\'' +
                ", eat_remark='" + eat_remark + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public List<TRemark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<TRemark> remarks) {
        this.remarks = remarks;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<TRemark> getSremarks() {
        return sremarks;
    }

    public void setSremarks(List<TRemark> sremarks) {
        this.sremarks = sremarks;
    }
}
