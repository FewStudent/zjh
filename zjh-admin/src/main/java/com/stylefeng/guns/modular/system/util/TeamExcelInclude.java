package com.stylefeng.guns.modular.system.util;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/17
 */
public class TeamExcelInclude {

    @ExcelColumn(value = "公司名称", col = 1)
    private String company;
    //团队负责人
    @ExcelColumn(value = "负责人", col = 2)
    private String company_leader;
    //团队负责人职务
    @ExcelColumn(value = "职务", col = 3)
    private String company_leader_job;
    //嘉宾对接人
    @ExcelColumn(value = "嘉宾对接人", col = 4)
    private String pick_up_user;
    @ExcelColumn(value = "证件类型（0：贵宾证 1：嘉宾证  2：参观证）", col = 5)
    private Integer certificates;
    //区域
    @ExcelColumn(value = "区域", col = 6)
    private String areas;
    //团队人数
    @ExcelColumn(value = "团队人数", col = 7)
    private Integer teams_peoples;
    //团队联系人
    @ExcelColumn(value = "团队联系人", col = 8)
    private String teams_contacts;
    //联系人电话
    @ExcelColumn(value = "联系人电话", col = 9)
    private String contacts_phone;

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
        return "TeamExcelInclude{" +
                "company='" + company + '\'' +
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
}
