package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TTeamEat;
import com.stylefeng.guns.modular.system.dao.TTeamEatMapper;
import com.stylefeng.guns.modular.system.service.ITTeamEatService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 团队用餐表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TTeamEatServiceImpl extends ServiceImpl<TTeamEatMapper, TTeamEat> implements ITTeamEatService {

    @Override
    public List<TTeamEat> findAllTeamEats(Integer status, Integer end, String search, Integer lrole) {
        return this.baseMapper.findAllTeamEats(status, end, search, lrole);
    }
}
