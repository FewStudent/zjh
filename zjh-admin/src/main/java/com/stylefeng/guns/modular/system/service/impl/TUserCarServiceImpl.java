package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TUserCar;
import com.stylefeng.guns.modular.system.dao.TUserCarMapper;
import com.stylefeng.guns.modular.system.service.ITUserCarService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 个人用车表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TUserCarServiceImpl extends ServiceImpl<TUserCarMapper, TUserCar> implements ITUserCarService {

    @Override
    public List<TUserCar> findAllUserCars(Integer status, Integer end, String search, Integer lrole) {
        return this.baseMapper.findAllUserCars(status, end, search, lrole);
    }
}
