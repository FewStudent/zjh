package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.enums.RoleType;
import com.stylefeng.guns.core.enums.VerifyType;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.system.excel.UserActivityExcel;
import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.modular.system.service.*;
import com.stylefeng.guns.modular.system.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:03:17
 */
@Controller
@RequestMapping("/tUserArchives")
public class TUserArchivesController extends BaseController {

    private String PREFIX = "/system/tUserArchives/";

    @Autowired
    private ITUserArchivesService tUserArchivesService;
    @Autowired
    private ITFileService fileService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITNewUserService service;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUserArchives.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/tUserArchives_add")
    public String tUserArchivesAdd() {
        return PREFIX + "tUserArchives_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/tUserArchives_update/{tUserArchivesId}")
    public String tUserArchivesUpdate(@PathVariable Integer tUserArchivesId, Model model) {
        TNewUser archive = service.queryUserActivityById(tUserArchivesId);
        // 演讲材料文件
        String sfile = archive.getSpeechFile();
        if (sfile != null && !sfile.equals("")) {
            String[] sfileArr = sfile.split(",");
            Set<Integer> ids = new HashSet<>();
            for (String str : sfileArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> sfiles = this.fileService.selectBatchIds(ids);
            model.addAttribute("sfiles", sfiles);
        } else {
            model.addAttribute("sfiles", null);
        }
        // 活动图片文件
        String photo = archive.getPhotoFile();
        if (photo != null && !photo.equals("")) {
            String[] photoArr = photo.split(",");
            Set<Integer> ids = new HashSet<>();

            for (String str : photoArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> photos = this.fileService.selectBatchIds(ids);
            model.addAttribute("photos", photos);
        } else {
            model.addAttribute("photos", null);
        }
        model.addAttribute("item", archive);
        LogObjectHolder.me().set(archive);
        return PREFIX + "tUserArchives_edit.html";
    }

    /**
     * 跳转到详情
     */
    @RequestMapping("/tUserArchives_detail/{tUserArchivesId}")
    public String tUserArchivesDetail(@PathVariable Integer tUserArchivesId, Model model) {
        TNewUser archive = service.queryUserActivityById(tUserArchivesId);
        archive.setActivityStatusName(VerifyType.getTypeByIndex(archive.getActivityStatus()));
        // 演讲材料文件
        String sfile = archive.getSpeechFile();
        if (sfile != null && !sfile.equals("")) {
            String[] sfileArr = sfile.split(",");
            Set<Integer> ids = new HashSet<>();
            for (String str : sfileArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> sfiles = this.fileService.selectBatchIds(ids);
            model.addAttribute("sfiles", sfiles);
        } else {
            model.addAttribute("sfiles", null);
        }
        // 活动图片文件
        String photo = archive.getPhotoFile();
        if (photo != null && !photo.equals("")) {
            String[] photoArr = photo.split(",");
            Set<Integer> ids = new HashSet<>();

            for (String str : photoArr) {
                ids.add(Integer.valueOf(str));
            }
            List<TFile> photos = this.fileService.selectBatchIds(ids);
            model.addAttribute("photos", photos);
        } else {
            model.addAttribute("photos", null);
        }
        model.addAttribute("item", archive);
        LogObjectHolder.me().set(archive);
        return PREFIX + "tUserArchives_detail.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String filed1, String filed2, String value1, String value2, Integer status, String search) {
        if (status != null && status.intValue() == -1) {
            status = null;
        }
        // 判断是否是录入员，如果是录入员 只能看到自己录入的信息
        List<TNewUser> userArchives;
        if (!ShiroKit.getUser().getRoleList().contains(6)) {
            userArchives = service.queryUserActivityByFiled(filed1, value1, filed2, value2, status, null);
        } else {
            userArchives = service.queryUserActivityByFiled(filed1, value1, filed2, value2, status, ShiroKit.getUser().getId());
        }
        for (TNewUser archives : userArchives) {
            // 审核状态
            archives.setActivityStatusName(VerifyType.getTypeByIndex(archives.getActivityStatus()));
            archives.setRoleName(RoleType.getTypeByIndex(archives.getRole()));

        }
        return userArchives;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TUserArchives tUserArchives, String sfile, String imgfile) {
        tUserArchives.setCreateTime(DateUtil.getTime());
        tUserArchives.setStatus(0);
        tUserArchives.setSpeechFile(sfile);
        tUserArchives.setPhoneFile(imgfile);
        tUserArchivesService.insert(tUserArchives);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserArchivesId) {
        service.deleteById(tUserArchivesId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TNewUser tUserArchives, String sfile, String imgfile) {
        TNewUser ot = this.service.selectById(tUserArchives.getId());
        tUserArchives.setUpdateTime(DateUtil.getTime());
        if (sfile != null && !sfile.equals("")) {
            String osfile = ot.getSpeechFile();
            if (osfile != null && !osfile.equals("")) {
                if (osfile.substring(osfile.length() - 1).equals(",")) {
                    tUserArchives.setSpeechFile(osfile + sfile);
                } else {
                    tUserArchives.setSpeechFile(osfile + "," + sfile);
                }
            } else {
                tUserArchives.setSpeechFile(sfile);
            }

        }
        if (imgfile != null && !imgfile.equals("")) {
            String opfile = ot.getPhotoFile();
            if (opfile != null && !opfile.equals("")) {
                if (opfile.substring(opfile.length() - 1).equals(",")) {
                    tUserArchives.setPhotoFile(opfile + imgfile);
                } else {
                    tUserArchives.setPhotoFile(opfile + "," + imgfile);
                }
            } else {
                tUserArchives.setPhotoFile(imgfile);
            }
        }
        service.updateById(tUserArchives);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{tUserArchivesId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserArchivesId") Integer tUserArchivesId) {
        return service.queryUserActivityById(tUserArchivesId);
    }

    /**
     * 跳转审核页面
     *
     * @param tUserArchivesId
     * @return
     */
    @RequestMapping(value = "/examine/{tUserArchivesId}")
    public String examine_html(@PathVariable("tUserArchivesId") Integer tUserArchivesId, Model model) {
        model.addAttribute("id", tUserArchivesId);
        model.addAttribute("item", service.queryUserActivityById(tUserArchivesId));
        return PREFIX + "tUserArchives_examine.html";
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
    @RequestMapping("/examine_do")
    @ResponseBody
    public Object examine_do(Integer id, Integer status, String sRemarkName, String sRemarkContent) {
        TNewUser archive = this.service.queryUserActivityById(id);
        archive.setActivityStatus(status);
        archive.setActivityStatusReamrkName(sRemarkName);
        archive.setActivityStatusRemark(sRemarkContent);
        this.service.updateById(archive);
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
        User user = this.iUserService.selectById(adminId);
        List<TNewUser> users = new ArrayList<>();
        String roleid = user.getRoleid();
        if (roleid.contains("6")) {
            Map<String, Object> params = new HashMap<>();
            params.put("create_by", adminId);
            users = this.service.selectByMap(params);
        } else {
            users = this.service.selectList(null);
        }
        List<UserActivityExcel> uas = new ArrayList<>();
        if (users != null) {
            for (TNewUser u : users) {
                UserActivityExcel ua = new UserActivityExcel();
                ua.setName(u.getName());
                ua.setSex(u.getSex());
                ua.setJob(u.getJob());
                ua.setLinkPhone(u.getLinkPhone());
                ua.setPickUp(u.getPickUp());
                ua.setTranslate(u.getTranslate());
                ua.setFollow(u.getFollow());
                ua.setAccompany(u.getAccompany());
                ua.setEmail(u.getEmail());
                ua.setCreateTime(u.getCreateTime());
                ua.setUpdateTime(u.getUpdateTime());
                ua.setCard(u.getCard());
                ua.setCompany(u.getCompany());
                ua.setPhone(u.getPhone());


                ua.setAccount(u.getAccount());
                ua.setAccountBlank(u.getAccountBlank());
                ua.setAccountName(u.getAccountName());
                ua.setActivity(u.getActivity());
                ua.setActivityAddRemark(u.getActivityAddRemark());
                ua.setActivityAddRemarkName(u.getActivityAddRemarkName());
                ua.setActivityStatus(u.getActivityStatus());
                ua.setActivityStatusReamrkName(u.getActivityStatusReamrkName());
                ua.setActivityStatusRemark(u.getActivityStatusRemark());
                ua.setPersonalSynopsis(u.getPersonalSynopsis());
                ua.setRole(u.getRole());
                ua.setSpeechTopic(u.getSpeechTopic());
                uas.add(ua);
            }
        }
        ExcelUtils.writeExcel(response, uas, UserActivityExcel.class, "客户个人活动表");
    }


    @RequestMapping(value = "/delete_sfile")
    @ResponseBody
    public String delete_sfile(Integer fileid, Integer aid) {
        TNewUser archives = this.service.selectById(aid);
        String sfile = archives.getSpeechFile();
        if (sfile != null) {
            String sf = "";
            String[] sfileArr = sfile.split(",");
            for (String str : sfileArr) {
                if (Integer.valueOf(str).intValue() != fileid.intValue()) {
                    sf = sf + str + ",";
                }
            }
            archives.setSpeechFile(sf);
            this.service.updateById(archives);
            this.fileService.deleteById(fileid);
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/delete_pfile")
    @ResponseBody
    public String delete_pfile(Integer fileid, Integer aid) {
        TNewUser archives = this.service.selectById(aid);
        String pfile = archives.getPhotoFile();
        if (pfile != null) {
            String sf = "";
            String[] pfileArr = pfile.split(",");
            for (String str : pfileArr) {
                if (Integer.valueOf(str).intValue() != fileid.intValue()) {
                    sf = sf + str + ",";
                }
            }
            archives.setPhotoFile(sf);
            this.service.updateById(archives);
            this.fileService.deleteById(fileid);
            return "success";
        }
        return "error";
    }
}
