/**
 * 管理初始化
 */
var TTeamEat = {
    id: "TTeamEatTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TTeamEat.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '所属团队', field: 'company', visible: true, align: 'center', valign: 'middle'},
        {title: '联系电话', field: 'linkPhone', visible: true, align: 'center', valign: 'middle'},
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
TTeamEat.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TTeamEat.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TTeamEat.openAddTTeamEat = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tTeamEat/tTeamEat_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TTeamEat.openTTeamEatDetail = function () {
    if (this.check()) {
        var ostatus = this.seItem.eatStatus;
        if (ostatus == 1) {
            layer.msg("审核通过的信息，无权修改");
            return;
        }
        var oend = this.seItem.eatEnd;
        console.log(oend);
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
            content: Feng.ctxPath + '/tTeamEat/tTeamEat_update/' + TTeamEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TTeamEat.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamEat/tTeamEat_detail/' + TTeamEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 审核
TTeamEat.examine = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '审核',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamEat/examine/' + TTeamEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

TTeamEat.ends = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结束',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamEat/end/' + TTeamEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 结束页面
TTeamEat.end = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '结束',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamEat/end/' + TTeamEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}



// 安排页面
TTeamEat.make = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '安排',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeamEat/make/' + TTeamEat.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

/**
 * 删除
 */
TTeamEat.delete = function () {
    if (this.check()) {
        var oid = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tTeamEat/delete", function (data) {
                Feng.success("删除成功!");
                TTeamEat.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            ajax.set("tTeamEatId", oid);
            ajax.start();
        }, function () {
            layer.msg("取消删除操作");
        });

    }
};

/**
 * 查询列表
 */
TTeamEat.search = function () {
    var queryData = {};
    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    queryData['search'] = $("#search").val();
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TTeamEat.table.refresh({query: queryData});
};

TTeamEat.reset = function () {
    var queryData = {};
    $("#end").val(-1);
    $("#status").val(-1);

    $('#filed1').val("");
    $('#filed2').val("");
    $('#value1').val("");
    $('#value2').val("");

    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();

    queryData['status'] = $("#status").val();
    queryData['end'] = $("#end").val();
    TTeamEat.table.refresh({query: queryData});
}

$(function () {
    var defaultColunms = TTeamEat.initColumn();
    var table = new BSTable(TTeamEat.id, "/tTeamEat/list", defaultColunms);
    table.setPaginationType("client");
    TTeamEat.table = table.init();
});
