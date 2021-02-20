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
public class UserEatExcel {

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
     * 晚宴（0：否 1：是）
     */
    @ExcelColumn(value = "晚宴（0：否 1：是）", col = 15)
    private Integer eatDinner;
    /**
     * 自助午餐（int 填数量）
     */
    @ExcelColumn(value = "自助午餐", col = 16)
    private Integer eatLunch;
    /**
     * 工作餐（int 填数量）
     */
    @ExcelColumn(value = "工作餐", col = 17)
    private Integer eatWorkMeal;
    /**
     * 用餐支付方式（0：自费 1：公费）
     */
    @ExcelColumn(value = "用餐支付方式（0：自费 1：公费）", col = 18)
    private Integer eatPayType;

    /**
     * 用餐添加备注
     */
    @ExcelColumn(value = "用餐备注", col = 19)
    private String eatAddRemark;
    /**
     * 用餐注意事项
     */
    @ExcelColumn(value = "用餐注意事项", col = 21)
    private String eatAttention;
    /**
     * 用餐审核状态（0：未审核 1：已审核 2：已退回）
     */
    @ExcelColumn(value = "审核状态（0：未审核 1：已审核 2：已退回）", col = 22)
    private Integer eatStatus;
    /**
     * 用餐审核备注人
     */
    @ExcelColumn(value = "用餐审核备注人", col = 23)
    private String eatStatusReamrkName;
    /**
     * 用餐审核备注
     */
    @ExcelColumn(value = "用餐审核备注", col = 24)
    private String eatStatusRemark;
    /**
     * 用餐结束状态（0：未结束 1：已结束）
     */
    @ExcelColumn(value = "用餐结束状态（0：未结束 1：已结束）", col = 25)
    private Integer eatEnd;
    /**
     * 用餐结束备注人
     */
    @ExcelColumn(value = "用餐结束备注人", col = 26)
    private String eatEndRemarkName;
    /**
     * 用餐结束备注
     */
    @ExcelColumn(value = "用餐结束备注内容", col = 27)
    private String eatEndRemark;
    /**
     * 用餐安排状态（0：未安排 1：已安排)
     */
    @ExcelColumn(value = "安排状态（0：未安排 1：已安排）", col = 28)
    private Integer eatArrange;
    /**
     * 用餐安排备注内容
     */
    @ExcelColumn(value = "用餐安排备注内容", col = 29)
    private String eatArrangeRemark;

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
}
