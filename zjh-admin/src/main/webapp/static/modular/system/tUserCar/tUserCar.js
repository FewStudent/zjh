/**
 * 管理初始化
 */
var TUserCar = {
    id: "TUserCarTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TUserCar.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '所属用户', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '联系电话', field: 'phone', visible: true, align: 'center', valign: 'middle'},
        {title: '接车安排', field: 'jCarArrangeName', visible: true, align: 'center', valign: 'middle'},
        {title: '送车安排', field: 'sCarArrangeName', visible: true, align: 'center', valign: 'middle'},
        {title: '市区安排', field: 'cCarArrangeName', visible: true, align: 'center', valign: 'middle'},
        {title: '接车情况', field: 'jCarSTypeName', visible: true, align: 'center', valign: 'middle'},
        {title: '送车情况', field: 'sCarSTypeName', visible: true, align: 'center', valign: 'middle'},
        {title: '市区情况', field: 'cCarSTypeName', visible: true, align: 'center', valign: 'middle'},
        {title: '用车审核', field: 'carStatusName', visible: true, align: 'center', valign: 'middle'},
        {title: '用车结束', field: 'carEndName', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TUserCar.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TUserCar.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TUserCar.openAddTUserCar = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUserCar/tUserCar_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TUserCar.openTUserCarDetail = function () {
    if (this.check()) {
        var ostatus = this.seItem.carStatus;
        if (ostatus == 1) {
            layer.msg("审核通过的信息，无权修改");
            return;
        }
        var oend = this.seItem.carEnd;
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
            content: Feng.ctxPath + '/tUserCar/tUserCar_update/' + TUserCar.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TUserCar.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserCar/tUserCar_detail/' + TUserCar.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 审核页面
TUserCar.examine = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '审核',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserCar/examine/' + TUserCar.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 结束页面
TUserCar.end = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结束',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserCar/end/' + TUserCar.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 安排页面
TUserCar.make = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '安排',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserCar/make/' + TUserCar.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}
/**
 * 删除
 */
TUserCar.delete = function () {
    if (this.check()) {
        var oid = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tUserCar/delete", function (data) {
                Feng.success("删除成功!");
                TUserCar.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            ajax.set("tUserCarId", oid);
            ajax.start();
        }, function () {
            layer.msg("取消删除操作");
        });
    }
};

/**
 * 查询列表
 */
TUserCar.search = function () {
    var queryData = {};
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    TUserCar.table.refresh({query: queryData});
};

/**
 * 重置
 */
TUserCar.reset = function () {
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

    TUserCar.table.refresh({query: queryData});
}

$(function () {
    var defaultColunms = TUserCar.initColumn();
    var table = new BSTable(TUserCar.id, "/tUserCar/list", defaultColunms);
    table.setPaginationType("client");
    TUserCar.table = table.init();
});
