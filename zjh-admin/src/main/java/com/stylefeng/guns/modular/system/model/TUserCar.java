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
 * 个人用车表
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@TableName("t_user_car")
public class TUserCar extends Model<TUserCar> {

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
	 * 所属用户id
	 */
	@TableField("user_id")
	private Integer userId;
	@ExcelColumn(value = "所属客户", col = 1)
	@TableField(exist = false)
	private String userIdName;
	/**
	 * 用车事项（int 0：接人 1：送客）
	 */
	@ExcelColumn(value = "用车事项（ 0：接人  1：送客）", col = 2)
	private Integer attention;
	@TableField(exist = false)
	private String attentionName;
	/**
	 * 到达航班/车次
	 */
	@ExcelColumn(value = "到达航班/车次", col = 3)
	@TableField("traffic_number")
	private String trafficNumber;
	/**
	 * 用车日期
	 */
	@ExcelColumn(value = "用车日期", col = 4)
	@TableField("need_car_date")
	private String needCarDate;
	/**
	 * 用车时间
	 */
	@ExcelColumn(value = "用车时间", col = 5)
	@TableField("need_car_time")
	private String needCarTime;
	/**
	 * 乘车地点
	 */
	@ExcelColumn(value = "乘车地点", col = 6)
	@TableField("ride_place")
	private String ridePlace;
	/**
	 * 目的地
	 */
	@ExcelColumn(value = "目的地", col = 7)
	private String destination;
	/**
	 * 乘车 人数
	 */
	@ExcelColumn(value = "乘车人数", col = 8)
	@TableField("ride_peoples")
	private Integer ridePeoples;
	/**
	 * 陪同领导
	 */
	@ExcelColumn(value = "陪同领导", col = 9)
	@TableField("accompany_leader")
	private String accompanyLeader;
	/**
	 * 费用承担方式（0：自费 1：公费）
	 */
	@ExcelColumn(value = "费用承担方式（0：自费  1：公费）", col = 10)
	@TableField("pay_type")
	private Integer payType;
	@TableField(exist = false)
	private String payTypeName;
	/**
	 * 停车费用
	 */
	@ExcelColumn(value = "停车费用", col = 11)
	@TableField("stop_price")
	private Double stopPrice;
	/**
	 * 审核状态（0：未审核 1：已审核 2：未审核）
	 */
	@ExcelColumn(value = "审核状态（0：未审核   1：已审核   2：未审核）", col = 12)
	private Integer status;
	@TableField(exist = false)
	private String statusName;
	/**
	 * 是否已经结束（0：否 1：是）
	 */
	@ExcelColumn(value = "是否已经结束（0：否  1：是）", col = 13)
	private Integer end;
	@TableField(exist = false)
	private String endName;
	/**
	 * 添加备注人姓名
	 */
	@ExcelColumn(value = "添加备注人姓名", col = 14)
	@TableField("remark_name")
	private String remarkName;
	/**
	 * 添加备注内容
	 */
	@ExcelColumn(value = "添加备注内容", col = 15)
	@TableField("remark_content")
	private String remarkContent;
	/**
	 * 审核时间
	 */
	@ExcelColumn(value = "审核时间", col = 16)
	@TableField("status_date")
	private String statusDate;
	/**
	 * 结束时间
	 */
	@ExcelColumn(value = "结束时间", col = 17)
	@TableField("end_date")
	private String endDate;
	/**
	 * 审核备注人
	 */
	@ExcelColumn(value = "审核备注人", col = 18)
	@TableField("s_remark_name")
	private String sRemarkName;
	/**
	 * 审核备注内容
	 */
	@ExcelColumn(value = "审核备注内容", col = 19)
	@TableField("s_remark_content")
	private String sRemarkContent;
	/**
	 * 结束备注人
	 */
	@ExcelColumn(value = "结束备注人", col = 20)
	@TableField("e_remark_name")
	private String eRemarkName;
	/**
	 * 结束备注内容
	 */
	@ExcelColumn(value = "结束备注内容", col = 21)
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

	/** 是否已经安排 */
	@TableField(exist = false)
	private Integer arrange;

	// 司机
	@ExcelColumn(value = "司机", col = 22)
	private String driver;
	// 司机电话号码
	@ExcelColumn(value = "司机手机", col = 23)
	@TableField("driver_phone")
	private String driverPhone;
	// 车牌号
	@ExcelColumn(value = "车牌号", col = 24)
	@TableField("car_num")
	private String carNum;
	// 车型
	@ExcelColumn(value = "车型号", col = 25)
	@TableField("car_type")
	private String catType;

	// 联系人
	@TableField(exist = false)
	private String contacts;

	/** 用车的类型 0接车 1送车 2市区用车 */
	@TableField(exist = false)
	private Integer type;
	/** 停车证 0 无 1 有 */
	@TableField(exist = false)
	private Integer stopCard;

	public Integer getArrange() {
		return arrange;
	}

	public void setArrange(Integer arrange) {
		this.arrange = arrange;
	}

	public Integer getStopCard() {
		return stopCard;
	}

	public void setStopCard(Integer stopCard) {
		this.stopCard = stopCard;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

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

	public Integer getAttention() {
		return attention;
	}

	public void setAttention(Integer attention) {
		this.attention = attention;
	}

	public String getTrafficNumber() {
		return trafficNumber;
	}

	public void setTrafficNumber(String trafficNumber) {
		this.trafficNumber = trafficNumber;
	}

	public String getNeedCarDate() {
		return needCarDate;
	}

	public void setNeedCarDate(String needCarDate) {
		this.needCarDate = needCarDate;
	}

	public String getNeedCarTime() {
		return needCarTime;
	}

	public void setNeedCarTime(String needCarTime) {
		this.needCarTime = needCarTime;
	}

	public String getRidePlace() {
		return ridePlace;
	}

	public void setRidePlace(String ridePlace) {
		this.ridePlace = ridePlace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getRidePeoples() {
		return ridePeoples;
	}

	public void setRidePeoples(Integer ridePeoples) {
		this.ridePeoples = ridePeoples;
	}

	public String getAccompanyLeader() {
		return accompanyLeader;
	}

	public void setAccompanyLeader(String accompanyLeader) {
		this.accompanyLeader = accompanyLeader;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(Double stopPrice) {
		this.stopPrice = stopPrice;
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUserIdName() {
		return userIdName;
	}

	public void setUserIdName(String userIdName) {
		this.userIdName = userIdName;
	}

	public String getAttentionName() {
		return attentionName;
	}

	public void setAttentionName(String attentionName) {
		this.attentionName = attentionName;
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
		return "TUserCar{" + "id=" + id + ", createTime=" + createTime + ", updateTime=" + updateTime + ", userId="
				+ userId + ", attention=" + attention + ", trafficNumber=" + trafficNumber + ", needCarDate="
				+ needCarDate + ", needCarTime=" + needCarTime + ", ridePlace=" + ridePlace + ", destination="
				+ destination + ", ridePeoples=" + ridePeoples + ", accompanyLeader=" + accompanyLeader + ", payType="
				+ payType + ", stopPrice=" + stopPrice + ", status=" + status + ", remarkName=" + remarkName
				+ ", remarkContent=" + remarkContent + ", end=" + end + ", statusDate=" + statusDate + ", endDate="
				+ endDate + ", sRemarkName=" + sRemarkName + ", sRemarkContent=" + sRemarkContent + ", eRemarkName="
				+ eRemarkName + ", eRemarkContent=" + eRemarkContent + ", aRemarkName=" + aRemarkName
				+ ", aRemarkContent=" + aRemarkContent + "}";
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
}
