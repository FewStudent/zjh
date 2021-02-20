package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.TNewUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 客户的信息总表 服务类
 * </p>
 *
 * @author lakyjpan
 * @since 2019-10-07
 */
public interface ITNewUserService extends IService<TNewUser> {
	
	/** 根据管理员的id查询客户的信息 */
	public List<TNewUser> queryByCreateId(Integer id);

	/**
	 * 获取所有客户的基础信息
	 */
	public List<TNewUser> queryAllUserInfo(Integer id);

	/**
	 * 获取单个客户所有信息
	 */
	public TNewUser queryUserInfoById(Integer id);

	/**
	 * 获取单个客户的用车信息
	 */
	public TNewUser queryUserCarById(Integer id);

	/**
	 * 获取所有客户的用车信息
	 */
	public List<TNewUser> queryAllUserCar(Integer id);

	/**
	 * 获取所有客户的用餐信息
	 */
	public List<TNewUser> queryAllUserEat(Integer id);

	/**
	 * 获取客户的详细用餐信息
	 */
	public TNewUser queryUserEatById( Integer id);

	/**
	 * 获取客户的所有活动信息
	 */
	public List<TNewUser> queryAllUserActivity(Integer id);

	/**
	 * 获取客户的活动详情
	 */
	public TNewUser queryUserActivityById( Integer id);

	/**
	 * 获取所有客户的住房信息
	 */
	public List<TNewUser> queryAllUserHouse(Integer id);

	/**
	 * 获取客户的住房详情
	 */
	public TNewUser queryUserHouseById( Integer id);

	/**
	 * 根据选择的属性进行查询客户的信息
	 */
	public List<TNewUser> queryUserInfoByFiled(String filed1, String value1, String filed2, String value2, Integer id);

	/** 根据选择的属性进行查询客户的活动信息 */
	public List<TNewUser> queryUserActivityByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer id);

	/**
	 * 根据选择的属性进行查询客户的用餐信息
	 */
	public List<TNewUser> queryUserEatByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer end, Integer id);

	/**
	 * 根据选择的属性进行查询客户的用车信息
	 */
	public List<TNewUser> queryUserCarByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer end, Integer id);

	/**
	 * 根据选择的属性进行查询客户的住房信息
	 */
	public List<TNewUser> queryUserHouseByFiled(String filed1, String value1, String filed2, String value2,
			Integer status, Integer end, Integer id);
}
