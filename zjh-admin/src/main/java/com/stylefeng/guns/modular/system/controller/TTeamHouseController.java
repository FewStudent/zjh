package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.ArrangeType;
import com.stylefeng.guns.core.enums.EndType;
import com.stylefeng.guns.core.enums.PayType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.TeamHouseExcel;
import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.modular.system.service.ITNewTeamService;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.util.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.service.ITTeamHouseService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:03:04
 */
@Controller
@RequestMapping("/tTeamHouse")
public class TTeamHouseController extends BaseController {

	private String PREFIX = "/system/tTeamHouse/";

	@Autowired
	private ITTeamHouseService tTeamHouseService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ITNewTeamService newTeamService;

	/**
	 * 跳转到首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "tTeamHouse.html";
	}

	/**
	 * 跳转到添加
	 */
	@RequestMapping("/tTeamHouse_add")
	public String tTeamHouseAdd() {
		return PREFIX + "tTeamHouse_add.html";
	}

	/**
	 * 跳转到修改
	 */
	@RequestMapping("/tTeamHouse_update/{tTeamHouseId}")
	public String tTeamHouseUpdate(@PathVariable Integer tTeamHouseId, Model model) {
		TNewTeam newUser = newTeamService.queryTeamInfoById(tTeamHouseId);
		model.addAttribute("item", newUser);
		LogObjectHolder.me().set(newUser);
		return PREFIX + "tTeamHouse_edit.html";
	}

	/**
	 * 跳转到详情
	 */
	@RequestMapping("/tTeamHouse_detail/{tTeamHouseId}")
	public String tTeamHouseDetail(@PathVariable Integer tTeamHouseId, Model model) {
		TNewTeam newUser = newTeamService.queryTeamHouseById(tTeamHouseId);
		model.addAttribute("item", newUser);
		LogObjectHolder.me().set(newUser);
		return PREFIX + "tTeamHouse_detail.html";
	}

	/**
	 * 获取列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(Integer status, Integer end, String filed1, String filed2, String value1, String value2) {
		if (status != null && status.intValue() == -1) {
			status = null;
		}
		if (end != null && end.intValue() == -1) {
			end = null;
		}
		List<TNewTeam> users;
		if (!ShiroKit.getUser().getRoleList().contains(6)) {
			users = newTeamService.queryTeamHouseByFiled(filed1, value1, filed2, value2, status, end, null);
		} else {
			users = newTeamService.queryTeamHouseByFiled(filed1, value1, filed2, value2, status, end,
					ShiroKit.getUser().getId());
		}
		for (TNewTeam house : users) {
			// 付费方式
			house.setHousePayTypeName(PayType.getTypeByIndex(house.getHousePayType()));
			house.setHouseEndName(EndType.getTypeByIndex(house.getHouseEnd()));
			house.setHouseStatusName(VerifyType.getTypeByIndex(house.getHouseStatus()));
			house.setHouseArrangeName(ArrangeType.getTypeByIndex(house.getHouseArrange()));
		}
		return users;
	}

	/**
	 * 新增
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(TTeamHouse tTeamHouse) {
		tTeamHouse.setCreateTime(DateUtil.getTime());
		tTeamHouse.setStatus(0);
		tTeamHouse.setEnd(0);
		tTeamHouseService.insert(tTeamHouse);
		return SUCCESS_TIP;
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer tTeamHouseId) {
		newTeamService.deleteById(tTeamHouseId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(TNewTeam tTeamHouse, Integer end, Integer status) {
		System.out.println("status:" + status);
		System.out.println("end:" + end);
		tTeamHouse.setUpdateTime(DateUtil.getTime());
		newTeamService.updateById(tTeamHouse);
		return SUCCESS_TIP;
	}

	/**
	 * 详情
	 */
	@RequestMapping(value = "/detail/{tTeamHouseId}")
	@ResponseBody
	public Object detail(@PathVariable("tTeamHouseId") Integer tTeamHouseId) {
		return newTeamService.queryTeamHouseById(tTeamHouseId);
	}

	/**
	 * 审核页面
	 *
	 * @param tTeamHouseId
	 * @return
	 */
	@RequestMapping(value = "/examine/{tTeamHouseId}")
	public String examine_html(@PathVariable("tTeamHouseId") Integer tTeamHouseId, Model model) {
		model.addAttribute("id", tTeamHouseId);
		model.addAttribute("item", newTeamService.queryTeamHouseById(tTeamHouseId));
		return PREFIX + "tTeamHouse_examine.html";
	}

	/**
	 * 审核
	 *
	 * @param id
	 * @param status
	 * @param sRemarkName
	 * @param sRemarkContent
	 * @return
	 */
	@RequestMapping(value = "/examine_do")
	@ResponseBody
	public Object examine_do(Integer id, Integer status, String sRemarkName, String sRemarkContent) {
		TNewTeam newUser = this.newTeamService.queryTeamHouseById(id);
		newUser.setHouseStatus(status);
		newUser.setHouseStatusReamrkName(sRemarkName);
		newUser.setHouseStatusRemark(sRemarkContent);
		this.newTeamService.updateById(newUser);
		return SUCCESS_TIP;
	}

