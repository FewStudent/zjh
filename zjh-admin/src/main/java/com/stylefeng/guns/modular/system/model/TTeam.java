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
 * 团队基础信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@TableName("t_team")
public class TTeam extends Model<TTeam> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelColumn(value = "主键",col = 1)
    private Integer id;
    /**
     * 创建时间
     */
    @TableField("create_time")
    @ExcelColumn(value = "创建时间",col = 2)
    private String createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    @ExcelColumn(value = "更新时间",col = 3)
    private String updateTime;
    /**
     * 公司名称
     */
    @ExcelColumn(value = "公司名称",col = 4)
    private String company;
    /**
     * 公司负责人
     */
    @TableField("company_leader")
    @ExcelColumn(value = "公司负责人",col = 5)
    private String companyLeader;
    /**
     * 公司负责人职位
     */
    @TableField("company_leader_job")
    @ExcelColumn(value = "公司领导职位",col = 6)
    private String companyLeaderJob;
    /**
     * 嘉宾对接人姓名
     */
    @ExcelColumn(value = "嘉宾对接人",col = 7)
    @TableField("pick_up_user")
    private String pickUpUser;
    /**
     * 证件类型（  0：贵宾证 1：嘉宾证 2：参观证）
     */
    @ExcelColumn(value = "证件类型（  0：贵宾证 1：嘉宾证 2：参观证）",col = 8)
    private Integer certificates;
    /**
     * 团队证件类型名称（辅助字段）
     */
    @TableField(exist = false)
    private String certificatesName;
    /**
     * 所属区域
     */
    @ExcelColumn(value = "所属区域",col = 9)
    private String areas;
    /**
     * 团队人数
     */
    @ExcelColumn(value = "团队人数",col = 10)
    @TableField("teams_peoples")
    private Integer teamsPeoples;
    /**
     * 团队联系人
     */
    @ExcelColumn(value = "团队联系人",col = 11)
    @TableField("teams_contacts")
    private String teamsContacts;
    /**
     * 团队联系人电话
     */
    @ExcelColumn(value = "团队联系人电话",col = 12)
    @TableField("contacts_phone")
    private String contactsPhone;

    @TableField("create_by")
    private Integer createBy;


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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyLeader() {
        return companyLeader;
    }

    public void setCompanyLeader(String companyLeader) {
        this.companyLeader = companyLeader;
    }

    public String getCompanyLeaderJob() {
        return companyLeaderJob;
    }

    public void setCompanyLeaderJob(String companyLeaderJob) {
        this.companyLeaderJob = companyLeaderJob;
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

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public Integer getTeamsPeoples() {
        return teamsPeoples;
    }

    public void setTeamsPeoples(Integer teamsPeoples) {
        this.teamsPeoples = teamsPeoples;
    }

    public String getTeamsContacts() {
        return teamsContacts;
    }

    public void setTeamsContacts(String teamsContacts) {
        this.teamsContacts = teamsContacts;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TTeam{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", company=" + company +
                ", companyLeader=" + companyLeader +
                ", companyLeaderJob=" + companyLeaderJob +
                ", pickUpUser=" + pickUpUser +
                ", certificates=" + certificates +
                ", areas=" + areas +
                ", teamsPeoples=" + teamsPeoples +
                ", teamsContacts=" + teamsContacts +
                ", contactsPhone=" + contactsPhone +
                "}";
    }

    public String getCertificatesName() {
        return certificatesName;
    }

    public void setCertificatesName(String certificatesName) {
        this.certificatesName = certificatesName;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}
