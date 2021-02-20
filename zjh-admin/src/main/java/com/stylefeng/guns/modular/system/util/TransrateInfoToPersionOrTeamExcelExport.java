package com.stylefeng.guns.modular.system.util;

import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.modular.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/9/25
 */
@Component
public class TransrateInfoToPersionOrTeamExcelExport {

    @Autowired
    private ITUserService userService;
    @Autowired
    private ITUserHouseService userHouseService;
    @Autowired
    private ITUserEatService userEatService;
    @Autowired
    private ITUserCarService userCarService;
    @Autowired
    private ITTeamService teamService;
    @Autowired
    private ITTeamHouseService teamHouseService;
    @Autowired
    private ITTeamEatService teamEatService;
    @Autowired
    private ITTeamCarService teamCarService;

    // 导出个人全部信息
    public List<PersonExcelExport> getPersonExcelExport(List<TUserArchives> userArchives) {
        List<PersonExcelExport> personExcelExports = new ArrayList<>();
        if (userArchives != null) {
            Set<Integer> userIds = new HashSet<>();
            for (TUserArchives archives : userArchives) {
                Integer userId = archives.getUserId();
                Map<String, Object> params = new HashMap<>();
                params.put("user_id", userId);
                // 个人信息
                TUser user = this.userService.selectById(userId);
                // 用车信息
                List<TUserCar> cars = this.userCarService.selectByMap(params);
                // 用餐信息
                List<TUserEat> eats = this.userEatService.selectByMap(params);
                // 住房信息
                List<TUserHouse> houses = this.userHouseService.selectByMap(params);
                // 判断用车信息多 还是用餐信息  还是住房信息
                int max = getMax(cars.size(), eats.size(), houses.size());
                for (int i = 0; i < max; i++) {
                    PersonExcelExport personExcelExport = new PersonExcelExport();
                    // 个人信息补充
                    personExcelExport.setName(user.getName());
                    personExcelExport.setSex(user.getSex());
                    personExcelExport.setCompany(user.getCompany());
                    personExcelExport.setJob((user.getJob()));
                    personExcelExport.setPhone(user.getPhone());
                    personExcelExport.setEmail(user.getEmail());
                    personExcelExport.setFollow(user.getFollow());
                    personExcelExport.setPickUpUser(user.getPickUpUser());
                    personExcelExport.setCertificates(user.getCertificates());
                    personExcelExport.setFollowName(user.getFollowName());
                    personExcelExport.setAccompany(user.getAccompany());
                    personExcelExport.setTranslate(user.getTranslate());
                    // 档案信息
                    personExcelExport.setActivity(archives.getActivity());
                    personExcelExport.setPersonalSynopsis(archives.getPersonalSynopsis());
                    personExcelExport.setRole(archives.getRole());
                    personExcelExport.setSpeechTopic(archives.getSpeechTopic());
                    personExcelExport.setAccount(archives.getAccount());
                    personExcelExport.setAccountBlank(archives.getAccountBlank());
                    personExcelExport.setAccountName(archives.getAccountName());
                    personExcelExport.setArchive_remarkName(archives.getRemarkName());
                    personExcelExport.setArchive_remarkContent(archives.getRemarkContent());
                    personExcelExport.setArchive_status(archives.getStatus());
                    personExcelExport.setArchive_statusDate(archives.getStatusDate());
                    personExcelExport.setArchive_sRemarkName(archives.getsRemarkName());
                    personExcelExport.setArchive_sRemarkContent(archives.getsRemarkContent());
                    // 用车信息
                    if (i < cars.size()) {
                        personExcelExport.setAttention(cars.get(i).getAttention());
                        personExcelExport.setTrafficNumber(cars.get(i).getTrafficNumber());
                        personExcelExport.setNeedCarDate(cars.get(i).getNeedCarDate());
                        personExcelExport.setNeedCarTime(cars.get(i).getNeedCarTime());
                        personExcelExport.setRidePlace(cars.get(i).getRidePlace());
                        personExcelExport.setRidePeoples(cars.get(i).getRidePeoples());
                        personExcelExport.setDestination(cars.get(i).getDestination());
                        personExcelExport.setAccompanyLeader(cars.get(i).getAccompanyLeader());
                        personExcelExport.setPayType(cars.get(i).getPayType());
                        personExcelExport.setStopPrice(cars.get(i).getStopPrice());
                        personExcelExport.setCar_status(cars.get(i).getStatus());
                        personExcelExport.setCar_end(cars.get(i).getEnd());
                        personExcelExport.setCar_remarkName(cars.get(i).getaRemarkName());
                        personExcelExport.setCar_remarkContent(cars.get(i).getRemarkContent());
                        personExcelExport.setCar_statusDate(cars.get(i).getStatusDate());
                        personExcelExport.setCar_endDate(cars.get(i).getEndDate());
                        personExcelExport.setCar_sRemarkName(cars.get(i).getsRemarkName());
                        personExcelExport.setCar_sRemarkContent(cars.get(i).getsRemarkContent());
                        personExcelExport.setCar_eRemarkName(cars.get(i).geteRemarkName());
                        personExcelExport.seteRemarkContent(cars.get(i).geteRemarkContent());
                    }
                    // 用餐信息
                    if (i < eats.size()) {
                        personExcelExport.setRestaurant(eats.get(i).getRestaurant());
                        personExcelExport.setRestaurantAttention(eats.get(i).getRestaurantAttention());
                        personExcelExport.setRestaurantDate(eats.get(i).getRestaurantDate());
                        personExcelExport.setRestaurantPeoples(eats.get(i).getRestaurantPeoples());
                        personExcelExport.setEat_payType(eats.get(i).getPayType());
                        personExcelExport.setEat_status(eats.get(i).getStatus());
                        personExcelExport.setEat_end(eats.get(i).getEnd());
                        personExcelExport.setEat_remarkName(eats.get(i).getRemarkName());
                        personExcelExport.setEat_remarkContent(eats.get(i).getRemarkContent());
                        personExcelExport.setEat_statusDate(eats.get(i).getStatusDate());
                        personExcelExport.setEat_endDate(eats.get(i).getEndDate());
                        personExcelExport.setEat_sRemarkName(eats.get(i).getsRemarkName());
                        personExcelExport.setEat_sRemarkContent(eats.get(i).getsRemarkContent());
                        personExcelExport.setEat_eRemarkContent(eats.get(i).geteRemarkContent());
                        personExcelExport.setEat_eRemarkName(eats.get(i).geteRemarkName());
                    }
                    // 住房信息
                    if (i < houses.size()) {
                        personExcelExport.setHotel(houses.get(i).getHotel());
                        personExcelExport.setCheckInDate(houses.get(i).getCheckInDate());
                        personExcelExport.setCheckOutDate(houses.get(i).getCheckOutDate());
                        personExcelExport.setRoomType(houses.get(i).getRoomType());
                        personExcelExport.setPrice(houses.get(i).getPrice());
                        personExcelExport.setTotal(houses.get(i).getTotal());
                        personExcelExport.setTotalPrice(houses.get(i).getTotalPrice());
                        personExcelExport.setHouse_payType(houses.get(i).getPayType());
                        personExcelExport.setRoomNum(houses.get(i).getRoomNum());
                        personExcelExport.setVacant(houses.get(i).getVacant());
                        personExcelExport.setSpliceRoom(houses.get(i).getSpliceRoom());
                        personExcelExport.setSplicePeople(houses.get(i).getSplicePeople());
                        personExcelExport.setHouse_status(houses.get(i).getStatus());
                        personExcelExport.setEnd(houses.get(i).getEnd());
                        personExcelExport.setHouse_statusDate(houses.get(i).getStatusDate());
                        personExcelExport.setHouse_endDate(houses.get(i).getEndDate());
                        personExcelExport.setHouse_remarkName(houses.get(i).getRemarkName());
                        personExcelExport.setHouse_remarkContent(houses.get(i).getRemarkContent());
                        personExcelExport.setHouse_sRemarkName(houses.get(i).getsRemarkName());
                        personExcelExport.setHouse_sRemarkContent(houses.get(i).getsRemarkContent());
                        personExcelExport.setHouse_eRemarkContent(houses.get(i).geteRemarkContent());
                        personExcelExport.setHouse_eRemarkName(houses.get(i).geteRemarkContent());
                    }
                    personExcelExports.add(personExcelExport);
                }
            }
        }
        return personExcelExports;
    }

