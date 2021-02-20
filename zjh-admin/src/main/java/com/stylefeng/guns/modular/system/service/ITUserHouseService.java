package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TUserHouse;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 个人住房表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITUserHouseService extends IService<TUserHouse> {

    List<TUserHouse> findAllUserHouses(Integer status, Integer end, String search, Integer lrole);

}
