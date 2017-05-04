layui.use(['layer'], function () {
    var $ = layui.jquery;

    $(function () {
        $("#btn-add-category").click(function () {
            var url = "/user/collect/category/add";
            layer.open({
                type: 2,
                title: '添加分类',
                shadeClose: false,
                btn: ['保存', '取消'],
                shade: 0.8,
                area: ['90%', '80%'],
                offset: ['50px'],
                content: url,
                yes: function (index,layero) {
                    var body = layer.getChildFrame('body', index);
                    var actionForm = $(body).find("#actionForm");
                    var url = "/user/collect/category/addSave";
                    $.ajax({
                        url: url,
                        data: actionForm.serialize(),
                        dataType: 'json',
                        type: 'post',
                        success: function (data) {
                            if(data.code === 0) {
                                layer.closeAll();
                                layer.msg("添加成功");
                                setTimeout("window.location.reload()",1000);
                            }else{
                                layer.msg(data.msg);
                            }
                        }
                    });
                }
            });
        });
    });

    $('.category-edit').on('click', function () {
        var id = $(this).parents('tr').prop('id');
        var url = "/user/collect/category/edit?id=" + id;
        layer.open({
            type: 2,
            title: '编辑分类',
            shadeClose: false,
            btn: ['保存', '取消'],
            shade: 0.8,
            area: ['90%', '80%'],
            offset: ['50px'],
            content: url,
            yes: function (index,layero) {
                var body = layer.getChildFrame('body', index);
                var actionForm = $(body).find("#actionForm");
                var url = "/user/collect/category/editSave";
                $.ajax({
                    url: url,
                    data: actionForm.serialize(),
                    dataType: 'json',
                    type: 'post',
                    success: function (data) {
                        if(data.code === 0) {
                            layer.closeAll();
                            layer.msg("编辑成功");
                            setTimeout("window.location.reload()",1000);
                        }else{
                            layer.msg(data.msg);
                        }
                    }
                });
            }
        });
    });

    $('.category-delete').on('click', function () {
        var id = $(this).parents('tr').prop('id');
        layer.confirm('删除该分类后，该分类所有收藏都转到默认收藏，是否继续？', {
            btn: ['确认','取消'] //按钮
        }, function(){
            layer.msg('确认', {icon: 1});
            var url = "/user/collect/category/delete";
            $.ajax({
                url: url,
                data: {id:id},
                dataType: 'json',
                type: 'post',
                success: function (data) {
                    if(data.code === 0) {
                        layer.closeAll();
                        layer.msg("删除成功");
                        setTimeout("window.location.reload()",1000);
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
        }, function(){

        });
    });
});