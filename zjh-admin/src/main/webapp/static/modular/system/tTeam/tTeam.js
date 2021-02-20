/**
 * 管理初始化
 */
var TTeam = {
    id: "TTeamTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TTeam.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '修改时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
        {title: '公司名称', field: 'company', visible: true, align: 'center', valign: 'middle'},
        {title: '负责人', field: 'companyLeader', visible: true, align: 'center', valign: 'middle'},
        {title: '嘉宾对接人', field: 'pickUp', visible: true, align: 'center', valign: 'middle'},
        {title: '团队证件', field: 'certificatesName', visible: true, align: 'center', valign: 'middle'},
        {title: '所属区域', field: 'area', visible: true, align: 'center', valign: 'middle'},
        {title: '团队人数', field: 'teamNums', visible: true, align: 'center', valign: 'middle'},
        {title: '团队联系人', field: 'linkUser', visible: true, align: 'center', valign: 'middle'},
        {title: '联系人电话', field: 'linkPhone', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TTeam.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TTeam.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TTeam.openAddTTeam = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tTeam/tTeam_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TTeam.openTTeamDetail = function () {
    if (this.check()) {

        var ohousestatus = this.seItem.houseStatus,
            ocarstuats = this.seItem.carStatus,
            oeatStatus = this.seItem.eatStatus,
            oactivityStatus = this.seItem.activityStatus;

        console.log(ohousestatus + "," + ocarstuats + "," + oeatStatus + "," + oactivityStatus)
        if (ohousestatus == 1 || ocarstuats == 1 || oeatStatus == 1 || oactivityStatus == 1) {
            layer.msg("存在审核通过的信息，无权修改");
            return;
        }

        var ohouseend = this.seItem.houseEnd,
            ocarEnd = this.seItem.carEnd,
            oeatEnd = this.seItem.eatEnd;

        if (ohouseend == 1 || ocarEnd == 1 || oeatEnd == 1) {
            layer.msg("存在已经结束的信息，无权修改");
            return;
        }

        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeam/tTeam_update/' + TTeam.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TTeam.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeam/tTeam_detail/' + TTeam.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

/**
 * 删除
 */
TTeam.delete = function () {
    if (this.check()) {
        var oid = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tTeam/delete", function (data) {
                Feng.success("删除成功!");
                TTeam.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            ajax.set("tTeamId", oid);
            ajax.start();
        }, function () {
            layer.msg("取消删除操作");
        });
    }
};


//用车添加页面
TTeam.addCar = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeam/car_add/' + TTeam.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

//用餐添加页面
TTeam.addEat = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeam/eat_add/' + TTeam.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

//住房添加页面
TTeam.addHouse = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeam/house_add/' + TTeam.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

//档案添加页面
TTeam.addArchive = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tTeam/archive_add/' + TTeam.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 导入页面
TTeam.include = function () {
    var index = layer.open({
        type: 2,
        title: '导入',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tTeam/include_html/'
    });
    layer.full(index);
    this.layerIndex = index;
}

// 导出
// TTeam.exclude = function () {
//
//     var ajax = new $ax(Feng.ctxPath + "/tTeam/exclude", function (data) {
//         Feng.success("导出成功!");
//         TTeam.table.refresh();
//     }, function (data) {
//         Feng.error("导出失败!" + data.message + "!");
//     });
//     ajax.start();
// }

/**
 * 查询列表
 */
TTeam.search = function () {
    var queryData = {};
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TTeam.table.refresh({query: queryData});
};

/**
 * 重置
 */
TTeam.reset = function () {
    $('#filed1').val("");
    $('#filed2').val("");
    $('#value1').val("");
    $('#value2').val("");
    var queryData = {};
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TTeam.table.refresh({query: queryData});
}

$(function () {
    var defaultColunms = TTeam.initColumn();
    var table = new BSTable(TTeam.id, "/tTeam/list", defaultColunms);
    table.setPaginationType("client");
    TTeam.table = table.init();
});
