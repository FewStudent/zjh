/**
 * 初始化详情对话框
 */
var TTeamEatInfoDlg = {
    tTeamEatInfoData: {}
};

/**
 * 清除数据
 */
TTeamEatInfoDlg.clearData = function () {
    this.tTeamEatInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
TTeamEatInfoDlg.set = function (key, val) {
    this.tTeamEatInfoData[key] = (typeof val == "undefined") ? $("#" + key)
        .val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
TTeamEatInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TTeamEatInfoDlg.close = function () {
    parent.layer.close(window.parent.TTeamEat.layerIndex);
}

/**
 * 收集数据
 */
TTeamEatInfoDlg.collectData = function () {
    this.set('id')
        .set('end')
        .set('remarkName')
        .set('remarkContent')
        .set('eatDinner').set('eatLunch').set('eatWorkMeal').set('eatPayType').set('createTime')
        .set('updateTime').set('eatAddRemark').set('eatAttention').set('teamId').set('restaurant')
        .set('restaurantDate').set('restaurantPeoples')
        .set('restaurantAttention').set('payType').set('status')
        .set('arrange')
        .set('statusDate').set('endDate').set('sRemarkName')
        .set('sRemarkContent').set('eRemarkName').set('eRemarkContent')
        .set('aRemarkName').set('aRemarkContent').set('company');
}

/**
 * 提交添加
 */
TTeamEatInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamEat/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TTeamEat.table.refresh();
        TTeamEatInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tTeamEatInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TTeamEatInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamEat/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TTeamEat.table.refresh();
        TTeamEatInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tTeamEatInfoData);
    ajax.start();
}

// 提交审核
TTeamEatInfoDlg.examineSubmit = function () {
    this.clearData();
    this.collectData();

    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamEat/examine_do", function (data) {
        Feng.success("审核成功!");
        window.parent.TTeamEat.table.refresh();
        TTeamEatInfoDlg.close();
    }, function (data) {
        Feng.error("审核失败!" + data.message + "!");
    });
    ajax.set(this.tTeamEatInfoData);
    ajax.start();
}

// 提交结束
TTeamEatInfoDlg.endSubmit = function () {
    this.clearData();
    this.collectData();

    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamEat/end_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TTeamEat.table.refresh();
        TTeamEatInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tTeamEatInfoData);
    ajax.start();
}

// 提交安排
TTeamEatInfoDlg.makeSubmit = function () {
    this.clearData();
    this.collectData();

    // 提交信息
    var ajax = new $ax(Feng.ctxPath + "/tTeamEat/make_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TTeamEat.table.refresh();
        TTeamEatInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tTeamEatInfoData);
    ajax.start();
}

$(function () {
    $("#sex").val($("#sexVal").val());
    $("#card").val($("#cardVal").val());
    $("#eatDinner").val($("#eatDinnerVal").val());
    $("#eatPayType").val($("#eatPayTypeVal").val());

    $('#eatStatus').val($('#eatStatusVal').val());
    $('#eatEnd').val($('#eatEndVal').val());
    $('#eatArrange').val($('#eatStatusVal').val());
});
