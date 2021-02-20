package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.TTeamCarMapper;
import com.stylefeng.guns.modular.system.model.TTeamCar;
import com.stylefeng.guns.modular.system.service.ITTeamCarService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 团队用车表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TTeamCarServiceImpl extends ServiceImpl<TTeamCarMapper, TTeamCar> implements ITTeamCarService {

    @Override
    public List<TTeamCar> findAllTeamCars(Integer status, Integer end, String search, Integer lrole) {
        return baseMapper.findAllTeamCars(status, end, search, lrole);
    }
}
