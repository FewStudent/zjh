package com.stylefeng.guns.rest.modular.rest.controller;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.modular.rest.common.ResponseCode;
import com.stylefeng.guns.rest.modular.rest.common.ResultVo;
import com.stylefeng.guns.rest.modular.rest.dao.*;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelUtils;
import com.stylefeng.guns.rest.modular.rest.excel.PersonExcelInClude;
import com.stylefeng.guns.rest.modular.rest.model.*;
import com.stylefeng.guns.rest.modular.rest.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * <p>Description</p>
 * <p>个人用户控制层</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/15
 */
@RestController
@RequestMapping("/user")
public class TUserController {

    private static final Logger log = LoggerFactory.getLogger(TUserController.class);
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TUserArchivesMapper userArchivesMapper;
    @Autowired
    private TUserEatMapper userEatMapper;
    @Autowired
    private TUserCarMapper userCarMapper;
    @Autowired
    private TUserHouseMapper userHouseMapper;
    @Autowired
    private TRemarkMapper remarkMapper;
    @Autowired
    private THouseMapper houseMapper;
    @Autowired
    private TFileMapper fileMapper;

    /**
     * 客户个人信息列表.
     *
     * @param seach
     * @return
     */
    @GetMapping("/list")
    public Object list(String seach) {
        log.info("客户个人信息列表接口  uri=user/list  参数列表：{'seach':{}}", new Object[]{seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TUser> users = this.userMapper.findAllUsers(seach);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("users", users);
            datas.put("count", users.size());
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 添加客户个人信息.
     *
     * @param user
     * @param errors
     * @return
     */
    @PostMapping("/add")
    public Object add(@Valid TUser user, BindingResult errors) {
        log.info("添加客户个人基本信息接口  uri=user/add  参数列表：{'user':{}}", new Object[]{user});
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
        try {
            user.setCreate_time(DateUtil.getTime());
            this.userMapper.insert(user);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("添加成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 删除用户个人信息
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Object delete_by_id(Integer id) {
        log.info("删除客户个人信息接口  uri = user/delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        if (id == null) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("id不能为空");
            return resultVo;
        }
        try {
            // 删除客户个人信息 及 用车 等信息
            this.userMapper.deleteById(id);
            Map<String, Object> params = new HashMap<>();
            params.put("user_id", id);
            this.userArchivesMapper.deleteByMap(params);
            this.userCarMapper.deleteByMap(params);
            this.userEatMapper.deleteByMap(params);
            this.userHouseMapper.deleteByMap(params);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用车信息添加.
     *
     * @param userCar
     * @return
     */
    @PostMapping("/car_add")
    public Object car_add(@Valid TUserCar userCar, @Valid TRemark remark, BindingResult errors) {
        log.info("个人用车信息添加  uri= user/car_add  参数列表：{'userCar':{}}", new Object[]{userCar});
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
        try {
            String uuid = UUID.randomUUID().toString();
            remark.setCreate_time(DateUtil.getTime());
            remark.setUuid(uuid);
            this.remarkMapper.insert(remark);
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> remarks = this.remarkMapper.selectByMap(params);
            String remarkid = "";
            for (TRemark tRemark : remarks) {
                remarkid = remarkid + tRemark.getId() + ",";
            }
            userCar.setCreate_time(DateUtil.getTime());
            userCar.setS_status(0);
            userCar.setCar_remark(remarkid);
            this.userCarMapper.insert(userCar);
            resultVo.setMsg("添加成功");
            resultVo.setCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用餐添加
     *
     * @param userEat
     * @param remark
     * @param errors
     * @return
     */
    @PostMapping("/eat_add")
    public Object eat_add(@Valid TUserEat userEat, @Valid TRemark remark, BindingResult errors) {
        log.info("个人用餐信息添加  uri= user/eat_add  参数列表：{'userEat':{}}", new Object[]{userEat});
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
        try {
            String uuid = UUID.randomUUID().toString();
            remark.setCreate_time(DateUtil.getTime());
            remark.setUuid(uuid);
            this.remarkMapper.insert(remark);
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> remarks = this.remarkMapper.selectByMap(params);
            String remarkid = "";
            for (TRemark tRemark : remarks) {
                remarkid = remarkid + tRemark.getId() + ",";
            }
            userEat.setCreate_time(DateUtil.getTime());
            userEat.setS_status(0);
            userEat.setEat_remark(remarkid);
            this.userEatMapper.insert(userEat);
            resultVo.setMsg("添加成功");
            resultVo.setCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 住房添加
     *
     * @param userHouse
     * @param remark
     * @param errors
     * @return
     */
    @PostMapping("/house_add")
    public Object house_add(@Valid TUserHouse userHouse, @Valid TRemark remark, @Valid THouse house, BindingResult errors) {
        log.info("个人用餐信息添加  uri= user/house_add  参数列表：{'userHouse':{}}", new Object[]{userHouse});
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
        try {
            //备注
            String uuid = UUID.randomUUID().toString();
            remark.setCreate_time(DateUtil.getTime());
            remark.setUuid(uuid);
            this.remarkMapper.insert(remark);
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> remarks = this.remarkMapper.selectByMap(params);
            String remarkid = "";
            for (TRemark tRemark : remarks) {
                remarkid = remarkid + tRemark.getId() + ",";
            }
            //住房
            house.setCreate_time(DateUtil.getTime());
            house.setUuid(uuid);
            this.houseMapper.insert(house);
            List<THouse> houses = this.houseMapper.selectByMap(params);
            String houseid = "";
            for (THouse tHouse : houses) {
                houseid = houseid + tHouse.getId() + ",";
            }
            //补充信息
            userHouse.setCreate_time(DateUtil.getTime());
            userHouse.setS_status(0);
            userHouse.setHouse_remark(remarkid);
            userHouse.setHouse_id(houseid);
            this.userHouseMapper.insert(userHouse);
            resultVo.setMsg("添加成功");
            resultVo.setCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 个人档案添加.
     *
     * @param userArchives
     * @param remark
     * @param errors
     * @return
     */
    @PostMapping("/archives_add")
    public Object archives_add(@Valid TUserArchives userArchives, @Valid TRemark remark, BindingResult errors) {
        log.info("个人档案信息添加  uri= user/archives_add  参数列表：{'userArchives':{}}", new Object[]{userArchives});
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
        try {
            String uuid = UUID.randomUUID().toString();
            remark.setCreate_time(DateUtil.getTime());
            remark.setUuid(uuid);
            this.remarkMapper.insert(remark);
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> remarks = this.remarkMapper.selectByMap(params);
            String remarkid = "";
            for (TRemark tRemark : remarks) {
                remarkid = remarkid + tRemark.getId() + ",";
            }
            userArchives.setCreate_time(DateUtil.getTime());
            userArchives.setArchives_remark(remarkid);
            userArchives.setS_status(0);
            this.userArchivesMapper.insert(userArchives);
            resultVo.setMsg("添加成功");
            resultVo.setCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 住房列表
     *
     * @param status
     * @param seach
     * @return
     */
    @GetMapping("/house_list")
    public Object house_list(Integer status, String seach, Integer end) {
        log.info("个人住房信息列表  uri=user/house_list  参数列表：{'status':{},'seach':{}}", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TUserHouse> houses = this.userHouseMapper.findAllUsersHouse(status, seach, end);
            for (TUserHouse house : houses) {
                Integer uid = house.getUser_id();
                house.setUserName(this.userMapper.selectById(uid).getName());
            }
            resultVo.setMsg("查询成功");
            resultVo.setCode(ResponseCode.SUCCESS);
            Map<String, Object> datas = new HashMap<>();
            datas.put("houses", houses);
            datas.put("count", houses.size());
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用车列表
     *
     * @param status
     * @param seach
     * @return
     */
    @GetMapping("/car_list")
    public Object car_list(Integer status, String seach, Integer end) {
        log.info("个人用车信息列表  uri=user/car_list  参数列表：{'status':{},'seach':{}}", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TUserCar> cars = this.userCarMapper.findAllUsersCar(status, seach, end);
            for (TUserCar car : cars) {
                Integer uid = car.getUser_id();
                car.setUserName(this.userMapper.selectById(uid).getName());
            }
            resultVo.setMsg("查询成功");
            resultVo.setCode(ResponseCode.SUCCESS);
            Map<String, Object> datas = new HashMap<>();
            datas.put("cars", cars);
            datas.put("count", cars.size());
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用餐列表
     *
     * @param status
     * @param seach
     * @return
     */
    @GetMapping("/eat_list")
    public Object eat_list(Integer status, String seach, Integer end) {
        log.info("个人用餐信息列表  uri=user/eat_list  参数列表：{'status':{},'seach':{}}", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TUserEat> eats = this.userEatMapper.findAllUsersEat(status, seach, end);
            for (TUserEat eat : eats) {
                Integer uid = eat.getUser_id();
                eat.setUserName(this.userMapper.selectById(uid).getName());
            }
            resultVo.setMsg("查询成功");
            resultVo.setCode(ResponseCode.SUCCESS);
            Map<String, Object> datas = new HashMap<>();
            datas.put("eats", eats);
            datas.put("count", eats.size());
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 档案列表
     *
     * @return
     */
    @GetMapping("/archives_list")
    public Object archives_list(Integer status, String seach) {
        log.info("档案列表  uri=user/archives_list 参数列表：{'status':{},'seach':{}} ", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TUserArchives> archives = this.userArchivesMapper.findAllTUserArchives(status, seach);
            for (TUserArchives archive : archives) {
                Integer uid = archive.getUser_id();
                archive.setUserName(this.userMapper.selectById(uid).getName());
            }
            resultVo.setMsg("查询成功");
            resultVo.setCode(ResponseCode.SUCCESS);
            Map<String, Object> datas = new HashMap<>();
            datas.put("archives", archives);
            datas.put("count", archives.size());
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 住房详情
     *
     * @param id
     * @return
     */
    @GetMapping("/house_detail")
    public Object house_detail(Integer id) {
        log.info("住房详情  uri=user/house_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TUserHouse userHouse = this.userHouseMapper.selectById(id);
            //用户姓名
            userHouse.setUserName(this.userMapper.selectById(userHouse.getUser_id()).getName());
            //档案备注
            String rid = userHouse.getHouse_remark();
            if (rid != null && !rid.equals("")) {
                String[] rids = rid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                userHouse.setRemarks(this.remarkMapper.selectBatchIds(ids));
            }
            //住房信息
            String house_id = userHouse.getHouse_id();
            if (house_id != null && !house_id.equals("")) {
                String[] hidArr = house_id.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : hidArr) {
                    ids.add(Integer.valueOf(str));
                }
                List<THouse> houses = this.houseMapper.selectBatchIds(ids);
                userHouse.setHouses(houses);
            }
            //审核备注
            String sid = userHouse.getS_remark();
            if (sid != null && !sid.equals("")) {
                String[] sids = sid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                userHouse.setSremarks(this.remarkMapper.selectBatchIds(ids));
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("house", userHouse);
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用车详情
     *
     * @param id
     * @return
     */
    @GetMapping("/car_detail")
    public Object car_detail(Integer id) {
        log.info("用车详情  uri=user/car_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TUserCar car = this.userCarMapper.selectById(id);
            //用户姓名
            car.setUserName(this.userMapper.selectById(car.getUser_id()).getName());
            //用车备注
            String rid = car.getCar_remark();
            if (rid != null && !rid.equals("")) {
                String[] rids = rid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                car.setRemarks(this.remarkMapper.selectBatchIds(ids));
            }
            //审核备注
            String sid = car.getS_remark();
            if (sid != null && !sid.equals("")) {
                String[] sids = sid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                car.setSremarks(this.remarkMapper.selectBatchIds(ids));
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("car", car);
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用餐详情
     *
     * @param id
     * @return
     */
    @GetMapping("/eat_detail")
    public Object eat_detail(Integer id) {
        log.info("用餐详情  uri=user/eat_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TUserEat eat = this.userEatMapper.selectById(id);
            //用户姓名
            eat.setUserName(this.userMapper.selectById(eat.getUser_id()).getName());
            // 用餐备注
            String rid = eat.getEat_remark();
            if (rid != null && !rid.equals("")) {
                String[] rids = rid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                eat.setRemarks(this.remarkMapper.selectBatchIds(ids));
            }
            //审核备注
            String sid = eat.getS_remark();
            if (sid != null && !sid.equals("")) {
                String[] sids = sid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                eat.setSremarks(this.remarkMapper.selectBatchIds(ids));
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("eat", eat);
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 档案详情
     *
     * @param id
     * @return
     */
    @GetMapping("/archives_detail")
    public Object archives_detail(Integer id) {
        log.info("用餐详情  uri=user/archives_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TUserArchives archives = this.userArchivesMapper.selectById(id);
            //用户姓名
            archives.setUserName(this.userMapper.selectById(archives.getUser_id()).getName());
            // 档案备注
            String rid = archives.getArchives_remark();
            if (rid != null && !rid.equals("")) {
                String[] rids = rid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                archives.setRemarks(this.remarkMapper.selectBatchIds(ids));
            }
            //审核备注
            String sid = archives.getS_remark();
            if (sid != null && !sid.equals("")) {
                String[] sids = sid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                archives.setSremarks(this.remarkMapper.selectBatchIds(ids));
            }
            // 照片
            String photo_id = archives.getPhone_file();
            if (photo_id != null && !photo_id.equals("")) {
                String[] photo_ids = photo_id.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : photo_ids) {
                    ids.add(Integer.valueOf(str));
                }
                archives.setPfiles(this.fileMapper.selectBatchIds(ids));
            }
            // 文档材料
            String spec_id = archives.getSpeech_file();
            if (spec_id != null && !spec_id.equals("")) {
                String[] spec_ids = spec_id.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : spec_ids) {
                    ids.add(Integer.valueOf(str));
                }
                archives.setSfiles(this.fileMapper.selectBatchIds(ids));
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("archives", archives);
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 档案删除
     *
     * @param id
     * @return
     */
    @GetMapping("/archives_delete")
    public Object archives_delete(Integer id) {
        log.info("档案删除  uri=user/archives_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TUserArchives archives = this.userArchivesMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            // 删除
            this.userArchivesMapper.deleteById(id);
            //备注
            String rid = archives.getArchives_remark();
            if (rid != null) {
                String[] rids = rid.split(",");
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            //审核备注
            String sid = archives.getS_remark();
            if (sid != null) {
                ids.clear();
                String[] sids = sid.split(",");
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 住房删除
     *
     * @param id
     * @return
     */
    @GetMapping("/house_delete")
    public Object house_delete(Integer id) {
        log.info("住房删除  uri=user/house_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TUserHouse house = this.userHouseMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            this.userHouseMapper.deleteById(id);
            //备注
            String rid = house.getHouse_remark();
            if (rid != null) {
                String[] rids = rid.split(",");
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            //审核备注
            String sid = house.getS_remark();
            if (sid != null) {
                ids.clear();
                String[] sids = sid.split(",");
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用餐删除
     *
     * @param id
     * @return
     */
    @GetMapping("/eat_delete")
    public Object eat_delete(Integer id) {
        log.info("用餐删除  uri=user/eat_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TUserEat eat = this.userEatMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            this.userEatMapper.deleteById(id);
            //备注
            String rid = eat.getEat_remark();
            if (rid != null) {
                String[] rids = rid.split(",");
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            //审核备注
            String sid = eat.getS_remark();
            if (sid != null) {
                ids.clear();
                String[] sids = sid.split(",");
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用车删除
     *
     * @param id
     * @return
     */
    @GetMapping("/car_delete")
    public Object car_delete(Integer id) {
        log.info("用车删除  uri=user/car_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TUserCar car = this.userCarMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            this.userCarMapper.deleteById(id);
            //备注
            String rid = car.getCar_remark();
            if (rid != null) {
                String[] rids = rid.split(",");
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            //审核备注
            String sid = car.getS_remark();
            if (sid != null) {
                ids.clear();
                String[] sids = sid.split(",");
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 个人审核
     *
     * @param remarks
     * @param type    0：用车审核   1：用餐审核  2：住房审核   3：档案审核
     * @param status  审核状态  1：通过  2：退回
     * @param id      数据表id
     * @return
     */
    @PostMapping("/examie")
    public Object examie(String remarks, Integer type, Integer status, Integer id) {
        log.info("审核接口 uri=user/examie 参数列表：{'remarks':{},'type':{},'status':{}}", new Object[]{remarks, type, status});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "审核失败");
        if (remarks == null || remarks.equals("") || type == null || status == null) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("参数不能为空");
            return resultVo;
        }
        //备注  去除 [ ]
        remarks = remarks.substring(1, remarks.length() - 1) + ",";
        String[] remarksArr = remarks.split("},");
        String uuid = UUID.randomUUID().toString();
        try {
            // 解析remark 并插进数据库
            for (String remarkStr : remarksArr) {
                remarkStr = remarkStr + "}";
                TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                remark.setUuid(uuid);
                this.remarkMapper.insert(remark);
            }
            // 获取remarkid
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> rs = this.remarkMapper.selectByMap(params);
            String rid = "";
            for (TRemark tRemark : rs) {
                rid = rid + tRemark.getId() + ",";
            }
            //更新remarkid  和审核状态status
            if (type.intValue() == 0) {
                //用车审核
                TUserCar car = this.userCarMapper.selectById(id);
                car.setS_status(status);
                if (car.getS_remark() != null) {
                    car.setS_remark(car.getS_remark() + rid);
                } else {
                    car.setS_remark(rid);
                }
                this.userCarMapper.updateById(car);
            } else if (type.intValue() == 1) {
                //用餐审核
                TUserEat eat = this.userEatMapper.selectById(id);
                eat.setS_status(status);
                if (eat.getS_remark() != null) {
                    eat.setS_remark(eat.getS_remark() + rid);
                } else {
                    eat.setS_remark(rid);
                }
                this.userEatMapper.updateById(eat);
            } else if (type.intValue() == 2) {
                //住房审核
                TUserHouse house = this.userHouseMapper.selectById(id);
                house.setS_status(status);
                if (house.getS_remark() != null) {
                    house.setS_remark(house.getS_remark() + rid);
                } else {
                    house.setS_remark(rid);
                }
                this.userHouseMapper.updateById(house);
            } else if (type.intValue() == 3) {
                //档案审核
                TUserArchives archives = this.userArchivesMapper.selectById(id);
                archives.setS_status(status);
                if (archives.getS_remark() != null) {
                    archives.setS_remark(archives.getS_remark() + rid);
                } else {
                    archives.setS_remark(rid);
                }
                this.userArchivesMapper.updateById(archives);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("审核成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 住房更新.
     *
     * @param userHouse
     * @param s_remarks
     * @param house
     * @return
     */
    @PostMapping("/house_update")
    public Object house_update(TUserHouse userHouse, String s_remarks, THouse house) {
        log.info("住房更新 uri=user/house_update 参数列表：{'userHouse':{},'remark':{},'house':{}}", new Object[]{userHouse, s_remarks, house});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TUserHouse oldUserHouse = this.userHouseMapper.selectById(userHouse.getId());
        // 检查是否是未审核状态，不是不能更改
        Integer status = oldUserHouse.getS_status();
        if (status != 0) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("数据已经被锁定，不能更改");
            return resultVo;
        }
        try {
            String uuid = UUID.randomUUID().toString();
            oldUserHouse.setUpdate_time(DateUtil.getTime());
            Map<String, Object> params = new HashMap<>();
            if(s_remarks != null &&!s_remarks.equals("")){
                //备注  去除 [ ]
                s_remarks = s_remarks.substring(1, s_remarks.length() - 1) + ",";
                String[] remarksArr = s_remarks.split("},");
                // 备注
                // 解析remark 并插进数据库
                for (String remarkStr : remarksArr) {
                    remarkStr = remarkStr + "}";
                    TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                    remark.setUuid(uuid);
                    this.remarkMapper.insert(remark);
                }
                // 获取remarkid
                params.put("uuid", uuid);
                List<TRemark> rs = this.remarkMapper.selectByMap(params);
                String rid = "";
                for (TRemark tRemark : rs) {
                    rid = rid + tRemark.getId() + ",";
                }
                // 查看是否存在旧的备注，存在删除 不存在直接更新
                String oldRemark = oldUserHouse.getHouse_remark();
                if (oldRemark != null) {
                    String[] ors = oldRemark.split(",");
                    Set<Integer> ids = new HashSet<>();
                    for (String str : ors) {
                        ids.add(Integer.valueOf(str));
                    }
                    this.remarkMapper.deleteBatchIds(ids);
                }
                oldUserHouse.setHouse_remark(rid);
            }

            // 住房
            house.setCreate_time(DateUtil.getTime());
            house.setUuid(uuid);
            this.houseMapper.insert(house);
            List<THouse> houses = this.houseMapper.selectByMap(params);
            String houseid = "";
            for (THouse tHouse : houses) {
                houseid = houseid + tHouse.getId() + ",";
            }
            // 查看是否存在住房信息，存在删除在更新  不存在直接更新
            String oldHouseid = oldUserHouse.getHouse_id();
            if (oldHouseid != null) {
                String[] ohs = oldHouseid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ohs) {
                    ids.add(Integer.valueOf(str));
                }
                this.houseMapper.deleteBatchIds(ids);
            }
            oldUserHouse.setHouse_id(houseid);
            //更新信息
            oldUserHouse.setHotel(userHouse.getHotel());
            oldUserHouse.setCheck_in_date(userHouse.getCheck_in_date());
            oldUserHouse.setCheck_out_date(userHouse.getCheck_out_date());
            oldUserHouse.setRoom_type(userHouse.getRoom_type());
            oldUserHouse.setPrice(userHouse.getPrice());
            oldUserHouse.setTotal(userHouse.getTotal());
            oldUserHouse.setTotal_price(userHouse.getTotal_price());
            oldUserHouse.setPay_type(userHouse.getPay_type());
            // 更新
            this.userHouseMapper.updateById(oldUserHouse);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("更新成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用餐更新
     *
     * @param userEat
     * @param s_remarks
     * @return
     */
    @PostMapping("/eat_update")
    public Object eat_update(TUserEat userEat, String s_remarks) {

        log.info("用餐更新 uri = user/eat_update  参数列表：{'userEat':{},'remarks':{}}", new Object[]{userEat, s_remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新事变");
        TUserEat oldUserEat = this.userEatMapper.selectById(userEat.getId());
        Integer status = oldUserEat.getS_status();
        // 判断是否是未审核  ，如果不是  直接返回 无权修改
        if (status != 0) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("数据已经被锁定，不能更改");
            return resultVo;
        }
        try {
            //备注  去除 [ ]
            s_remarks = s_remarks.substring(1, s_remarks.length() - 1) + ",";
            String[] remarksArr = s_remarks.split("},");
            String uuid = UUID.randomUUID().toString();
            // 备注
            // 解析remark 并插进数据库
            for (String remarkStr : remarksArr) {
                remarkStr = remarkStr + "}";
                TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                remark.setUuid(uuid);
                this.remarkMapper.insert(remark);
            }
            // 获取remarkid
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> rs = this.remarkMapper.selectByMap(params);
            String rid = "";
            for (TRemark tRemark : rs) {
                rid = rid + tRemark.getId() + ",";
            }
            // 查看是否存在旧的备注，存在删除 不存在直接更新
            String oldRemark = oldUserEat.getEat_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            // 更新内容
            oldUserEat.setUpdate_time(DateUtil.getTime());
            oldUserEat.setRestaurant(userEat.getRestaurant());
            oldUserEat.setRestaurant_date(userEat.getRestaurant_date());
            oldUserEat.setRestaurant_peoples(userEat.getRestaurant_peoples());
            oldUserEat.setRestaurant_attention(userEat.getRestaurant_attention());
            oldUserEat.setPay_type(userEat.getPay_type());
            oldUserEat.setEat_remark(rid);
            this.userEatMapper.updateById(oldUserEat);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("更新成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用车更新.
     *
     * @param userCar
     * @param s_remarks
     * @return
     */
    @PostMapping("/car_update")
    public Object car_update(TUserCar userCar, String s_remarks) {
        log.info("用车更新 uri = user/car_update  参数列表：{'userEat':{},'remarks':{}}", new Object[]{userCar, s_remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TUserCar oldUserCar = this.userCarMapper.selectById(userCar.getId());
        Integer status = oldUserCar.getS_status();
        // 判断是否是未审核  ，如果不是  直接返回 无权修改
        if (status != 0) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("数据已经被锁定，不能更改");
            return resultVo;
        }
        try {
            //备注  去除 [ ]
            s_remarks = s_remarks.substring(1, s_remarks.length() - 1) + ",";
            String[] remarksArr = s_remarks.split("},");
            String uuid = UUID.randomUUID().toString();
            // 备注
            // 解析remark 并插进数据库
            for (String remarkStr : remarksArr) {
                remarkStr = remarkStr + "}";
                TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                remark.setUuid(uuid);
                this.remarkMapper.insert(remark);
            }
            // 获取remarkid
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> rs = this.remarkMapper.selectByMap(params);
            String rid = "";
            for (TRemark tRemark : rs) {
                rid = rid + tRemark.getId() + ",";
            }
            // 查看是否存在旧的备注，存在删除 不存在直接更新
            String oldRemark = oldUserCar.getCar_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            // 更新内容
            oldUserCar.setUpdate_time(DateUtil.getTime());
            oldUserCar.setAttention(userCar.getAttention());
            oldUserCar.setTraffic_number(userCar.getTraffic_number());
            oldUserCar.setNeed_car_date(userCar.getNeed_car_date());
            oldUserCar.setNeed_car_time(userCar.getNeed_car_time());
            oldUserCar.setRide_place(userCar.getRide_place());
            oldUserCar.setDestination(userCar.getDestination());
            oldUserCar.setRide_peoples(userCar.getRide_peoples());
            oldUserCar.setAccompany_leader(userCar.getAccompany_leader());
            oldUserCar.setPay_type(userCar.getPay_type());
            oldUserCar.setStop_price(userCar.getStop_price());
            oldUserCar.setCar_remark(rid);
            this.userCarMapper.updateById(oldUserCar);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("更新成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 档案更新
     *
     * @param userArchives
     * @param s_remarks
     * @return
     */
    @PostMapping("/archives_update")
    public Object archives_update(TUserArchives userArchives, String s_remarks) {
        log.info("档案更新 uri = user/archives_update  参数列表：{'userEat':{},'remarks':{}}", new Object[]{userArchives, s_remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TUserArchives oldUserArchives = this.userArchivesMapper.selectById(userArchives.getId());
        Integer status = oldUserArchives.getS_status();
        // 判断是否是未审核  ，如果不是  直接返回 无权修改
        if (status != 0) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("数据已经被锁定，不能更改");
            return resultVo;
        }
        try {
            //备注  去除 [ ]
            s_remarks = s_remarks.substring(1, s_remarks.length() - 1) + ",";
            String[] remarksArr = s_remarks.split("},");
            String uuid = UUID.randomUUID().toString();
            // 备注
            // 解析remark 并插进数据库
            for (String remarkStr : remarksArr) {
                remarkStr = remarkStr + "}";
                TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                remark.setUuid(uuid);
                this.remarkMapper.insert(remark);
            }
            // 获取remarkid
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", uuid);
            List<TRemark> rs = this.remarkMapper.selectByMap(params);
            String rid = "";
            for (TRemark tRemark : rs) {
                rid = rid + tRemark.getId() + ",";
            }
            // 查看是否存在旧的备注，存在删除 不存在直接更新
            String oldRemark = oldUserArchives.getArchives_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            // 内容更新
            oldUserArchives.setUpdate_time(DateUtil.getTime());
            oldUserArchives.setActivity(userArchives.getActivity());
            oldUserArchives.setPersonal_synopsis(userArchives.getPersonal_synopsis());
            oldUserArchives.setRole(userArchives.getRole());
            oldUserArchives.setSpeech_topic(userArchives.getSpeech_topic());
            oldUserArchives.setSpeech_file(userArchives.getSpeech_file());
            oldUserArchives.setPhone_file(userArchives.getPhone_file());
            oldUserArchives.setAccount(userArchives.getAccount());
            oldUserArchives.setAccount_blank(userArchives.getAccount_blank());
            oldUserArchives.setAccount_name(userArchives.getAccount_name());
            oldUserArchives.setArchives_remark(rid);
            this.userArchivesMapper.updateById(oldUserArchives);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("更新成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 执行员 结束接口
     *
     * @param type    0:住房  1：用餐   2：用车
     * @param id      主键
     * @param remarks 备注
     * @return
     */
    @PostMapping("/end")
    public Object user_end(Integer type, Integer id, String remarks) {
        log.info("结束接口 uri=user/end 参数列表：{'type':{},'id':{},'remarks':{}}", new Object[]{type, id, remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "操作失败");
        try {
            String rid = "";
            //备注  去除 [ ]
            if (remarks != null && !remarks.equals("")) {
                remarks = remarks.substring(1, remarks.length() - 1) + ",";
                String[] remarksArr = remarks.split("},");
                String uuid = UUID.randomUUID().toString();
                // 备注
                // 解析remark 并插进数据库
                for (String remarkStr : remarksArr) {
                    remarkStr = remarkStr + "}";
                    TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                    remark.setUuid(uuid);
                    this.remarkMapper.insert(remark);
                }
                // 获取remarkid
                Map<String, Object> params = new HashMap<>();
                params.put("uuid", uuid);
                List<TRemark> rs = this.remarkMapper.selectByMap(params);
                for (TRemark tRemark : rs) {
                    rid = rid + tRemark.getId() + ",";
                }
            }
            if (type.intValue() == 0) {
                //住房
                TUserHouse house = this.userHouseMapper.selectById(id);
                //结束
                house.setEnd(1);
                String userR = house.getHouse_remark();
                if (userR != null) {
                    house.setHouse_remark(house.getHouse_remark() + rid);
                } else {
                    house.setHouse_remark(rid);
                }
                this.userHouseMapper.updateById(house);
            } else if (type.intValue() == 1) {
                //用餐
                TUserEat eat = this.userEatMapper.selectById(id);
                //结束
                eat.setEnd(1);
                String userR = eat.getEat_remark();
                if (userR != null) {
                    eat.setEat_remark(eat.getEat_remark() + rid);
                } else {
                    eat.setEat_remark(rid);
                }
                this.userEatMapper.updateById(eat);
            } else if (type.intValue() == 2) {
                //用车
                TUserCar car = this.userCarMapper.selectById(id);
                //结束
                car.setEnd(1);
                String userR = car.getCar_remark();
                if (userR != null) {
                    car.setCar_remark(car.getCar_remark() + rid);
                } else {
                    car.setCar_remark(rid);
                }
                this.userCarMapper.updateById(car);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("操作成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 操作员安排接口
     *
     * @param type    0:住房  1：用餐   2：用车
     * @param id
     * @param remarks
     * @return
     */
    @PostMapping("/arrange")
    public Object user_arrange(Integer type, Integer id, String remarks) {
        log.info("结束接口 uri=user/arrange 参数列表：{'type':{},'id':{},'remarks':{}}", new Object[]{type, id, remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "操作失败");
        try {
            String rid = "";
            //备注  去除 [ ]
            if (remarks != null && !remarks.equals("")) {
                remarks = remarks.substring(1, remarks.length() - 1) + ",";
                String[] remarksArr = remarks.split("},");
                String uuid = UUID.randomUUID().toString();
                // 备注
                // 解析remark 并插进数据库
                for (String remarkStr : remarksArr) {
                    remarkStr = remarkStr + "}";
                    TRemark remark = (TRemark) JsonUtil.JSONToObj(remarkStr, TRemark.class);
                    remark.setUuid(uuid);
                    this.remarkMapper.insert(remark);
                }
                // 获取remarkid
                Map<String, Object> params = new HashMap<>();
                params.put("uuid", uuid);
                List<TRemark> rs = this.remarkMapper.selectByMap(params);
                for (TRemark tRemark : rs) {
                    rid = rid + tRemark.getId() + ",";
                }
            }
            if (type.intValue() == 0) {
                //住房
                TUserHouse house = this.userHouseMapper.selectById(id);
                String userR = house.getHouse_remark();
                if (userR != null) {
                    house.setHouse_remark(house.getHouse_remark() + rid);
                } else {
                    house.setHouse_remark(rid);
                }
                this.userHouseMapper.updateById(house);
            } else if (type.intValue() == 1) {
                //用餐
                TUserEat eat = this.userEatMapper.selectById(id);
                //结束
                String userR = eat.getEat_remark();
                if (userR != null) {
                    eat.setEat_remark(eat.getEat_remark() + rid);
                } else {
                    eat.setEat_remark(rid);
                }
                this.userEatMapper.updateById(eat);
            } else if (type.intValue() == 2) {
                //用车
                TUserCar car = this.userCarMapper.selectById(id);
                //结束
                String userR = car.getCar_remark();
                if (userR != null) {
                    car.setCar_remark(car.getCar_remark() + rid);
                } else {
                    car.setCar_remark(rid);
                }
                this.userCarMapper.updateById(car);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("操作成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 导出
     *
     * @param type 0：个人信息  1：个人用车   2：个人用餐   3：个人住房  4：个人档案
     * @param ids  选中的ids
     * @return
     */
    @GetMapping("/export")
    public Object user_export(Integer type, String ids, HttpServletResponse response) {
        log.info("导出  uri=user/deport  参数列表：{'type':{},'ids':{}}", new Object[]{type, ids});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "导出失败，无资源");
        if (type == null || ids == null || ids.equals("")) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("type，ids不能为空");
            return resultVo;
        }
        Set<Integer> allId = new HashSet<>();
        if (type.intValue() == 0) {
            // 个人信息
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TUser> users = this.userMapper.selectBatchIds(allId);
            if (users != null) {
                for (TUser user : users) {
                    //性别
                    int sex = user.getSex();
                    if (sex == 0) {
                        user.setSexName("女");
                    } else if (sex == 1) {
                        user.setSexName("男");
                    } else {
                        user.setSexName("未填");
                    }
                    //是否需要跟随人员
                    int follow = user.getFollow();
                    if (follow == 0) {
                        user.setFollow_name("不需要");
                    } else if (follow == 1) {
                        user.setFollow_name("需要");
                    } else {
                        user.setFollow_name("未填");
                    }
                    //证件类型 （0：身份证   1：护照   2：港粤通行证）
                    int cer = user.getCertificates();
                    if (cer == 0) {
                        user.setCertificatesName("身份证");
                    } else if (cer == 1) {
                        user.setCertificatesName("护照");
                    } else if (cer == 2) {
                        user.setCertificatesName("港粤通行证");
                    } else {
                        user.setCertificatesName("未填");
                    }
                    //是否需要陪同
                    int acc = user.getAccompany();
                    if (acc == 0) {
                        user.setAccompanyName("不需要");
                    } else if (acc == 1) {
                        user.setAccompanyName("需要");
                    }
                    //是否需要翻译
                    int tran = user.getTranslate();
                    if (tran == 0) {
                        user.setTranslateName("不需要");
                    } else if (tran == 1) {
                        user.setTranslateName("需要");
                    }
                }
                ExcelUtils.writeExcel(response, users, TUser.class, "客户个人信息表");
            }
        } else if (type.intValue() == 1) {
            //用车
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TUserCar> cars = this.userCarMapper.selectBatchIds(allId);
            if (cars != null) {
                for (TUserCar tUserCar : cars) {
                    // 用户姓名
                    String name = this.userMapper.selectById(tUserCar.getUser_id()).getName();
                    tUserCar.setUserName(name);
                }
                ExcelUtils.writeExcel(response, cars, TUserCar.class, "客户个人用车信息表");
            }
        } else if (type.intValue() == 2) {
            // 用餐
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TUserEat> eats = this.userEatMapper.selectBatchIds(allId);
            if (eats != null) {
                for (TUserEat userEat : eats) {
                    // 用户姓名
                    String name = this.userMapper.selectById(userEat.getUser_id()).getName();
                    userEat.setUserName(name);
                }
                ExcelUtils.writeExcel(response, eats, TUserEat.class, "客户个人用餐信息表");
            }
        } else if (type.intValue() == 4) {
            //档案
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TUserArchives> archivers = this.userArchivesMapper.selectBatchIds(allId);
            if (archivers != null) {
                for (TUserArchives userArchives : archivers) {
                    // 用户姓名
                    String name = this.userMapper.selectById(userArchives.getUser_id()).getName();
                    userArchives.setUserName(name);
                    // 审核状态（int   0：未审核   1：已审核   2：未审核）
                    int status = userArchives.getS_status();
                    if (status == 0) {
                        userArchives.setStatusName("未审核");
                    } else if (status == 1) {
                        userArchives.setStatusName("已通过");
                    } else if (status == 2) {
                        userArchives.setStatusName("未通过");
                    }

                }
                ExcelUtils.writeExcel(response, archivers, TUserArchives.class, "客户个人档案信息表");
            }
        } else if (type.intValue() == 3) {
            //用房
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TUserHouse> houses = this.userHouseMapper.selectBatchIds(allId);
            if (houses != null) {
                for (TUserHouse house : houses) {
                    // 用户姓名
                    String name = this.userMapper.selectById(house.getUser_id()).getName();
                    house.setUserName(name);
                }
                ExcelUtils.writeExcel(response, houses, TUserHouse.class, "客户个人住房信息表");
            }
        }
        return resultVo;
    }

    /**
     * 导入.
     *
     * @param file
     * @return
     */
    @PostMapping("/include")
    public Object user_include(MultipartFile file) {
        log.info("导入 uri=user/inlucde");
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "导入失败");
        List<PersonExcelInClude> usersExcel = ExcelUtils.readExcel("", PersonExcelInClude.class, file);
        try {
            for (PersonExcelInClude personExcelInClude : usersExcel) {
                TUser user = new TUser();
                user.setCreate_time(DateUtil.getTime());
                user.setName(personExcelInClude.getName());
                user.setSex(personExcelInClude.getSex());
                user.setCompany(personExcelInClude.getCompany());
                user.setJob(personExcelInClude.getJob());
                user.setPhone(personExcelInClude.getPhone());
                user.setEmail(personExcelInClude.getEmail());
                user.setFollow(personExcelInClude.getFollow());
                user.setFollow_name(personExcelInClude.getFollow_name());
                user.setPick_up_user(personExcelInClude.getPick_up_user());
                user.setCertificates(personExcelInClude.getCertificates());
                user.setAccompany(personExcelInClude.getAccompany());
                user.setTranslate(personExcelInClude.getTranslate());
                System.out.println(user);
                this.userMapper.insert(user);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("导入成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }
}
