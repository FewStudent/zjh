package com.stylefeng.guns.core.util;

import java.util.ArrayList;
import java.util.List;

import com.stylefeng.guns.modular.system.model.TNewUser;
import com.stylefeng.guns.modular.system.model.TUserCar;

/**
 * @author lakyjpan
 * @version 创建时间：2019年10月11日 上午2:28:30 用于把TNewUser类的用车信息与TUserCar之间转换
 */
public class UserCarTransformUtil {

	public static TNewUser oneToTNewUser(TUserCar tUserCar, TNewUser user) {
		if (tUserCar == null) {
			return null;
		}
		if (user == null) {
			user = new TNewUser();
			user.setId(tUserCar.getId());
		}
		user.setName(tUserCar.getUserIdName());
		user.setPhone(tUserCar.getContacts());
		user.setCreateTime(tUserCar.getCreateTime());
		if (tUserCar.getType() == 1) {
			// 接车
			user.setjAccompanyLeader(tUserCar.getAccompanyLeader());
			user.setjArrangeRemark(tUserCar.getaRemarkContent());
			if (tUserCar.getaRemarkName() != null || !tUserCar.getaRemarkName().equals("")) {
				user.setjCarArrange(1);
				user.setjAddRemark(tUserCar.getaRemarkContent());
			}
			user.setjUseCarDate(tUserCar.getNeedCarDate());
			user.setjUseCarTime(tUserCar.getNeedCarTime());
			user.setjTrafficNum(tUserCar.getTrafficNumber());
			user.setjRidePlace(tUserCar.getRidePlace());
			user.setjRidePeoples(tUserCar.getRidePeoples());
			user.setjDestination(tUserCar.getDestination());
			user.setjPayType(tUserCar.getPayType());
			user.setjHasStopCard(tUserCar.getStopCard());
			user.setjDriver(tUserCar.getDriver());
			user.setjDriverPhone(tUserCar.getDriverPhone());
			user.setjCarCard(tUserCar.getCarNum());
			user.setjCarSType(tUserCar.getEnd());
			user.setjArrangeRemark(tUserCar.getaRemarkContent());
		} else if (tUserCar.getType() == 2) {
			// 送车
			user.setsAccompanyLeader(tUserCar.getAccompanyLeader());
			user.setsArrangeRemark(tUserCar.getaRemarkContent());
			if (tUserCar.getaRemarkName() != null || !tUserCar.getaRemarkName().equals("")) {
				user.setsCarArrange(1);
				user.setsAddRemark(tUserCar.getaRemarkContent());
			}
			user.setsUseCarDate(tUserCar.getNeedCarDate());
			user.setsUseCarTime(tUserCar.getNeedCarTime());
			user.setsTrafficNum(tUserCar.getTrafficNumber());
			user.setsRidePlace(tUserCar.getRidePlace());
			user.setsRidePeoples(tUserCar.getRidePeoples());
			user.setsDestination(tUserCar.getDestination());
			user.setsPayType(tUserCar.getPayType());
			user.setsHasStopCard(tUserCar.getStopCard());
			user.setsDriver(tUserCar.getDriver());
			user.setsDriverPhone(tUserCar.getDriverPhone());
			user.setsCarCard(tUserCar.getCarNum());
			user.setsCarSType(tUserCar.getEnd());
			user.setsArrangeRemark(tUserCar.getaRemarkContent());
		} else {
			// 市区用车
			user.setcAccompanyLeader(tUserCar.getAccompanyLeader());
			user.setcArrangeRemark(tUserCar.getaRemarkContent());
			if (tUserCar.getaRemarkName() != null || !tUserCar.getaRemarkName().equals("")) {
				user.setcCarArrange(1);
				user.setcAddRemark(tUserCar.getaRemarkContent());
			}
			user.setcUseCarDate(tUserCar.getNeedCarDate());
			user.setcUseCarTime(tUserCar.getNeedCarTime());
			user.setcRidePlace(tUserCar.getRidePlace());
			user.setcRidePeoples(tUserCar.getRidePeoples());
			user.setcDestination(tUserCar.getDestination());
			user.setcPayType(tUserCar.getPayType());
			user.setcHasStopCard(tUserCar.getStopCard());
			user.setcDriver(tUserCar.getDriver());
			user.setcDriverPhone(tUserCar.getDriverPhone());
			user.setcCarCard(tUserCar.getCarNum());
			user.setcCarSType(tUserCar.getEnd());
			user.setcArrangeRemark(tUserCar.getaRemarkContent());
		}
		return user;
	}

