package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TTeam;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 团队基础信息表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITTeamService extends IService<TTeam> {

    List<TTeam> findAllTeams(String search, Integer lrole);

}