	/**
	 * 安排页面
	 *
	 * @param tTeamHouseId
	 * @return
	 */
	@RequestMapping(value = "/make/{tTeamHouseId}")
	public String make(@PathVariable("tTeamHouseId") Integer tTeamHouseId, Model model) {
		model.addAttribute("id", tTeamHouseId);
		model.addAttribute("item", newTeamService.queryTeamHouseById(tTeamHouseId));
		return PREFIX + "tTeamHouse_make.html";
	}

	/**
	 * 安排
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/make_do")
	@ResponseBody
	public Object make_do(Integer id, Integer status, String remark,Integer arrange) {
		TNewTeam newUser = newTeamService.queryTeamHouseById(id);
		newUser.setHouseArrange(arrange);
		newUser.setHouseArrangeRemark(remark);
		newTeamService.updateById(newUser);
		return SUCCESS_TIP;
	}

	/**
	 * 结束页面
	 *
	 * @param tTeamHouseId
	 * @param model
	 * @return
	 */
	@RequestMapping("/end/{tTeamHouseId}")
	public String end_html(@PathVariable("tTeamHouseId") Integer tTeamHouseId, Model model) {
		model.addAttribute("id", tTeamHouseId);
		model.addAttribute("item", newTeamService.queryTeamHouseById(tTeamHouseId));
		return PREFIX + "tTeamHouse_end.html";
	}

	/**
	 * 结束
	 *
	 * @param id
	 * @param end
	 * @param eRemarkName
	 * @param eRemarkContent
	 * @return
	 */
	@RequestMapping(value = "/end_do")
	@ResponseBody
	public Object end(Integer id, Integer end, String eRemarkName, String eRemarkContent) {
		TNewTeam newUser = this.newTeamService.selectById(id);
		newUser.setHouseEnd(end);
		newUser.setHouseEndRemark(eRemarkContent);
		newUser.setHouseEndRemarkName(eRemarkName);
		this.newTeamService.updateById(newUser);
		return SUCCESS_TIP;
	}

	/**
	 * 导出
	 *
	 * @return
	 */
	@RequestMapping(value = "/exclude")
	public void exclude(HttpServletResponse response) {
		// 判断是否是录入员，如果是录入员 只能看到自己录入的信息
		Integer adminId = ShiroKit.getUser().getId();
		User user = this.userService.selectById(adminId);
		String roleid = user.getRoleid();
		List<TNewTeam> newTeams = new ArrayList<>();
		if (roleid.contains("6")) {
			Map<String, Object> params = new HashMap<>();
			params.put("create_by", adminId);
			newTeams = this.newTeamService.selectByMap(params);
		} else {
			newTeams = this.newTeamService.selectList(null);
		}
		List<TeamHouseExcel> ths = new ArrayList<>();
		if (newTeams != null) {
			for (TNewTeam u : newTeams) {
				TeamHouseExcel h = new TeamHouseExcel();
				h.setCompany(u.getCompany());
				h.setArea(u.getArea());
				h.setCard(u.getCard());
				h.setCompanyLeader(u.getCompanyLeader());
				h.setCreateTime(u.getCreateTime());
				h.setUpdateTime(u.getUpdateTime());
				h.setPickUp(u.getPickUp());
				h.setTeamNums(u.getTeamNums());
				h.setLinkUser(u.getLinkUser());
				h.setLinkPhone(u.getLinkPhone());

				h.setHotelName(u.getHotelName());
				h.setHotelRoomNum(u.getHotelRoomNum());
				h.setHotelRoomType(u.getHotelRoomType());
				h.setHotelVacant(u.getHotelVacant());
				h.setHouseAddRemark(u.getHouseAddRemark());
				h.setHouseArrange(u.getHouseArrange());
				h.setHouseArrangeRemark(u.getHouseArrangeRemark());
				h.setHouseEnd(u.getHouseEnd());
				h.setHouseEndRemark(u.getHouseEndRemark());
				h.setHouseEndRemarkName(u.getHouseEndRemarkName());
				h.setHouseInDate(u.getHouseInDate());
				h.setHouseOutDate(u.getHouseOutDate());
				h.setHousePayType(u.getHousePayType());
				h.setHouseStatus(u.getHouseStatus());
				h.setHouseStatusReamrkName(u.getHouseStatusReamrkName());
				h.setHouseStatusRemark(u.getHouseStatusRemark());
				h.setPrice(u.getPrice());
				h.setRoomTotal(u.getRoomTotal());
				h.setSplicePeople(u.getSplicePeople());
				h.setSpliceRoom(u.getSpliceRoom());
				h.setTotalPrice(u.getTotalPrice());
				ths.add(h);
			}
		}
		ExcelUtils.writeExcel(response, ths, TeamHouseExcel.class, "客户团体住房表");
	}

}