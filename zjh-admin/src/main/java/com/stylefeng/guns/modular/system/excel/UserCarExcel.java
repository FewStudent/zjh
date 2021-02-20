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
public class UserCarExcel {

    /**
     * 客户姓名
     */
    @ExcelColumn(value = "客户姓名", col = 1)
    private String name;

    /**
     * 创建时间
     * */
    @ExcelColumn(value = "创建时间",col = 2)
    private String createTime;

    /**
     * 联系人对话
     * */
    @ExcelColumn(value = "联系人电话",col = 3)
    private String linkPhone;

    /**
     * 修改时间
     * */
    @ExcelColumn(value = "修改时间",col = 4)
    private String updateTime;

    /**
     * 性别（0：男   1：女）
     * */
    @ExcelColumn(value = "性别（0：男   1：女）",col = 5)
    private Integer sex;

    /**
     * 所属公司
     * */
    @ExcelColumn(value = "所属公司",col = 6)
    private String company;

    /**
     * 职位
     * */
    @ExcelColumn(value = "职位",col = 7)
    private String job;

    /**
     * 证件类型（int  0：贵宾证  1：嘉宾证   2：参观证）
     * */
    @ExcelColumn(value = "证件类型（ 0：贵宾证  1：嘉宾证   2：参观证）",col = 8)
    private Integer card;

    /**
     * 嘉宾对接人
     * */
    @ExcelColumn(value = "嘉宾对接人",col = 9)
    private String pickUp;

    /**
     * 电话
     * */
    @ExcelColumn(value = "联系电话",col = 10)
    private String phone;

    /**
     * 邮箱
     * */
    @ExcelColumn(value = "邮箱",col = 11)
    private String email;

    /**
     * 随从人员
     * */
    @ExcelColumn(value = "随从人员",col = 12)
    private String follow;

    /**
     * 陪同人员
     * */
    @ExcelColumn(value = "陪同人员",col = 13)
    private String accompany;

    /**
     * 翻译人员
     * */
    @ExcelColumn(value = "翻译人员",col = 14)
    private String translate;

