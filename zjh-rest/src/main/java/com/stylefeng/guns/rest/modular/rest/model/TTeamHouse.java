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
 * <p>团队住房表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@TableName("t_team_house")
public class TTeamHouse extends Model<TTeamHouse> {

    private static final long serialVersionUID = 5088748802999425448L;
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelColumn(value = "主键", col = 1)
    private Integer id;
    //创建时间
    @ExcelColumn(value = "创建时间", col = 2)
    private String create_time;
    //更新时间
    private String update_time;
    //所属院队id
    private Integer team_id;
    @ExcelColumn(value = "所属团队名称", col = 3)
    @TableField(exist = false)
    private String teamName;
    //酒店名称
    @ExcelColumn(value = "酒店名称", col = 4)
    private String hotel;
    //入住日期
    @ExcelColumn(value = "入住日期", col = 5)
    private String check_in_date;
    //退房日期
    @ExcelColumn(value = "退房日期", col = 6)
    private String check_out_date;
    //房间类型
    @ExcelColumn(value = "房间类型", col = 7)
    private String room_type;
    //单价
    @ExcelColumn(value = "单价", col = 8)
    private double price;
    //数量
    @ExcelColumn(value = "数量", col = 9)
    private Integer total;
    //总价
    @ExcelColumn(value = "总价", col = 10)
    private double total_price;
    //支付方式（0：自费  1：公费）
    @ExcelColumn(value = "支付方式", col = 11)
    private Integer pay_type;
    //住房信息id
    private String house_id;
    @TableField(exist = false)
    private List<THouse> houses;
    //审核状态（int   0：未审核   1：已审核   2：未审核）
    @ExcelColumn(value = "审核状态（0：未审核   1：已审核   2：未审核）", col = 12)
    private Integer s_status;
    //审核备注id
    private String s_remark;
    @TableField(exist = false)
    private List<TRemark> sremarks;
    //用餐备注id
    private String house_remark;
    // 是否结束  0：否  1：是
    @ExcelColumn(value = "是否结束  0：否  1：是", col = 13)
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

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
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

    public String getHouse_remark() {
        return house_remark;
    }

    public void setHouse_remark(String house_remark) {
        this.house_remark = house_remark;
    }

    @Override
    public String toString() {
        return "TTeamHouse{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", team_id=" + team_id +
                ", hotel='" + hotel + '\'' +
                ", check_in_date='" + check_in_date + '\'' +
                ", check_out_date='" + check_out_date + '\'' +
                ", room_type='" + room_type + '\'' +
                ", price=" + price +
                ", total=" + total +
                ", total_price=" + total_price +
                ", pay_type=" + pay_type +
                ", house_id='" + house_id + '\'' +
                ", s_status='" + s_status + '\'' +
                ", s_remark='" + s_remark + '\'' +
                ", eat_remark='" + house_remark + '\'' +
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<TRemark> getSremarks() {
        return sremarks;
    }

    public void setSremarks(List<TRemark> sremarks) {
        this.sremarks = sremarks;
    }

    public List<THouse> getHouses() {
        return houses;
    }

    public void setHouses(List<THouse> houses) {
        this.houses = houses;
    }
}
