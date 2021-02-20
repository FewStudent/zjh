package com.stylefeng.guns.rest.modular.rest.controller;

import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.rest.common.ResponseCode;
import com.stylefeng.guns.rest.modular.rest.common.ResultVo;
import com.stylefeng.guns.rest.modular.rest.dao.SysAdminMapper;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelUtils;
import com.stylefeng.guns.rest.modular.rest.model.SysAdmin;
import com.stylefeng.guns.rest.modular.rest.model.TTeam;
import com.stylefeng.guns.rest.modular.rest.util.Md5Password;
import com.stylefeng.guns.rest.modular.rest.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * <p>Description</p>
 * <p>系统管理员控制层</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/14
 */
@RestController
@RequestMapping("/system")
public class SysAdminController {

    private static final Logger log = LoggerFactory.getLogger(SysAdminController.class);

    @Autowired
    private SysAdminMapper sysAdminMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 登录接口.
     *
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Object login(String account, String password) {
        log.info("登录接口 uri = system/login 参数列表：{'account':{},'password':{}}", new Object[]{account, password});
        Map<String, Object> params = new HashMap<>();
        ResultVo resultVo = new ResultVo(ResponseCode.USER_NOT_EXIST, "用户名与密码不匹配");
        params.put("account", account);
        List<SysAdmin> admins = this.sysAdminMapper.selectByMap(params);
        if (admins != null && admins.size() > 0) {
            SysAdmin sysAdmin = admins.get(0);
            String old_pwd = sysAdmin.getPassword();
            String salt = sysAdmin.getSalt();
            if (old_pwd.equals(Md5Password.md5(password, salt))) {
                sysAdmin.setPassword(null);
                sysAdmin.setSalt(null);
                final String randomKey = jwtTokenUtil.getRandomKey();
                final String token = jwtTokenUtil.generateToken(account + randomKey, randomKey);
                Map<String, Object> datas = new HashMap<>();
                resultVo.setCode(ResponseCode.SUCCESS);
                resultVo.setMsg("登录成功");
                datas.put("token", token);
                datas.put("randomKey", randomKey);
                datas.put("admin", sysAdmin);
                resultVo.setDatas(datas);
            }
        }
        return resultVo;
    }

    /**
     * 添加管理员接口
     *
     * @param sysAdmin
     * @return
     */
    @PostMapping("/regist")
    public Object add_admin(@Valid SysAdmin sysAdmin, BindingResult errors) {
        log.info("添加管理员接口 uri=system/regist  参数列表：{'admin':{}}", new Object[]{sysAdmin});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "添加失败");
        // 非空参数判断
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                resultVo.setMsg(fieldError.getField() + ":" + fieldError.getDefaultMessage());
                resultVo.setCode(ResponseCode.PARAMS_ERROR);
            });
            return resultVo;
        }
        sysAdmin.setCreate_time(DateUtil.getTime());
        String salt = RandomUtil.getRancomSalt();
        sysAdmin.setSalt(salt);
        sysAdmin.setAdmin(0);
        sysAdmin.setPassword(Md5Password.md5(sysAdmin.getPassword(), salt));
        try {
            this.sysAdminMapper.insert(sysAdmin);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("添加成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 删除管理员接口
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Object delete_by_id(Integer id) {
        log.info("删除账号接口  uri=system/delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        if (id == null) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("id不能为空");
            return resultVo;
        }
        try {
            SysAdmin admin = this.sysAdminMapper.selectById(id);
            if (id == 1 || admin.getAccount().equals("boss")) {
                resultVo.setMsg("不能删除超级管理员");
                return resultVo;
            }
            this.sysAdminMapper.deleteById(id);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 查看详情.
     *
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public Object detail_by_id(Integer id) {
        log.info("查看管理员详情接口 uri=system/detail 参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.RESOURCES_NOT_EXIST, "用户不存在");
        if (id == null) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("id不能为空");
            return resultVo;
        }
        try {
            SysAdmin admin = this.sysAdminMapper.selectById(id);
            admin.setPassword(null);
            admin.setSalt(null);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("admin", admin);
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 跟新接口
     *
     * @param sysAdmin
     * @return
     */
    @PostMapping("/update")
    public Object update_by_id(SysAdmin sysAdmin) {
        log.info("更新管理员信息接口  url=system/update  参数列表：{'admin':{}}", new Object[]{sysAdmin});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "修改失败");
        // 非空参数判断
        if (sysAdmin.getId() == null || sysAdmin.getAccount() == null || sysAdmin.getAccount().equals("")) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("id / account不能为空");
            return resultVo;
        }
        try {
            SysAdmin admin = this.sysAdminMapper.selectById(sysAdmin.getId());
            if (sysAdmin.getPassword() != null && !sysAdmin.getPassword().equals("")) {
                String salt = RandomUtil.getRancomSalt();
                admin.setSalt(salt);
                admin.setPassword(Md5Password.md5(sysAdmin.getPassword(), salt));
            }
            admin.setName(sysAdmin.getName());
            admin.setUpdate_time(DateUtil.getTime());
            admin.setSex(sysAdmin.getSex());
            admin.setDepartment(sysAdmin.getDepartment());
            admin.setJob(sysAdmin.getJob());
            admin.setPhone(sysAdmin.getPhone());
            admin.setAccount(sysAdmin.getAccount());
            admin.setEnter(sysAdmin.getEnter());
            admin.setExamine(sysAdmin.getExamine());
            admin.setOperation(sysAdmin.getOperation());
            admin.setImplement(sysAdmin.getImplement());
            admin.setHouse(sysAdmin.getHouse());
            admin.setMeals(sysAdmin.getMeals());
            admin.setCar(sysAdmin.getCar());
            this.sysAdminMapper.updateById(admin);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("更新成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 管理员列表.
     *
     * @return
     */
    @GetMapping("/list")
    public Object list() {
        log.info("管理员列表接口  uri=system/list");
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<SysAdmin> admins = this.sysAdminMapper.findAllAdmins();
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("admins", admins);
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 系统管理员导出
     *
     * @param ids
     * @param response
     * @return
     */
    @GetMapping("/export")
    public Object system_export(String ids, HttpServletResponse response) {
        log.info("管理员导出接口 uri=system/export  参数列表：{'ids':{}}", new Object[]{ids});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "导出失败,无资源");
        if (ids == null || ids.equals("")) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("ids不能为空");
            return resultVo;
        }
        Set<Integer> allid = new HashSet<>();
        String[] idArr = ids.split(",");
        for (String str : idArr) {
            allid.add(Integer.valueOf(str));
        }
        List<SysAdmin> admins = this.sysAdminMapper.selectBatchIds(allid);
        ExcelUtils.writeExcel(response, admins, SysAdmin.class, "系统管理员表");
        return resultVo;
    }

}
