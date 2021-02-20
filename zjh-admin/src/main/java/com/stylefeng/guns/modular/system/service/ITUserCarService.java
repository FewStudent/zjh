package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TUserCar;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 个人用车表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITUserCarService extends IService<TUserCar> {

    List<TUserCar> findAllUserCars(Integer status, Integer end, String search, Integer lrole);

}
