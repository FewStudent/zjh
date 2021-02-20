package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TTeamArchives;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 团队档案表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITTeamArchivesService extends IService<TTeamArchives> {

    List<TTeamArchives> findAllTeamArchives(Integer status, String search, Integer lrole);

}
