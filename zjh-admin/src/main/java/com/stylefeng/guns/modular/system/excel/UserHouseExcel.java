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
public class UserHouseExcel {

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
     * 入住日期（yyyy-MM-dd HH:mm:ss）
     */
    @ExcelColumn(value = "入住日期", col = 15)
    private String houseInDate;
    /**
     * 退房日期（yyyy-MM-dd HH:mm:ss）
     */
    @ExcelColumn(value = "退房日期", col = 16)
    private String houseOutDate;
    /**
     * 酒店名称
     */
    @ExcelColumn(value = "酒店名称", col = 17)
    private String hotelName;
    /**
     * 入住房间号
     */
    @ExcelColumn(value = "房间号", col = 18)
    private String hotelRoomNum;
    /**
     * 房间类型
     */
    @ExcelColumn(value = "房价类型", col = 19)
    private String hotelRoomType;
    /**
     * 空置床位
     */
    @ExcelColumn(value = "空置床位", col = 20)
    private String hotelVacant;
    /**
     * 单价
     */
    @ExcelColumn(value = "单价（100.00）", col = 21)
    private Double price;
    /**
     * 是否拼房
     */
    @ExcelColumn(value = "是否拼房", col = 22)
    private String spliceRoom;
    /**
     * 拼房人姓名
     */
    @ExcelColumn(value = "拼房人姓名", col = 23)
    private String splicePeople;
    /**
     * 房间总数
     */
    @ExcelColumn(value = "房间总数", col = 24)
    private Integer roomTotal;
    /**
     * 总价（double）
     */
    @ExcelColumn(value = "住房总价格", col = 25)
    private Double totalPrice;
    /**
     * 住房付费方式（0：自费 1：公费）
     */
    @ExcelColumn(value = "住房付费方式（0：自费 1：公费）", col = 26)
    private Integer housePayType;
    /**
     * 住房添加备注
     */
    @ExcelColumn(value = "住房备注", col = 27)
    private String houseAddRemark;
    /**
     * 住房审核状态（0：未审核 1：已审核 2：已退回）
     */
    @ExcelColumn(value = "住房审核状态（0：未审核 1：已审核 2：已退回）", col = 28)
    private Integer houseStatus;
    /**
     * 住房审核备注人
     */
    @ExcelColumn(value = "住房审核备注人", col = 29)
    private String houseStatusReamrkName;
    /**
     * 住房审核备注
     */
    @ExcelColumn(value = "住房审核备注信息", col = 30)
    private String houseStatusRemark;
    /**
     * 住房结束状态（0：未结束 1：已结束）
     */
    @ExcelColumn(value = "住房结束状态（0：未结束 1：已结束）", col = 31)
    private Integer houseEnd;
    /**
     * 住房结束备注人
     */
    @ExcelColumn(value = "住房结束备注人", col = 32)
    private String houseEndRemarkName;
    /**
     * 住房结束备注
     */
    @ExcelColumn(value = "住房结束备信息", col = 33)
    private String houseEndRemark;
    /**
     * 住房安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "住房安排（0：未安排 1：已安排）", col = 34)
    private Integer houseArrange;
    /**
     * 住房安排备注内容
     */
    @ExcelColumn(value = "住房安排备注内容", col = 35)
    private String houseArrangeRemark;

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
}
