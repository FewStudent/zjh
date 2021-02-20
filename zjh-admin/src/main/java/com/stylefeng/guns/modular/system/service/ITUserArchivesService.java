package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.TUserArchives;

import java.util.List;

/**
 * <p>
 * 个人档案表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITUserArchivesService extends IService<TUserArchives> {

    List<TUserArchives> findAllUserArchives(Integer status, String search, Integer lrole);
}
