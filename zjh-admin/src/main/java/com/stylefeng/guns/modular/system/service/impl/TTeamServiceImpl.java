package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TTeam;
import com.stylefeng.guns.modular.system.dao.TTeamMapper;
import com.stylefeng.guns.modular.system.service.ITTeamService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 团队基础信息表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TTeamServiceImpl extends ServiceImpl<TTeamMapper, TTeam> implements ITTeamService {


    @Override
    public List<TTeam> findAllTeams(String search, Integer lrole) {
        return this.baseMapper.findAllTeams(search, lrole);
    }
}
