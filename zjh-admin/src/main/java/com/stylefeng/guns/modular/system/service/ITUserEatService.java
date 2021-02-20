package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TUserEat;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 个人用餐表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
public interface ITUserEatService extends IService<TUserEat> {

    List<TUserEat> findAllUserEats(Integer status, Integer end, String search, Integer lrole);

}
