/**
 * 初始化详情对话框
 */
var TTeamCarInfoDlg = {
    tTeamCarInfoData: {}
};

/**
 * 清除数据
 */
TTeamCarInfoDlg.clearData = function () {
    this.tTeamCarInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TTeamCarInfoDlg.set = function (key, val) {
    this.tTeamCarInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TTeamCarInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TTeamCarInfoDlg.close = function () {
    parent.layer.close(window.parent.TTeamCar.layerIndex);
}

/**
 * 收集数据
 */
TTeamCarInfoDlg.collectData = function () {
    this
        .set('id')
        .set('jUseCarDate')
        .set('status')
        .set('jUseCarTime')
        .set('jTrafficNum')
        .set('jRidePlace')
        .set('jDestination')
        .set('jRidePeoples')
        .set('jAccompanyLeader')
        .set('jPayType')
        .set('jHasStopCard')
        .set('jAddRemark')
        .set('jCarArrange')
        .set('jDriver')
        .set('jDriverPhone')
        .set('jCarType')
        .set('jArrangeRemark')
        .set('jCarSType')
        .set('sUseCarDate')
        .set('sUseCarTime')
        .set('sTrafficNum')
        .set('sRidePlace')
        .set('sDestination')
        .set('sRidePeoples')
        .set('sAccompanyLeader')
        .set('sPayType')
        .set('sHasStopCard')
        .set('sAddRemark')
        .set('sCarArrange')
        .set('sDriver')
        .set('sDriverPhone')
        .set('sCarType')
        .set('sArrangeRemark')
        .set('sCarSType')
        .set('cUseCarDate')
        .set('cUseCarTime')
        .set('cTrafficNum')
        .set('cRidePlace')
        .set('cDestination')
        .set('cRidePeoples')
        .set('cAccompanyLeader')
        .set('cPayType')
        .set('cHasStopCard')
        .set('cAddRemark')
        .set('cCarArrange')
        .set('cDriver')
        .set('cDriverPhone')
        .set('cCarType')
        .set('cArrangeRemark')
        .set('cCarSType')
        .set('carStatusReamrkName')
        .set('carStatusRemark')
        .set('carStatus')
        .set('carEndRemarkName')
        .set('carEndRemark')
        .set('jCarCard')
        .set('cCarCard')
        .set('sCarCard')
        .set('carEnd')
        .set('end')
        .set("eRemarkName")
        .set('eRemarkContent')
        ;
}

/**
 * 提交添加
 */
TTeamCarInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamCar/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TTeamCar.table.refresh();
        TTeamCarInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tTeamCarInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TTeamCarInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamCar/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TTeamCar.table.refresh();
        TTeamCarInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tTeamCarInfoData);
    ajax.start();
}

// 提交审核
TTeamCarInfoDlg.examineSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamCar/examine_do", function (data) {
        Feng.success("审核成功!");
        window.parent.TTeamCar.table.refresh();
        TTeamCarInfoDlg.close();
    }, function (data) {
        Feng.error("审核失败!" + data.message + "!");
    });
    ajax.set(this.tTeamCarInfoData);
    ajax.start();
}

// 提交结束
TTeamCarInfoDlg.endSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamCar/end_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TTeamCar.table.refresh();
        TTeamCarInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tTeamCarInfoData);
    ajax.start();
}

// 提交安排
TTeamCarInfoDlg.makeSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamCar/make_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TTeamCar.table.refresh();
        TTeamCarInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tTeamCarInfoData);
    ajax.start();
}

$(function () {
    $("#sex").val($("#sexVal").val());
    $("#card").val($("#cardVal").val());

    $("#jPayType").val($("#jPayTypeVal").val());
    $("#jHasStopCard").val($("#jHasStopCardVal").val());
    $("#jCarArrange").val($("#jCarArrangeVal").val());
    $("#jCarSType").val($("#jCarSTypeVal").val());

    $("#sPayType").val($("#sPayTypeVal").val());
    $("#sHasStopCard").val($("#sHasStopCardVal").val());
    $("#sCarArrange").val($("#sCarArrangeVal").val());
    $("#sCarSType").val($("#sCarSTypeVal").val());

    $("#cPayType").val($("#cPayTypeVal").val());
    $("#cHasStopCard").val($("#cHasStopCardVal").val());
    $("#cCarArrange").val($("#cCarArrangeVal").val());
    $("#cCarSType").val($("#cCarSTypeVal").val());

    $("#carStatus").val($("#carStatusVal").val());
    $("#carEnd").val($("#carEndVal").val());
});
