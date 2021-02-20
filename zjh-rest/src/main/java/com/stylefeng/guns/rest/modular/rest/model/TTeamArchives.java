package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelColumn;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description</p>
 * <p>团队档案表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@TableName("t_team_archives")
public class TTeamArchives extends Model<TTeamArchives> {
    private static final long serialVersionUID = -1336778867832638564L;
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelColumn(value = "主键", col = 1)
    private Integer id;
    //创建时间
    @ExcelColumn(value = "创建时间", col = 2)
    private String create_time;
    //更新时间
    private String update_time;
    //所属院队id
    private Integer team_id;
    @ExcelColumn(value = "所属所团名称", col = 3)
    @TableField(exist = false)
    private String teamName;
    //参加的活动
    @ExcelColumn(value = "活动", col = 4)
    private String activity;
    //个人简介
    @ExcelColumn(value = "团对简介", col = 5)
    private String personal_synopsis;
    //角色
    @ExcelColumn(value = "角色", col = 6)
    private String role;
    //演讲主题
    @ExcelColumn(value = "主题", col = 7)
    private String speech_topic;
    //文件id
    private String speech_file;
    @TableField(exist = false)
    private List<TFile> sfiles;
    //照片id
    private String phone_file;
    @TableField(exist = false)
    private List<TFile> pfiles;
    //开户客户姓名
    @ExcelColumn(value = "开户客户姓名", col = 8)
    private String account_name;
    //开户行
    @ExcelColumn(value = "开户行", col = 9)
    private String account_blank;
    //开户账号
    @ExcelColumn(value = "开户账号", col = 10)
    private String account;
    //审核状态（int   0：未审核   1：已审核   2：未审核）
    @ExcelColumn(value = "审核状态（0：未审核 1：已审核 2：未通过）", col = 11)
    private Integer s_status;
    //审核备注id
    private String s_remark;
    @TableField(exist = false)
    private List<TRemark> sremarks;
    // 档案备注id
    private String archives_remark;
    // 备注信息
    @TableField(exist = false)
    private List<TRemark> remarks;

    public Integer getS_status() {
        return s_status;
    }

    public void setS_status(Integer s_status) {
        this.s_status = s_status;
    }

    public String getS_remark() {
        return s_remark;
    }

    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPersonal_synopsis() {
        return personal_synopsis;
    }

    public void setPersonal_synopsis(String personal_synopsis) {
        this.personal_synopsis = personal_synopsis;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSpeech_topic() {
        return speech_topic;
    }

    public void setSpeech_topic(String speech_topic) {
        this.speech_topic = speech_topic;
    }

    public String getSpeech_file() {
        return speech_file;
    }

    public void setSpeech_file(String speech_file) {
        this.speech_file = speech_file;
    }

    public String getPhone_file() {
        return phone_file;
    }

    public void setPhone_file(String phone_file) {
        this.phone_file = phone_file;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_blank() {
        return account_blank;
    }

    public void setAccount_blank(String account_blank) {
        this.account_blank = account_blank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getArchives_remark() {
        return archives_remark;
    }

    public void setArchives_remark(String archives_remark) {
        this.archives_remark = archives_remark;
    }

    @Override
    public String toString() {
        return "TTeamArchives{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", team_id=" + team_id +
                ", activity='" + activity + '\'' +
                ", personal_synopsis='" + personal_synopsis + '\'' +
                ", role=" + role +
                ", speech_topic='" + speech_topic + '\'' +
                ", account_name='" + account_name + '\'' +
                ", account_blank='" + account_blank + '\'' +
                ", account='" + account + '\'' +
                ", archives_remark='" + archives_remark + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public List<TRemark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<TRemark> remarks) {
        this.remarks = remarks;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<TRemark> getSremarks() {
        return sremarks;
    }

    public void setSremarks(List<TRemark> sremarks) {
        this.sremarks = sremarks;
    }

    public List<TFile> getPfiles() {
        return pfiles;
    }

    public void setPfiles(List<TFile> pfiles) {
        this.pfiles = pfiles;
    }

    public List<TFile> getSfiles() {
        return sfiles;
    }

    public void setSfiles(List<TFile> sfiles) {
        this.sfiles = sfiles;
    }
}
