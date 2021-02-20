package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TTeamHouse;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 团队住房表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITTeamHouseService extends IService<TTeamHouse> {

    List<TTeamHouse> findAllTeamHouses(Integer status, Integer end, String search, Integer lrole);
}
