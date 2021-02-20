/**
 * 管理初始化
 */
var TUser = {
    id: "TUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
        {title: '修改时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
        {title: '用户姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '性别', field: 'sexName', visible: true, align: 'center', valign: 'middle'},
        {title: '公司/单位', field: 'company', visible: true, align: 'center', valign: 'middle'},
        {title: '职务', field: 'job', visible: true, align: 'center', valign: 'middle'},
        {title: '电话号码', field: 'phone', visible: true, align: 'center', valign: 'middle'},
        {title: '邮件', field: 'email', visible: true, align: 'center', valign: 'middle'},
        {title: '跟随人员', field: 'follow', visible: true, align: 'center', valign: 'middle'},
        {title: '嘉宾对接人', field: 'pickUp', visible: true, align: 'center', valign: 'middle'},
        {title: '证件类型', field: 'certificatesName', visible: true, align: 'center', valign: 'middle'},
        {title: '陪同人员', field: 'accompany', visible: true, align: 'center', valign: 'middle'},
        {title: '翻译人员', field: 'translate', visible: true, align: 'center', valign: 'middle'}
        // {title: '用车审核', field: 'carStatus', visible: true, align: 'center', valign: 'middle'},
        // {title: '用餐审核', field: 'eatStatus', visible: true, align: 'center', valign: 'middle'},
        // {title: '住房审核', field: 'houseStatus', visible: true, align: 'center', valign: 'middle'},
        // {title: '档案审核', field: 'activityStatus', visible: true, align: 'center', valign: 'middle'},
        // {title: '用餐结束', field: 'eatEnd', visible: true, align: 'center', valign: 'middle'},
        // {title: '住房结束', field: 'houseEnd', visible: true, align: 'center', valign: 'middle'},
        // {title: '用车结束', field: 'carEnd', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TUser.openAddTUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUser/tUser_add'
    });
    layer.full(index);
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
TUser.openTUserDetail = function () {

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
            title: '更新',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/tUser_update/' + TUser.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
};

TUser.detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/tUser_detail/' + TUser.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

/**
 * 删除
 */
TUser.delete = function () {
    if (this.check()) {
        var id = this.seItem.id;
        layer.confirm("确定删除？", {title: '删除确认', btn: ['确定', '取消']}, function (index) {
            layer.close(index);
            var ajax = new $ax(Feng.ctxPath + "/tUser/delete", function (data) {
                Feng.success("删除成功!");
                TUser.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            ajax.set("tUserId", id);
            ajax.start();
        }, function (index) {
            layer.msg("取消删除操作")
        });
    }
};

/**
 * 查询列表
 */
TUser.search = function () {
    var queryData = {};
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TUser.table.refresh({query: queryData});
};

/**
 * 重置
 */
TUser.reset = function () {
    $('#filed1').val("");
    $('#filed2').val("");
    $('#value1').val("");
    $('#value2').val("");
    var queryData = {};
    queryData['filed1'] = $("#filed1").val();
    queryData['filed2'] = $("#filed2").val();
    queryData['value1'] = $("#value1").val();
    queryData['value2'] = $("#value2").val();
    TUser.table.refresh({query: queryData})
}

//用车添加页面
TUser.addCar = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/car_add/' + TUser.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

//用餐添加页面
TUser.addEat = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/eat_add/' + TUser.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

//住房添加页面
TUser.addHouse = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/house_add/' + TUser.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

//档案添加页面
TUser.addArchive = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/archive_add/' + TUser.seItem.id
        });
        layer.full(index);
        this.layerIndex = index;
    }
}

// 导入页面
TUser.include = function () {
    var index = layer.open({
        type: 2,
        title: '导入',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUser/include_html/'
    });
    layer.full(index);
    this.layerIndex = index;
}


$(function () {
    var defaultColunms = TUser.initColumn();
    var table = new BSTable(TUser.id, "/tUser/list", defaultColunms);
    table.setPaginationType("client");
    TUser.table = table.init();
});
