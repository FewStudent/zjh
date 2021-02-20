package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TTeamEat;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 团队用餐表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITTeamEatService extends IService<TTeamEat> {

    List<TTeamEat> findAllTeamEats(Integer status, Integer end, String search, Integer lrole);

}
