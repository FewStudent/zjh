/**
 * 初始化详情对话框
 */
var TUserHouseInfoDlg = {
    tUserHouseInfoData: {}
};

/**
 * 清除数据
 */
TUserHouseInfoDlg.clearData = function () {
    this.tUserHouseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserHouseInfoDlg.set = function (key, val) {
    this.tUserHouseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserHouseInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TUserHouseInfoDlg.close = function () {
    parent.layer.close(window.parent.TUserHouse.layerIndex);
}

/**
 * 收集数据
 */
TUserHouseInfoDlg.collectData = function () {
    this
        .set('id')
        .set('arrange')
        .set('houseInDate')
        .set('houseOutDate')
        .set('hotelName')
        .set('hotelRoomType')
        .set('price')
        .set('roomTotal')
        .set('housePayType')
        .set('totalPrice')
        .set('spliceRoom')
        .set('splicePeople')
        .set('houseStatusRemark')
        .set('houseStatusReamrkName')
        .set('houseStatus')
        .set('houseEndRemarkName')
        .set('houseEndRemark')
        .set('houseArrangeRemark')
        .set('hotelRoomNum')
        .set('status')
        .set('sRemarkName')
        .set('sRemarkContent')
        .set('hotelVacant')
        .set('end')
        .set('eRemarkName')
        .set('eRemarkContent')
        .set('houseAddRemark');
       
        
}

/**
 * 提交添加
 */
TUserHouseInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserHouse/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TUserHouse.table.refresh();
        TUserHouseInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserHouseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TUserHouseInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserHouse/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TUserHouse.table.refresh();
        TUserHouseInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserHouseInfoData);
    ajax.start();
}

// 提交审核
TUserHouseInfoDlg.examineSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserHouse/examine_do", function (data) {
        Feng.success("审核成功!");
        window.parent.TUserHouse.table.refresh();
        TUserHouseInfoDlg.close();
    }, function (data) {
        Feng.error("审核失败!" + data.message + "!");
    });
    ajax.set(this.tUserHouseInfoData);
    ajax.start();
}

// 提交结束
TUserHouseInfoDlg.endSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserHouse/end_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TUserHouse.table.refresh();
        TUserHouseInfoDlg.close();
    }, function (data) {
        Feng.error("审操作失败!" + data.message + "!");
    });
    ajax.set(this.tUserHouseInfoData);
    ajax.start();
}

// 提交安排
TUserHouseInfoDlg.makeSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserHouse/make_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TUserHouse.table.refresh();
        TUserHouseInfoDlg.close();
    }, function (data) {
        Feng.error("审操作失败!" + data.message + "!");
    });
    ajax.set(this.tUserHouseInfoData);
    ajax.start();
}

$(function () {
    $("#sex").val($("#sexVal").val());
    $("#card").val($("#cardVal").val());
    $("#housePayType").val($("#payTypeVal").val());
    $("#houseEnd").val($("#houseEndVal").val());
    $("#houseArrange").val($("#houseArrangeVal").val());
    $("#houseStatus").val($("#houseStatusVal").val());
});
