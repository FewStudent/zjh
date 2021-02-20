package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TUserHouse;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 个人住房表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TUserHouseMapper extends BaseMapper<TUserHouse> {

    List<TUserHouse> findAllUserHouses(@Param("status") Integer status, @Param("end") Integer end, @Param("search") String search, @Param("lrole") Integer lrole);
}
