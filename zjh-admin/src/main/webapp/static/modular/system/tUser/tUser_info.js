/**
 * 初始化详情对话框
 */
var TUserInfoDlg = {
    tUserInfoData: {}
};

var ufile = "",
    imgfile = "";

/**
 * 清除数据
 */
TUserInfoDlg.clearData = function () {
    this.tUserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserInfoDlg.set = function (key, val) {
    this.tUserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TUserInfoDlg.close = function () {
    parent.layer.close(window.parent.TUser.layerIndex);
}

/**
 * 收集数据
 */
TUserInfoDlg.collectData = function () {
    this
        .set('id')
        .set('createTime')
        .set('updateTime')
        .set('name')
        .set('sex')
        .set('company')
        .set('job')
        .set('phone')
        .set('email')
        .set('follow')
        .set('pickUp')
        .set('card')
        .set('linkPhone')
        .set('accompany')
        .set('translater')
        .set('translate')
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
        .set('cUseCarDate')
        .set('cUseCarTime')
        .set('cRidePlace')
        .set('cDestination')
        .set('cRidePeoples')
        .set('cAccompanyLeader')
        .set('cPayType')
        .set('cHasStopCard')
        .set('cAddRemark')
        .set('eatDinner')
        .set('eatLunch')
        .set('eatWorkMeal')
        .set('eatPayType')
        .set('eatAddRemark')
        .set('eatAttention')
        .set('houseInDate')
        .set('hotelName')
        .set('hotelRoomNum')
        .set('hotelRoomType')
        .set('hotelVacant')
        .set('price')
        .set('totalPrice')
        .set('houseOutDate')
        .set('roomTotal')
        .set('spliceRoom')
        .set('splicePeople')
        .set('housePayType')
        .set('houseAddRemark')
        .set('activity')
        .set('accountName')
        .set('accountBlank')
        .set('account')
        .set('personalSynopsis')
        .set('role')
        .set('speechTopic')
        .set('activityAddRemark')
        .set('activityAddRemarkName')
        .set('sfile')
        .set('imgfile');
}

/**
 * 提交添加
 */
TUserInfoDlg.addSubmit = function () {

    $("#sfile").val(ufile);
    $("#imgfile").val(imgfile);

    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUser/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TUser.table.refresh();
        TUserInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.message + "!");
    });
    ajax.set(this.tUserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TUserInfoDlg.editSubmit = function () {

    $("#sfile").val(ufile);
    $("#imgfile").val(imgfile);

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUser/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TUser.table.refresh();
        TUserInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserInfoData);
    ajax.start();
}

// 导入
TUserInfoDlg.includeSubmit = function(){
    var formData = new FormData($('#uploadForm')[0]);
    $.ajax({
        type: 'post',
        url: Feng.ctxPath + '/tUser/include',
        data: formData,
        dataType: 'json',
        cache: false,
        processData: false,
        contentType: false,
        success: function (result) {
            if (result.code == 200) {
                layer.msg("添加成功");
            } else {
                layer.msg("添加失败");
            }
            window.parent.TUser.table.refresh();
            TUserInfoDlg.close();
        }, error: function (xhr) {
            console.log(xhr);
        }
    });
}

/**
 * 档案添加
 */
TUserInfoDlg.addArchiveSubmit = function () {
    var formData = $("#archiveF").serialize();
    formData = formData + "&sfile=" + ufile + "&imgfile=" + imgfile;
    $.ajax({
        type: 'post',
        url: Feng.ctxPath + '/tUserArchives/add',
        data: formData,
        dataType: 'json',
        success: function (result) {
            if (result.code == 200) {
                layer.msg("添加成功");
            } else {
                layer.msg("添加失败");
            }
            TUserInfoDlg.close();
        }, error: function (xhr) {
            console.log(xhr);
        }
    });
}

/**
 * 用车添加
 */