    // 导出团队全部信息
    public List<TeamExcelExport> getTeamExcelExport(List<TTeamArchives> teamArchives) {
        List<TeamExcelExport> teamExcelExports = new ArrayList<>();
        if (teamArchives != null) {
            Set<Integer> userIds = new HashSet<>();
            for (TTeamArchives archives : teamArchives) {
                Integer teamId = archives.getTeamId();
                Map<String, Object> params = new HashMap<>();
                params.put("team_id", teamId);
                // 团队信息
                TTeam team = this.teamService.selectById(teamId);
                // 用车信息
                List<TTeamCar> cars = this.teamCarService.selectByMap(params);
                // 用餐信息
                List<TTeamEat> eats = this.teamEatService.selectByMap(params);
                // 住房信息
                List<TTeamHouse> houses = this.teamHouseService.selectByMap(params);
                // 判断用车信息多 还是用餐信息  还是住房信息
                int max = getMax(cars.size(), eats.size(), houses.size());
                for (int i = 0; i < max; i++) {
                    TeamExcelExport teamExcelExport = new TeamExcelExport();
                    // 个人信息补充
                    teamExcelExport.setId(team.getId());
                    teamExcelExport.setCreateTime(team.getCreateTime());
                    teamExcelExport.setUpdateTime(team.getUpdateTime());
                    teamExcelExport.setCompany(team.getCompany());
                    teamExcelExport.setCompanyLeader(team.getCompanyLeader());
                    teamExcelExport.setCompanyLeaderJob(team.getCompanyLeaderJob());
                    teamExcelExport.setCertificates(team.getCertificates());
                    teamExcelExport.setPickUpUser(team.getPickUpUser());
                    teamExcelExport.setAreas(team.getAreas());
                    teamExcelExport.setTeamsPeoples(team.getTeamsPeoples());
                    teamExcelExport.setTeamsContacts(team.getTeamsContacts());
                    teamExcelExport.setContactsPhone(team.getContactsPhone());
                    // 档案信息
                    teamExcelExport.setActivity(archives.getActivity());
                    teamExcelExport.setPersonalSynopsis(archives.getPersonalSynopsis());
                    teamExcelExport.setRole(archives.getRole());
                    teamExcelExport.setSpeechTopic(archives.getSpeechTopic());
                    teamExcelExport.setAccount(archives.getAccount());
                    teamExcelExport.setAccountBlank(archives.getAccountBlank());
                    teamExcelExport.setAccountName(archives.getAccountName());
                    teamExcelExport.setArchive_remarkName(archives.getRemarkName());
                    teamExcelExport.setArchive_remarkContent(archives.getRemarkContent());
                    teamExcelExport.setArchive_status(archives.getStatus());
                    teamExcelExport.setArchive_statusDate(archives.getStatusDate());
                    teamExcelExport.setArchive_sRemarkName(archives.getsRemarkName());
                    teamExcelExport.setArchive_sRemarkContent(archives.getsRemarkContent());
                    // 用车信息
                    if (i < cars.size()) {
                        teamExcelExport.setAttention(cars.get(i).getAttention());
                        teamExcelExport.setTrafficNumber(cars.get(i).getTrafficNumber());
                        teamExcelExport.setNeedCarDate(cars.get(i).getNeedCarDate());
                        teamExcelExport.setNeedCarTime(cars.get(i).getNeedCarTime());
                        teamExcelExport.setRidePlace(cars.get(i).getRidePlace());
                        teamExcelExport.setRidePeoples(cars.get(i).getRidePeoples());
                        teamExcelExport.setDestination(cars.get(i).getDestination());
                        teamExcelExport.setAccompanyLeader(cars.get(i).getAccompanyLeader());
                        teamExcelExport.setPayType(cars.get(i).getPayType());
                        teamExcelExport.setStopPrice(cars.get(i).getStopPrice());
                        teamExcelExport.setCar_status(cars.get(i).getStatus());
                        teamExcelExport.setCar_end(cars.get(i).getEnd());
                        teamExcelExport.setCar_remarkName(cars.get(i).getaRemarkName());
                        teamExcelExport.setCar_remarkContent(cars.get(i).getRemarkContent());
                        teamExcelExport.setCar_statusDate(cars.get(i).getStatusDate());
                        teamExcelExport.setCar_endDate(cars.get(i).getEndDate());
                        teamExcelExport.setCar_sRemarkName(cars.get(i).getsRemarkName());
                        teamExcelExport.setCar_sRemarkContent(cars.get(i).getsRemarkContent());
                        teamExcelExport.setCar_eRemarkName(cars.get(i).geteRemarkName());
                        teamExcelExport.seteRemarkContent(cars.get(i).geteRemarkContent());
                    }
                    // 用餐信息
                    if (i < eats.size()) {
                        teamExcelExport.setRestaurant(eats.get(i).getRestaurant());
                        teamExcelExport.setRestaurantAttention(eats.get(i).getRestaurantAttention());
                        teamExcelExport.setRestaurantDate(eats.get(i).getRestaurantDate());
                        teamExcelExport.setRestaurantPeoples(eats.get(i).getRestaurantPeoples());
                        teamExcelExport.setEat_payType(eats.get(i).getPayType());
                        teamExcelExport.setEat_status(eats.get(i).getStatus());
                        teamExcelExport.setEat_end(eats.get(i).getEnd());
                        teamExcelExport.setEat_remarkName(eats.get(i).getRemarkName());
                        teamExcelExport.setEat_remarkContent(eats.get(i).getRemarkContent());
                        teamExcelExport.setEat_statusDate(eats.get(i).getStatusDate());
                        teamExcelExport.setEat_endDate(eats.get(i).getEndDate());
                        teamExcelExport.setEat_sRemarkName(eats.get(i).getsRemarkName());
                        teamExcelExport.setEat_sRemarkContent(eats.get(i).getsRemarkContent());
                        teamExcelExport.setEat_eRemarkContent(eats.get(i).geteRemarkContent());
                        teamExcelExport.setEat_eRemarkName(eats.get(i).geteRemarkName());
                    }
                    // 住房信息
                    if (i < houses.size()) {
                        teamExcelExport.setHotel(houses.get(i).getHotel());
                        teamExcelExport.setCheckInDate(houses.get(i).getCheckInDate());
                        teamExcelExport.setCheckOutDate(houses.get(i).getCheckOutDate());
                        teamExcelExport.setRoomType(houses.get(i).getRoomType());
                        teamExcelExport.setPrice(houses.get(i).getPrice());
                        teamExcelExport.setTotal(houses.get(i).getTotal());
                        teamExcelExport.setTotalPrice(houses.get(i).getTotalPrice());
                        teamExcelExport.setHouse_payType(houses.get(i).getPayType());
                        teamExcelExport.setRoomNum(houses.get(i).getRoomNum());
                        teamExcelExport.setVacant(houses.get(i).getVacant());
                        teamExcelExport.setSpliceRoom(houses.get(i).getSpliceRoom());
                        teamExcelExport.setSplicePeople(houses.get(i).getSplicePeople());
                        teamExcelExport.setHouse_status(houses.get(i).getStatus());
                        teamExcelExport.setEnd(houses.get(i).getEnd());
                        teamExcelExport.setHouse_statusDate(houses.get(i).getStatusDate());
                        teamExcelExport.setHouse_endDate(houses.get(i).getEndDate());
                        teamExcelExport.setHouse_remarkName(houses.get(i).getRemarkName());
                        teamExcelExport.setHouse_remarkContent(houses.get(i).getRemarkContent());
                        teamExcelExport.setHouse_sRemarkName(houses.get(i).getsRemarkName());
                        teamExcelExport.setHouse_sRemarkContent(houses.get(i).getsRemarkContent());
                        teamExcelExport.setHouse_eRemarkContent(houses.get(i).geteRemarkContent());
                        teamExcelExport.setHouse_eRemarkName(houses.get(i).geteRemarkContent());
                    }
                    teamExcelExports.add(teamExcelExport);
                }
            }
        }
        return teamExcelExports;
    }

    public int getMax(int a, int b, int c) {
        int max = 0;
        if (a >= b) {
            max = a;
        } else {
            max = b;
        }
        if (c >= max) {
            max = c;
        }
        return max;
    }
}