    /**
     * 接车用车日期 yyyy-MM-dd
     */
    @ExcelColumn(value = "接车用车日期", col = 15)
    private String jUseCarDate;
    /**
     * 接车用车额时间 HH:mm:ss
     */
    @ExcelColumn(value = "接车用车时间", col = 16)
    private String jUseCarTime;
    /**
     * 接车航班车次
     */
    @ExcelColumn(value = "接车航班车次", col = 17)
    private String jTrafficNum;
    /**
     * 接车乘车地点
     */
    @ExcelColumn(value = "接车乘车地点", col = 18)
    private String jRidePlace;
    /**
     * 接车去往目的地
     */
    @ExcelColumn(value = "接车去往的目的地", col = 19)
    private String jDestination;
    /**
     * 接车坐车人数
     */
    @ExcelColumn(value = "接车坐车人数", col = 20)
    private Integer jRidePeoples;
    /**
     * 接车陪同领导
     */
    @ExcelColumn(value = "接车陪同领导", col = 21)
    private String jAccompanyLeader;
    /**
     * 接车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "接车付费方式（0：自费 1：公费）", col = 22)
    private Integer jPayType;

    /**
     * 接车是否有停车证（0：否 1：是）
     */
    @ExcelColumn(value = "接车是否有停车证（0：否 1：是）", col = 23)
    private Integer jHasStopCard;
    /**
     * 接车添加的备注信息
     */
    @ExcelColumn(value = "接车备注信息", col = 24)
    private String jAddRemark;
    /**
     * 用车安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "接车安排状态（0：未安排 1：已安排）", col = 25)
    private Integer jCarArrange;
    /**
     * 接车安排司机姓名
     */
    @ExcelColumn(value = "接车安排司机姓名", col = 26)
    private String jDriver;
    /**
     * 接车安排联系电话
     */
    @ExcelColumn(value = "接车安排联系电话", col = 27)
    private String jDriverPhone;
    /**
     * 接车安排车的车牌号
     */
    @ExcelColumn(value = "接车安排车的车牌号", col = 28)
    private String jCarCard;
    /**
     * 接车安排的车类型
     */
    @ExcelColumn(value = "接车安排的车类型", col = 29)
    private String jCarType;
    /**
     * 接车安排的接送情况（0：未接送 1：已接送）
     */
    @ExcelColumn(value = "接车安排的接送情况（0：未接送 1：已接送）", col = 30)
    private Integer jCarSType;
    /**
     * 接车安排备注内容
     */
    @ExcelColumn(value = "接车安排备注内容", col = 31)
    private String jArrangeRemark;
    /**
     * 送车用车日期 yyyy-MM-dd
     */
    @ExcelColumn(value = "送车用车日期", col = 32)
    private String sUseCarDate;
    /**
     * 送车用车时间 HH:mm:ss
     */
    @ExcelColumn(value = "送车用车时间", col = 33)
    private String sUseCarTime;
    /**
     * 送车航班车次
     */
    @ExcelColumn(value = "送车航班车次", col = 34)
    private String sTrafficNum;
    /**
     * 送车乘车地点
     */
    @ExcelColumn(value = "送车乘车地点", col = 35)
    private String sRidePlace;
    /**
     * 送车去往目的地
     */
    @ExcelColumn(value = "送车去往目的地", col = 36)
    private String sDestination;
    /**
     * 送车坐车人数
     */
    @ExcelColumn(value = "送车坐车人数", col = 37)
    private Integer sRidePeoples;
    /**
     * 送车陪同领导
     */
    @ExcelColumn(value = "送车陪同领导", col = 38)
    private String sAccompanyLeader;
    /**
     * 送车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "送车付费方式（0：自费 1：公费）", col = 39)
    private Integer sPayType;
    /**
     * 送车是否有停车证（0：否 1：是）
     */
    @ExcelColumn(value = "送车是否有停车证（0：否 1：是）", col = 40)
    private Integer sHasStopCard;
    /**
     * 送车添加的备注信息
     */
    @ExcelColumn(value = "送车备注信息", col = 41)
    private String sAddRemark;
    /**
     * 送车用车安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "送车安排状态（0：未安排 1：已安排）", col = 42)
    private Integer sCarArrange;
    /**
     * 送车安排司机姓名
     */
    @ExcelColumn(value = "送车安排司机姓名", col = 43)
    private String sDriver;
    /**
     * 送车安排联系电话
     */
    @ExcelColumn(value = "送车安排联系电话", col = 44)
    private String sDriverPhone;
    /**
     * 送车安排车的车牌号
     */
    @ExcelColumn(value = "送车安排车的车牌号", col = 45)
    private String sCarCard;
    /**
     * 送车安排的车类型
     */
    @ExcelColumn(value = "送车安排的车类型", col = 46)
    private String sCarType;
    /**
     * 送车安排的接送情况（0：未接送 1：已接送）
     */
    @ExcelColumn(value = "送车安排的接送情况（0：未接送 1：已接送）", col = 47)
    private Integer sCarSType;
    /**
     * 送车安排备注内容
     */
    @ExcelColumn(value = "送车安排备注内容", col = 48)
    private String sArrangeRemark;
    /**
     * 市内用车日期 yyyy-MM-dd
     */
    @ExcelColumn(value = "市内用车日期", col = 49)
    private String cUseCarDate;
    /**
     * 市内用车时间 HH:mm:ss
     */
    @ExcelColumn(value = "市内用车时间", col = 50)
    private String cUseCarTime;
    /**
     * 市内用车乘车地点
     */
    @ExcelColumn(value = "市内用车乘车地点", col = 51)
    private String cRidePlace;
    /**
     * 市内用车去往目的地
     */
    @ExcelColumn(value = "市内用车去往目的地", col = 52)
    private String cDestination;
    /**
     * 市内用车坐车人数
     */
    @ExcelColumn(value = "市内用车坐车人数", col = 53)
    private Integer cRidePeoples;
    /**
     * 市内用车陪同领导
     */
    @ExcelColumn(value = "市内用车陪同领导", col = 54)
    private String cAccompanyLeader;
    /**
     * 市内用车付费方式（int 0：自费 1：公费）
     */
    @ExcelColumn(value = "市内用车付费方式（0：自费 1：公费）", col = 55)
    private Integer cPayType;
    /**
     * 市内用车是否有停车证（0：否 1：是）
     */
    @ExcelColumn(value = "市内用车是否停车证（0：否 1：是）", col = 56)
    private Integer cHasStopCard;
    /**
     * 市内用车添加的备注信息
     */
    @ExcelColumn(value = "市内用车备注信息", col = 57)
    private String cAddRemark;
    /**
     * 市内用车安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "市内用车安排状态（0：未安排 1：已安排）", col = 58)
    private Integer cCarArrange;
    /**
     * 市内用车安排司机姓名
     */
    @ExcelColumn(value = "市内用车安排司机姓名", col = 59)
    private String cDriver;
    /**
     * 市内用车安排联系电话
     */
    @ExcelColumn(value = "内用车安排联系电话", col = 60)
    private String cDriverPhone;
    /**
     * 市内用车安排车的车牌号
     */
    @ExcelColumn(value = "市内用车安排车的车牌号", col = 61)
    private String cCarCard;
    /**
     * 市内用车安排的车类型
     */
    @ExcelColumn(value = "市内用车安排的车类型", col = 62)
    private String cCarType;
    /**
     * 市内同车安排的接送情况（0：未接送 1：已接送）
     */
    @ExcelColumn(value = "市内同车安排的接送情况（0：未接送 1：已接送）", col = 63)
    private Integer cCarSType;
    /**
     * 市内用车安排备注内容
     */
    @ExcelColumn(value = "市内用车安排备注内容", col = 64)
    private String cArrangeRemark;
    /**
     * 用车审核状态（0：未审核 1：已审核 2：已退回）
     */
    @ExcelColumn(value = "用车审核状态（0：未审核 1：已审核 2：已退回）", col = 65)
    private Integer carStatus;
    /**
     * 用车审核备注人
     */
    @ExcelColumn(value = "用车审核备注人", col = 66)
    private String carStatusReamrkName;
    /**
     * 用车审核备注
     */
    @ExcelColumn(value = "用车审核备注", col = 67)
    private String carStatusRemark;
    /**
     * 用车结束（0：未结束 1：已结束）
     */
    @ExcelColumn(value = "用车结束（0：未结束 1：已结束）", col = 68)
    private Integer carEnd;
    /**
     * 用车结束备注人
     */
    @ExcelColumn(value = "用车结束备注人", col = 69)
    private String carEndRemarkName;
    /**
     * 用车结束备注
     */
    @ExcelColumn(value = "用车结束备注", col = 70)
    private String carEndRemark;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
