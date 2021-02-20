package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TTeamCar;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 团队用车表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITTeamCarService extends IService<TTeamCar> {

    List<TTeamCar> findAllTeamCars(Integer status, Integer end, String search, Integer lrole);

}
