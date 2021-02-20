package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.TUserArchivesMapper;
import com.stylefeng.guns.modular.system.model.TUserArchives;
import com.stylefeng.guns.modular.system.service.ITUserArchivesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人档案表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TUserArchivesServiceImpl extends ServiceImpl<TUserArchivesMapper, TUserArchives> implements ITUserArchivesService {

    @Override
    public List<TUserArchives> findAllUserArchives(Integer status, String search, Integer lrole) {
        return this.baseMapper.findAllUserArchives(status, search, lrole);
    }
}
