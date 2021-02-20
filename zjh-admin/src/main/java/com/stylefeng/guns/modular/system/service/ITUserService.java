package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 个人信息表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITUserService extends IService<TUser> {

    List<TUser> findAllUsers(String search, Integer lrole);

}
