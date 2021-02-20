package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.TTeamHouseMapper;
import com.stylefeng.guns.modular.system.model.TTeamHouse;
import com.stylefeng.guns.modular.system.service.ITTeamHouseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 团队住房表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TTeamHouseServiceImpl extends ServiceImpl<TTeamHouseMapper, TTeamHouse> implements ITTeamHouseService {

    @Override
    public List<TTeamHouse> findAllTeamHouses(Integer status, Integer end, String search, Integer lrole) {
        return this.baseMapper.findAllTeamHouses(status, end, search, lrole);
    }
}