	/** 将所有用车情况转换为TNewUser对象 */
	public static TNewUser listToTNewUser(List<TUserCar> cars, TNewUser user) {
		if (cars == null) {
			return null;
		}
		if (user == null) {
			user = new TNewUser();
			user.setId(cars.get(0).getId());
		}
		user.setName(cars.get(0).getUserIdName());
		user.setPhone(cars.get(0).getContacts());
		user.setCreateTime(cars.get(0).getCreateTime());
		for (TUserCar tUserCar : cars) {

			if (tUserCar.getType() == 1) {
				// 接车
				user.setjAccompanyLeader(tUserCar.getAccompanyLeader());
				user.setjArrangeRemark(tUserCar.getaRemarkContent());
				if (tUserCar.getaRemarkName() != null || !tUserCar.getaRemarkName().equals("")) {
					user.setjCarArrange(1);
					user.setjAddRemark(tUserCar.getaRemarkContent());
				}
				user.setjUseCarDate(tUserCar.getNeedCarDate());
				user.setjUseCarTime(tUserCar.getNeedCarTime());
				user.setjTrafficNum(tUserCar.getTrafficNumber());
				user.setjRidePlace(tUserCar.getRidePlace());
				user.setjRidePeoples(tUserCar.getRidePeoples());
				user.setjDestination(tUserCar.getDestination());
				user.setjPayType(tUserCar.getPayType());
				user.setjHasStopCard(tUserCar.getStopCard());
				user.setjDriver(tUserCar.getDriver());
				user.setjDriverPhone(tUserCar.getDriverPhone());
				user.setjCarCard(tUserCar.getCarNum());
				user.setjCarSType(tUserCar.getEnd());
				user.setjArrangeRemark(tUserCar.getaRemarkContent());
			} else if (tUserCar.getType() == 2) {
				// 送车
				user.setsAccompanyLeader(tUserCar.getAccompanyLeader());
				user.setsArrangeRemark(tUserCar.getaRemarkContent());
				if (tUserCar.getaRemarkName() != null || !tUserCar.getaRemarkName().equals("")) {
					user.setsCarArrange(1);
					user.setsAddRemark(tUserCar.getaRemarkContent());
				}
				user.setsUseCarDate(tUserCar.getNeedCarDate());
				user.setsUseCarTime(tUserCar.getNeedCarTime());
				user.setsTrafficNum(tUserCar.getTrafficNumber());
				user.setsRidePlace(tUserCar.getRidePlace());
				user.setsRidePeoples(tUserCar.getRidePeoples());
				user.setsDestination(tUserCar.getDestination());
				user.setsPayType(tUserCar.getPayType());
				user.setsHasStopCard(tUserCar.getStopCard());
				user.setsDriver(tUserCar.getDriver());
				user.setsDriverPhone(tUserCar.getDriverPhone());
				user.setsCarCard(tUserCar.getCarNum());
				user.setsCarSType(tUserCar.getEnd());
				user.setsArrangeRemark(tUserCar.getaRemarkContent());
			} else {
				// 市区用车
				user.setcAccompanyLeader(tUserCar.getAccompanyLeader());
				user.setcArrangeRemark(tUserCar.getaRemarkContent());
				if (tUserCar.getaRemarkName() != null || !tUserCar.getaRemarkName().equals("")) {
					user.setcCarArrange(1);
					user.setcAddRemark(tUserCar.getaRemarkContent());
				}
				user.setcUseCarDate(tUserCar.getNeedCarDate());
				user.setcUseCarTime(tUserCar.getNeedCarTime());
				user.setcRidePlace(tUserCar.getRidePlace());
				user.setcRidePeoples(tUserCar.getRidePeoples());
				user.setcDestination(tUserCar.getDestination());
				user.setcPayType(tUserCar.getPayType());
				user.setcHasStopCard(tUserCar.getStopCard());
				user.setcDriver(tUserCar.getDriver());
				user.setcDriverPhone(tUserCar.getDriverPhone());
				user.setcCarCard(tUserCar.getCarNum());
				user.setcCarSType(tUserCar.getEnd());
				user.setcArrangeRemark(tUserCar.getaRemarkContent());
			}
		}
		return user;

	}

	/** 将TnewUser对象转换为所有的用车信息 */
	public static List<TUserCar> toTUserCar(TNewUser user) {
		if (user == null) {
			return null;
		}
		List<TUserCar> cars = new ArrayList<TUserCar>();
		/** 市区用车 */
		cars.add(toJCar(user));
		/** 送车 */
		cars.add(toSCar(user));
		/** 接车 */
		cars.add(toCCar(user));
		return cars;
	}

