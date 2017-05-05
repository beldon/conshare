$(function () {
    loadData();

    $("#refresh").click(function () {
        loadData();
    });

    $("body").on("click", ".collect-edit", function () {
        var id = $(this).parent().prop('id');
        var url = "/user/collect/edit?id=" + id;
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
                var url = "/user/collect/editSave";
                $.ajax({
                    url: url,
                    data: actionForm.serialize(),
                    dataType: 'json',
                    type: 'post',
                    success: function (data) {
                        if(data.code === 0) {
                            layer.closeAll();
                            layer.msg("编辑成功");
                            loadData();
                        }else{
                            layer.msg(data.msg);
                        }
                    }
                });
            }
        });
    });

    $("body").on("click", ".collect-delete", function () {
        var id = $(this).parent().prop('id');
        layer.confirm('删除该分类后，该分类所有收藏都转到默认收藏，是否继续？', {
            btn: ['确认','取消'] //按钮
        }, function(){
            var url = "/user/collect/delete";
            $.ajax({
                url: url,
                data: {id:id},
                dataType: 'json',
                type: 'post',
                success: function (data) {
                    if(data.code === 0) {
                        layer.closeAll();
                        layer.msg("删除成功");
                        loadData();
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
        }, function(){

        });
    });
});


var loadData = function () {
    var catId = $('#catId').val();
    var url = "/user/collect/content";
    if(catId) {
        url += "?catId="+ catId
    }
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#collect-content').html(data);
            var pageNo = $('#pageNo').val();
            var pageSize = $('#pageSize').val();
            var totalPage = $('#totalPage').val();
            var totalRecord = $('#totalRecord').val();
            layui.use(['laypage', 'layer'], function () {
                var laypage = layui.laypage;
                laypage({
                    cont: 'collect-page'
                    , pages: parseInt(totalPage) //总页数
                    , groups: 5,//连续显示分页数
                    curr: function () {
                        return pageNo;
                    },
                    jump: function (e, first) { //触发分页后的回调
                        if (e.curr !== pageNo) {
                            var queryUrl = url + "?pageNo=" + e.curr;
                            if(catId) {
                                queryUrl = url + "&pageNo=" + e.curr;
                            }
                            $.ajax({
                                url: queryUrl,
                                type: 'GET',
                                data: {},
                                dataType: 'html',
                                success: function (data) {
                                    $('#collect-content').html(data);
                                }
                            });
                        }
                    }
                });
            });
        }
    });
};
