package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TTeamArchives;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团队档案表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TTeamArchivesMapper extends BaseMapper<TTeamArchives> {

    List<TTeamArchives> findAllTeamArchives(@Param("status") Integer status, @Param("search") String search, @Param("lrole") Integer lrole);

}
