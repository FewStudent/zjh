package com.stylefeng.guns.modular.system.excel;

import com.baomidou.mybatisplus.annotations.TableField;
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
public class TeamCarExcel {

    /**
     * 公司名称
     */
    @ExcelColumn(value = "公司名称", col = 1)
    private String company;


    /**
     * 创建时间
     * */
    @ExcelColumn(value = "创建时间",col = 2)
    private String createTime;

    /**
     * 修改时间
     * */
    @ExcelColumn(value = "修改时间",col = 3)
    private String updateTime;

    /**
     * 所属区域
     * */
    @ExcelColumn(value = "所属区域",col = 4)
    private String area;

    /**
     * 公司领导人
     * */
    @ExcelColumn(value = "公司领导人",col = 5)
    private String companyLeader;

    /**
     * 团队人数
     * */
    @ExcelColumn(value = "团队人数",col = 6)
    private Integer teamNums;


    /**
     * 证件类型（int  0：贵宾证  1：嘉宾证   2：参观证）
     * */
    @ExcelColumn(value = "证件类型（0：贵宾证  1：嘉宾证   2：参观证）",col = 7)
    private Integer card;

    /**
     * 团队联系人
     * */
    @ExcelColumn(value = "团队联系人",col = 8)
    private String linkUser;


    /**
     * 联系人电话
     * */
    @ExcelColumn(value = "联系人电话",col = 9)
    private String linkPhone;

    /**
     * 嘉宾对接人
     * */
    @ExcelColumn(value = "嘉宾对接人",col = 10)
    private String pickUp;

