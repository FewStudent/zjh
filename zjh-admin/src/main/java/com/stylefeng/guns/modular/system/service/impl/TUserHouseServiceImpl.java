package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TUserHouse;
import com.stylefeng.guns.modular.system.dao.TUserHouseMapper;
import com.stylefeng.guns.modular.system.service.ITUserHouseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 个人住房表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TUserHouseServiceImpl extends ServiceImpl<TUserHouseMapper, TUserHouse> implements ITUserHouseService {


    @Override
    public List<TUserHouse> findAllUserHouses(Integer status, Integer end, String search, Integer lrole) {
        return this.baseMapper.findAllUserHouses(status, end, search, lrole);
    }
}
