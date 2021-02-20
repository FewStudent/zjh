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
public class TeamHouseExcel {

    /**
     * 公司名称
     */
    @ExcelColumn(value = "公司名称",col = 1)
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
    @ExcelColumn(value = "证件类型(0：贵宾证  1：嘉宾证   2：参观证）",col = 7)
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
     * 入住日期（yyyy-MM-dd HH:mm:ss）
     */
    @ExcelColumn(value = "入住日期", col = 11)
    private String houseInDate;
    /**
     * 退房日期（yyyy-MM-dd HH:mm:ss）
     */
    @ExcelColumn(value = "退房日期", col = 12)
    private String houseOutDate;
    /**
     * 酒店名称
     */
    @ExcelColumn(value = "酒店名称", col = 13)
    private String hotelName;
    /**
     * 入住房间号
     */
    @ExcelColumn(value = "房间号", col = 14)
    private String hotelRoomNum;
    /**
     * 房间类型
     */
    @ExcelColumn(value = "房价类型", col = 15)
    private String hotelRoomType;
    /**
     * 空置床位
     */
    @ExcelColumn(value = "空置床位", col = 16)
    private String hotelVacant;
    /**
     * 单价
     */
    @ExcelColumn(value = "单价（100.00）", col = 17)
    private Double price;
    /**
     * 是否拼房
     */
    @ExcelColumn(value = "是否拼房", col = 18)
    private String spliceRoom;
    /**
     * 拼房人姓名
     */
    @ExcelColumn(value = "拼房人姓名", col = 19)
    private String splicePeople;
    /**
     * 房间总数
     */
    @ExcelColumn(value = "房间总数", col = 20)
    private Integer roomTotal;
    /**
     * 总价（double）
     */
    @ExcelColumn(value = "住房总价格", col = 21)
    private Double totalPrice;
    /**
     * 住房付费方式（0：自费 1：公费）
     */
    @ExcelColumn(value = "住房付费方式（0：自费 1：公费）", col = 22)
    private Integer housePayType;
    /**
     * 住房添加备注
     */
    @ExcelColumn(value = "住房备注", col = 23)
    private String houseAddRemark;
    /**
     * 住房审核状态（0：未审核 1：已审核 2：已退回）
     */
    @ExcelColumn(value = "住房审核状态（0：未审核 1：已审核 2：已退回）", col = 24)
    private Integer houseStatus;
    /**
     * 住房审核备注人
     */
    @ExcelColumn(value = "住房审核备注人", col = 25)
    private String houseStatusReamrkName;
    /**
     * 住房审核备注
     */
    @ExcelColumn(value = "住房审核备注信息", col = 26)
    private String houseStatusRemark;
    /**
     * 住房结束状态（0：未结束 1：已结束）
     */
    @ExcelColumn(value = "住房结束状态（0：未结束 1：已结束）", col = 27)
    private Integer houseEnd;
    /**
     * 住房结束备注人
     */
    @ExcelColumn(value = "住房结束备注人", col = 28)
    private String houseEndRemarkName;
    /**
     * 住房结束备注
     */
    @ExcelColumn(value = "住房结束备信息", col = 29)
    private String houseEndRemark;
    /**
     * 住房安排状态（0：未安排 1：已安排）
     */
    @ExcelColumn(value = "住房安排（0：未安排 1：已安排）", col = 30)
    private Integer houseArrange;
    /**
     * 住房安排备注内容
     */
    @ExcelColumn(value = "住房安排备注内容", col = 31)
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
