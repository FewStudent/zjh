package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TNewTeam;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团队的信息总表 Mapper 接口
 * </p>
 *
 * @author lakyjpan
 * @since 2019-10-07
 */
public interface TNewTeamMapper extends BaseMapper<TNewTeam> {

    /**
     * 获取所有团队信息，通过创建人
     */
    List<TNewTeam> queryAllTeamInfo(@Param("create") Integer id);

    /**
     * 获取单个团队所有信息
     */
    TNewTeam queryTeamInfoById(@Param("id") Integer id);

    /**
     * 获取单个团队的用车信息
     * @param id
     * @return
     */
    TNewTeam queryTeamCarById(@Param("id")Integer id);

    /**
     * 获取所有团队的用车信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamCar(@Param("create") Integer id);

    /**
     * 获取所有团队的用餐信息
     *
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamEat(@Param("create") Integer id);


    /**
     * 获取团队的详细用餐信息
     *
     * @param id
     * @return
     */
    TNewTeam queryTeamEatById(@Param("id") Integer id);


    /**
     * 获取团队的所有活动信息
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamActivity(@Param("create") Integer id);


    /**
     * 获取团队的活动详情
     */
    TNewTeam queryTeamActivityById(@Param("id") Integer id);

    /**
     * 获取所有团队的住房信息
     * @param id
     * @return
     */
    List<TNewTeam> queryAllTeamHouse(@Param("create")Integer id);

    /**
     * 获取团队的住房详情
     * @param id
     * @return
     */
    TNewTeam queryTeamHomeById(@Param("id") Integer id);

    /**
     * 根据选择的属性进行查询团队的信息
     */
    List<TNewTeam> queryTeamInfoByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
                                               @Param("filed2") String filed2, @Param("value2") String value2, @Param("create") Integer id);

    /**
     * 根据选择的属性进行查询团队的活动信息
     */
    List<TNewTeam> queryTeamActivityByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
                                      @Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
                                      @Param("create") Integer id);

    /**
     * 根据选择的属性进行查询团队的用餐信息
     */
    List<TNewTeam> queryTeamEatByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
                                              @Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
                                              @Param("end") Integer end, @Param("create") Integer id);


    /**
     * 根据选择的属性进行查询团队的用车信息
     */
    List<TNewTeam> queryTeamCarByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
                                              @Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
                                              @Param("end") Integer end, @Param("create") Integer id);

    /**
     * 根据选择的属性进行查询团队的住房信息
     */
    List<TNewTeam> queryTeamHouseByFiled(@Param("filed1") String filed1, @Param("value1") String value1,
                                                @Param("filed2") String filed2, @Param("value2") String value2, @Param("status") Integer status,
                                                @Param("end") Integer end, @Param("create") Integer id);




}
