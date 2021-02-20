package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.TNewTeamMapper;
import com.stylefeng.guns.modular.system.model.TNewTeam;
import com.stylefeng.guns.modular.system.service.ITNewTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
@Service
public class TNewTeamServiceImpl extends ServiceImpl<TNewTeamMapper, TNewTeam> implements ITNewTeamService {

    @Autowired
    TNewTeamMapper mapper;
    @Override
    public List<TNewTeam> queryByCreateId(Integer id) {
        return mapper.queryAllTeamInfo(id);
    }

    @Override
    public List<TNewTeam> queryAllTeamInfo(Integer id) {
        return mapper.queryAllTeamInfo(id);
    }

    @Override
    public TNewTeam queryTeamInfoById(Integer id) {
        return mapper.queryTeamInfoById(id);
    }

    @Override
    public TNewTeam queryTeamCarById(Integer id) {
        return mapper.queryTeamCarById(id);
    }

    @Override
    public List<TNewTeam> queryAllTeamCar(Integer id) {
        return mapper.queryAllTeamCar(id);
    }

    @Override
    public List<TNewTeam> queryAllTeamEat(Integer id) {
        return mapper.queryAllTeamEat(id);
    }

    @Override
    public TNewTeam queryTeamEatById(Integer id) {
        return mapper.queryTeamEatById(id);
    }

    @Override
    public List<TNewTeam> queryAllTeamActivity(Integer id) {
        return mapper.queryAllTeamActivity(id);
    }

    @Override
    public TNewTeam queryTeamActivityById(Integer id) {
        return mapper.queryTeamActivityById(id);
    }

    @Override
    public List<TNewTeam> queryAllTeamHouse(Integer id) {
        return mapper.queryAllTeamHouse(id);
    }

    @Override
    public TNewTeam queryTeamHouseById(Integer id) {
        return mapper.queryTeamHomeById(id);
    }

    @Override
    public List<TNewTeam> queryTeamInfoByFiled(String filed1, String value1, String filed2, String value2, Integer id) {
        return mapper.queryTeamInfoByFiled(filed1, value1, filed2, value2, id);
    }

    @Override
    public List<TNewTeam> queryTeamActivityByFiled(String filed1, String value1, String filed2, String value2, Integer status, Integer id) {
        return  mapper.queryTeamActivityByFiled(filed1, value1, filed2, value2, status, id);
    }

    @Override
    public List<TNewTeam> queryTeamEatByFiled(String filed1, String value1, String filed2, String value2, Integer status, Integer end, Integer id) {
        return mapper.queryTeamEatByFiled(filed1, value1, filed2, value2, status, end, id);
    }

    @Override
    public List<TNewTeam> queryTeamCarByFiled(String filed1, String value1, String filed2, String value2, Integer status, Integer end, Integer id) {
        return mapper.queryTeamCarByFiled(filed1, value1, filed2, value2, status,end, id);
    }

    @Override
    public List<TNewTeam> queryTeamHouseByFiled(String filed1, String value1, String filed2, String value2, Integer status, Integer end, Integer id) {
        return  mapper.queryTeamHouseByFiled(filed1, value1, filed2, value2, status, end, id);
    }

}
