package com.stylefeng.guns.rest.modular.rest.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.rest.model.TTeamArchives;
import com.stylefeng.guns.rest.modular.rest.model.TUserArchives;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
public interface TTeamArchivesMapper extends BaseMapper<TTeamArchives> {
    List<TTeamArchives> findAllTTeamArchives(@Param("status") Integer status, @Param("seach") String seach);
}
