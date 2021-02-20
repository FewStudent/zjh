package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TNewUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 客户的信息总表 Mapper 接口
 * </p>
 *
 * @author lakyjpan
 * @since 2019-10-07
 */
public interface TNewUserMapper extends BaseMapper<TNewUser> {

	/**
	 * 获取所有客户的基础信息
	 */
	public List<TNewUser> queryAllUserInfo(@Param("create") Integer id);

	/**
	 * 获取单个客户所有信息
	 */
	public TNewUser queryUserInfoById(@Param("id") Integer id);

	/**
	 * 获取单个客户的用车信息
	 */
	public TNewUser queryUserCarById(@Param("id") Integer id);

	/**
	 * 获取所有客户的用车信息
	 */
	public List<TNewUser> queryAllUserCar(@Param("create") Integer id);

	/**
	 * 获取所有客户的用餐信息
	 */
	public List<TNewUser> queryAllUserEat(@Param("create") Integer id);

	/**
	 * 获取客户的详细用餐信息
	 */
	public TNewUser queryUserEatById(@Param("id") Integer id);

	/**
	 * 获取客户的所有活动信息
	 */
	public List<TNewUser> queryAllUserActivity(@Param("create") Integer id);

	/**
	 * 获取客户的活动详情
	 */
	public TNewUser queryUserActivityById(@Param("id") Integer id);

	/**
	 * 获取所有客户的住房信息
	 */
	public List<TNewUser> queryAllUserHouse(@Param("create") Integer id);

	/**
	 * 获取客户的住房详情
	 */
	public TNewUser queryUserHouseById(@Param("id") Integer id);

	/**
	 * 根据选择的属性进行查询客户的信息
	 */
	public List<TNewUser> queryUserInfoByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
			@Param("filed2") String filed2, @Param("value2") String value2, @Param("create") Integer id);

	/** 根据选择的属性进行查询客户的活动信息 */
	public List<TNewUser> queryUserActivityByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
			@Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
			@Param("create") Integer id);

	/**
	 * 根据选择的属性进行查询客户的用餐信息
	 */
	public List<TNewUser> queryUserEatByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
			@Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
			@Param("end") Integer end, @Param("create") Integer id);

	/**
	 * 根据选择的属性进行查询客户的用车信息
	 */
	public List<TNewUser> queryUserCarByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
			@Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
			@Param("end") Integer end, @Param("create") Integer id);

	/**
	 * 根据选择的属性进行查询客户的住房信息
	 */
	public List<TNewUser> queryUserHouseByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
			@Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
			@Param("end") Integer end, @Param("create") Integer id);

}
