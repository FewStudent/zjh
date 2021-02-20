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
 * 团队用餐表
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@TableName("t_team_eat")
public class TTeamEat extends Model<TTeamEat> {

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
     * 所属团队id
     */
    @TableField("team_id")
    private Integer teamId;
    @ExcelColumn(value = "所属团队", col = 1)
    @TableField(exist = false)
    private String teamIdName;
    /**
     * 餐饮
     */
    @ExcelColumn(value = "餐饮", col = 2)
    private String restaurant;
    /**
     * 用餐时间
     */
    @ExcelColumn(value = "用餐时间", col = 3)
    @TableField("restaurant_date")
    private String restaurantDate;
    /**
     * 用餐人数
     */
    @ExcelColumn(value = "用餐人数", col = 4)
    @TableField("restaurant_peoples")
    private Integer restaurantPeoples;
    /**
     * 用餐注意事项
     */
    @ExcelColumn(value = "用餐注意事项", col = 5)
    @TableField("restaurant_attention")
    private String restaurantAttention;
    /**
     * 费用承担方式（0：自费   1：公费）
     */
    @ExcelColumn(value = "费用承担方式（0：自费   1：公费）", col = 6)
    @TableField("pay_type")
    private Integer payType;
    @TableField(exist = false)
    private String payTypeName;
    /**
     * 审核状态（int   0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "审核状态（ 0：未审核   1：已审核   2：未审核）", col = 7)
    private Integer status;
    @TableField(exist = false)
    private String statusName;

    /**
     * 是否结束（0：否  1：是）
     */
    @ExcelColumn(value = "是否结束（0：否  1：是）", col = 8)
    private Integer end;
    @TableField(exist = false)
    private String endName;
    /**
     * 备注人姓名
     */
    @ExcelColumn(value = "添加备注人姓名", col = 9)
    @TableField("remark_name")
    private String remarkName;
    /**
     * 备注内容
     */
    @ExcelColumn(value = "添加备注内容", col = 10)
    @TableField("remark_content")
    private String remarkContent;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "审核时间", col = 11)
    @TableField("status_date")
    private String statusDate;
    /**
     * 结束时间
     */
    @ExcelColumn(value = "结束时间", col = 12)
    @TableField("end_date")
    private String endDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "审核备注人", col = 13)
    @TableField("s_remark_name")
    private String sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "审核备注内容", col = 14)
    @TableField("s_remark_content")
    private String sRemarkContent;
    /**
     * 结束备注人
     */
    @ExcelColumn(value = "结束备注人", col = 15)
    @TableField("e_remark_name")
    private String eRemarkName;
    /**
     * 结束备注内容
     */
    @ExcelColumn(value = "结束备注时间", col = 16)
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

    // 联系人
    @TableField(exist = false)
    private String contacts;


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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
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

    public String getTeamIdName() {
        return teamIdName;
    }

    public void setTeamIdName(String teamIdName) {
        this.teamIdName = teamIdName;
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
        return "TTeamEat{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teamId=" + teamId +
                ", restaurant=" + restaurant +
                ", restaurantDate=" + restaurantDate +
                ", restaurantPeoples=" + restaurantPeoples +
                ", restaurantAttention=" + restaurantAttention +
                ", payType=" + payType +
                ", status=" + status +
                ", end=" + end +
                ", remarkName=" + remarkName +
                ", remarkContent=" + remarkContent +
                ", statusDate=" + statusDate +
                ", endDate=" + endDate +
                ", sRemarkName=" + sRemarkName +
                ", sRemarkContent=" + sRemarkContent +
                ", eRemarkName=" + eRemarkName +
                ", eRemarkContent=" + eRemarkContent +
                ", aRemarkName=" + aRemarkName +
                ", aRemarkContent=" + aRemarkContent +
                "}";
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
