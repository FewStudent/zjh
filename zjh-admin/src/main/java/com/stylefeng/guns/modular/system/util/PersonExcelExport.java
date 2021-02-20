package com.stylefeng.guns.modular.system.util;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/25
 */
public class PersonExcelExport {

    //*************************基础信息 **************************

    /**
     * 用户姓名
     */
    @ExcelColumn(value = "用户名", col = 1)
    private String name;
    /**
     * 性别（0：男  1：女）
     */
    @ExcelColumn(value = "性别（0：男  1：女）", col = 2)
    private Integer sex;
    /**
     * 性别名称.
     */
    @TableField(exist = false)
    private String sexName;
    /**
     * 公司/单位
     */
    @ExcelColumn(value = "公司单位", col = 3)
    private String company;
    /**
     * 职务
     */
    @ExcelColumn(value = "公司职务", col = 4)
    private String job;
    /**
     * 电话号码
     */
    @ExcelColumn(value = "电话号码", col = 5)
    private String phone;
    /**
     * 邮件
     */
    @ExcelColumn(value = "邮箱", col = 6)
    private String email;
    /**
     * 是否有跟随人员（ 0：否    1：是）
     */
    @ExcelColumn(value = "是否有跟随人员（ 0：否  1：是）", col = 7)
    private Integer follow;
    /**
     * 跟随人员姓名
     */
    @ExcelColumn(value = "跟随人姓名", col = 8)
    private String followName;
    /**
     * 嘉宾对接人姓名
     */
    @ExcelColumn(value = "嘉宾对接人", col = 9)
    private String pickUpUser;
    /**
     * 证件类型（0：贵宾证 1：嘉宾证  2：参观证）
     */
    @ExcelColumn(value = "证件类型（0：贵宾证 1：嘉宾证  2：参观证）", col = 10)
    private Integer certificates;
    /**
     * 证件类型名称（辅助字段）
     */
    @TableField(exist = false)
    private String certificatesName;
    /**
     * 是否需要陪同（  0：否    1：是）
     */
    @ExcelColumn(value = "是否需要陪同（0：否 1：是）", col = 11)
    private Integer accompany;
    /**
     * 陪同名称（辅助字段）
     */
    @TableField(exist = false)
    private String accompanyName;
    /**
     * 是否需要翻译（   0：否     1：是）
     */
    @ExcelColumn(value = "是否需要翻译（0：否 1：是）", col = 12)
    private Integer translate;
    //********************************档案信息****************
    /**
     * 参与活动
     */
    @ExcelColumn(value = "参与活动", col = 13)
    private String activity;
    /**
     * 个人简介
     */
    @ExcelColumn(value = "个人简介", col = 14)
    private String personalSynopsis;
    /**
     * 角色名称
     */
    @ExcelColumn(value = "角色名称", col = 15)
    private String role;
    /**
     * 演讲主题
     */
    @ExcelColumn(value = "演讲主题", col = 16)
    @TableField("speech_topic")
    private String speechTopic;
    /**
     * 开户姓名
     */
    @ExcelColumn(value = "开户姓名", col = 17)
    private String accountName;
    /**
     * 开户银行
     */
    @ExcelColumn(value = "开户银行", col = 18)
    private String accountBlank;
    /**
     * 开户账号
     */
    @ExcelColumn(value = "开户账号", col = 19)
    private String account;
    /**
     * 添加备注内容
     */
    @ExcelColumn(value = "档案添加备注内容", col = 20)
    private String archive_remarkContent;
    /**
     * 添加备注人姓名
     */
    @ExcelColumn(value = "档案添加备注人姓名", col = 21)
    private String archive_remarkName;
    /**
     * 审核状态（int   0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "档案审核状态（0：未审核 1：已审核 2：未审核）", col = 22)
    private Integer archive_status;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "档案审核时间", col = 23)
    private String archive_statusDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "档案审核备注人", col = 24)
    private String archive_sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "档案审核备注内容", col = 25)
    private String archive_sRemarkContent;

    //*****************  用车******************************
    /**
     * 用车事项（int   0：接人   1：送客）
     */
    @ExcelColumn(value = "用车事项（ 0：接人  1：送客）", col = 26)
    private Integer attention;
    /**
     * 航班/车次
     */
    @ExcelColumn(value = "航班/车次", col = 27)
    private String trafficNumber;
    /**
     * 用车日期
     */
    @ExcelColumn(value = "用车日期", col = 28)
    private String needCarDate;
    /**
     * 用车时间
     */
    @ExcelColumn(value = "用车时间", col = 29)
    private String needCarTime;
    /**
     * 乘车地点
     */
    @ExcelColumn(value = "乘车地点", col = 30)
    private String ridePlace;
    /**
     * 目的地
     */
    @ExcelColumn(value = "目的地", col = 31)
    private String destination;
    /**
     * 乘车 人数
     */
    @ExcelColumn(value = "乘车人数", col = 32)
    private Integer ridePeoples;
    /**
     * 陪同领导
     */
    @ExcelColumn(value = "陪同领导", col = 33)
    private String accompanyLeader;
    /**
     * 费用承担方式（0：自费   1：公费）
     */
    @ExcelColumn(value = "用车费用承担方式（0：自费  1：公费）", col = 34)
    @TableField("pay_type")
    private Integer payType;