TUserInfoDlg.addCarSubmit = function(){
    var formData = $("#carF").serialize();
    $.ajax({
        type: 'post',
        url: Feng.ctxPath + '/tUserCar/add',
        data: formData,
        dataType: 'json',
        success: function (result) {
            if (result.code == 200) {
                layer.msg("添加成功");
            } else {
                layer.msg("添加失败");
            }
            TUserInfoDlg.close();
        }, error: function (xhr) {
            console.log(xhr);
        }
    });
}

/**
 * 用餐添加
 */
TUserInfoDlg.addEatSubmit = function(){
    var formData = $("#eatF").serialize();
    $.ajax({
        type: 'post',
        url: Feng.ctxPath + '/tUserEat/add',
        data: formData,
        dataType: 'json',
        success: function (result) {
            if (result.code == 200) {
                layer.msg("添加成功");
            } else {
                layer.msg("添加失败");
            }
            TUserInfoDlg.close();
        }, error: function (xhr) {
            console.log(xhr);
        }
    });
}

/**
 * 住房添加
 */
TUserInfoDlg.addHouseSubmit = function(){
    var formData = $("#houseF").serialize();
    $.ajax({
        type: 'post',
        url: Feng.ctxPath + '/tUserHouse/add',
        data: formData,
        dataType: 'json',
        success: function (result) {
            if (result.code == 200) {
                layer.msg("添加成功");
            } else {
                layer.msg("添加失败");
            }
            TUserInfoDlg.close();
        }, error: function (xhr) {
            console.log(xhr);
        }
    });
}

$(function () {

    // 修改页面赋值
    $("#sex").val($("#sexVal").val());
    $("#card").val($("#cardVal").val());
    $("#accompanyVal").val($("#accompanyValVal").val());
    $("#translate").val($("#translateVal").val());
    $("#jPayType").val($("#jPayTypeVal").val());
    $("#jHasStopCard").val($("#jHasStopCardVal").val());
    $("#sPayType").val($("#sPayTypeVal").val());
    $("#sHasStopCard").val($("#sHasStopCardVal").val());
    $("#cPayType").val($("#cPayTypeVal").val());
    $("#cHasStopCard").val($("#cHasStopCardVal").val());
    $("#eatDinner").val($("#eatDinnerVal").val());
    $("#eatPayType").val($("#eatPayTypeVal").val()); 
    $("#spliceRoom").val($("#spliceRoomVal").val()); 
    $("#housePayType").val($("#housePayTypeVal").val()); 
    $("#role").val($("#roleVal").val()); 

    var uploader = WebUploader.create({
        auto: true,
        // 文件接收服务端。
        server: Feng.ctxPath + '/file/upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false
    });
    // 当有文件被添加进队列的时候
    uploader.on( 'fileQueued', function( file ) {
        var $list = $("#thelist");
        $list.append( '<div id="' + file.id + '" class="item">' +
            '<h4 class="info">' + file.name + '</h4>' +
            '</div>' );
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, response) {
        console.log(response);
        $("#" + file.id).attr("fileSrc", response.id);
        if (ufile == "") {
            ufile = ufile + response.id;
        } else {
            ufile = ufile + "," + response.id;
        }
    });


    var uploader1 = WebUploader.create({
        auto: true,
        // 文件接收服务端。
        server: Feng.ctxPath + '/file/upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker',
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    // 当有文件被添加进队列的时候
    // 当有文件添加进来的时候
    uploader1.on('fileQueued', function (file) {
        var $li = $(
            '<div id="' + file.id + '" class="file-item img-item col-xs-2">' +
            '<img style="height: 115px;width: 100%">' +
            '</div>'
            ),
            $img = $li.find('img');
        // $list为容器jQuery实例
        $("#fileList").append($li)

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader1.makeThumb(file, function (error, src) {
            if (error) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }
            $img.attr('src', src);
        }, 100, 115);
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader1.on('uploadSuccess', function (file, response) {
        console.log(response);
        $("#" + file.id).attr("fileSrc", response.id);
        if (imgfile == "") {
            imgfile = imgfile + response.id;
        } else {
            imgfile = imgfile + "," + response.id;
        }
    });

});
