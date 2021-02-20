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
 * 个人住房表
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@TableName("t_user_house")
public class TUserHouse extends Model<TUserHouse> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
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
     * 所属用户id
     */
    @TableField("user_id")
    private Integer userId;
    @ExcelColumn(value = "所属客户", col = 1)
    @TableField(exist = false)
    private String userIdName;
    /**
     * 酒店名称
     */
    @ExcelColumn(value = "酒店", col = 2)
    private String hotel;
    /**
     * 入住日期
     */
    @ExcelColumn(value = "入住日期", col = 3)
    @TableField("check_in_date")
    private String checkInDate;
    /**
     * 退房日期
     */
    @ExcelColumn(value = "退房日期", col = 4)
    @TableField("check_out_date")
    private String checkOutDate;
    /**
     * 房间类型
     */
    @ExcelColumn(value = "房间类型", col = 5)
    @TableField("room_type")
    private String roomType;
    /**
     * 单价
     */
    @ExcelColumn(value = "单价", col = 6)
    private Double price;
    /**
     * 房间数
     */
    @ExcelColumn(value = "房间数", col = 7)
    private Integer total;
    /**
     * 总价格
     */
    @ExcelColumn(value = "总价格", col = 8)
    @TableField("total_price")
    private Double totalPrice;
    /**
     * 费用承担方式（0：自费   1：公费）
     */
    @ExcelColumn(value = "费用承担方式（0：自费   1：公费）", col = 9)
    @TableField("pay_type")
    private Integer payType;
    @TableField(exist = false)
    private String payTypeName;
    /**
     * 入住房间号
     */
    @ExcelColumn(value = "入住房间号", col = 10)
    @TableField("room_num")
    private String roomNum;
    /**
     * 空置床位
     */
    @ExcelColumn(value = "空置床位", col = 11)
    private String vacant;
    /**
     * 是否拼房
     */
    @ExcelColumn(value = "是否拼房", col = 12)
    @TableField("splice_room")
    private String spliceRoom;
    /**
     * 拼房人姓名
     */
    @ExcelColumn(value = "拼房人姓名", col = 13)
    @TableField("splice_people")
    private String splicePeople;
    /**
     * 审核状态（int   0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "审核状态（ 0：未审核   1：已审核   2：未审核）", col = 14)
    private Integer status;
    @TableField(exist = false)
    private String statusName;
    /**
     * 备注内容
     */
    @ExcelColumn(value = "添加备注内容", col = 15)
    @TableField("remark_content")
    private String remarkContent;
    /**
     * 备注人姓名
     */
    @ExcelColumn(value = "添加备注人", col = 16)
    @TableField("remark_name")
    private String remarkName;
    /**
     * 是否结束（0：否  1：是）
     */
    @ExcelColumn(value = "是否结束（0：否  1：是）", col = 17)
    private Integer end;
    @TableField(exist = false)
    private String endName;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "审核时间", col = 18)
    @TableField("status_date")
    private String statusDate;
    /**
     * 结束时间
     */
    @ExcelColumn(value = "结束时间", col = 19)
    @TableField("end_date")
    private String endDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "审核备注人", col = 20)
    @TableField("s_remark_name")
    private String sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "审核备注内容", col = 21)
    @TableField("s_remark_content")
    private String sRemarkContent;
    /**
     * 结束备注人
     */
    @ExcelColumn(value = "结束备注人", col = 22)
    @TableField("e_remark_name")
    private String eRemarkName;
    /**
     * 结束备注内容
     */
    @ExcelColumn(value = "结束备注内容", col = 23)
    @TableField("e_remark_content")
    private String eRemarkContent;
    /**
     * 安排备注人
     */
    @TableField("a_remark_name")
    private String aRemarkName;
    /**
     * 安排备注人姓名
     */
    @TableField("a_remark_content")
    private String aRemarkContent;

    // 联系人
    @TableField(exist = false)
    private String contacts;


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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getVacant() {
        return vacant;
    }

    public void setVacant(String vacant) {
        this.vacant = vacant;
    }

    public String getSpliceRoom() {
        return spliceRoom;
    }

    public void setSpliceRoom(String spliceRoom) {
        this.spliceRoom = spliceRoom;
    }

    public String getSplicePeople() {
        return splicePeople;
    }

    public void setSplicePeople(String splicePeople) {
        this.splicePeople = splicePeople;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getsRemarkName() {
        return sRemarkName;
    }

    public void setsRemarkName(String sRemarkName) {
        this.sRemarkName = sRemarkName;
    }

    public String getsRemarkContent() {
        return sRemarkContent;
    }

    public void setsRemarkContent(String sRemarkContent) {
        this.sRemarkContent = sRemarkContent;
    }

    public String geteRemarkName() {
        return eRemarkName;
    }

    public void seteRemarkName(String eRemarkName) {
        this.eRemarkName = eRemarkName;
    }

    public String geteRemarkContent() {
        return eRemarkContent;
    }

    public void seteRemarkContent(String eRemarkContent) {
        this.eRemarkContent = eRemarkContent;
    }

    public String getaRemarkName() {
        return aRemarkName;
    }

    public void setaRemarkName(String aRemarkName) {
        this.aRemarkName = aRemarkName;
    }

    public String getaRemarkContent() {
        return aRemarkContent;
    }

    public void setaRemarkContent(String aRemarkContent) {
        this.aRemarkContent = aRemarkContent;
    }

    public String getUserIdName() {
        return userIdName;
    }

    public void setUserIdName(String userIdName) {
        this.userIdName = userIdName;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TUserHouse{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", hotel=" + hotel +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", roomType=" + roomType +
                ", price=" + price +
                ", total=" + total +
                ", totalPrice=" + totalPrice +
                ", payType=" + payType +
                ", roomNum=" + roomNum +
                ", vacant=" + vacant +
                ", spliceRoom=" + spliceRoom +
                ", splicePeople=" + splicePeople +
                ", status=" + status +
                ", remarkName=" + remarkName +
                ", remarkContent=" + remarkContent +
                ", end=" + end +
                ", statusDate=" + statusDate +
                ", endDate=" + endDate +
                ", sRemarkName=" + sRemarkName +
                ", sRemarkContent=" + sRemarkContent +
                ", eRemarkName=" + eRemarkName +
                ", eRemarkContent=" + eRemarkContent +
                ", aRemarkName=" + aRemarkName +
                ", aRemarkContent=" + aRemarkContent +
                "}";
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
