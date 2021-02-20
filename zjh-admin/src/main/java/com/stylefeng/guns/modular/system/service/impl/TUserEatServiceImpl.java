package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TUserEat;
import com.stylefeng.guns.modular.system.dao.TUserEatMapper;
import com.stylefeng.guns.modular.system.service.ITUserEatService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 个人用餐表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TUserEatServiceImpl extends ServiceImpl<TUserEatMapper, TUserEat> implements ITUserEatService {

    @Override
    public List<TUserEat> findAllUserEats(Integer status, Integer end, String search, Integer lrole) {
        return this.baseMapper.findAllUserEats(status, end, search, lrole);
    }
}
