package com.stylefeng.guns.rest.modular.rest.controller;

import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.modular.rest.common.ResponseCode;
import com.stylefeng.guns.rest.modular.rest.common.ResultVo;
import com.stylefeng.guns.rest.modular.rest.dao.*;
import com.stylefeng.guns.rest.modular.rest.excel.ExcelUtils;
import com.stylefeng.guns.rest.modular.rest.excel.TeamExcelInclude;
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
 * <p>团队信息控制层</p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/15
 */
@RestController
@RequestMapping("/team")
public class TTeamController {

    private static final Logger log = LoggerFactory.getLogger(TTeamController.class);
    @Autowired
    private TTeamMapper teamMapper;
    @Autowired
    private TTeamArchivesMapper teamArchivesMapper;
    @Autowired
    private TTeamHouseMapper teamHouseMapper;
    @Autowired
    private TTeamEatMapper teamEatMapper;
    @Autowired
    private TTeamCarMapper teamCarMapper;
    @Autowired
    private TRemarkMapper remarkMapper;
    @Autowired
    private THouseMapper houseMapper;
    @Autowired
    private TFileMapper fileMapper;

    /**
     * 获取团队信息列表
     *
     * @param seach
     * @return
     */
    @GetMapping("/list")
    public Object list(String seach) {
        log.info("客户团体信息列表接口  uri=team/list  参数列表：{'seach':{}}", new Object[]{seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TTeam> teams = this.teamMapper.findAllTeams(seach);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("teams", teams);
            datas.put("count", teams.size());
            resultVo.setDatas(datas);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 添加信息.
     *
     * @param team
     * @param errors
     * @return
     */
    @PostMapping("/add")
    public Object add(@Valid TTeam team, BindingResult errors) {
        log.info("团队添加基础信息接口  uri=team/add 参数列表：{'team':{}}", new Object[]{team});
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
            team.setCreate_time(DateUtil.getTime());
            this.teamMapper.insert(team);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("添加成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 删除接口
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Object delete(Integer id) {
        log.info("团体信息删除接口  uri=team/delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        if (id == null) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("id不能为空");
            return resultVo;
        }
        try {
            this.teamMapper.deleteById(id);
            Map<String, Object> params = new HashMap<>();
            params.put("team_id", id);
            this.teamArchivesMapper.deleteByMap(params);
            this.teamCarMapper.deleteByMap(params);
            this.teamEatMapper.deleteByMap(params);
            this.teamHouseMapper.deleteByMap(params);
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("删除成功");
            return resultVo;
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

    /**
     * 用车信息添加.
     *
     * @param teamCar
     * @return
     */
    @PostMapping("/car_add")
    public Object car_add(@Valid TTeamCar teamCar, @Valid TRemark remark, BindingResult errors) {
        log.info("个人用车信息添加  uri= team/car_add  参数列表：{'userCar':{}}", new Object[]{teamCar});
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
            teamCar.setCreate_time(DateUtil.getTime());
            teamCar.setS_status(0);
            teamCar.setCar_remark(remarkid);
            this.teamCarMapper.insert(teamCar);
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
     * @param teamEat
     * @param remark
     * @param errors
     * @return
     */
    @PostMapping("/eat_add")
    public Object eat_add(@Valid TTeamEat teamEat, @Valid TRemark remark, BindingResult errors) {
        log.info("个人用餐信息添加  uri= team/eat_add  参数列表：{'teamEat':{}}", new Object[]{teamEat});
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
            teamEat.setCreate_time(DateUtil.getTime());
            teamEat.setS_status(0);
            teamEat.setEat_remark(remarkid);
            this.teamEatMapper.insert(teamEat);
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
     * @param teamHouse
     * @param remark
     * @param errors
     * @return
     */
    @PostMapping("/house_add")
    public Object house_add(@Valid TTeamHouse teamHouse, @Valid TRemark remark, @Valid THouse house, BindingResult errors) {
        log.info("个人用餐信息添加  uri= team/house_add  参数列表：{'teamHouse':{}}", new Object[]{teamHouse});
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
            teamHouse.setCreate_time(DateUtil.getTime());
            teamHouse.setS_status(0);
            teamHouse.setHouse_remark(remarkid);
            teamHouse.setHouse_id(houseid);
            this.teamHouseMapper.insert(teamHouse);
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
     * @param teamArchives
     * @param remark
     * @param errors
     * @return
     */
    @PostMapping("/archives_add")
    public Object archives_add(@Valid TTeamArchives teamArchives, @Valid TRemark remark, BindingResult errors) {
        log.info("个人档案信息添加  uri= team/archives_add  参数列表：{'teamArchives':{}}", new Object[]{teamArchives});
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
            teamArchives.setCreate_time(DateUtil.getTime());
            teamArchives.setArchives_remark(remarkid);
            teamArchives.setS_status(0);
            this.teamArchivesMapper.insert(teamArchives);
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
        log.info("团队住房信息列表  uri=team/house_list  参数列表：{'status':{},'seach':{},'end':{}}", new Object[]{status, seach, end});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TTeamHouse> houses = this.teamHouseMapper.findAllTeamHouse(status, seach, end);
            for (TTeamHouse house : houses) {
                Integer uid = house.getTeam_id();
                house.setTeamName(this.teamMapper.selectById(uid).getCompany());
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
        log.info("团体用车信息列表  uri=team/car_list  参数列表：{'status':{},'seach':{}}", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TTeamCar> cars = this.teamCarMapper.findAllTeamCar(status, seach, end);
            for (TTeamCar car : cars) {
                Integer uid = car.getTeam_id();
                car.setTeamName(this.teamMapper.selectById(uid).getCompany());
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
        log.info("团体用餐信息列表  uri=team/eat_list  参数列表：{'status':{},'seach':{}}", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TTeamEat> eats = this.teamEatMapper.findAllTeamEat(status, seach, end);
            for (TTeamEat eat : eats) {
                Integer uid = eat.getTeam_id();
                eat.setTeamName(this.teamMapper.selectById(uid).getCompany());
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
        log.info("档案信息列表  uri=team/archives_list  参数列表：{'status':{},'seach':{}} ", new Object[]{status, seach});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            List<TTeamArchives> archives = this.teamArchivesMapper.findAllTTeamArchives(status, seach);
            for (TTeamArchives archive : archives) {
                Integer uid = archive.getTeam_id();
                archive.setTeamName(this.teamMapper.selectById(uid).getCompany());
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
        log.info("住房详情  uri=team/house_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TTeamHouse house = this.teamHouseMapper.selectById(id);
            // 公司名称
            house.setTeamName(this.teamMapper.selectById(house.getTeam_id()).getCompany());
            // 住房备注
            String rid = house.getHouse_remark();
            if (rid != null && !rid.equals("")) {
                String[] rids = rid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : rids) {
                    ids.add(Integer.valueOf(str));
                }
                house.setRemarks(this.remarkMapper.selectBatchIds(ids));
            }
            //住房信息
            String house_id = house.getHouse_id();
            if (house_id != null && !house_id.equals("")) {
                String[] hidArr = house_id.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : hidArr) {
                    ids.add(Integer.valueOf(str));
                }
                List<THouse> houses = this.houseMapper.selectBatchIds(ids);
                house.setHouses(houses);
            }
            //审核备注
            String sid = house.getS_remark();
            if (sid != null && !sid.equals("")) {
                String[] sids = sid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : sids) {
                    ids.add(Integer.valueOf(str));
                }
                house.setSremarks(this.remarkMapper.selectBatchIds(ids));
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("查询成功");
            Map<String, Object> datas = new HashMap<>();
            datas.put("house", house);
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
        log.info("用车详情  uri=team/car_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TTeamCar car = this.teamCarMapper.selectById(id);
            // 公司名称
            car.setTeamName(this.teamMapper.selectById(car.getTeam_id()).getCompany());
            // 住房备注
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
        log.info("用餐详情  uri=team/eat_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TTeamEat eat = this.teamEatMapper.selectById(id);
            // 公司名称
            eat.setTeamName(this.teamMapper.selectById(eat.getTeam_id()).getCompany());
            // 住房备注
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
        log.info("档案详情  uri=team/archives_detail  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "查询失败");
        try {
            TTeamArchives archives = this.teamArchivesMapper.selectById(id);
            // 公司名称
            archives.setTeamName(this.teamMapper.selectById(archives.getTeam_id()).getCompany());
            // 住房备注
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
        log.info("档案删除  uri=team/archives_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TTeamArchives archives = this.teamArchivesMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            this.teamArchivesMapper.deleteById(id);
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
        log.info("住房删除  uri=team/house_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TTeamHouse house = this.teamHouseMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            this.teamHouseMapper.deleteById(id);
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
        log.info("用餐删除  uri=team/eat_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TTeamEat eat = this.teamEatMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();
            this.teamEatMapper.deleteById(id);
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
        log.info("用车删除  uri=team/car_delete  参数列表：{'id':{}}", new Object[]{id});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "删除失败");
        try {
            TTeamCar car = this.teamCarMapper.selectById(id);
            Set<Integer> ids = new HashSet<>();

            this.teamCarMapper.deleteById(id);
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
     * 团体审核
     *
     * @param remarks
     * @param type    0：用车审核   1：用餐审核  2：住房审核   3：档案审核
     * @param status  审核状态  1：通过  2：退回
     * @param id      数据表id
     * @return
     */
    @PostMapping("/examie")
    public Object examie(String remarks, Integer type, Integer status, Integer id) {
        log.info("审核接口 uri=team/examie 参数列表：{'remarks':{},'type':{},'status':{}}", new Object[]{remarks, type, status});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "审核失败");
        if (remarks == null || remarks.equals("") || type == null || status == null) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("参数不能为空");
            return resultVo;
        }
        //去除 [ ]
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
                TTeamCar car = this.teamCarMapper.selectById(id);
                car.setS_status(status);
                if (car.getS_remark() != null) {
                    car.setS_remark(car.getS_remark() + rid);
                } else {
                    car.setS_remark(rid);
                }
                this.teamCarMapper.updateById(car);
            } else if (type.intValue() == 1) {
                //用餐审核
                TTeamEat eat = this.teamEatMapper.selectById(id);
                eat.setS_status(status);
                if (eat.getS_remark() != null) {
                    eat.setS_remark(eat.getS_remark() + rid);
                } else {
                    eat.setS_remark(rid);
                }
                this.teamEatMapper.updateById(eat);
            } else if (type.intValue() == 2) {
                //住房审核
                TTeamHouse house = this.teamHouseMapper.selectById(id);
                house.setS_status(status);
                if (house.getS_remark() != null) {
                    house.setS_remark(house.getS_remark() + rid);
                } else {
                    house.setS_remark(rid);
                }
                this.teamHouseMapper.updateById(house);
            } else if (type.intValue() == 3) {
                //档案审核
                TTeamArchives archives = this.teamArchivesMapper.selectById(id);
                archives.setS_status(status);
                if (archives.getS_remark() != null) {
                    archives.setS_remark(archives.getS_remark() + rid);
                } else {
                    archives.setS_remark(rid);
                }
                this.teamArchivesMapper.updateById(archives);
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
     * @param teamHouse
     * @param s_remarks
     * @param house
     * @return
     */
    @PostMapping("/house_update")
    public Object house_update(TTeamHouse teamHouse, String s_remarks, THouse house) {
        log.info("住房更新 uri=team/house_update 参数列表：{'userHouse':{},'remark':{},'house':{}}", new Object[]{teamHouse, s_remarks, house});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TTeamHouse oldTeamHouse = this.teamHouseMapper.selectById(teamHouse.getId());
        // 检查是否是未审核状态，不是不能更改
        Integer status = oldTeamHouse.getS_status();
        if (status != 0) {
            resultVo.setCode(ResponseCode.PARAMS_ERROR);
            resultVo.setMsg("数据已经被锁定，不能更改");
            return resultVo;
        }
        try {
            oldTeamHouse.setUpdate_time(DateUtil.getTime());
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
            String oldRemark = oldTeamHouse.getHouse_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            oldTeamHouse.setHouse_remark(rid);
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
            String oldHouseid = oldTeamHouse.getHouse_id();
            if (oldHouseid != null) {
                String[] ohs = oldHouseid.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ohs) {
                    ids.add(Integer.valueOf(str));
                }
                this.houseMapper.deleteBatchIds(ids);
            }
            oldTeamHouse.setHouse_id(houseid);
            //更新信息
            oldTeamHouse.setHotel(teamHouse.getHotel());
            oldTeamHouse.setCheck_in_date(teamHouse.getCheck_in_date());
            oldTeamHouse.setCheck_out_date(teamHouse.getCheck_out_date());
            oldTeamHouse.setRoom_type(teamHouse.getRoom_type());
            oldTeamHouse.setPrice(teamHouse.getPrice());
            oldTeamHouse.setTotal(teamHouse.getTotal());
            oldTeamHouse.setTotal_price(teamHouse.getTotal_price());
            oldTeamHouse.setPay_type(teamHouse.getPay_type());
            // 更新
            this.teamHouseMapper.updateById(oldTeamHouse);
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
     * @param teamEat
     * @param s_remarks
     * @return
     */
    @PostMapping("/eat_update")
    public Object eat_update(TTeamEat teamEat, String s_remarks) {
        log.info("用餐更新 uri = team/eat_update  参数列表：{'teamEat':{},'remarks':{}}", new Object[]{teamEat, s_remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TTeamEat oldTeamEat = this.teamEatMapper.selectById(teamEat.getId());
        Integer status = oldTeamEat.getS_status();
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
            String oldRemark = oldTeamEat.getEat_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            // 更新内容
            oldTeamEat.setUpdate_time(DateUtil.getTime());
            oldTeamEat.setRestaurant(teamEat.getRestaurant());
            oldTeamEat.setRestaurant_date(teamEat.getRestaurant_date());
            oldTeamEat.setRestaurant_peoples(teamEat.getRestaurant_peoples());
            oldTeamEat.setRestaurant_attention(teamEat.getRestaurant_attention());
            oldTeamEat.setPay_type(teamEat.getPay_type());
            oldTeamEat.setEat_remark(rid);
            this.teamEatMapper.updateById(oldTeamEat);
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
     * @param teamCar
     * @param s_remarks
     * @return
     */
    @PostMapping("/car_update")
    public Object car_update(TTeamCar teamCar, String s_remarks) {
        log.info("用车更新 uri = user/car_update  参数列表：{'teamCar':{},'remarks':{}}", new Object[]{teamCar, s_remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TTeamCar oldTeamCar = this.teamCarMapper.selectById(teamCar.getId());
        Integer status = oldTeamCar.getS_status();
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
            String oldRemark = oldTeamCar.getCar_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            // 更新内容
            oldTeamCar.setUpdate_time(DateUtil.getTime());
            oldTeamCar.setAttention(teamCar.getAttention());
            oldTeamCar.setTraffic_number(teamCar.getTraffic_number());
            oldTeamCar.setNeed_car_date(teamCar.getNeed_car_date());
            oldTeamCar.setNeed_car_time(teamCar.getNeed_car_time());
            oldTeamCar.setRide_place(teamCar.getRide_place());
            oldTeamCar.setDestination(teamCar.getDestination());
            oldTeamCar.setRide_peoples(teamCar.getRide_peoples());
            oldTeamCar.setAccompany_leader(teamCar.getAccompany_leader());
            oldTeamCar.setPay_type(teamCar.getPay_type());
            oldTeamCar.setStop_price(teamCar.getStop_price());
            oldTeamCar.setCar_remark(rid);
            this.teamCarMapper.updateById(oldTeamCar);
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
     * @param teamArchives
     * @param s_remarks
     * @return
     */
    @PostMapping("/archives_update")
    public Object archives_update(TTeamArchives teamArchives, String s_remarks) {
        log.info("档案更新 uri = user/archives_update  参数列表：{'teamArchives':{},'remarks':{}}", new Object[]{teamArchives, s_remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "更新失败");
        TTeamArchives oldTeamArchives = this.teamArchivesMapper.selectById(teamArchives.getId());
        Integer status = oldTeamArchives.getS_status();
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
            String oldRemark = oldTeamArchives.getArchives_remark();
            if (oldRemark != null) {
                String[] ors = oldRemark.split(",");
                Set<Integer> ids = new HashSet<>();
                for (String str : ors) {
                    ids.add(Integer.valueOf(str));
                }
                this.remarkMapper.deleteBatchIds(ids);
            }
            // 内容更新
            oldTeamArchives.setUpdate_time(DateUtil.getTime());
            oldTeamArchives.setActivity(teamArchives.getActivity());
            oldTeamArchives.setPersonal_synopsis(teamArchives.getPersonal_synopsis());
            oldTeamArchives.setRole(teamArchives.getRole());
            oldTeamArchives.setSpeech_topic(teamArchives.getSpeech_topic());
            oldTeamArchives.setSpeech_file(teamArchives.getSpeech_file());
            oldTeamArchives.setPhone_file(teamArchives.getPhone_file());
            oldTeamArchives.setAccount(teamArchives.getAccount());
            oldTeamArchives.setAccount_blank(teamArchives.getAccount_blank());
            oldTeamArchives.setAccount_name(teamArchives.getAccount_name());
            oldTeamArchives.setArchives_remark(rid);
            this.teamArchivesMapper.updateById(oldTeamArchives);
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
                TTeamHouse house = this.teamHouseMapper.selectById(id);
                //结束
                house.setEnd(1);
                String userR = house.getHouse_remark();
                if (userR != null) {
                    house.setHouse_remark(house.getHouse_remark() + rid);
                } else {
                    house.setHouse_remark(rid);
                }
                this.teamHouseMapper.updateById(house);
            } else if (type.intValue() == 1) {
                //用餐
                TTeamEat eat = this.teamEatMapper.selectById(id);
                //结束
                eat.setEnd(1);
                String userR = eat.getEat_remark();
                if (userR != null) {
                    eat.setEat_remark(eat.getEat_remark() + rid);
                } else {
                    eat.setEat_remark(rid);
                }
                this.teamEatMapper.updateById(eat);
            } else if (type.intValue() == 2) {
                //用车
                TTeamCar car = this.teamCarMapper.selectById(id);
                //结束
                car.setEnd(1);
                String userR = car.getCar_remark();
                if (userR != null) {
                    car.setCar_remark(car.getCar_remark() + rid);
                } else {
                    car.setCar_remark(rid);
                }
                this.teamCarMapper.updateById(car);
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
    public Object user_arrange(Integer type, Integer id, String remarks, String houses) {
        log.info("结束接口 uri=team/arrange 参数列表：{'type':{},'id':{},'remarks':{}}", new Object[]{type, id, remarks});
        ResultVo resultVo = new ResultVo(ResponseCode.ERROR, "操作失败");
        try {
            String rid = "";
            String hid = "";
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
            // 住房
            if (houses != null && !houses.equals("")) {
                houses = houses.substring(1, houses.length() - 1) + ",";
                String[] housesArr = houses.split("},");
                String uuid = UUID.randomUUID().toString();
                // 备注
                // 解析remark 并插进数据库
                for (String str : housesArr) {
                    str = str + "}";
                    THouse house = (THouse) JsonUtil.JSONToObj(str, THouse.class);
                    house.setUuid(uuid);
                    this.houseMapper.insert(house);
                }
                // 获取remarkid
                Map<String, Object> params = new HashMap<>();
                params.put("uuid", uuid);
                List<THouse> rs = this.houseMapper.selectByMap(params);
                for (THouse tHouse : rs) {
                    rid = rid + tHouse.getId() + ",";
                }
            }
            if (type.intValue() == 0) {
                //住房
                TTeamHouse house = this.teamHouseMapper.selectById(id);
                String userR = house.getHouse_remark();
                String h_ids = house.getHouse_id();
                if (userR != null) {
                    house.setHouse_remark(house.getHouse_remark() + rid);
                } else {
                    house.setHouse_remark(rid);
                }
                if (h_ids != null) {
                    house.setHouse_id(house.getHouse_id() + hid);
                } else {
                    house.setHouse_id(hid);
                }
                this.teamHouseMapper.updateById(house);
            } else if (type.intValue() == 1) {
                //用餐
                TTeamEat eat = this.teamEatMapper.selectById(id);
                //结束
                String userR = eat.getEat_remark();
                if (userR != null) {
                    eat.setEat_remark(eat.getEat_remark() + rid);
                } else {
                    eat.setEat_remark(rid);
                }
                this.teamEatMapper.updateById(eat);
            } else if (type.intValue() == 2) {
                //用车
                TTeamCar car = this.teamCarMapper.selectById(id);
                //结束
                String userR = car.getCar_remark();
                if (userR != null) {
                    car.setCar_remark(car.getCar_remark() + rid);
                } else {
                    car.setCar_remark(rid);
                }
                this.teamCarMapper.updateById(car);
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
        log.info("导出  uri=team/export  参数列表：{'type':{},'ids':{}}", new Object[]{type, ids});
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
            List<TTeam> teams = this.teamMapper.selectBatchIds(allId);
            if (teams != null) {
                ExcelUtils.writeExcel(response, teams, TTeam.class, "客户团体信息表");
            }
        } else if (type.intValue() == 1) {
            //用车
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TTeamCar> cars = this.teamCarMapper.selectBatchIds(allId);
            if (cars != null) {
                for (TTeamCar tTeamCar : cars) {
                    // 用户姓名
                    String name = this.teamMapper.selectById(tTeamCar.getTeam_id()).getCompany();
                    tTeamCar.setTeamName(name);
                }
                ExcelUtils.writeExcel(response, cars, TTeamCar.class, "客户团体用车信息表");
            }
        } else if (type.intValue() == 2) {
            // 用餐
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TTeamEat> eats = this.teamEatMapper.selectBatchIds(allId);
            if (eats != null) {
                for (TTeamEat teamEat : eats) {
                    // 用户姓名
                    String name = this.teamMapper.selectById(teamEat.getTeam_id()).getCompany();
                    teamEat.setTeamName(name);
                }
                ExcelUtils.writeExcel(response, eats, TTeamEat.class, "客户团体用餐信息表");
            }
        } else if (type.intValue() == 4) {
            //档案
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TTeamArchives> archivers = this.teamArchivesMapper.selectBatchIds(allId);
            if (archivers != null) {
                for (TTeamArchives teamArchives : archivers) {
                    // 用户姓名
                    String name = this.teamMapper.selectById(teamArchives.getTeam_id()).getCompany();
                    teamArchives.setTeamName(name);
                }
                ExcelUtils.writeExcel(response, archivers, TTeamArchives.class, "客户团体档案信息表");
            }
        } else if (type.intValue() == 3) {
            //用房
            String[] idArr = ids.split(",");
            allId.clear();
            for (String id : idArr) {
                allId.add(Integer.valueOf(id));
            }
            List<TTeamHouse> houses = this.teamHouseMapper.selectBatchIds(allId);
            if (houses != null) {
                for (TTeamHouse house : houses) {
                    // 用户姓名
                    String name = this.teamMapper.selectById(house.getTeam_id()).getCompany();
                    house.setTeamName(name);
                }
                ExcelUtils.writeExcel(response, houses, TTeamHouse.class, "客户团体住房信息表");
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
        List<TeamExcelInclude> teamExcelIncludes = ExcelUtils.readExcel("", TeamExcelInclude.class, file);
        try {
            for (TeamExcelInclude teamExcelInclude : teamExcelIncludes) {
                TTeam team = new TTeam();
                team.setCreate_time(DateUtil.getTime());
                team.setCompany(teamExcelInclude.getCompany());
                team.setCompany_leader(teamExcelInclude.getCompany_leader());
                team.setCompany_leader_job(teamExcelInclude.getCompany_leader_job());
                team.setPick_up_user(teamExcelInclude.getPick_up_user());
                team.setCertificates(teamExcelInclude.getCertificates());
                team.setAreas(teamExcelInclude.getAreas());
                team.setTeams_peoples(teamExcelInclude.getTeams_peoples());
                team.setTeams_contacts(teamExcelInclude.getTeams_contacts());
                team.setContacts_phone(teamExcelInclude.getContacts_phone());
                System.out.println(team);
                this.teamMapper.insert(team);
            }
            resultVo.setCode(ResponseCode.SUCCESS);
            resultVo.setMsg("导入成功");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return resultVo;
    }

}
