package com.stylefeng.guns.modular.system.excel;

import com.stylefeng.guns.modular.system.util.ExcelColumn;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/10/10
 */
public class TeamExcel {

    @ExcelColumn(value = "公司名称", col = 1)
    private String company;
    @ExcelColumn(value = "所属区域", col = 2)
    private String area;
    @ExcelColumn(value = "公司负责人", col = 3)
    private String companyLeader;
    @ExcelColumn(value = "团队人数", col = 4)
    private Integer teamNums;
    @ExcelColumn(value = "证件类型（0：贵宾证 1：嘉宾证 2：参观证）", col = 5)
    private Integer card;
    @ExcelColumn(value = "团队联系人", col = 6)
    private String linkUser;
    @ExcelColumn(value = "联系人电话", col = 7)
    private String linkPhone;
    @ExcelColumn(value = "嘉宾对接人", col = 8)
    private String pickUp;
    @ExcelColumn(value = "接车用车日期", col = 9)
    private String jUseCarDate;
    @ExcelColumn(value = "接车用车时间", col = 10)
    private String jUseCarTime;
    @ExcelColumn(value = "接车航班车次", col = 11)
    private String jTrafficNum;
    @ExcelColumn(value = "接车乘车地点", col = 12)
    private String jRidePlace;
    @ExcelColumn(value = "接车去往的目的地", col = 13)
    private String jDestination;
    @ExcelColumn(value = "接车坐车人数", col = 14)
    private Integer jRidePeoples;
    @ExcelColumn(value = "接车陪同领导", col = 15)
    private String jAccompanyLeader;
    @ExcelColumn(value = "接车付费方式（0：自费 1：公费）", col = 16)
    private Integer jPayType;
    @ExcelColumn(value = "接车是否有停车证（0：否 1：是）", col = 17)
    private Integer jHasStopCard;
    @ExcelColumn(value = "接车备注信息", col = 18)
    private String jAddRemark;
    @ExcelColumn(value = "接车安排状态（0：未安排 1：已安排）", col = 19)
    private Integer jCarArrange;
    @ExcelColumn(value = "接车安排司机姓名", col = 20)
    private String jDriver;
    @ExcelColumn(value = "接车安排联系电话", col = 21)
    private String jDriverPhone;
    @ExcelColumn(value = "接车安排车牌号", col = 22)
    private String jCarCard;
    @ExcelColumn(value = "接车安排车类型", col = 23)
    private String jCarType;
    @ExcelColumn(value = "接车安排接送（0：未接送 1：已接送）", col = 24)
    private Integer jCarSType;
    @ExcelColumn(value = "接车安排备注内容", col = 25)
    private String jArrangeRemark;
    @ExcelColumn(value = "送车用车日期", col = 26)
    private String sUseCarDate;
    @ExcelColumn(value = "送车用车时间", col = 27)
    private String sUseCarTime;
    @ExcelColumn(value = "送车航班车次", col = 28)
    private String sTrafficNum;
    @ExcelColumn(value = "送车乘车地点", col = 29)
    private String sRidePlace;
    @ExcelColumn(value = "送车去往目的地", col = 30)
    private String sDestination;
    @ExcelColumn(value = "送车坐车人数", col = 31)
    private Integer sRidePeoples;
    @ExcelColumn(value = "送车陪同领导", col = 32)
    private String sAccompanyLeader;
    @ExcelColumn(value = "送车付费方式（0：自费 1：公费）", col = 33)
    private Integer sPayType;
    @ExcelColumn(value = "送车是否有停车证（0：否 1：是）", col = 34)
    private Integer sHasStopCard;
    @ExcelColumn(value = "送车备注信息", col = 35)
    private String sAddRemark;
    @ExcelColumn(value = "送车备注信息", col = 36)
    private Integer sCarArrange;
    @ExcelColumn(value = "送车安排司机", col = 37)
    private String sDriver;
    @ExcelColumn(value = "送车安排联系电话", col = 38)
    private String sDriverPhone;
    @ExcelColumn(value = "送车安排车牌号", col = 39)
    private String sCarCard;
    @ExcelColumn(value = "送车安排车类型", col = 40)
    private String sCarType;
    @ExcelColumn(value = "送车接送情况（0：为接送 1：已接送）", col = 41)
    private Integer sCarSType;
    @ExcelColumn(value = "送车安排备注内容", col = 42)
    private String sArrangeRemark;
    @ExcelColumn(value = "市内用车日期", col = 43)
    private String cUseCarDate;
    @ExcelColumn(value = "市内用车时间", col = 44)
    private String cUseCarTime;
    @ExcelColumn(value = "市内用车乘车地点", col = 45)
    private String cRidePlace;
    @ExcelColumn(value = "市内用车去往目的地", col = 46)
    private String cDestination;
    @ExcelColumn(value = "市内用车坐车人数", col = 47)
    private Integer cRidePeoples;
    @ExcelColumn(value = "市内用车陪同领导", col = 48)
    private String cAccompanyLeader;
    @ExcelColumn(value = "市内用车付费方式（0：自费 1：公费）", col = 49)
    private Integer cPayType;
    @ExcelColumn(value = "市内用车是否停车证（0：否 1：是）", col = 50)
    private Integer cHasStopCard;
    @ExcelColumn(value = "市内用车备注信息", col = 51)
    private String cAddRemark;
    @ExcelColumn(value = "市内用车安排状态（0：未安排 1：已安排）", col = 52)
    private Integer cCarArrange;
    @ExcelColumn(value = "市内用车安排司机", col = 53)
    private String cDriver;
    @ExcelColumn(value = "市内用车安排联系电话", col = 54)
    private String cDriverPhone;
    @ExcelColumn(value = "市内用车安排车牌号", col = 55)
    private String cCarCard;
    @ExcelColumn(value = "市内用车安排车类型", col = 56)
    private String cCarType;
    @ExcelColumn(value = "市内用车接送情况（0：未接送 1：已接送）", col = 57)
    private Integer cCarSType;
    @ExcelColumn(value = "市内用车安排备注内容", col = 58)
    private String cArrangeRemark;
    @ExcelColumn(value = "市内用车审核状态（0：未审核 1：已审核 2：已退回）", col = 59)
    private Integer carStatus;
    @ExcelColumn(value = "用车审核备注人", col = 60)
    private String carStatusReamrkName;
    @ExcelColumn(value = "市内用车备注内容", col = 61)
    private String carStatusRemark;
    @ExcelColumn(value = "用车结束状态（0：未结束 1：已结束）", col = 62)
    private Integer carEnd;
    @ExcelColumn(value = "市内用车结束备注人", col = 63)
    private String carEndRemarkName;
    @ExcelColumn(value = "市内用车结束备注信息", col = 64)
    private String carEndRemark;
    @ExcelColumn(value = "晚宴（0：否 1：是）", col = 65)
    private Integer eatDinner;
    @ExcelColumn(value = "自助午餐", col = 66)
    private Integer eatLunch;
    @ExcelColumn(value = "工作餐", col = 67)
    private Integer eatWorkMeal;
    @ExcelColumn(value = "用餐支付方式（0：自费 1：公费）", col = 68)
    private Integer eatPayType;
    @ExcelColumn(value = "用餐备注", col = 69)
    private String eatAddRemark;
    @ExcelColumn(value = "用餐注意事项", col = 70)
    private String eatAttention;
    @ExcelColumn(value = "用餐审核状态（0：未审核 1：已审核 2：已退回）", col = 71)
    private Integer eatStatus;
    @ExcelColumn(value = "用餐审核备注人", col = 72)
    private String eatStatusReamrkName;
    @ExcelColumn(value = "用餐审核备注信息", col = 73)
    private String eatStatusRemark;
    @ExcelColumn(value = "用餐结束状态（0：未结束 1：已结束）", col = 74)
    private Integer eatEnd;
    @ExcelColumn(value = "用餐结束备注人", col = 75)
    private String eatEndRemarkName;
    @ExcelColumn(value = "用餐结束备注信息", col = 76)
    private String eatEndRemark;
    @ExcelColumn(value = "用餐安排状态（0：未安排 1：已安排）", col = 77)
    private Integer eatArrange;
    @ExcelColumn(value = "用餐安排备注内容", col = 78)
    private String eatArrangeRemark;
    @ExcelColumn(value = "入住日期", col = 79)
    private String houseInDate;
    @ExcelColumn(value = "退房日期", col = 80)
    private String houseOutDate;
    @ExcelColumn(value = "酒店名称", col = 81)
    private String hotelName;
    @ExcelColumn(value = "房间号", col = 82)
    private String hotelRoomNum;
    @ExcelColumn(value = "房价类型", col = 83)
    private String hotelRoomType;
    @ExcelColumn(value = "空置床位", col = 84)
    private String hotelVacant;
    @ExcelColumn(value = "单价", col = 85)
    private Double price;
    @ExcelColumn(value = "是否拼房", col = 86)
    private String spliceRoom;
    @ExcelColumn(value = "拼房人姓名", col = 87)
    private String splicePeople;
    @ExcelColumn(value = "房间总数", col = 88)
    private Integer roomTotal;
    @ExcelColumn(value = "住房总价格", col = 89)
    private Double totalPrice;
    @ExcelColumn(value = "住房付费方式（0：自费 1：公费）", col = 90)
    private Integer housePayType;
    @ExcelColumn(value = "住房备注", col = 91)
    private String houseAddRemark;
    @ExcelColumn(value = "住房审核状态", col = 92)
    private Integer houseStatus;
    @ExcelColumn(value = "住房审核备注人", col = 93)
    private String houseStatusReamrkName;
    @ExcelColumn(value = "住房审核备注信息", col = 94)
    private String houseStatusRemark;
    @ExcelColumn(value = "住房结束状态（0：未结束 1：已结束）", col = 95)
    private Integer houseEnd;
    @ExcelColumn(value = "住房结束备注人", col = 96)
    private String houseEndRemarkName;
    @ExcelColumn(value = "住房结束备注", col = 97)
    private String houseEndRemark;
    @ExcelColumn(value = "住房安排状态（0：未安排 1：已安排）", col = 98)
    private Integer houseArrange;
    @ExcelColumn(value = "住房安排备注内容", col = 99)
    private String houseArrangeRemark;
    @ExcelColumn(value = "参与活动", col = 100)
    private String activity;
    @ExcelColumn(value = "开户姓名", col = 101)
    private String accountName;
    @ExcelColumn(value = "开户银行", col = 102)
    private String accountBlank;
    @ExcelColumn(value = "开户账号", col = 103)
    private String account;
    @ExcelColumn(value = "个人简介", col = 104)
    private String personalSynopsis;
    @ExcelColumn(value = "个人角色（0：主持人 1：演讲嘉宾 2：观众）", col = 105)
    private Integer role;
    @ExcelColumn(value = "演讲主题", col = 106)
    private String speechTopic;
    @ExcelColumn(value = "活动备注", col = 107)
    private String activityAddRemark;
    @ExcelColumn(value = "活动备注人", col = 108)
    private String activityAddRemarkName;
    @ExcelColumn(value = "活动审核状态（0：未审核 1：已审核 2：已退回）", col = 109)
    private Integer activityStatus;
    @ExcelColumn(value = "活动审核备注人", col = 110)
    private String activityStatusReamrkName;
    @ExcelColumn(value = "活动审核备注信息", col = 111)
    private String activityStatusRemark;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompanyLeader() {
        return companyLeader;
    }

    public void setCompanyLeader(String companyLeader) {
        this.companyLeader = companyLeader;
    }

    public Integer getTeamNums() {
        return teamNums;
    }

    public void setTeamNums(Integer teamNums) {
        this.teamNums = teamNums;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public String getLinkUser() {
        return linkUser;
    }

    public void setLinkUser(String linkUser) {
        this.linkUser = linkUser;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
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
}
