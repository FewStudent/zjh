/**
 * 初始化详情对话框
 */
var TUserEatInfoDlg = {
    tUserEatInfoData: {}
};

/**
 * 清除数据
 */
TUserEatInfoDlg.clearData = function () {
    this.tUserEatInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserEatInfoDlg.set = function (key, val) {
    this.tUserEatInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserEatInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TUserEatInfoDlg.close = function () {
    parent.layer.close(window.parent.TUserEat.layerIndex);
}

/**
 * 收集数据
 */
TUserEatInfoDlg.collectData = function () {
    this
        .set('id')
        .set('createTime')
        .set('updateTime')
        .set('restaurant')
        .set('eatWorkMeal')
        .set('restaurantDate')
        .set('restaurantPeoples')
        .set('restaurantAttention')
        .set('payType')
        .set('status')
        .set('remarkContent')
        .set('remarkName')
        .set('end')
        .set('arrange')
        .set('statusDate')
        .set('endDate')
        .set('sRemarkName')
        .set('sRemarkContent')
        .set('eRemarkName')
        .set('eRemarkContent')
        .set('aRemarkName')
        .set('aRemarkContent')
        .set('eatDinner')
        .set('eatLunch')
        .set('eatPayType')
        .set('eatAddRemark')
        .set('eatAttention')
    ;
}

/**
 * 提交添加
 */
TUserEatInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserEat/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TUserEat.table.refresh();
        TUserEatInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserEatInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TUserEatInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserEat/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TUserEat.table.refresh();
        TUserEatInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserEatInfoData);
    ajax.start();
}

// 提交审核
TUserEatInfoDlg.examineSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserEat/examine_do", function (data) {
        Feng.success("审核成功!");
        window.parent.TUserEat.table.refresh();
        TUserEatInfoDlg.close();
    }, function (data) {
        Feng.error("审核失败!" + data.message + "!");
    });
    ajax.set(this.tUserEatInfoData);
    ajax.start();
}

// 提交结束
TUserEatInfoDlg.endSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserEat/end_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TUserEat.table.refresh();
        TUserEatInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tUserEatInfoData);
    ajax.start();
}

// 提交安排
TUserEatInfoDlg.makeSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserEat/make_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TUserEat.table.refresh();
        TUserEatInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tUserEatInfoData);
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
