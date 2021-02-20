/**
 * 管理初始化
 */
var TUserArchives = {
    id: "TUserArchivesTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TUserArchives.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '所属用户', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '活动', field: 'activity', visible: true, align: 'center', valign: 'middle'},
        {title: '简介', field: 'personalSynopsis', visible: true, align: 'center', valign: 'middle'},
        {title: '角色', field: 'roleName', visible: true, align: 'center', valign: 'middle'},
        {title: '演讲主题', field: 'speechTopic', visible: true, align: 'center', valign: 'middle'},
        {title: '开户姓名', field: 'accountName', visible: true, align: 'center', valign: 'middle'},
        {title: '开户行', field: 'accountBlank', visible: true, align: 'center', valign: 'middle'},
        {title: '开户账号', field: 'account', visible: true, align: 'center', valign: 'middle'},
        {title: '审核状态', field: 'activityStatusName', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
TUserArchives.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TUserArchives.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TUserArchives.openAddTUserArchives = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUserArchives/tUserArchives_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TUserArchives.openTUserArchivesDetail = function () {
    if (this.check()) {
        var ostatus = this.seItem.activityStatus;
        if (ostatus == 1) {
            layer.msg("审核通过的信息，无权修改");
            return;
        }
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserArchives/tUserArchives_update/' + TUserArchives.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TUserArchives.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserArchives/tUserArchives_detail/' + TUserArchives.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 审核页面
TUserArchives.examine = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '审核',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUserArchives/examine/' + TUserArchives.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

/**
 * 删除
 */
TUserArchives.delete = function () {
    if (this.check()) {
        var oid = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tUserArchives/delete", function (data) {
                Feng.success("删除成功!");
                TUserArchives.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("tUserArchivesId", oid);
            ajax.start();
        }, function () {
            layer.msg("取消删除操作");
        });

    }
};

/**
 * 查询列表
 */
TUserArchives.search = function () {
    var queryData = {};
    queryData['status'] = $("#status").val();
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TUserArchives.table.refresh({query: queryData});
};

TUserArchives.reset = function () {
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

    TUserArchives.table.refresh({query:queryData});

}

$(function () {
    var defaultColunms = TUserArchives.initColumn();
    var table = new BSTable(TUserArchives.id, "/tUserArchives/list", defaultColunms);
    table.setPaginationType("client");
    TUserArchives.table = table.init();
});
