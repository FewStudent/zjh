/**
 * 管理初始化
 */
var TUserEat = {
    id: "TUserEatTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TUserEat.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '用户姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '联系电话', field: 'phone', visible: true, align: 'center', valign: 'middle'},
        {title: '是否晚宴', field: 'eatDinnerName', visible: true, align: 'center', valign: 'middle'},
        {title: '午餐数', field: 'eatLunch', visible: true, align: 'center', valign: 'middle'},
        {title: '工作餐数', field: 'eatWorkMeal', visible: true, align: 'center', valign: 'middle'},
        {title: '用餐注意事项', field: 'eatAttention', visible: true, align: 'center', valign: 'middle'},
        {title: '费用承担方式', field: 'eatPayTypeName', visible: true, align: 'center', valign: 'middle'},
        {title: '审核状态', field: 'eatStatusName', visible: true, align: 'center', valign: 'middle'},
        //{title: '审核时间', field: 'eatStatusDate', visible: true, align: 'center', valign: 'middle'},
        {title: '是否结束', field: 'eatEndName', visible: true, align: 'center', valign: 'middle'},
        {title: '安排情况', field: 'eatArrangeName', visible: true, align: 'center', valign: 'middle'},
        //{title: '结束时间', field: 'endDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TUserEat.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TUserEat.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TUserEat.openAddTUserEat = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUserEat/tUserEat_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TUserEat.openTUserEatDetail = function () {
    if (this.check()) {
        var ostatus = this.seItem.eatStatus;
        if (ostatus == 1) {
            layer.msg("审核通过的信息，无权修改");
            return;
        }
        var oend = this.seItem.eatEnd;
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
            content: Feng.ctxPath + '/tUserEat/tUserEat_update/' + TUserEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TUserEat.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserEat/tUserEat_detail/' + TUserEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 审核页面
TUserEat.examine = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '审核',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserEat/examine/' + TUserEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;

    }
}

// 结束页面
TUserEat.end = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结束',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserEat/end/' + TUserEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 安排页面
TUserEat.make = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结束',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserEat/make/' + TUserEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

/**
 * 删除
 */
TUserEat.delete = function () {
    if (this.check()) {
        var oid = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tUserEat/delete", function (data) {
                Feng.success("删除成功!");
                TUserEat.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            ajax.set("tUserEatId", oid);
            ajax.start();
        }, function () {
            layer.msg("取消删除操作");
        });

    }
};

/**
 * 查询列表
 */
TUserEat.search = function () {
    var queryData = {};
    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    queryData['search'] = $("#search").val();
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TUserEat.table.refresh({query: queryData});
};

TUserEat.reset = function () {
    $('#filed1').val("");
    $('#filed2').val("");
    $('#value1').val("");
    $('#value2').val("");
    $("#search").val("");

    $("#end").val(-1);
    $("#status").val(-1);
    var queryData = {};

    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    queryData['search'] = $("#search").val();
    TUserEat.table.refresh({query: queryData});
}

$(function () {
    var defaultColunms = TUserEat.initColumn();
    var table = new BSTable(TUserEat.id, "/tUserEat/list", defaultColunms);
    table.setPaginationType("client");
    TUserEat.table = table.init();
});
