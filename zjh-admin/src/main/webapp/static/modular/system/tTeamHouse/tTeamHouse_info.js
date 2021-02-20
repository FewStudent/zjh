/**
 * 初始化详情对话框
 */
var TTeamHouseInfoDlg = {
	tTeamHouseInfoData : {}
};

/**
 * 清除数据
 */
TTeamHouseInfoDlg.clearData = function() {
	this.tTeamHouseInfoData = {};
}

/**
 * 设置对话框中的数据
 * 
 * @param key
 *            数据的名称
 * @param val
 *            数据的具体值
 */
TTeamHouseInfoDlg.set = function(key, val) {
	this.tTeamHouseInfoData[key] = (typeof val == "undefined") ? $("#" + key)
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
TTeamHouseInfoDlg.get = function(key) {
	return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TTeamHouseInfoDlg.close = function() {
	parent.layer.close(window.parent.TTeamHouse.layerIndex);
}

/**
 * 收集数据
 */
TTeamHouseInfoDlg.collectData = function() {
	this
	.set('id')
	.set('houseInDate')
	.set('houseOutDate')
	.set('hotelName')
	.set('hotelRoomType')
	.set('houseEnd')
	.set('houseArrange')
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
	.set('hotelVacant')
	.set('end').set('arrange')
	.set('eRemarkName')
	.set('eRemarkContent')
	.set('remark')
	.set('status')
	.set('sRemarkName')
	.set('sRemarkContent').set('houseAddRemark')
}

/**
 * 提交添加
 */
TTeamHouseInfoDlg.addSubmit = function() {

	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/tTeamHouse/add", function(data) {
		Feng.success("添加成功!");
		window.parent.TTeamHouse.table.refresh();
		TTeamHouseInfoDlg.close();
	}, function(data) {
		Feng.error("添加失败!" + data.responseJSON.message + "!");
	});
	ajax.set(this.tTeamHouseInfoData);
	ajax.start();
}

/**
 * 提交修改
 */
TTeamHouseInfoDlg.editSubmit = function() {

	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/tTeamHouse/update", function(data) {
		Feng.success("修改成功!");
		window.parent.TTeamHouse.table.refresh();
		TTeamHouseInfoDlg.close();
	}, function(data) {
		Feng.error("修改失败!" + data.responseJSON.message + "!");
	});
	ajax.set(this.tTeamHouseInfoData);
	ajax.start();
}

// 提交审核
TTeamHouseInfoDlg.examineSubmit = function() {
	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/tTeamHouse/examine_do", function(data) {
		Feng.success("审核成功!");
		window.parent.TTeamHouse.table.refresh();
		TTeamHouseInfoDlg.close();
	}, function(data) {
		Feng.error("审核失败!" + data.message + "!");
	});
	ajax.set(this.tTeamHouseInfoData);
	ajax.start();
}

// 提交结束
TTeamHouseInfoDlg.endSubmit = function() {
	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/tTeamHouse/end_do", function(data) {
		Feng.success("操作成功!");
		window.parent.TTeamHouse.table.refresh();
		TTeamHouseInfoDlg.close();
	}, function(data) {
		Feng.error("操作失败!" + data.message + "!");
	});
	ajax.set(this.tTeamHouseInfoData);
	ajax.start();
}

// 提交安排
TTeamHouseInfoDlg.makeSubmit = function() {
	this.clearData();
	this.collectData();

	// 提交信息
	var ajax = new $ax(Feng.ctxPath + "/tTeamHouse/make_do", function(data) {
		Feng.success("操作成功!");
		window.parent.TTeamHouse.table.refresh();
		TTeamHouseInfoDlg.close();
	}, function(data) {
		Feng.error("操作失败!" + data.message + "!");
	});
	ajax.set(this.tTeamHouseInfoData);
	ajax.start();
}

$(function() {
	$("#sex").val($("#sexVal").val());
	$("#card").val($("#cardVal").val());
	$("#housePayType").val($("#payTypeVal").val());
	$("#houseEnd").val($("#houseEndVal").val());
	$("#houseArrange").val($("#houseArrangeVal").val());
	$("#houseStatus").val($("#houseStatusVal").val());

});
