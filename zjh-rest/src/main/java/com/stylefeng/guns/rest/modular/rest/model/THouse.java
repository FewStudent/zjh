package com.stylefeng.guns.rest.modular.rest.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>Description</p>
 * <p>住房表</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@TableName("t_house")
public class THouse extends Model<THouse> {
    private static final long serialVersionUID = 1349419968905385148L;
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //创建时间
    private String create_time;
    //更新时间
    private String update_time;
    //房间号
    private String room_num;
    //空置床位
    private String vacant;
    //是否拼房
    private String splice_room;
    //拼房人姓名
        private String splice_people;
    private String uuid;

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

    public String getRoom_num() {
        return room_num;
    }

    public void setRoom_num(String room_num) {
        this.room_num = room_num;
    }

    public String getVacant() {
        return vacant;
    }

    public void setVacant(String vacant) {
        this.vacant = vacant;
    }

    public String getSplice_room() {
        return splice_room;
    }

    public void setSplice_room(String splice_room) {
        this.splice_room = splice_room;
    }

    public String getSplice_people() {
        return splice_people;
    }

    public void setSplice_people(String splice_people) {
        this.splice_people = splice_people;
    }

    @Override
    public String toString() {
        return "THouse{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", room_num='" + room_num + '\'' +
                ", vacant='" + vacant + '\'' +
                ", splice_room='" + splice_room + '\'' +
                ", splice_people='" + splice_people + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
