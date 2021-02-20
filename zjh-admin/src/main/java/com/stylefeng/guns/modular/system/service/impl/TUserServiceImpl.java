package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.TUserMapper;
import com.stylefeng.guns.modular.system.model.TUser;
import com.stylefeng.guns.modular.system.service.ITUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人信息表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {


    @Override
    public List<TUser> findAllUsers(String search, Integer lrole) {
        return this.baseMapper.findAllUsers(search, lrole);
    }
}
