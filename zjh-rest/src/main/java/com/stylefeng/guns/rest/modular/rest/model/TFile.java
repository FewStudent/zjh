package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>Description</p>
 * <p>文件表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/13
 */
@TableName("t_file")
public class TFile extends Model<TFile> {
    private static final long serialVersionUID = 4249107398385660969L;
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //创建时间
    private String create_time;
    //原文件名称
    private String old_file_name;
    //存储名称
    private String new_file_name;
    //文件类型（0：照片  1：演讲材料）
    private Integer file_type;

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

    public String getOld_file_name() {
        return old_file_name;
    }

    public void setOld_file_name(String old_file_name) {
        this.old_file_name = old_file_name;
    }

    public String getNew_file_name() {
        return new_file_name;
    }

    public void setNew_file_name(String new_file_name) {
        this.new_file_name = new_file_name;
    }

    public Integer getFile_type() {
        return file_type;
    }

    public void setFile_type(Integer file_type) {
        this.file_type = file_type;
    }

    @Override
    public String toString() {
        return "TFile{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", old_file_name='" + old_file_name + '\'' +
                ", new_file_name='" + new_file_name + '\'' +
                ", file_type=" + file_type +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
