package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.stylefeng.guns.modular.system.util.ExcelColumn;

import java.io.Serializable;

/**
 * <p>
 * 客户的信息总表
 * </p>
 *
 * @author lakyjpan
 * @since 2019-10-07
 */
@TableName("t_new_user")
public class TNewUser extends Model<TNewUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（int）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 创建时间（datetime）
     */
    @TableField("create_time")
    private String createTime;
    /**
     * 更新时间（datetime）
     */
    @TableField("update_time")
    private String updateTime;
    /**
     * 客户姓名
     */
    @ExcelColumn(value = "客户姓名", col = 1)
    private String name;
    /**
     * 性别（int 0：男 1：女）
     */
    @ExcelColumn(value = "性别（0：男 1：女）", col = 2)
    private Integer sex;
    /**
     * 性别名称.
     */
    @TableField(exist = false)
    private String sexName;

    /**
     * 公司/单位
     */
    @ExcelColumn(value = "公司/单位", col = 3)
    private String company;
    /**
     * 职务
     */
    @ExcelColumn(value = "职务", col = 4)
    private String job;
    /**
     * 证件类型（int 0：贵宾证 1：嘉宾证 2：参观证）
     */
    @ExcelColumn(value = "证件类型（0：贵宾证 1：嘉宾证 2：参观证）", col = 5)
    private Integer card;
    /**
     * 证件类型名称（辅助字段）
     */
    @TableField(exist = false)
    private String certificatesName;
    /**
     * 嘉宾对接人
     */
    @ExcelColumn(value = "嘉宾对接人", col = 6)
    @TableField("pick_up")
    private String pickUp;
    /**
     * 联系人电话
     */
    @ExcelColumn(value = "联系人电话", col = 7)
    @TableField("link_phone")
    private String linkPhone;
    /**
     * 个人电话号码
     */
    @ExcelColumn(value = "电话号码", col = 8)
    private String phone;
    /**
     * 跟随人员姓名
     */
    @ExcelColumn(value = "跟随人员", col = 9)
    private String follow;
    /**
     * 陪同人姓名
     */
    @ExcelColumn(value = "陪同人员", col = 10)
    private String accompany;
    /**
     * 翻译人姓名
     */
    @ExcelColumn(value = "翻译人", col = 11)
    private String translate;
    /**
     * 辅助字段,翻译人员
     */
    @TableField(exist = false)
    private String translater;
    /**
     * 电子邮箱
     */
    @ExcelColumn(value = "电子邮箱", col = 12)
    private String email;
    /**
     * 接车用车日期 yyyy-MM-dd
     */
    @TableField("j_use_car_date")
    @ExcelColumn(value = "接车用车日期", col = 13)
    private String jUseCarDate;
    /**
     * 接车用车额时间 HH:mm:ss
     */
    @TableField("j_use_car_time")
    @ExcelColumn(value = "接车用车时间", col = 14)
    private String jUseCarTime;
    /**
     * 接车航班车次
     */
    @TableField("j_traffic_num")
    @ExcelColumn(value = "接车航班车次", col = 15)
    private String jTrafficNum;
    /**
     * 接车乘车地点
     */
    @TableField("j_ride_place")
    @ExcelColumn(value = "接车乘车地点", col = 16)
    private String jRidePlace;
    /**
     * 接车去往目的地
     */
    @TableField("j_destination")
    @ExcelColumn(value = "接车去往的目的地", col = 17)
    private String jDestination;
    /**
     * 接车坐车人数
     */
    @TableField("j_ride_peoples")
    @ExcelColumn(value = "接车坐车人数", col = 18)
    private Integer jRidePeoples;
    /**
     * 接车陪同领导
     */
    @TableField("j_accompany_leader")
    @ExcelColumn(value = "接车陪同领导", col = 19)
    private String jAccompanyLeader;
    /**
     * 接车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "接车付费方式（0：自费 1：公费）", col = 20)
    @TableField("j_pay_type")
    private Integer jPayType;

    @TableField(exist = false)
    private String jPayTypeName;
    /**
     * 接车是否有停车证（0：否 1：是）
     */
    @TableField("j_has_stop_card")
    @ExcelColumn(value = "接车是否有停车证（0：否 1：是）", col = 21)
    private Integer jHasStopCard;
    /**
     * 接车添加的备注信息
     */
    @TableField("j_add_remark")
    @ExcelColumn(value = "接车备注信息", col = 22)
    private String jAddRemark;
    /**
     * 用车安排状态（0：未安排 1：已安排）
     */
    @TableField("j_car_arrange")
    private Integer jCarArrange;
    /**
     * 接车安排司机姓名
     */
    @TableField("j_driver")
    private String jDriver;
    /**
     * 接车安排联系电话
     */
    @TableField("j_driver_phone")
    private String jDriverPhone;
    /**
     * 接车安排车的车牌号
     */
    @TableField("j_car_card")
    private String jCarCard;
    /**
     * 接车安排的车类型
     */
    @TableField("j_car_type")
    private String jCarType;
    /**
     * 接车安排的接送情况（0：未接送 1：已接送）
     */
    @TableField("j_car_s_type")
    private Integer jCarSType;
    @TableField(exist = false)
    private String jCarSTypeName;
    
    /**
     * 接车安排备注内容
     */
    @TableField("j_arrange_remark")
    private String jArrangeRemark;
    /**
     * 送车用车日期 yyyy-MM-dd
     */
    @TableField("s_use_car_date")
    @ExcelColumn(value = "送车用车日期", col = 23)
    private String sUseCarDate;
    /**
     * 送车用车时间 HH:mm:ss
     */
    @TableField("s_use_car_time")
    @ExcelColumn(value = "送车用车时间", col = 24)
    private String sUseCarTime;
    /**
     * 送车航班车次
     */
    @TableField("s_traffic_num")
    @ExcelColumn(value = "送车航班车次", col = 25)
    private String sTrafficNum;
    /**
     * 送车乘车地点
     */
    @TableField("s_ride_place")
    @ExcelColumn(value = "送车乘车地点", col = 26)
    private String sRidePlace;
    /**
     * 送车去往目的地
     */
    @TableField("s_destination")
    @ExcelColumn(value = "送车去往目的地", col = 27)
    private String sDestination;
    /**
     * 送车坐车人数
     */
    @TableField("s_ride_peoples")
    @ExcelColumn(value = "送车坐车人数", col = 28)
    private Integer sRidePeoples;
    /**
     * 送车陪同领导
     */
    @TableField("s_accompany_leader")
    @ExcelColumn(value = "送车陪同领导", col = 29)
    private String sAccompanyLeader;
    /**
     * 送车付费方式（int 0：自费 1：公费）
     */
    @TableField("s_pay_type")
    @ExcelColumn(value = "送车付费方式（0：自费 1：公费）", col = 30)
    private Integer sPayType;

    @TableField(exist = false)
    private String sPayTypeName;

    /**
     * 送车是否有停车证（0：否 1：是）
     */
    @TableField("s_has_stop_card")
    @ExcelColumn(value = "送车是否有停车证（0：否 1：是）", col = 31)
    private Integer sHasStopCard;
    /**
     * 送车添加的备注信息
     */
    @TableField("s_add_remark")
    @ExcelColumn(value = "送车备注信息", col = 32)
    private String sAddRemark;
    /**
     * 送车用车安排状态（0：未安排 1：已安排）
     */
    @TableField("s_car_arrange")
    private Integer sCarArrange;
    /**
     * 送车安排司机姓名
     */
    @TableField("s_driver")
    private String sDriver;
    /**
     * 送车安排联系电话
     */
    @TableField("s_driver_phone")
    private String sDriverPhone;
    /**
     * 送车安排车的车牌号
     */
    @TableField(" s_car_card")
    private String sCarCard;
    /**
     * 送车安排的车类型
     */
    @TableField("s_car_type")
    private String sCarType;
    /**
     * 送车安排的接送情况（0：未接送 1：已接送）
     */
    @TableField("s_car_s_type")
    private Integer sCarSType;
    @TableField(exist =false)
    private String sCarSTypeName;
    /**
     * 送车安排备注内容
     */
    @TableField("s_arrange_remark")
    private String sArrangeRemark;
    /**
     * 市内用车日期 yyyy-MM-dd
     */
    @TableField("c_use_car_date")
    @ExcelColumn(value = "市内用车日期（2019-01-01）", col = 33)
    private String cUseCarDate;
    /**
     * 市内用车时间 HH:mm:ss
     */
    @TableField("c_use_car_time")
    @ExcelColumn(value = "市内用车时间（12:00:00）", col = 34)
    private String cUseCarTime;
    /**
     * 市内用车乘车地点
     */
    @TableField("c_ride_place")
    @ExcelColumn(value = "市内用车乘车地点", col = 35)
    private String cRidePlace;
    /**
     * 市内用车去往目的地
     */
    @TableField("c_destination")
    @ExcelColumn(value = "市内用车去往目的地", col = 36)
    private String cDestination;
    /**
     * 市内用车坐车人数
     */
    @TableField("c_ride_peoples")
    @ExcelColumn(value = "市内用车坐车人数", col = 37)
    private Integer cRidePeoples;
    /**
     * 市内用车陪同领导
     */
    @TableField("c_accompany_leader")
    @ExcelColumn(value = "市内用车陪同领导", col = 38)
    private String cAccompanyLeader;
    /**
     * 市内用车付费方式（int 0：自费 1：公费）
     */
    @TableField("c_pay_type")
    @ExcelColumn(value = "市内用车付费方式（0：自费 1：公费）", col = 39)
    private Integer cPayType;

    @TableField(exist = false)
    private String cPayTypeName;
    /**
     * 市内用车是否有停车证（0：否 1：是）
     */
    @TableField("c_has_stop_card")
    @ExcelColumn(value = "市内用车是否停车证（0：否 1：是）", col = 40)
    private Integer cHasStopCard;
    /**
     * 市内用车添加的备注信息
     */
    @TableField("c_add_remark")
    @ExcelColumn(value = "市内用车备注信息", col = 41)
    private String cAddRemark;
    /**
     * 市内用车安排状态（0：未安排 1：已安排）
     */
    @TableField("c_car_arrange")
    private Integer cCarArrange;
    /**
     * 市内用车安排司机姓名
     */
    @TableField(" c_driver")
    private String cDriver;
    /**
     * 市内用车安排联系电话
     */
    @TableField("c_driver_phone")
    private String cDriverPhone;
    /**
     * 市内用车安排车的车牌号
     */
    @TableField(" c_car_card")
    private String cCarCard;
    /**
     * 市内用车安排的车类型
     */
    @TableField("c_car_type")
    private String cCarType;
    /**
     * 市内同车安排的接送情况（0：未接送 1：已接送）
     */
    @TableField("c_car_s_type")
    private Integer cCarSType;
    @TableField(exist = false)
    private String cCarSTypeName;
    /**
     * 市内用车安排备注内容
     */
    @TableField("c_arrange_remark")
    private String cArrangeRemark;
    /**
     * 用车审核状态（0：未审核 1：已审核 2：已退回）
     */
    @TableField("car_status")
    private Integer carStatus;
    @TableField(exist = false)
    private String carStatusName;
    /**
     * 用车审核备注人
     */
    @TableField("car_status_reamrk_name")
    private String carStatusReamrkName;
    /**
     * 用车审核备注
     */
    @TableField("car_status_remark")
    private String carStatusRemark;
    /**
     * 用车结束（0：未结束 1：已结束）
     */
    @TableField("car_end")
    private Integer carEnd;
    /**
     * 用车结束备注人
     */
    @TableField("car_end_remark_name")
    private String carEndRemarkName;
    /**
     * 用车结束备注
     */
    @TableField("car_end_remark")
    private String carEndRemark;
    /**
     * 晚宴（0：否 1：是）
     */
    @TableField("eat_dinner")
    @ExcelColumn(value = "晚宴（0：否 1：是）", col = 42)
    private Integer eatDinner;
    @TableField(exist = false)
    private String eatDinnerName;
    /**
     * 自助午餐（int 填数量）
     */
    @TableField("eat_lunch")
    @ExcelColumn(value = "自助午餐（填整数）", col = 43)
    private Integer eatLunch;
    /**
     * 工作餐（int 填数量）
     */
    @TableField("eat_work_meal")
    @ExcelColumn(value = "工作餐（填整数）", col = 44)
    private Integer eatWorkMeal;
    /**
     * 用餐支付方式（0：自费 1：公费）
     */
    @TableField("eat_pay_type")
    @ExcelColumn(value = "用餐支付方式（0：自费 1：公费）", col = 45)
    private Integer eatPayType;

    @TableField(exist = false)
    private String eatPayTypeName;
    /**
     * 用餐添加备注
     */
    @TableField("eat_add_remark")
    @ExcelColumn(value = "用餐备注", col = 46)
    private String eatAddRemark;
    /**
     * 用餐注意事项
     */
    @TableField("eat_attention")
    @ExcelColumn(value = "用餐注意事项", col = 47)
    private String eatAttention;
    /**
     * 用餐审核状态（0：未审核 1：已审核 2：已退回）
     */
    @TableField("eat_status")
    private Integer eatStatus;
    @TableField(exist = false)
    private String eatStatusName;
    /**
     * 用餐审核备注人
     */
    @TableField("eat_status_reamrk_name")
    private String eatStatusReamrkName;
    /**
     * 用餐审核备注
     */
    @TableField("eat_status_remark")
    private String eatStatusRemark;
    /**
     * 用餐结束状态（0：未结束 1：已结束）
     */
    @TableField("eat_end")
    private Integer eatEnd;
    @TableField(exist = false)
    private String eatEndName;
    /**
     * 用餐结束备注人
     */
    @TableField("eat_end_remark_name")
    private String eatEndRemarkName;
    /**
     * 用餐结束备注
     */
    @TableField("eat_end_remark")
    private String eatEndRemark;
    /**
     * 用餐安排状态（0：未安排 1：已安排)
     */
    @TableField("eat_arrange")
    private Integer eatArrange;
    /**
     * 用餐安排备注内容
     */
    @TableField("eat_arrange_remark")
    private String eatArrangeRemark;
    /**
     * 入住日期（yyyy-MM-dd HH:mm:ss）
     */
    @ExcelColumn(value = "入住日期（2019-01-01 12:00:00）", col = 48)
    @TableField("house_in_date")
    private String houseInDate;
    /**
     * 退房日期（yyyy-MM-dd HH:mm:ss）
     */
    @ExcelColumn(value = "退房日期（2019-01-01 12:00:00）", col = 49)
    @TableField("house_out_date")
    private String houseOutDate;
    /**
     * 酒店名称
     */
    @TableField("hotel_name")
    @ExcelColumn(value = "酒店名称", col = 50)
    private String hotelName;
    /**
     * 入住房间号
     */
    @TableField("hotel_room_num")
    @ExcelColumn(value = "房间号", col = 51)
    private String hotelRoomNum;
    /**
     * 房间类型
     */
    @TableField("hotel_room_type")
    @ExcelColumn(value = "房价类型", col = 52)
    private String hotelRoomType;
    /**
     * 空置床位
     */
    @TableField("hotel_vacant")
    @ExcelColumn(value = "空置床位", col = 53)
    private String hotelVacant;
    /**
     * 单价
     */
    @ExcelColumn(value = "单价（100.00）", col = 54)
    private Double price;
    /**
     * 是否拼房
     */
    @ExcelColumn(value = "是否拼房", col = 55)
    @TableField("splice_room")
    private String spliceRoom;
    /**
     * 拼房人姓名
     */
    @TableField("splice_people")
    @ExcelColumn(value = "拼房人姓名", col = 56)
    private String splicePeople;
    /**
     * 房间总数
     */
    @TableField("room_total")
    @ExcelColumn(value = "房间总数", col = 57)
    private Integer roomTotal;
    /**
     * 总价（double）
     */
    @TableField("total_price")
    @ExcelColumn(value = "住房总价格", col = 58)
    private Double totalPrice;
    /**
     * 住房付费方式（0：自费 1：公费）
     */
    @TableField("house_pay_type")
    @ExcelColumn(value = "住房付费方式（0：自费 1：公费）", col = 59)
    private Integer housePayType;

    @TableField(exist = false)
    private String housePayTypeName;
    /**
     * 住房添加备注
     */
    @TableField("house_add_remark")
    @ExcelColumn(value = "住房备注", col = 60)
    private String houseAddRemark;
    /**
     * 住房审核状态（0：未审核 1：已审核 2：已退回）
     */
    @TableField("house_status")
    private Integer houseStatus;
    @TableField(exist = false)
    private String houseStatusName;
    /**
     * 住房审核备注人
     */
    @TableField("house_status_reamrk_name")
    private String houseStatusReamrkName;
    /**
     * 住房审核备注
     */
    @TableField("house_status_remark")
    private String houseStatusRemark;
    /**
     * 住房结束状态（0：未结束 1：已结束）
     */
    @TableField("house_end")
    private Integer houseEnd;
    @TableField(exist = false)
    private String houseEndName;
    /**
     * 住房结束备注人
     */
    @TableField("house_end_remark_name")
    private String houseEndRemarkName;
    /**
     * 住房结束备注
     */
    @TableField("house_end_remark")
    private String houseEndRemark;
    /**
     * 住房安排状态（0：未安排 1：已安排）
     */
    @TableField("house_arrange")
    private Integer houseArrange;
    /**
     * 住房安排备注内容
     */
    @TableField("house_arrange_remark")
    private String houseArrangeRemark;
    /**
     * 参与活动
     */
    @ExcelColumn(value = "参与活动", col = 61)
    private String activity;
    /**
     * 开户姓名
     */
    @TableField("account_name")
    @ExcelColumn(value = "开户姓名", col = 62)
    private String accountName;
    /**
     * 开户银行
     */
    @TableField("account_blank")
    @ExcelColumn(value = "开户银行", col = 63)
    private String accountBlank;
    /**
     * 开户账号
     */
    @ExcelColumn(value = "开户账号", col = 64)
    private String account;
    /**
     * 个人简介
     */
    @TableField("personal_synopsis")
    @ExcelColumn(value = "个人简介", col = 65)
    private String personalSynopsis;
    /**
     * 个人角色（0：主持人 1：演讲嘉宾 2：观众）
     */
    @ExcelColumn(value = "个人角色（0：主持人 1：演讲嘉宾 2：观众）", col = 66)
    private Integer role;
    @TableField(exist = false)
    private String roleName;
    /**
     * 演讲主题
     */
    @TableField("speech_topic")
    @ExcelColumn(value = "演讲主题", col = 67)
    private String speechTopic;
    /**
     * 活动添加备注
     */
    @TableField("activity_add_remark")
    @ExcelColumn(value = "活动备注", col = 68)
    private String activityAddRemark;
    /**
     * 活动添加备注人姓名
     */
    @TableField("activity_add_remark_name")
    @ExcelColumn(value = "活动备注人", col = 69)
    private String activityAddRemarkName;
    /**
     * 演讲材料文件id
     */
    @TableField("speech_file")
    private String speechFile;
    /**
     * 个人照片文件id
     */
    @TableField("photo_file")
    private String photoFile;
    /**
     * 活动审核状态（0：未审核 1：已审核 2：已退回）
     */
    @TableField("activity_status")
    private Integer activityStatus;
    @TableField(exist = false)
    private String activityStatusName;
    /**
     * 活动审核备注人
     */
    @TableField("activity_status_reamrk_name")
    private String activityStatusReamrkName;
    /**
     * 活动审核备注
     */
    @TableField("activity_status_remark")
    private String activityStatusRemark;
    /**
     * 录入员/管理员的id
     */
    @TableField("create_by")
    private Integer createBy;

    @TableField(exist = false)
    private String jCarArrangeName;
    @TableField(exist = false)
    private String sCarArrangeName;
    @TableField(exist = false)
    private String cCarArrangeName;
    @TableField(exist = false)
    private String eatArrangeName;
    @TableField(exist = false)
    private String houseArrangeName;
    @TableField(exist = false)
    private String carEndName;
    
    public String getCarEndName() {
		return carEndName;
	}

	public void setCarEndName(String carEndName) {
		this.carEndName = carEndName;
	}

	public String getjCarSTypeName() {
		return jCarSTypeName;
	}

	public void setjCarSTypeName(String jCarSTypeName) {
		this.jCarSTypeName = jCarSTypeName;
	}

	public String getsCarSTypeName() {
		return sCarSTypeName;
	}

	public void setsCarSTypeName(String sCarSTypeName) {
		this.sCarSTypeName = sCarSTypeName;
	}

	public String getcCarSTypeName() {
		return cCarSTypeName;
	}

	public void setcCarSTypeName(String cCarSTypeName) {
		this.cCarSTypeName = cCarSTypeName;
	}

	public String getCarStatusName() {
		return carStatusName;
	}

	public void setCarStatusName(String carStatusName) {
		this.carStatusName = carStatusName;
	}

	public String getEatEndName() {
        return eatEndName;
    }

    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getActivityStatusName() {
		return activityStatusName;
	}

	public void setActivityStatusName(String activityStatusName) {
		this.activityStatusName = activityStatusName;
	}

	public String getHouseEndName() {
		return houseEndName;
	}

	public void setHouseEndName(String houseEndName) {
		this.houseEndName = houseEndName;
	}

	public String getHouseStatusName() {
		return houseStatusName;
	}

	public void setHouseStatusName(String houseStatusName) {
		this.houseStatusName = houseStatusName;
	}

	public String getjCarArrangeName() {
		return jCarArrangeName;
	}

	public void setjCarArrangeName(String jCarArrangeName) {
		this.jCarArrangeName = jCarArrangeName;
	}

	public String getsCarArrangeName() {
		return sCarArrangeName;
	}

	public void setsCarArrangeName(String sCarArrangeName) {
		this.sCarArrangeName = sCarArrangeName;
	}

	public String getcCarArrangeName() {
		return cCarArrangeName;
	}

	public void setcCarArrangeName(String cCarArrangeName) {
		this.cCarArrangeName = cCarArrangeName;
	}

	public String getEatArrangeName() {
		return eatArrangeName;
	}

	public void setEatArrangeName(String eatArrangeName) {
		this.eatArrangeName = eatArrangeName;
	}

	public String getHouseArrangeName() {
		return houseArrangeName;
	}

	public void setHouseArrangeName(String houseArrangeName) {
		this.houseArrangeName = houseArrangeName;
	}

	public String getEatDinnerName() {
        return eatDinnerName;
    }

    public void setEatDinnerName(String eatDinnerName) {
        this.eatDinnerName = eatDinnerName;
    }

    public void setEatEndName(String eatEndName) {
        this.eatEndName = eatEndName;
    }

    public String getTranslater() {
        return translater;
    }

    public void setTranslater(String translater) {
        this.translater = translater;
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

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public String getAccompany() {
        return accompany;
    }

    public void setAccompany(String accompany) {
        this.accompany = accompany;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getjUseCarDate() {
        return jUseCarDate;
    }

    public void setjUseCarDate(String jUseCarDate) {
        this.jUseCarDate = jUseCarDate;
    }

    public String getjUseCarTime() {
        return jUseCarTime;
    }

    public void setjUseCarTime(String jUseCarTime) {
        this.jUseCarTime = jUseCarTime;
    }

    public String getjTrafficNum() {
        return jTrafficNum;
    }

    public void setjTrafficNum(String jTrafficNum) {
        this.jTrafficNum = jTrafficNum;
    }

    public String getjRidePlace() {
        return jRidePlace;
    }

    public void setjRidePlace(String jRidePlace) {
        this.jRidePlace = jRidePlace;
    }

    public String getjDestination() {
        return jDestination;
    }

    public void setjDestination(String jDestination) {
        this.jDestination = jDestination;
    }

    public Integer getjRidePeoples() {
        return jRidePeoples;
    }

    public void setjRidePeoples(Integer jRidePeoples) {
        this.jRidePeoples = jRidePeoples;
    }

    public String getjAccompanyLeader() {
        return jAccompanyLeader;
    }

    public void setjAccompanyLeader(String jAccompanyLeader) {
        this.jAccompanyLeader = jAccompanyLeader;
    }

    public Integer getjPayType() {
        return jPayType;
    }

    public void setjPayType(Integer jPayType) {
        this.jPayType = jPayType;
    }

    public Integer getjHasStopCard() {
        return jHasStopCard;
    }

    public void setjHasStopCard(Integer jHasStopCard) {
        this.jHasStopCard = jHasStopCard;
    }

    public String getjAddRemark() {
        return jAddRemark;
    }

    public void setjAddRemark(String jAddRemark) {
        this.jAddRemark = jAddRemark;
    }

    public Integer getjCarArrange() {
        return jCarArrange;
    }

    public void setjCarArrange(Integer jCarArrange) {
        this.jCarArrange = jCarArrange;
    }

    public String getjDriver() {
        return jDriver;
    }

    public void setjDriver(String jDriver) {
        this.jDriver = jDriver;
    }

    public String getjDriverPhone() {
        return jDriverPhone;
    }

    public void setjDriverPhone(String jDriverPhone) {
        this.jDriverPhone = jDriverPhone;
    }

    public String getjCarCard() {
        return jCarCard;
    }

    public void setjCarCard(String jCarCard) {
        this.jCarCard = jCarCard;
    }

    public String getjCarType() {
        return jCarType;
    }

    public void setjCarType(String jCarType) {
        this.jCarType = jCarType;
    }

    public Integer getjCarSType() {
        return jCarSType;
    }

    public void setjCarSType(Integer jCarSType) {
        this.jCarSType = jCarSType;
    }

    public String getjArrangeRemark() {
        return jArrangeRemark;
    }

    public void setjArrangeRemark(String jArrangeRemark) {
        this.jArrangeRemark = jArrangeRemark;
    }

    public String getsUseCarDate() {
        return sUseCarDate;
    }

    public void setsUseCarDate(String sUseCarDate) {
        this.sUseCarDate = sUseCarDate;
    }

    public String getsUseCarTime() {
        return sUseCarTime;
    }

    public void setsUseCarTime(String sUseCarTime) {
        this.sUseCarTime = sUseCarTime;
    }

    public String getsTrafficNum() {
        return sTrafficNum;
    }

    public void setsTrafficNum(String sTrafficNum) {
        this.sTrafficNum = sTrafficNum;
    }

    public String getsRidePlace() {
        return sRidePlace;
    }

    public void setsRidePlace(String sRidePlace) {
        this.sRidePlace = sRidePlace;
    }

    public String getsDestination() {
        return sDestination;
    }

    public void setsDestination(String sDestination) {
        this.sDestination = sDestination;
    }

    public Integer getsRidePeoples() {
        return sRidePeoples;
    }

    public void setsRidePeoples(Integer sRidePeoples) {
        this.sRidePeoples = sRidePeoples;
    }

    public String getsAccompanyLeader() {
        return sAccompanyLeader;
    }

    public void setsAccompanyLeader(String sAccompanyLeader) {
        this.sAccompanyLeader = sAccompanyLeader;
    }

    public Integer getsPayType() {
        return sPayType;
    }

    public void setsPayType(Integer sPayType) {
        this.sPayType = sPayType;
    }

    public Integer getsHasStopCard() {
        return sHasStopCard;
    }

    public void setsHasStopCard(Integer sHasStopCard) {
        this.sHasStopCard = sHasStopCard;
    }

    public String getsAddRemark() {
        return sAddRemark;
    }

    public void setsAddRemark(String sAddRemark) {
        this.sAddRemark = sAddRemark;
    }

    public Integer getsCarArrange() {
        return sCarArrange;
    }

    public void setsCarArrange(Integer sCarArrange) {
        this.sCarArrange = sCarArrange;
    }

    public String getsDriver() {
        return sDriver;
    }

    public void setsDriver(String sDriver) {
        this.sDriver = sDriver;
    }

    public String getsDriverPhone() {
        return sDriverPhone;
    }

    public void setsDriverPhone(String sDriverPhone) {
        this.sDriverPhone = sDriverPhone;
    }

    public String getsCarCard() {
        return sCarCard;
    }

    public void setsCarCard(String sCarCard) {
        this.sCarCard = sCarCard;
    }

    public String getsCarType() {
        return sCarType;
    }

    public void setsCarType(String sCarType) {
        this.sCarType = sCarType;
    }

    public Integer getsCarSType() {
        return sCarSType;
    }

    public void setsCarSType(Integer sCarSType) {
        this.sCarSType = sCarSType;
    }

    public String getsArrangeRemark() {
        return sArrangeRemark;
    }

    public void setsArrangeRemark(String sArrangeRemark) {
        this.sArrangeRemark = sArrangeRemark;
    }

    public String getcUseCarDate() {
        return cUseCarDate;
    }

    public void setcUseCarDate(String cUseCarDate) {
        this.cUseCarDate = cUseCarDate;
    }

    public String getcUseCarTime() {
        return cUseCarTime;
    }

    public void setcUseCarTime(String cUseCarTime) {
        this.cUseCarTime = cUseCarTime;
    }

    public String getcRidePlace() {
        return cRidePlace;
    }

    public void setcRidePlace(String cRidePlace) {
        this.cRidePlace = cRidePlace;
    }

    public String getcDestination() {
        return cDestination;
    }

    public void setcDestination(String cDestination) {
        this.cDestination = cDestination;
    }

    public Integer getcRidePeoples() {
        return cRidePeoples;
    }

    public void setcRidePeoples(Integer cRidePeoples) {
        this.cRidePeoples = cRidePeoples;
    }

    public String getcAccompanyLeader() {
        return cAccompanyLeader;
    }

    public void setcAccompanyLeader(String cAccompanyLeader) {
        this.cAccompanyLeader = cAccompanyLeader;
    }

    public Integer getcPayType() {
        return cPayType;
    }

    public void setcPayType(Integer cPayType) {
        this.cPayType = cPayType;
    }

    public Integer getcHasStopCard() {
        return cHasStopCard;
    }

    public void setcHasStopCard(Integer cHasStopCard) {
        this.cHasStopCard = cHasStopCard;
    }

    public String getcAddRemark() {
        return cAddRemark;
    }

    public void setcAddRemark(String cAddRemark) {
        this.cAddRemark = cAddRemark;
    }

    public Integer getcCarArrange() {
        return cCarArrange;
    }

    public void setcCarArrange(Integer cCarArrange) {
        this.cCarArrange = cCarArrange;
    }

    public String getcDriver() {
        return cDriver;
    }

    public void setcDriver(String cDriver) {
        this.cDriver = cDriver;
    }

    public String getcDriverPhone() {
        return cDriverPhone;
    }

    public void setcDriverPhone(String cDriverPhone) {
        this.cDriverPhone = cDriverPhone;
    }

    public String getcCarCard() {
        return cCarCard;
    }

    public void setcCarCard(String cCarCard) {
        this.cCarCard = cCarCard;
    }

    public String getcCarType() {
        return cCarType;
    }

    public void setcCarType(String cCarType) {
        this.cCarType = cCarType;
    }

    public Integer getcCarSType() {
        return cCarSType;
    }

    public void setcCarSType(Integer cCarSType) {
        this.cCarSType = cCarSType;
    }

    public String getcArrangeRemark() {
        return cArrangeRemark;
    }

    public void setcArrangeRemark(String cArrangeRemark) {
        this.cArrangeRemark = cArrangeRemark;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarStatusReamrkName() {
        return carStatusReamrkName;
    }

    public void setCarStatusReamrkName(String carStatusReamrkName) {
        this.carStatusReamrkName = carStatusReamrkName;
    }

    public String getCarStatusRemark() {
        return carStatusRemark;
    }

    public void setCarStatusRemark(String carStatusRemark) {
        this.carStatusRemark = carStatusRemark;
    }

    public Integer getCarEnd() {
        return carEnd;
    }

    public void setCarEnd(Integer carEnd) {
        this.carEnd = carEnd;
    }

    public String getCarEndRemarkName() {
        return carEndRemarkName;
    }

    public void setCarEndRemarkName(String carEndRemarkName) {
        this.carEndRemarkName = carEndRemarkName;
    }

    public String getCarEndRemark() {
        return carEndRemark;
    }

    public void setCarEndRemark(String carEndRemark) {
        this.carEndRemark = carEndRemark;
    }

    public Integer getEatDinner() {
        return eatDinner;
    }

    public void setEatDinner(Integer eatDinner) {
        this.eatDinner = eatDinner;
    }

    public Integer getEatLunch() {
        return eatLunch;
    }

    public void setEatLunch(Integer eatLunch) {
        this.eatLunch = eatLunch;
    }

    public Integer getEatWorkMeal() {
        return eatWorkMeal;
    }

    public void setEatWorkMeal(Integer eatWorkMeal) {
        this.eatWorkMeal = eatWorkMeal;
    }

    public Integer getEatPayType() {
        return eatPayType;
    }

    public void setEatPayType(Integer eatPayType) {
        this.eatPayType = eatPayType;
    }

    public String getEatAddRemark() {
        return eatAddRemark;
    }

    public void setEatAddRemark(String eatAddRemark) {
        this.eatAddRemark = eatAddRemark;
    }

    public String getEatAttention() {
        return eatAttention;
    }

    public void setEatAttention(String eatAttention) {
        this.eatAttention = eatAttention;
    }

    public Integer getEatStatus() {
        return eatStatus;
    }

    public void setEatStatus(Integer eatStatus) {
        this.eatStatus = eatStatus;
    }

    public String getEatStatusReamrkName() {
        return eatStatusReamrkName;
    }

    public void setEatStatusReamrkName(String eatStatusReamrkName) {
        this.eatStatusReamrkName = eatStatusReamrkName;
    }

    public String getEatStatusRemark() {
        return eatStatusRemark;
    }

    public void setEatStatusRemark(String eatStatusRemark) {
        this.eatStatusRemark = eatStatusRemark;
    }

    public Integer getEatEnd() {
        return eatEnd;
    }

    public void setEatEnd(Integer eatEnd) {
        this.eatEnd = eatEnd;
    }

    public String getEatEndRemarkName() {
        return eatEndRemarkName;
    }

    public void setEatEndRemarkName(String eatEndRemarkName) {
        this.eatEndRemarkName = eatEndRemarkName;
    }

    public String getEatEndRemark() {
        return eatEndRemark;
    }

    public void setEatEndRemark(String eatEndRemark) {
        this.eatEndRemark = eatEndRemark;
    }

    public Integer getEatArrange() {
        return eatArrange;
    }

    public void setEatArrange(Integer eatArrange) {
        this.eatArrange = eatArrange;
    }

    public String getEatArrangeRemark() {
        return eatArrangeRemark;
    }

    public void setEatArrangeRemark(String eatArrangeRemark) {
        this.eatArrangeRemark = eatArrangeRemark;
    }

    public String getHouseInDate() {
        return houseInDate;
    }

    public void setHouseInDate(String houseInDate) {
        this.houseInDate = houseInDate;
    }

    public String getHouseOutDate() {
        return houseOutDate;
    }

    public void setHouseOutDate(String houseOutDate) {
        this.houseOutDate = houseOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelRoomNum() {
        return hotelRoomNum;
    }

    public void setHotelRoomNum(String hotelRoomNum) {
        this.hotelRoomNum = hotelRoomNum;
    }

    public String getHotelRoomType() {
        return hotelRoomType;
    }

    public void setHotelRoomType(String hotelRoomType) {
        this.hotelRoomType = hotelRoomType;
    }

    public String getHotelVacant() {
        return hotelVacant;
    }

    public void setHotelVacant(String hotelVacant) {
        this.hotelVacant = hotelVacant;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getRoomTotal() {
        return roomTotal;
    }

    public void setRoomTotal(Integer roomTotal) {
        this.roomTotal = roomTotal;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getHousePayType() {
        return housePayType;
    }

    public void setHousePayType(Integer housePayType) {
        this.housePayType = housePayType;
    }

    public String getHouseAddRemark() {
        return houseAddRemark;
    }

    public void setHouseAddRemark(String houseAddRemark) {
        this.houseAddRemark = houseAddRemark;
    }

    public Integer getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Integer houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getHouseStatusReamrkName() {
        return houseStatusReamrkName;
    }

    public void setHouseStatusReamrkName(String houseStatusReamrkName) {
        this.houseStatusReamrkName = houseStatusReamrkName;
    }

    public String getHouseStatusRemark() {
        return houseStatusRemark;
    }

    public void setHouseStatusRemark(String houseStatusRemark) {
        this.houseStatusRemark = houseStatusRemark;
    }

    public Integer getHouseEnd() {
        return houseEnd;
    }

    public void setHouseEnd(Integer houseEnd) {
        this.houseEnd = houseEnd;
    }

    public String getHouseEndRemarkName() {
        return houseEndRemarkName;
    }

    public void setHouseEndRemarkName(String houseEndRemarkName) {
        this.houseEndRemarkName = houseEndRemarkName;
    }

    public String getHouseEndRemark() {
        return houseEndRemark;
    }

    public void setHouseEndRemark(String houseEndRemark) {
        this.houseEndRemark = houseEndRemark;
    }

    public Integer getHouseArrange() {
        return houseArrange;
    }

    public void setHouseArrange(Integer houseArrange) {
        this.houseArrange = houseArrange;
    }

    public String getHouseArrangeRemark() {
        return houseArrangeRemark;
    }

    public void setHouseArrangeRemark(String houseArrangeRemark) {
        this.houseArrangeRemark = houseArrangeRemark;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBlank() {
        return accountBlank;
    }

    public void setAccountBlank(String accountBlank) {
        this.accountBlank = accountBlank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPersonalSynopsis() {
        return personalSynopsis;
    }

    public void setPersonalSynopsis(String personalSynopsis) {
        this.personalSynopsis = personalSynopsis;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getSpeechTopic() {
        return speechTopic;
    }

    public void setSpeechTopic(String speechTopic) {
        this.speechTopic = speechTopic;
    }

    public String getActivityAddRemark() {
        return activityAddRemark;
    }

    public void setActivityAddRemark(String activityAddRemark) {
        this.activityAddRemark = activityAddRemark;
    }

    public String getActivityAddRemarkName() {
        return activityAddRemarkName;
    }

    public void setActivityAddRemarkName(String activityAddRemarkName) {
        this.activityAddRemarkName = activityAddRemarkName;
    }

    public String getSpeechFile() {
        return speechFile;
    }

    public void setSpeechFile(String speechFile) {
        this.speechFile = speechFile;
    }

    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityStatusReamrkName() {
        return activityStatusReamrkName;
    }

    public void setActivityStatusReamrkName(String activityStatusReamrkName) {
        this.activityStatusReamrkName = activityStatusReamrkName;
    }

    public String getActivityStatusRemark() {
        return activityStatusRemark;
    }

    public void setActivityStatusRemark(String activityStatusRemark) {
        this.activityStatusRemark = activityStatusRemark;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getCertificatesName() {
        return certificatesName;
    }

    public void setCertificatesName(String certificatesName) {
        this.certificatesName = certificatesName;
    }

    public String getEatPayTypeName() {
        return eatPayTypeName;
    }

    public void setEatPayTypeName(String eatPayTypeName) {
        this.eatPayTypeName = eatPayTypeName;
    }


    public String getjPayTypeName() {
        return jPayTypeName;
    }

    public void setjPayTypeName(String jPayTypeName) {
        this.jPayTypeName = jPayTypeName;
    }

    public String getsPayTypeName() {
        return sPayTypeName;
    }

    public void setsPayTypeName(String sPayTypeName) {
        this.sPayTypeName = sPayTypeName;
    }

    public String getcPayTypeName() {
        return cPayTypeName;
    }

    public void setcPayTypeName(String cPayTypeName) {
        this.cPayTypeName = cPayTypeName;
    }

    public String getHousePayTypeName() {
        return housePayTypeName;
    }

    public void setHousePayTypeName(String housePayTypeName) {
        this.housePayTypeName = housePayTypeName;
    }

    public String getEatStatusName() {
        return eatStatusName;
    }

    public void setEatStatusName(String eatStatusName) {
        this.eatStatusName = eatStatusName;
    }

    @Override
    public String toString() {
        return "TNewUser{" + "id=" + id + ", createTime=" + createTime + ", updateTime=" + updateTime + ", name=" + name
                + ", sex=" + sex + ", company=" + company + ", job=" + job + ", card=" + card + ", pickUp=" + pickUp
                + ", linkPhone=" + linkPhone + ", phone=" + phone + ", follow=" + follow + ", accompany=" + accompany
                + ", translate=" + translate + ", email=" + email + ", jUseCarDate=" + jUseCarDate + ", jUseCarTime="
                + jUseCarTime + ", jTrafficNum=" + jTrafficNum + ", jRidePlace=" + jRidePlace + ", jDestination="
                + jDestination + ", jRidePeoples=" + jRidePeoples + ", jAccompanyLeader=" + jAccompanyLeader
                + ", jPayType=" + jPayType + ", jHasStopCard=" + jHasStopCard + ", jAddRemark=" + jAddRemark
                + ", jCarArrange=" + jCarArrange + ", jDriver=" + jDriver + ", jDriverPhone=" + jDriverPhone
                + ", jCarCard=" + jCarCard + ", jCarType=" + jCarType + ", jCarSType=" + jCarSType + ", jArrangeRemark="
                + jArrangeRemark + ", sUseCarDate=" + sUseCarDate + ", sUseCarTime=" + sUseCarTime + ", sTrafficNum="
                + sTrafficNum + ", sRidePlace=" + sRidePlace + ", sDestination=" + sDestination + ", sRidePeoples="
                + sRidePeoples + ", sAccompanyLeader=" + sAccompanyLeader + ", sPayType=" + sPayType + ", sHasStopCard="
                + sHasStopCard + ", sAddRemark=" + sAddRemark + ", sCarArrange=" + sCarArrange + ", sDriver=" + sDriver
                + ", sDriverPhone=" + sDriverPhone + ", sCarCard=" + sCarCard + ", sCarType=" + sCarType
                + ", sCarSType=" + sCarSType + ", sArrangeRemark=" + sArrangeRemark + ", cUseCarDate=" + cUseCarDate
                + ", cUseCarTime=" + cUseCarTime + ", cRidePlace=" + cRidePlace + ", cDestination=" + cDestination
                + ", cRidePeoples=" + cRidePeoples + ", cAccompanyLeader=" + cAccompanyLeader + ", cPayType=" + cPayType
                + ", cHasStopCard=" + cHasStopCard + ", cAddRemark=" + cAddRemark + ", cCarArrange=" + cCarArrange
                + ", cDriver=" + cDriver + ", cDriverPhone=" + cDriverPhone + ", cCarCard=" + cCarCard + ", cCarType="
                + cCarType + ", cCarSType=" + cCarSType + ", cArrangeRemark=" + cArrangeRemark + ", carStatus="
                + carStatus + ", carStatusReamrkName=" + carStatusReamrkName + ", carStatusRemark=" + carStatusRemark
                + ", carEnd=" + carEnd + ", carEndRemarkName=" + carEndRemarkName + ", carEndRemark=" + carEndRemark
                + ", eatDinner=" + eatDinner + ", eatLunch=" + eatLunch + ", eatWorkMeal=" + eatWorkMeal
                + ", eatPayType=" + eatPayType + ", eatAddRemark=" + eatAddRemark + ", eatAttention=" + eatAttention
                + ", eatStatus=" + eatStatus + ", eatStatusReamrkName=" + eatStatusReamrkName + ", eatStatusRemark="
                + eatStatusRemark + ", eatEnd=" + eatEnd + ", eatEndRemarkName=" + eatEndRemarkName + ", eatEndRemark="
                + eatEndRemark + ", eatArrange=" + eatArrange + ", eatArrangeRemark=" + eatArrangeRemark
                + ", houseInDate=" + houseInDate + ", houseOutDate=" + houseOutDate + ", hotelName=" + hotelName
                + ", hotelRoomNum=" + hotelRoomNum + ", hotelRoomType=" + hotelRoomType + ", hotelVacant=" + hotelVacant
                + ", price=" + price + ", spliceRoom=" + spliceRoom + ", splicePeople=" + splicePeople + ", roomTotal="
                + roomTotal + ", totalPrice=" + totalPrice + ", housePayType=" + housePayType + ", houseAddRemark="
                + houseAddRemark + ", houseStatus=" + houseStatus + ", houseStatusReamrkName=" + houseStatusReamrkName
                + ", houseStatusRemark=" + houseStatusRemark + ", houseEnd=" + houseEnd + ", houseEndRemarkName="
                + houseEndRemarkName + ", houseEndRemark=" + houseEndRemark + ", houseArrange=" + houseArrange
                + ", houseArrangeRemark=" + houseArrangeRemark + ", activity=" + activity + ", accountName="
                + accountName + ", accountBlank=" + accountBlank + ", account=" + account + ", personalSynopsis="
                + personalSynopsis + ", role=" + role + ", speechTopic=" + speechTopic + ", activityAddRemark="
                + activityAddRemark + ", activityAddRemarkName=" + activityAddRemarkName + ", speechFile=" + speechFile
                + ", photoFile=" + photoFile + ", activityStatus=" + activityStatus + ", activityStatusReamrkName="
                + activityStatusReamrkName + ", activityStatusRemark=" + activityStatusRemark + ", createBy=" + createBy
                + "}";
    }
}
