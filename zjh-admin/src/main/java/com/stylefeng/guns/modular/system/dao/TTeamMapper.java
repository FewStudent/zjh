package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TTeam;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团队基础信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TTeamMapper extends BaseMapper<TTeam> {

    List<TTeam> findAllTeams(@Param("search") String search, @Param("lrole") Integer lrole);
}
