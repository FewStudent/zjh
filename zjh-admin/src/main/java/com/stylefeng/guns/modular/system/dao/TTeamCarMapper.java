package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TTeamCar;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团队用车表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TTeamCarMapper extends BaseMapper<TTeamCar> {

    List<TTeamCar> findAllTeamCars(@Param("status") Integer status, @Param("end") Integer end, @Param("search") String search, @Param("lrole") Integer lrole);
}
