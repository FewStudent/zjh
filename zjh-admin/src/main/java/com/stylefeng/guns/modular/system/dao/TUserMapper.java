package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 个人信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface TUserMapper extends BaseMapper<TUser> {

    List<TUser> findAllUsers(@Param("search") String search, @Param("lrole") Integer lrole);
}