    /**
     * 停车费用
     */
    @ExcelColumn(value = "停车费用", col = 35)
    private Double stopPrice;
    /**
     * 审核状态（0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "用车审核状态（0：未审核   1：已审核   2：未审核）", col = 36)
    private Integer car_status;
    /**
     * 是否已经结束（0：否  1：是）
     */
    @ExcelColumn(value = "用车是否已经结束（0：否  1：是）", col = 37)
    private Integer car_end;
    /**
     * 添加备注人姓名
     */
    @ExcelColumn(value = "用车添加备注人姓名", col = 38)
    private String car_remarkName;
    /**
     * 添加备注内容
     */
    @ExcelColumn(value = "用车添加备注内容", col = 15)
    private String car_remarkContent;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "用车审核时间", col = 39)
    private String car_statusDate;
    /**
     * 结束时间
     */
    @ExcelColumn(value = "用车结束时间", col = 40)
    private String car_endDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "用车审核备注人", col = 41)
    private String car_sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "用车审核备注内容", col = 42)
    private String car_sRemarkContent;
    /**
     * 结束备注人
     */
    @ExcelColumn(value = "用车结束备注人", col = 43)
    private String car_eRemarkName;
    /**
     * 结束备注内容
     */
    @ExcelColumn(value = "用车结束备注内容", col = 44)
    private String eRemarkContent;
    // 司机
    @ExcelColumn(value = "司机", col = 45)
    private String driver;
    // 司机电话号码
    @ExcelColumn(value = "司机手机", col = 46)
    private String driverPhone;
    //车牌号
    @ExcelColumn(value = "车牌号", col = 47)
    private String carNum;
    // 车型
    @ExcelColumn(value = "车型号", col = 48)
    private String catType;
    // ***************** 用餐 *******************
    /**
     * 餐饮
     */
    @ExcelColumn(value = "餐饮", col = 49)
    private String restaurant;
    /**
     * 用餐时间
     */
    @ExcelColumn(value = "用餐时间", col = 50)
    private String restaurantDate;
    /**
     * 用餐人数
     */
    @ExcelColumn(value = "用餐人数", col = 51)
    private Integer restaurantPeoples;
    /**
     * 用餐注意事项
     */
    @ExcelColumn(value = "用餐注意事项", col = 52)
    private String restaurantAttention;
    /**
     * 费用承担方式（0：自费   1：公费）
     */
    @ExcelColumn(value = "用餐费用承担方式（0：自费   1：公费）", col = 53)
    private Integer eat_payType;
    /**
     * 审核状态（int   0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "用餐审核状态（ 0：未审核 1：已审核 2：未审核）", col = 54)
    private Integer eat_status;
    /**
     * 是否结束（0：否  1：是）
     */
    @ExcelColumn(value = "用餐是否结束（0：否  1：是）", col = 55)
    private Integer eat_end;
    /**
     * 备注人姓名
     */
    @ExcelColumn(value = "用餐添加备注人姓名", col = 56)
    private String eat_remarkName;
    /**
     * 备注内容
     */
    @ExcelColumn(value = "用餐添加备注内容", col = 57)
    private String eat_remarkContent;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "用餐审核时间", col = 58)
    private String eat_statusDate;
    /**
     * 结束时间
     */
    @ExcelColumn(value = "用餐结束时间", col = 59)
    private String eat_endDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "用餐审核备注人", col = 60)
    private String eat_sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "用餐审核备注内容", col = 61)
    private String eat_sRemarkContent;
    /**
     * 结束备注人
     */
    @ExcelColumn(value = "用餐结束备注人", col = 62)
    private String eat_eRemarkName;
    /**
     * 结束备注内容
     */
    @ExcelColumn(value = "用餐结束备注时间", col = 65)
    private String eat_eRemarkContent;
    //***********************住房信息********************
    /**
     * 酒店名称
     */
    @ExcelColumn(value = "酒店", col = 67)
    private String hotel;
    /**
     * 入住日期
     */
    @ExcelColumn(value = "入住日期", col = 68)
    private String checkInDate;
    /**
     * 退房日期
     */
    @ExcelColumn(value = "退房日期", col = 69)
    private String checkOutDate;
    /**
     * 房间类型
     */
    @ExcelColumn(value = "房间类型", col = 70)
    private String roomType;
    /**
     * 单价
     */
    @ExcelColumn(value = "单价", col = 71)
    private Double price;
    /**
     * 房间数
     */
    @ExcelColumn(value = "房间数", col = 72)
    private Integer total;
    /**
     * 总价格
     */
    @ExcelColumn(value = "总价格", col = 73)
    private Double totalPrice;
    /**
     * 费用承担方式（0：自费   1：公费）
     */
    @ExcelColumn(value = "住房费用承担方式（0：自费   1：公费）", col = 74)
    private Integer house_payType;
    /**
     * 入住房间号
     */
    @ExcelColumn(value = "入住房间号", col = 75)
    @TableField("room_num")
    private String roomNum;
    /**
     * 空置床位
     */
    @ExcelColumn(value = "空置床位", col = 76)
    private String vacant;
    /**
     * 是否拼房
     */
    @ExcelColumn(value = "是否拼房", col = 77)
    @TableField("splice_room")
    private String spliceRoom;
    /**
     * 拼房人姓名
     */
    @ExcelColumn(value = "拼房人姓名", col = 78)
    private String splicePeople;
    /**
     * 审核状态（int   0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "住房审核状态（ 0：未审核   1：已审核   2：未审核）", col = 79)
    private Integer house_status;

    /**
     * 备注内容
     */
    @ExcelColumn(value = "住房添加备注内容", col = 80)
    private String house_remarkContent;
    /**
     * 备注人姓名
     */
    @ExcelColumn(value = "住房添加备注人", col = 81)
    private String house_remarkName;
    /**
     * 是否结束（0：否  1：是）
     */
    @ExcelColumn(value = "住房是否结束（0：否  1：是）", col = 82)
    private Integer end;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "住房审核时间", col = 83)
    private String house_statusDate;
    /**
     * 结束时间
     */
    @ExcelColumn(value = "住房结束时间", col = 84)
    private String house_endDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "住房审核备注人", col = 85)
    private String house_sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "住房审核备注内容", col = 86)
    private String house_sRemarkContent;
    /**
     * 结束备注人
     */
    @ExcelColumn(value = "住房结束备注人", col = 87)
    private String house_eRemarkName;
    /**
     * 结束备注内容
     */
    @ExcelColumn(value = "住房结束备注内容", col = 88)
    private String house_eRemarkContent;

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

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
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

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
    }

    public String getPickUpUser() {
        return pickUpUser;
    }

    public void setPickUpUser(String pickUpUser) {
        this.pickUpUser = pickUpUser;
    }

    public Integer getCertificates() {
        return certificates;
    }

    public void setCertificates(Integer certificates) {
        this.certificates = certificates;
    }

    public String getCertificatesName() {
        return certificatesName;
    }

    public void setCertificatesName(String certificatesName) {
        this.certificatesName = certificatesName;
    }

    public Integer getAccompany() {
        return accompany;
    }

    public void setAccompany(Integer accompany) {
        this.accompany = accompany;
    }

    public String getAccompanyName() {
        return accompanyName;
    }

    public void setAccompanyName(String accompanyName) {
        this.accompanyName = accompanyName;
    }

    public Integer getTranslate() {
        return translate;
    }

    public void setTranslate(Integer translate) {
        this.translate = translate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPersonalSynopsis() {
        return personalSynopsis;
    }

    public void setPersonalSynopsis(String personalSynopsis) {
        this.personalSynopsis = personalSynopsis;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSpeechTopic() {
        return speechTopic;
    }

    public void setSpeechTopic(String speechTopic) {
        this.speechTopic = speechTopic;
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

    public String getArchive_remarkContent() {
        return archive_remarkContent;
    }

    public void setArchive_remarkContent(String archive_remarkContent) {
        this.archive_remarkContent = archive_remarkContent;
    }

    public String getArchive_remarkName() {
        return archive_remarkName;
    }

    public void setArchive_remarkName(String archive_remarkName) {
        this.archive_remarkName = archive_remarkName;
    }

    public Integer getArchive_status() {
        return archive_status;
    }

    public void setArchive_status(Integer archive_status) {
        this.archive_status = archive_status;
    }

    public String getArchive_statusDate() {
        return archive_statusDate;
    }

    public void setArchive_statusDate(String archive_statusDate) {
        this.archive_statusDate = archive_statusDate;
    }

    public String getArchive_sRemarkName() {
        return archive_sRemarkName;
    }

    public void setArchive_sRemarkName(String archive_sRemarkName) {
        this.archive_sRemarkName = archive_sRemarkName;
    }

    public String getArchive_sRemarkContent() {
        return archive_sRemarkContent;
    }

    public void setArchive_sRemarkContent(String archive_sRemarkContent) {
        this.archive_sRemarkContent = archive_sRemarkContent;
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

    public Integer getCar_status() {
        return car_status;
    }

    public void setCar_status(Integer car_status) {
        this.car_status = car_status;
    }

    public Integer getCar_end() {
        return car_end;
    }

    public void setCar_end(Integer car_end) {
        this.car_end = car_end;
    }

    public String getCar_remarkName() {
        return car_remarkName;
    }

    public void setCar_remarkName(String car_remarkName) {
        this.car_remarkName = car_remarkName;
    }

    public String getCar_remarkContent() {
        return car_remarkContent;
    }

    public void setCar_remarkContent(String car_remarkContent) {
        this.car_remarkContent = car_remarkContent;
    }

    public String getCar_statusDate() {
        return car_statusDate;
    }

    public void setCar_statusDate(String car_statusDate) {
        this.car_statusDate = car_statusDate;
    }

    public String getCar_endDate() {
        return car_endDate;
    }

    public void setCar_endDate(String car_endDate) {
        this.car_endDate = car_endDate;
    }

    public String getCar_sRemarkName() {
        return car_sRemarkName;
    }

    public void setCar_sRemarkName(String car_sRemarkName) {
        this.car_sRemarkName = car_sRemarkName;
    }

    public String getCar_sRemarkContent() {
        return car_sRemarkContent;
    }

    public void setCar_sRemarkContent(String car_sRemarkContent) {
        this.car_sRemarkContent = car_sRemarkContent;
    }

    public String getCar_eRemarkName() {
        return car_eRemarkName;
    }

    public void setCar_eRemarkName(String car_eRemarkName) {
        this.car_eRemarkName = car_eRemarkName;
    }

    public String geteRemarkContent() {
        return eRemarkContent;
    }

    public void seteRemarkContent(String eRemarkContent) {
        this.eRemarkContent = eRemarkContent;
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

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getRestaurantDate() {
        return restaurantDate;
    }

    public void setRestaurantDate(String restaurantDate) {
        this.restaurantDate = restaurantDate;
    }

    public Integer getRestaurantPeoples() {
        return restaurantPeoples;
    }

    public void setRestaurantPeoples(Integer restaurantPeoples) {
        this.restaurantPeoples = restaurantPeoples;
    }

    public String getRestaurantAttention() {
        return restaurantAttention;
    }

    public void setRestaurantAttention(String restaurantAttention) {
        this.restaurantAttention = restaurantAttention;
    }

    public Integer getEat_payType() {
        return eat_payType;
    }

    public void setEat_payType(Integer eat_payType) {
        this.eat_payType = eat_payType;
    }

    public Integer getEat_status() {
        return eat_status;
    }

    public void setEat_status(Integer eat_status) {
        this.eat_status = eat_status;
    }

    public Integer getEat_end() {
        return eat_end;
    }

    public void setEat_end(Integer eat_end) {
        this.eat_end = eat_end;
    }

    public String getEat_remarkName() {
        return eat_remarkName;
    }

    public void setEat_remarkName(String eat_remarkName) {
        this.eat_remarkName = eat_remarkName;
    }

    public String getEat_remarkContent() {
        return eat_remarkContent;
    }

    public void setEat_remarkContent(String eat_remarkContent) {
        this.eat_remarkContent = eat_remarkContent;
    }

    public String getEat_statusDate() {
        return eat_statusDate;
    }

    public void setEat_statusDate(String eat_statusDate) {
        this.eat_statusDate = eat_statusDate;
    }

    public String getEat_endDate() {
        return eat_endDate;
    }

    public void setEat_endDate(String eat_endDate) {
        this.eat_endDate = eat_endDate;
    }

    public String getEat_sRemarkName() {
        return eat_sRemarkName;
    }

    public void setEat_sRemarkName(String eat_sRemarkName) {
        this.eat_sRemarkName = eat_sRemarkName;
    }

    public String getEat_sRemarkContent() {
        return eat_sRemarkContent;
    }

    public void setEat_sRemarkContent(String eat_sRemarkContent) {
        this.eat_sRemarkContent = eat_sRemarkContent;
    }

    public String getEat_eRemarkName() {
        return eat_eRemarkName;
    }

    public void setEat_eRemarkName(String eat_eRemarkName) {
        this.eat_eRemarkName = eat_eRemarkName;
    }

    public String getEat_eRemarkContent() {
        return eat_eRemarkContent;
    }

    public void setEat_eRemarkContent(String eat_eRemarkContent) {
        this.eat_eRemarkContent = eat_eRemarkContent;
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

    public Integer getHouse_payType() {
        return house_payType;
    }

    public void setHouse_payType(Integer house_payType) {
        this.house_payType = house_payType;
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

    public Integer getHouse_status() {
        return house_status;
    }

    public void setHouse_status(Integer house_status) {
        this.house_status = house_status;
    }

    public String getHouse_remarkContent() {
        return house_remarkContent;
    }

    public void setHouse_remarkContent(String house_remarkContent) {
        this.house_remarkContent = house_remarkContent;
    }

    public String getHouse_remarkName() {
        return house_remarkName;
    }

    public void setHouse_remarkName(String house_remarkName) {
        this.house_remarkName = house_remarkName;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getHouse_statusDate() {
        return house_statusDate;
    }

    public void setHouse_statusDate(String house_statusDate) {
        this.house_statusDate = house_statusDate;
    }

    public String getHouse_endDate() {
        return house_endDate;
    }

    public void setHouse_endDate(String house_endDate) {
        this.house_endDate = house_endDate;
    }

    public String getHouse_sRemarkName() {
        return house_sRemarkName;
    }

    public void setHouse_sRemarkName(String house_sRemarkName) {
        this.house_sRemarkName = house_sRemarkName;
    }

    public String getHouse_sRemarkContent() {
        return house_sRemarkContent;
    }

    public void setHouse_sRemarkContent(String house_sRemarkContent) {
        this.house_sRemarkContent = house_sRemarkContent;
    }

    public String getHouse_eRemarkName() {
        return house_eRemarkName;
    }

    public void setHouse_eRemarkName(String house_eRemarkName) {
        this.house_eRemarkName = house_eRemarkName;
    }

    public String getHouse_eRemarkContent() {
        return house_eRemarkContent;
    }

    public void setHouse_eRemarkContent(String house_eRemarkContent) {
        this.house_eRemarkContent = house_eRemarkContent;
    }
}