    /**
     * 接车用车日期 yyyy-MM-dd
     */
    @ExcelColumn(value = "接车用车日期", col = 11)
    private String jUseCarDate;
    /**
     * 接车用车额时间 HH:mm:ss
     */
    @ExcelColumn(value = "接车用车时间", col = 12)
    private String jUseCarTime;
    /**
     * 接车航班车次
     */
    @ExcelColumn(value = "接车航班车次", col = 13)
    private String jTrafficNum;
    /**
     * 接车乘车地点
     */
    @ExcelColumn(value = "接车乘车地点", col = 14)
    private String jRidePlace;
    /**
     * 接车去往目的地
     */
    @ExcelColumn(value = "接车去往的目的地", col = 15)
    private String jDestination;
    /**
     * 接车坐车人数
     */
    @ExcelColumn(value = "接车坐车人数", col = 16)
    private Integer jRidePeoples;
    /**
     * 接车陪同领导
     */
    @ExcelColumn(value = "接车陪同领导", col = 17)
    private String jAccompanyLeader;
    /**
     * 接车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "接车付费方式（0：自费 1：公费）", col = 18)
    private Integer jPayType;

    /**
     * 接车是否有停车证（0：否 1：是）
     */
    @ExcelColumn(value = "接车是否有停车证（0：否 1：是）", col = 19)
    private Integer jHasStopCard;
    /**
     * 接车添加的备注信息
     */
    @ExcelColumn(value = "接车备注信息", col = 20)
    private String jAddRemark;
    /**
     * 用车安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "接车安排状态（0：未安排 1：已安排）", col = 21)
    private Integer jCarArrange;
    /**
     * 接车安排司机姓名
     */
    @ExcelColumn(value = " 接车安排司机姓名", col = 22)
    private String jDriver;
    /**
     * 接车安排联系电话
     */
    @ExcelColumn(value = "接车安排联系电话", col = 23)
    private String jDriverPhone;
    /**
     * 接车安排车的车牌号
     */
    @ExcelColumn(value = "接车安排车的车牌号", col = 24)
    private String jCarCard;
    /**
     * 接车安排的车类型
     */
    @ExcelColumn(value = "接车安排的车类型", col = 25)
    private String jCarType;
    /**
     * 接车安排的接送情况（0：未接送 1：已接送）
     */
    @ExcelColumn(value = "接车安排的接送情况（0：未接送 1：已接送）", col = 26)
    private Integer jCarSType;
    /**
     * 接车安排备注内容
     */
    @ExcelColumn(value = "接车安排备注内容", col = 27)
    private String jArrangeRemark;
    /**
     * 送车用车日期 yyyy-MM-dd
     */
    @ExcelColumn(value = "送车用车日期", col = 28)
    private String sUseCarDate;
    /**
     * 送车用车时间 HH:mm:ss
     */
    @ExcelColumn(value = "送车用车时间", col = 29)
    private String sUseCarTime;
    /**
     * 送车航班车次
     */
    @ExcelColumn(value = "送车航班车次", col = 30)
    private String sTrafficNum;
    /**
     * 送车乘车地点
     */
    @ExcelColumn(value = "送车乘车地点", col = 31)
    private String sRidePlace;
    /**
     * 送车去往目的地
     */
    @ExcelColumn(value = "送车去往目的地", col = 32)
    private String sDestination;
    /**
     * 送车坐车人数
     */
    @ExcelColumn(value = "送车坐车人数", col = 33)
    private Integer sRidePeoples;
    /**
     * 送车陪同领导
     */
    @ExcelColumn(value = "送车陪同领导", col = 34)
    private String sAccompanyLeader;
    /**
     * 送车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "送车付费方式（0：自费 1：公费）", col = 35)
    private Integer sPayType;
    /**
     * 送车是否有停车证（0：否 1：是）
     */
    @ExcelColumn(value = "送车是否有停车证（0：否 1：是）", col = 36)
    private Integer sHasStopCard;
    /**
     * 送车添加的备注信息
     */
    @ExcelColumn(value = "送车备注信息", col = 37)
    private String sAddRemark;
    /**
     * 送车用车安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "送车用车安排状态（0：未安排 1：已安排）", col = 38)
    private Integer sCarArrange;
    /**
     * 送车安排司机姓名
     */
    @ExcelColumn(value = "送车安排司机姓名", col = 39)
    private String sDriver;
    /**
     * 送车安排联系电话
     */
    @ExcelColumn(value = "送车安排联系电话", col = 40)
    private String sDriverPhone;
    /**
     * 送车安排车的车牌号
     */
    @ExcelColumn(value = "送车安排车的车牌号", col = 41)
    private String sCarCard;
    /**
     * 送车安排的车类型
     */
    @ExcelColumn(value = "送车安排的车类型", col = 42)
    private String sCarType;
    /**
     * 送车安排的接送情况（0：未接送 1：已接送）
     */
    @ExcelColumn(value = "送车安排的接送情况（0：未接送 1：已接送）", col = 43)
    private Integer sCarSType;
    /**
     * 送车安排备注内容
     */
    @ExcelColumn(value = "送车安排备注内容", col = 44)
    private String sArrangeRemark;
    /**
     * 市内用车日期 yyyy-MM-dd
     */
    @ExcelColumn(value = "市内用车日期", col = 45)
    private String cUseCarDate;
    /**
     * 市内用车时间 HH:mm:ss
     */
    @ExcelColumn(value = "市内用车时间", col = 46)
    private String cUseCarTime;
    /**
     * 市内用车乘车地点
     */
    @ExcelColumn(value = "市内用车乘车地点", col = 47)
    private String cRidePlace;
    /**
     * 市内用车去往目的地
     */
    @ExcelColumn(value = "市内用车去往目的地", col = 48)
    private String cDestination;
    /**
     * 市内用车坐车人数
     */
    @ExcelColumn(value = "市内用车坐车人数", col = 49)
    private Integer cRidePeoples;
    /**
     * 市内用车陪同领导
     */
    @ExcelColumn(value = "市内用车陪同领导", col = 50)
    private String cAccompanyLeader;
    /**
     * 市内用车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "市内用车付费方式（0：自费 1：公费）", col = 51)
    private Integer cPayType;
    /**
     * 市内用车是否有停车证（0：否 1：是）
     */
    @ExcelColumn(value = "市内用车是否停车证（0：否 1：是）", col = 52)
    private Integer cHasStopCard;
    /**
     * 市内用车添加的备注信息
     */
    @ExcelColumn(value = "市内用车备注信息", col = 53)
    private String cAddRemark;
    /**
     * 市内用车安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "市内用车安排状态（0：未安排 1：已安排）", col = 54)
    private Integer cCarArrange;
    /**
     * 市内用车安排司机姓名
     */
    @ExcelColumn(value = "市内用车安排司机姓名", col = 55)
    private String cDriver;
    /**
     * 市内用车安排联系电话
     */
    @ExcelColumn(value = "市内用车安排联系电话", col = 56)
    private String cDriverPhone;
    /**
     * 市内用车安排车的车牌号
     */
    @ExcelColumn(value = "市内用车安排车的车牌号", col = 57)
    private String cCarCard;
    /**
     * 市内用车安排的车类型
     */
    @ExcelColumn(value = "市内用车安排的车类型", col = 58)
    private String cCarType;
    /**
     * 市内同车安排的接送情况（0：未接送 1：已接送）
     */
    @ExcelColumn(value = "市内同车安排的接送情况（0：未接送 1：已接送）", col = 59)
    private Integer cCarSType;
    /**
     * 市内用车安排备注内容
     */
    @ExcelColumn(value = "市内用车安排备注内容", col = 60)
    private String cArrangeRemark;
    /**
     * 用车审核状态（0：未审核 1：已审核 2：已退回）
     */
    @ExcelColumn(value = "用车审核状态（0：未审核 1：已审核 2：已退回）", col = 61)
    private Integer carStatus;
    /**
     * 用车审核备注人
     */
    @ExcelColumn(value = "用车审核备注人", col = 62)
    private String carStatusReamrkName;
    /**
     * 用车审核备注
     */
    @ExcelColumn(value = "用车审核备注", col = 63)
    private String carStatusRemark;
    /**
     * 用车结束（0：未结束 1：已结束）
     */
    @ExcelColumn(value = " 用车结束（0：未结束 1：已结束）", col = 64)
    private Integer carEnd;
    /**
     * 用车结束备注人
     */
    @ExcelColumn(value = "用车结束备注人", col = 65)
    private String carEndRemarkName;
    /**
     * 用车结束备注
     */
    @ExcelColumn(value = "用车结束备注", col = 66)
    private String carEndRemark;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
}
