package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.system.model.TNewTeam;
import com.stylefeng.guns.modular.system.service.ITNewTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 团队总信息控制器
 *
 * @author fengshuonan
 * @Date 2019-10-07 16:56:26
 */
@Controller
@RequestMapping("/tNewTeam")
public class TNewTeamController extends BaseController {

    private String PREFIX = "/new_team/tNewTeam/";

    @Autowired
    private ITNewTeamService tNewTeamService;

    /**
     * 跳转到团队总信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tNewTeam.html";
    }

    /**
     * 跳转到添加团队总信息
     */
    @RequestMapping("/tNewTeam_add")
    public String tNewTeamAdd() {
        return PREFIX + "tNewTeam_add.html";
    }

    /**
     * 跳转到修改团队总信息
     */
    @RequestMapping("/tNewTeam_update/{tNewTeamId}")
    public String tNewTeamUpdate(@PathVariable Integer tNewTeamId, Model model) {
        TNewTeam tNewTeam = tNewTeamService.selectById(tNewTeamId);
        model.addAttribute("item",tNewTeam);
        LogObjectHolder.me().set(tNewTeam);
        return PREFIX + "tNewTeam_edit.html";
    }

    /**
     * 获取团队总信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tNewTeamService.selectList(null);
    }

    /**
     * 新增团队总信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TNewTeam tNewTeam) {
        tNewTeamService.insert(tNewTeam);
        return SUCCESS_TIP;
    }

    /**
     * 删除团队总信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tNewTeamId) {
        tNewTeamService.deleteById(tNewTeamId);
        return SUCCESS_TIP;
    }

    /**
     * 修改团队总信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewTeam tNewTeam) {
        tNewTeamService.updateById(tNewTeam);
        return SUCCESS_TIP;
    }

    /**
     * 团队总信息详情
     */
    @RequestMapping(value = "/detail/{tNewTeamId}")
    @ResponseBody
    public Object detail(@PathVariable("tNewTeamId") Integer tNewTeamId) {
        return tNewTeamService.selectById(tNewTeamId);
    }
}
