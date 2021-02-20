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
 * <p>团队用车表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@TableName("t_team_car")
public class TTeamCar extends Model<TTeamCar> {

    private static final long serialVersionUID = 3310985392505953622L;
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
    //用车事项（ 0：接人   1：送客）
    @ExcelColumn(value = "用车事项（ 0：接人   1：送客）", col = 4)
    private Integer attention;
    //到达航班/车次
    @ExcelColumn(value = "到达航班/车次", col = 5)
    private String traffic_number;
    //用车日期
    @ExcelColumn(value = "用车日期", col = 6)
    private String need_car_date;
    //用车时间
    @ExcelColumn(value = "用车时间", col = 7)
    private String need_car_time;
    //乘车地点
    @ExcelColumn(value = "乘车地点", col = 8)
    private String ride_place;
    //目的地
    @ExcelColumn(value = "目的地", col = 9)
    private String destination;
    //乘车人数
    @ExcelColumn(value = "乘车人数", col = 10)
    private Integer ride_peoples;
    //陪同领导
    @ExcelColumn(value = "陪同领导", col = 11)
    private String accompany_leader;
    //费用承担方式（0：自费  1：公费）
    @ExcelColumn(value = "费用承担方式（0：自费  1：公费）", col = 12)
    private Integer pay_type;
    //停车费用
    @ExcelColumn(value = "停车费用", col = 13)
    private double stop_price;
    //审核状态（int   0：未审核   1：已审核   2：未审核）
    @ExcelColumn(value = "审核状态（0：未审核   1：已审核   2：未审核）", col = 14)
    private Integer s_status;
    //审核备注id
    private String s_remark;
    @TableField(exist = false)
    private List<TRemark> sremarks;
    //用车备注id
    private String car_remark;
    // 是否结束  0：否  1：是
    @ExcelColumn(value = "是否结束  0：否  1：是", col = 15)
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

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public String getTraffic_number() {
        return traffic_number;
    }

    public void setTraffic_number(String traffic_number) {
        this.traffic_number = traffic_number;
    }

    public String getNeed_car_date() {
        return need_car_date;
    }

    public void setNeed_car_date(String need_car_date) {
        this.need_car_date = need_car_date;
    }

    public String getNeed_car_time() {
        return need_car_time;
    }

    public void setNeed_car_time(String need_car_time) {
        this.need_car_time = need_car_time;
    }

    public String getRide_place() {
        return ride_place;
    }

    public void setRide_place(String ride_place) {
        this.ride_place = ride_place;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getRide_peoples() {
        return ride_peoples;
    }

    public void setRide_peoples(Integer ride_peoples) {
        this.ride_peoples = ride_peoples;
    }

    public String getAccompany_leader() {
        return accompany_leader;
    }

    public void setAccompany_leader(String accompany_leader) {
        this.accompany_leader = accompany_leader;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public double getStop_price() {
        return stop_price;
    }

    public void setStop_price(double stop_price) {
        this.stop_price = stop_price;
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

    public String getCar_remark() {
        return car_remark;
    }

    public void setCar_remark(String car_remark) {
        this.car_remark = car_remark;
    }

    @Override
    public String toString() {
        return "TTeamCar{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", team_id=" + team_id +
                ", attention=" + attention +
                ", traffic_number='" + traffic_number + '\'' +
                ", need_car_date='" + need_car_date + '\'' +
                ", need_car_time='" + need_car_time + '\'' +
                ", ride_place='" + ride_place + '\'' +
                ", destination='" + destination + '\'' +
                ", ride_peoples=" + ride_peoples +
                ", accompany_leader='" + accompany_leader + '\'' +
                ", pay_type=" + pay_type +
                ", stop_price=" + stop_price +
                ", s_status=" + s_status +
                ", s_remark='" + s_remark + '\'' +
                ", car_remark='" + car_remark + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return null;
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
}
