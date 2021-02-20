/**
 * 初始化详情对话框
 */
var TUserCarInfoDlg = {
    tUserCarInfoData: {}
};

/**
 * 清除数据
 */
TUserCarInfoDlg.clearData = function () {
    this.tUserCarInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserCarInfoDlg.set = function (key, val) {
    this.tUserCarInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserCarInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TUserCarInfoDlg.close = function () {
    parent.layer.close(window.parent.TUserCar.layerIndex);
}

/**
 * 收集数据
 */
TUserCarInfoDlg.collectData = function () {
    this
        .set('id')
        .set('jUseCarDate')
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
        .set('carEnd')
        .set('jCarCard')
        .set('sCarCard')
        .set('cCarCard')
        .set('end')
        .set("eRemarkName")
        .set('eRemarkContent')
        .set('status');
}

/**
 * 提交添加
 */
TUserCarInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserCar/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TUserCar.table.refresh();
        TUserCarInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserCarInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TUserCarInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserCar/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TUserCar.table.refresh();
        TUserCarInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserCarInfoData);
    ajax.start();
}

// 提交审核
TUserCarInfoDlg.examineSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserCar/examine_do", function (data) {
        Feng.success("审核成功!");
        window.parent.TUserCar.table.refresh();
        TUserCarInfoDlg.close();
    }, function (data) {
        Feng.error("审核失败!" + data.message + "!");
    });
    ajax.set(this.tUserCarInfoData);
    ajax.start();
}

// 提交结束
TUserCarInfoDlg.endSubmit = function () {
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserCar/end_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TUserCar.table.refresh();
        TUserCarInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tUserCarInfoData);
    ajax.start();
}

// 提交安排
TUserCarInfoDlg.makeSubmit = function(){
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserCar/make_do", function (data) {
        Feng.success("操作成功!");
        window.parent.TUserCar.table.refresh();
        TUserCarInfoDlg.close();
    }, function (data) {
        Feng.error("操作失败!" + data.message + "!");
    });
    ajax.set(this.tUserCarInfoData);
    ajax.start();
}

$(function() {
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

    laydate.render({
		elem : '#jUseCarDate'
	});
	
	laydate.render({
		elem : '#jUseCarTime',
		type : 'time'
	});
	
	laydate.render({
		elem : '#sUseCarDate'
	});
	
	laydate.render({
		elem : '#sUseCarTime',
		type : 'time'
	});
	

	laydate.render({
		elem : '#cUseCarDate'
	});
	
	laydate.render({
		elem : '#cUseCarTime',
		type : 'time'
	});
})
