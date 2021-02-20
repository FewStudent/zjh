package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelColumn;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>Description</p>
 * <p>备注表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@TableName("t_remark")
public class TRemark extends Model<TRemark> {
    private static final long serialVersionUID = -8378841903322942397L;
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //创建时间
    private String create_time;
    //更新时间
    private String update_time;
    //备注人姓名
    @NotBlank(message = "备注人姓名不能为空")
    @ExcelColumn(value = "备注人姓名")
    private String remarks_people;
    //备注内容
    @NotBlank(message = "备注人内容不能为空")
    @ExcelColumn(value = "备注内容")
    private String remarks_content;
    //备注日期
    @NotBlank(message = "备注日期不能为空")
    @ExcelColumn(value = "备注日期")
    private String remarks_date;
    //业务流水
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getRemarks_people() {
        return remarks_people;
    }

    public void setRemarks_people(String remarks_people) {
        this.remarks_people = remarks_people;
    }

    public String getRemarks_content() {
        return remarks_content;
    }

    public void setRemarks_content(String remarks_content) {
        this.remarks_content = remarks_content;
    }

    public String getRemarks_date() {
        return remarks_date;
    }

    public void setRemarks_date(String remarks_date) {
        this.remarks_date = remarks_date;
    }

    @Override
    public String toString() {
        return "TRemark{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", remarks_people='" + remarks_people + '\'' +
                ", remarks_content='" + remarks_content + '\'' +
                ", remarks_date='" + remarks_date + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
