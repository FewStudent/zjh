/**
 * 管理初始化
 */
var TTeamHouse = {
    id: "TTeamHouseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TTeamHouse.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '所属团队', field: 'company', visible: true, align: 'center', valign: 'middle'},
        {title: '联系电话', field: 'linkPhone', visible: true, align: 'center', valign: 'middle'},

        {title: '酒店', field: 'hotelName', visible: true, align: 'center', valign: 'middle'},
        {title: '入住日期', field: 'houseInDate', visible: true, align: 'center', valign: 'middle'},
        {title: '退房日期', field: 'houseOutDate', visible: true, align: 'center', valign: 'middle'},
        {title: '房间类型', field: 'hotelRoomType', visible: true, align: 'center', valign: 'middle'},
        {title: '单价', field: 'price', visible: true, align: 'center', valign: 'middle'},
        {title: '房间数', field: 'roomTotal', visible: true, align: 'center', valign: 'middle'},
        {title: '总价', field: 'totalPrice', visible: true, align: 'center', valign: 'middle'},
        {title: '费用承担方式', field: 'housePayTypeName', visible: true, align: 'center', valign: 'middle'},
        {title: '房间号', field: 'hotelRoomNum', visible: true, align: 'center', valign: 'middle'},
        {title: '空置床位', field: 'hotelVacant', visible: true, align: 'center', valign: 'middle'},
        {title: '是否拼房', field: 'spliceRoom', visible: true, align: 'center', valign: 'middle'},
        {title: '拼房人姓名', field: 'splicePeople', visible: true, align: 'center', valign: 'middle'},
        {title: '审核状态', field: 'houseStatusName', visible: true, align: 'center', valign: 'middle'},
        {title: '是否结束', field: 'houseEndName', visible: true, align: 'center', valign: 'middle'},
        {title: '安排情况', field: 'houseArrangeName', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
TTeamHouse.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TTeamHouse.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TTeamHouse.openAddTTeamHouse = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tTeamHouse/tTeamHouse_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TTeamHouse.openTTeamHouseDetail = function () {
    if (this.check()) {
        var ostatus = this.seItem.houseStatus;
        if (ostatus == 1) {
            layer.msg("审核通过的信息，无权修改");
            return;
        }
        var oend = this.seItem.houseEnd;
        if (oend == 1) {
            layer.msg("已经结束的信息，无权修改");
            return;
        }
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamHouse/tTeamHouse_update/' + TTeamHouse.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TTeamHouse.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamHouse/tTeamHouse_detail/' + TTeamHouse.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 审核页面
TTeamHouse.examine = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '审核',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamHouse/examine/' + TTeamHouse.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 结束页面
TTeamHouse.end = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结束',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamHouse/end/' + TTeamHouse.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 安排页面
TTeamHouse.make = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '安排',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamHouse/make/' + TTeamHouse.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}
/**
 * 删除
 */
TTeamHouse.delete = function () {
    if (this.check()) {
        var oid = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tTeamHouse/delete", function (data) {
                Feng.success("删除成功!");
                TTeamHouse.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            ajax.set("tTeamHouseId", oid);
            ajax.start();
        }, function () {
            layer.msg("取消删除操作");
        });
    }
};

/**
 * 查询列表
 */
TTeamHouse.search = function () {
    var queryData = {};
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    TTeamHouse.table.refresh({query: queryData});
};

/**
 * 重置
 */
TTeamHouse.reset = function () {
    $("#end").val(-1);
    $("#status").val(-1);

    $('#filed1').val("");
    $('#filed2').val("");
    $('#value1').val("");
    $('#value2').val("");
    var queryData = {};

    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();

    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    TTeamHouse.table.refresh({query: queryData});
}

$(function () {
    var defaultColunms = TTeamHouse.initColumn();
    var table = new BSTable(TTeamHouse.id, "/tTeamHouse/list", defaultColunms);
    table.setPaginationType("client");
    TTeamHouse.table = table.init();
});
