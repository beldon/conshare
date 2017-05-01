$(function () {
    loadData();

    $("#refresh").click(function () {
        loadData();
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