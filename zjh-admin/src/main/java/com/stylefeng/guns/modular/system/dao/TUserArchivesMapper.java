package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TUserArchives;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 个人档案表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TUserArchivesMapper extends BaseMapper<TUserArchives> {

    List<TUserArchives> findAllUserArchives(@Param("status") Integer status, @Param("search") String search, @Param("lrole") Integer lrole);

}