	/** 转换为其中一种用车 */
	public static TUserCar toOneUsercar(TNewUser user, int type) {
		if (user == null) {
			return null;
		}
		if (type == 0) {
			return toJCar(user);
		}
		if (type == 1) {
			return toSCar(user);
		}
		if (type == 2) {
			return toCCar(user);
		}
		return null;
	}

	/** 转换为市区用车 */
	private static TUserCar toCCar(TNewUser user) {
		TUserCar car = new TUserCar();
		car.setType(2);
		car.setUserIdName(user.getName());
		car.setUserId(user.getId());
		car.setAccompanyLeader(user.getcAccompanyLeader());
		car.setaRemarkContent(user.getcArrangeRemark());
		car.setArrange(user.getcCarArrange());
		car.setRemarkContent(user.getcAddRemark());
		car.setNeedCarDate(user.getcUseCarDate());
		car.setNeedCarTime(user.getcUseCarTime());
		car.setRidePeoples(user.getcRidePeoples());
		car.setRidePlace(user.getcRidePlace());
		car.setDestination(user.getcDestination());
		car.setPayType(user.getcPayType());
		car.setStopCard(user.getcHasStopCard());
		car.setDriver(user.getcDriver());
		car.setDriverPhone(user.getcDriverPhone());
		car.setCarNum(user.getcCarCard());
		car.setEnd(user.getcCarSType());
		car.setaRemarkContent(user.getcArrangeRemark());
		car.setUserIdName(user.getName());
		car.setContacts(user.getPhone());
		car.setCreateTime(user.getCreateTime());
		car.setId(user.getId());
		return car;
	}

	/** 转换为送客用车 */
	private static TUserCar toSCar(TNewUser user) {
		TUserCar car = new TUserCar();
		car.setType(1);
		car.setUserIdName(user.getName());
		car.setUserId(user.getId());
		car.setAccompanyLeader(user.getsAccompanyLeader());
		car.setaRemarkContent(user.getsArrangeRemark());
		car.setArrange(user.getsCarArrange());
		car.setRemarkContent(user.getsAddRemark());
		car.setNeedCarDate(user.getsUseCarDate());
		car.setNeedCarTime(user.getsUseCarTime());
		car.setRidePeoples(user.getsRidePeoples());
		car.setRidePlace(user.getsRidePlace());
		car.setDestination(user.getsDestination());
		car.setPayType(user.getsPayType());
		car.setStopCard(user.getsHasStopCard());
		car.setDriver(user.getsDriver());
		car.setDriverPhone(user.getsDriverPhone());
		car.setCarNum(user.getsCarCard());
		car.setEnd(user.getsCarSType());
		car.setaRemarkContent(user.getsArrangeRemark());
		car.setUserIdName(user.getName());
		car.setContacts(user.getPhone());
		car.setCreateTime(user.getCreateTime());
		car.setTrafficNumber(user.getsTrafficNum());
		car.setId(user.getId());
		return car;
	}

	/** 转换为接人用车 */
	private static TUserCar toJCar(TNewUser user) {
		TUserCar car = new TUserCar();
		car.setType(0);
		car.setUserIdName(user.getName());
		car.setUserId(user.getId());
		car.setAccompanyLeader(user.getjAccompanyLeader());
		car.setaRemarkContent(user.getjArrangeRemark());
		car.setArrange(user.getjCarArrange());
		car.setRemarkContent(user.getjAddRemark());
		car.setNeedCarDate(user.getjUseCarDate());
		car.setNeedCarTime(user.getjUseCarTime());
		car.setRidePeoples(user.getjRidePeoples());
		car.setRidePlace(user.getjRidePlace());
		car.setDestination(user.getjDestination());
		car.setPayType(user.getjPayType());
		car.setStopCard(user.getjHasStopCard());
		car.setDriver(user.getjDriver());
		car.setDriverPhone(user.getjDriverPhone());
		car.setCarNum(user.getjCarCard());
		car.setEnd(user.getjCarSType());
		car.setaRemarkContent(user.getjArrangeRemark());
		car.setUserIdName(user.getName());
		car.setContacts(user.getPhone());
		car.setCreateTime(user.getCreateTime());
		car.setTrafficNumber(user.getjTrafficNum());
		car.setId(user.getId());
		return car;
	}

}
