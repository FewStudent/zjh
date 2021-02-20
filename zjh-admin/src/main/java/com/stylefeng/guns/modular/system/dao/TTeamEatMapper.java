package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TTeamEat;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团队用餐表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TTeamEatMapper extends BaseMapper<TTeamEat> {

    List<TTeamEat> findAllTeamEats(@Param("status") Integer status, @Param("end") Integer end, @Param("search") String search, @Param("lrole") Integer lrole);
}
