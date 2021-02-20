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
 * 团队档案表
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@TableName("t_team_archives")
public class TTeamArchives extends Model<TTeamArchives> {

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
    /**
     * 所属团队名称
     */
    @ExcelColumn(value = "所属团队",col = 1)
    @TableField(exist = false)
    private String teamIdName;
    /**
     * 参与活动
     */
    @ExcelColumn(value = "参与活动",col = 2)
    private String activity;
    /**
     * 个人简介
     */
    @ExcelColumn(value = "个人简介",col = 3)
    @TableField("personal_synopsis")
    private String personalSynopsis;
    /**
     * 角色名称
     */
    @ExcelColumn(value = "角色名称",col = 4)
    private String role;
    /**
     * 演讲主题
     */
    @ExcelColumn(value = "演讲主题",col = 5)
    @TableField("speech_topic")
    private String speechTopic;
    /**
     * 演讲材料文件
     */
    @TableField("speech_file")
    private String speechFile;
    /**
     * 上传图片
     */
    @TableField("phone_file")
    private String phoneFile;
    /**
     * 开户姓名
     */
    @ExcelColumn(value = "开户姓名",col = 6)
    @TableField("account_name")
    private String accountName;
    /**
     * 开户银行
     */
    @ExcelColumn(value = "开户银行",col = 7)
    @TableField("account_blank")
    private String accountBlank;
    /**
     * 开户账号
     */
    @ExcelColumn(value = "开户账号",col = 8)
    private String account;
    /**
     * 添加备注内容
     */
    @ExcelColumn(value = "添加备注内容",col = 9)
    @TableField("remark_content")
    private String remarkContent;
    /**
     * 添加备注人姓名
     */
    @ExcelColumn(value = "添加备注人姓名",col = 10)
    @TableField("remark_name")
    private String remarkName;
    /**
     * 审核状态（int   0：未审核   1：已审核   2：未审核）
     */
    @ExcelColumn(value = "审核状态（0：未审核 1：已审核 2：未审核）",col = 11)
    private Integer status;
    /**
     * s审核状态解析（辅助字段）
     */
    @TableField(exist = false)
    private String statusName;
    /**
     * 审核时间
     */
    @ExcelColumn(value = "审核时间",col = 12)
    @TableField("status_date")
    private String statusDate;
    /**
     * 审核备注人
     */
    @ExcelColumn(value = "审核备注人",col = 13)
    @TableField("s_remark_name")
    private String sRemarkName;
    /**
     * 审核备注内容
     */
    @ExcelColumn(value = "审核备注内容",col = 14)
    @TableField("s_remark_content")
    private String sRemarkContent;
    /**
     * 结束备注人
     */
    @TableField("e_remark_name")
    private String eRemarkName;
    /**
     * 结束备注内容
     */
    @TableField("e_remark_content")
    private String eRemarkContent;


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

    public String getSpeechFile() {
        return speechFile;
    }

    public void setSpeechFile(String speechFile) {
        this.speechFile = speechFile;
    }

    public String getPhoneFile() {
        return phoneFile;
    }

    public void setPhoneFile(String phoneFile) {
        this.phoneFile = phoneFile;
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

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TTeamArchives{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teamId=" + teamId +
                ", activity=" + activity +
                ", personalSynopsis=" + personalSynopsis +
                ", role=" + role +
                ", speechTopic=" + speechTopic +
                ", speechFile=" + speechFile +
                ", phoneFile=" + phoneFile +
                ", accountName=" + accountName +
                ", accountBlank=" + accountBlank +
                ", account=" + account +
                ", remarkContent=" + remarkContent +
                ", remarkName=" + remarkName +
                ", status=" + status +
                ", statusDate=" + statusDate +
                ", sRemarkName=" + sRemarkName +
                ", sRemarkContent=" + sRemarkContent +
                ", eRemarkName=" + eRemarkName +
                ", eRemarkContent=" + eRemarkContent +
                "}";
    }

    public String getTeamIdName() {
        return teamIdName;
    }

    public void setTeamIdName(String teamIdName) {
        this.teamIdName = teamIdName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
