/**
 * 初始化详情对话框
 */
var TUserArchivesInfoDlg = {
    tUserArchivesInfoData: {}
};

var ufile = "",
    imgfile = "";

/**
 * 清除数据
 */
TUserArchivesInfoDlg.clearData = function () {
    this.tUserArchivesInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserArchivesInfoDlg.set = function (key, val) {
    this.tUserArchivesInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserArchivesInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TUserArchivesInfoDlg.close = function () {
    parent.layer.close(window.parent.TUserArchives.layerIndex);
}

/**
 * 收集数据
 */
TUserArchivesInfoDlg.collectData = function () {
    this
        .set('id')
        .set('createTime')
        .set('updateTime')
        .set('name')
        .set('activity')
        .set('personalSynopsis')
        .set('role')
        .set('speechTopic')
        .set('speechFile')
        .set('phoneFile')
        .set('accountName')
        .set('accountBlank')
        .set('account')
        .set('remarkName')
        .set('remarkContent')
        .set('status')
        .set('statusDate')
        .set('sRemarkName')
        .set('sRemarkContent')
        .set('eRemarkName')
        .set('eRemarkContent')
        .set('activityStatusRemark')
        .set('activityStatusReamrkName')
        .set('sfile')
        .set('imgfile');
}

/**
 * 提交添加
 */
TUserArchivesInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserArchives/add", function (data) {
        Feng.success("添加成功!");
        window.parent.TUserArchives.table.refresh();
        TUserArchivesInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.message + "!");
    });
    ajax.set(this.tUserArchivesInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TUserArchivesInfoDlg.editSubmit = function () {

    $("#sfile").val(ufile);
    $("#imgfile").val(imgfile);
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserArchives/update", function (data) {
        Feng.success("修改成功!");
        window.parent.TUserArchives.table.refresh();
        TUserArchivesInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.message + "!");
    });
    ajax.set(this.tUserArchivesInfoData);
    ajax.start();
}


//提交审核
TUserArchivesInfoDlg.examineSubmit = function () {
    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUserArchives/examine_do", function (data) {
        Feng.success("审核成功!");
        window.parent.TUserArchives.table.refresh();
        TUserArchivesInfoDlg.close();
    }, function (data) {
        Feng.error("审核失败!" + data.message + "!");
    });
    ajax.set(this.tUserArchivesInfoData);
    ajax.start();
}

$(function () {
    $("#sex").val($("#sexVal").val());
    $("#card").val($("#cardVal").val());
    $('#role').val($('#roleVal').val());
    $('#activityStatus').val($('#activityStatusVal').val());

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
    uploader.on('fileQueued', function (file) {
        var $list = $("#thelist");
        $list.append('<div id="' + file.id + '" class="item">' +
            '<h4 class="info">' + file.name + '</h4>' +
            '</div>');
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
