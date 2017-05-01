function getQueryString(key) {
    var reg = new RegExp("(^|&)"+key+"=([^&]*)(&|$)");
    var result = window.location.search.substr(1).match(reg);
    return result?decodeURIComponent(result[2]):null;
}

$("#collect-title").val(getQueryString("title"));
$("#collect-url").val(getQueryString("url"));
$("#collect-description").val(getQueryString("description"));
