package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.TTeamArchivesMapper;
import com.stylefeng.guns.modular.system.model.TTeamArchives;
import com.stylefeng.guns.modular.system.service.ITTeamArchivesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 团队档案表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TTeamArchivesServiceImpl extends ServiceImpl<TTeamArchivesMapper, TTeamArchives> implements ITTeamArchivesService {

    @Override
    public List<TTeamArchives> findAllTeamArchives(Integer status, String search, Integer lrole) {
        return this.baseMapper.findAllTeamArchives(status, search, lrole);
    }
}
