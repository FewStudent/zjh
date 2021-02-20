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
public class TeamActivityExcel {

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
     * 参与活动
     */
    @ExcelColumn(value = "参与活动", col = 11)
    private String activity;
    /**
     * 开户姓名
     */
    @ExcelColumn(value = "开户姓名", col = 12)
    private String accountName;
    /**
     * 开户银行
     */
    @ExcelColumn(value = "开户银行", col = 13)
    private String accountBlank;
    /**
     * 开户账号
     */
    @ExcelColumn(value = "开户账号", col = 14)
    private String account;
    /**
     * 个人简介
     */
    @ExcelColumn(value = "个人简介", col = 15)
    private String personalSynopsis;
    /**
     * 个人角色（0：主持人 1：演讲嘉宾 2：观众）
     */
    @ExcelColumn(value = "个人角色（0：主持人 1：演讲嘉宾 2：观众）", col = 16)
    private Integer role;
    /**
     * 演讲主题
     */
    @ExcelColumn(value = "演讲主题", col = 17)
    private String speechTopic;
    /**
     * 活动添加备注
     */
    @ExcelColumn(value = "活动备注", col = 18)
    private String activityAddRemark;
    /**
     * 活动添加备注人姓名
     */
    @ExcelColumn(value = "活动备注人", col = 19)
    private String activityAddRemarkName;
    /**
     * 活动审核状态（0：未审核 1：已审核 2：已退回）
     */
    @ExcelColumn(value = "审核状态（0：未审核 1：已审核 2：已退回）", col = 20)
    private Integer activityStatus;
    /**
     * 活动审核备注人
     */
    @ExcelColumn(value = "审核备注人", col = 21)
    private String activityStatusReamrkName;
    /**
     * 活动审核备注
     */
    @ExcelColumn(value = "审核备注内容", col = 22)
    private String activityStatusRemark;

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
