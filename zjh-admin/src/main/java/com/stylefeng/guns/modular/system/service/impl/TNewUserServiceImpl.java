package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TNewUser;
import com.stylefeng.guns.modular.system.service.ITNewUserService;
import com.stylefeng.guns.modular.system.dao.TNewUserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客户的信息总表 服务实现类
 * </p>
 *
 * @author lakyjpan
 * @since 2019-10-07
 */
@Service
public class TNewUserServiceImpl extends ServiceImpl<TNewUserMapper, TNewUser> implements ITNewUserService {

    @Autowired
    TNewUserMapper mapper;

    @Override
    public List<TNewUser> queryByCreateId(Integer id) {
        return mapper.queryAllUserInfo(id);
    }

	@Override
	public List<TNewUser> queryAllUserInfo(Integer id) {
		return mapper.queryAllUserInfo(id);
	}

	@Override
	public TNewUser queryUserInfoById(Integer id) {
		return mapper.queryUserInfoById(id);
	}

	@Override
	public TNewUser queryUserCarById(Integer id) {
		return mapper.queryUserCarById(id);
	}

	@Override
	public List<TNewUser> queryAllUserCar(Integer id) {
		return mapper.queryAllUserCar(id);
	}

	@Override
	public List<TNewUser> queryAllUserEat(Integer id) {
		return mapper.queryAllUserEat(id);
	}

	@Override
	public TNewUser queryUserEatById(Integer id) {
		return mapper.queryUserEatById(id);
	}

	@Override
	public List<TNewUser> queryAllUserActivity(Integer id) {
		return mapper.queryAllUserActivity(id);
	}

	@Override
	public TNewUser queryUserActivityById(Integer id) {
		return mapper.queryUserActivityById(id);
	}

	@Override
	public List<TNewUser> queryAllUserHouse(Integer id) {
		return mapper.queryAllUserHouse(id);
	}

	@Override
	public TNewUser queryUserHouseById(Integer id) {
		return mapper.queryUserHouseById(id);
	}

	@Override
	public List<TNewUser> queryUserInfoByFiled(String filed1, String value1, String filed2, String value2, Integer id) {
		return mapper.queryUserInfoByFiled(filed1, value1, filed2, value2, id);
	}

	@Override
	public List<TNewUser> queryUserActivityByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer id) {
		return mapper.queryUserActivityByFiled(filed1, value1, filed2, value2, status, id);
	}

	@Override
	public List<TNewUser> queryUserEatByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer end, Integer id) {
		return mapper.queryUserEatByFiled(filed1, value1, filed2, value2, status, end, id);
	}

	@Override
	public List<TNewUser> queryUserCarByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer end, Integer id) {
		return mapper.queryUserCarByFiled(filed1, value1, filed2, value2, status, end, id);
	}

	@Override
	public List<TNewUser> queryUserHouseByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer end, Integer id) {
		return mapper.queryUserHouseByFiled(filed1, value1, filed2, value2, status, end, id);
	}
}
