//获取请求参数
function getQueryString(key) {
    var reg = new RegExp("(^|&)"+key+"=([^&]*)(&|$)");
    var result = window.location.search.substr(1).match(reg);
    return result?decodeURIComponent(result[2]):null;
}

var url = getQueryString("url");

$("#collect-title").val(getQueryString("title"));
$("#collect-url").val(url);
$("#collect-description").val(getQueryString("description"));

function getBase64Image(img) {
    var canvas = document.createElement("canvas");
    canvas.width = img.width;
    canvas.height = img.height;
    var ctx = canvas.getContext("2d");
    ctx.drawImage(img, 0, 0, img.width, img.height);
    var ext = img.src.substring(img.src.lastIndexOf(".")+1).toLowerCase();
    var dataURL = canvas.toDataURL("image/"+ext);
    return dataURL;
}
console.log("url:"+url);
if(url) {
    var img = "/user/collect/favicon.ioc?domain="+url;
    var image = new Image();
    image.src = img;
    image.onload = function () {
        var base64 = getBase64Image(image);
        $("#favicon").attr('src', base64);
        $('#collect-favicon').val(base64);
    };
}

//提交
layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form()
        ,layer = layui.layer;
    //监听提交
    form.on('submit(collect)', function(data){
        var url = "/user/collect/addCollect";
        console.log(JSON.stringify(data.field));
        $.ajax({
            url: url,
            data: data.field,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                if(data.code===0) {
                    layer.msg("添加成功！，3秒后自动关闭");
                    setTimeout("window.close()", 3000);
                }else{
                    layer.msg(data.msg);
                }
            }
        });
        return false;
    });


});
