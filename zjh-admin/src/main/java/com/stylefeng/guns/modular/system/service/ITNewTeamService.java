package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.TNewTeam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 团队信息总表 服务类
 *
 * @author Hatcher Su
 * @since 2019-10-10
 */

public interface ITNewTeamService extends IService<TNewTeam> {



    /**
     * gen
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryByCreateId(Integer id);

    /**
     * 获取所有团队的基础信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamInfo(Integer id);


    /**
     * 获取单个团队的信息
     *
     * @param id
     * @return
     */
    TNewTeam queryTeamInfoById(Integer id);


    /**
     * 获取单个团队的用车信息
     *
     * @param id
     * @return
     */
    TNewTeam queryTeamCarById(Integer id);


    /**
     * 获取所有团队的用车信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamCar(Integer id);


    /**
     * 获取所有团队的用餐信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamEat(Integer id);


    /**
     * 获取单个团队的用餐信息
     *
     * @param id
     * @return
     */
    TNewTeam queryTeamEatById(Integer id);

    /**
     * 获取所有团队的活动信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamActivity(Integer id);


    /**
     * 获取单个团队的活动详情
     *
     * @param id
     * @return
     */
    TNewTeam queryTeamActivityById(Integer id);

    /**
     * 获取所有团队的住房信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamHouse(Integer id);

    /**
     * 获取单个团队的住房信息
     *
     * @param id
     * @return
     */
    TNewTeam queryTeamHouseById(Integer id);

    /**
     * 根据选择的属性进行查询团队的信息
     *
     * @param filed1
     * @param value1
     * @param filed2
     * @param value2
     * @param id
     * @return
     */
    List<TNewTeam> queryTeamInfoByFiled(String filed1, String value1, String filed2, String value2, Integer id);

    /**
     * 根据选择的属性进行查询团队的活动信息
     */
    List<TNewTeam> queryTeamActivityByFiled(String filed1, String value1, String filed2, String value2,
                                            Integer status, Integer id);

    /**
     * 根据选择的属性进行查询团队的用餐信息
     */
    List<TNewTeam> queryTeamEatByFiled(String filed1, String value1, String filed2, String value2,
                                       Integer status, Integer end, Integer id);

    /**
     * 根据选择的属性进行查询团队的用车信息
     */
    List<TNewTeam> queryTeamCarByFiled(String filed1, String value1, String filed2, String value2,
                                       Integer status, Integer end, Integer id);

    /**
     * 根据选择的属性进行查询团队的住房信息
     */
    List<TNewTeam> queryTeamHouseByFiled(String filed1, String value1, String filed2, String value2,
                                         Integer status, Integer end, Integer id);


}
