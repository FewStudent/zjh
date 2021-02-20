package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelColumn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Description</p>
 * <p>团队表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@TableName("t_team")
public class TTeam extends Model<TTeam> {

    private static final long serialVersionUID = 5627594887674744309L;
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelColumn(value = "主键", col = 1)
    private Integer id;
    //创建时间
    @ExcelColumn(value = "创建时间", col = 2)
    private String create_time;
    //更新时间
    private String update_time;
    //公司名称
    @NotBlank(message = "公司名称不能为空")
    @ExcelColumn(value = "公司名称", col = 3)
    private String company;
    //团队负责人
    @NotBlank(message = "负责人不能为空")
    @ExcelColumn(value = "负责人", col = 4)
    private String company_leader;
    //团队负责人职务
    @ExcelColumn(value = "职务", col = 5)
    private String company_leader_job;
    //嘉宾对接人
    @NotBlank(message = "嘉宾对接人不能为空")
    @ExcelColumn(value = "嘉宾对接人", col = 6)
    private String pick_up_user;
    //团队证件类型（int   0：身份证    1：护照      2：港粤证）
    @NotNull(message = "证件类型不能为空")
    @ExcelColumn(value = "证件类型（0：身份证  1：护照  2：港粤证）", col = 7)
    private Integer certificates;
    //区域
    @ExcelColumn(value = "区域", col = 8)
    private String areas;
    //团队人数
    @NotNull(message = "团队人数不能为空")
    @ExcelColumn(value = "团队人数", col = 9)
    private Integer teams_peoples;
    //团队联系人
    @NotBlank(message = "团队联系人不能为空")
    @ExcelColumn(value = "团队联系人", col = 10)
    private String teams_contacts;
    //联系人电话
    @ExcelColumn(value = "联系人电话", col = 11)
    @NotBlank(message = "联系人电话不能为空")
    private String contacts_phone;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_leader() {
        return company_leader;
    }

    public void setCompany_leader(String company_leader) {
        this.company_leader = company_leader;
    }

    public String getCompany_leader_job() {
        return company_leader_job;
    }

    public void setCompany_leader_job(String company_leader_job) {
        this.company_leader_job = company_leader_job;
    }

    public String getPick_up_user() {
        return pick_up_user;
    }

    public void setPick_up_user(String pick_up_user) {
        this.pick_up_user = pick_up_user;
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

    public Integer getTeams_peoples() {
        return teams_peoples;
    }

    public void setTeams_peoples(Integer teams_peoples) {
        this.teams_peoples = teams_peoples;
    }

    public String getTeams_contacts() {
        return teams_contacts;
    }

    public void setTeams_contacts(String teams_contacts) {
        this.teams_contacts = teams_contacts;
    }

    public String getContacts_phone() {
        return contacts_phone;
    }

    public void setContacts_phone(String contacts_phone) {
        this.contacts_phone = contacts_phone;
    }

    @Override
    public String toString() {
        return "TTeam{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", company='" + company + '\'' +
                ", company_leader='" + company_leader + '\'' +
                ", company_leader_job='" + company_leader_job + '\'' +
                ", pick_up_user='" + pick_up_user + '\'' +
                ", certificates=" + certificates +
                ", areas='" + areas + '\'' +
                ", teams_peoples=" + teams_peoples +
                ", teams_contacts='" + teams_contacts + '\'' +
                ", contacts_phone='" + contacts_phone + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
