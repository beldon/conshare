/*(function() {
 var description;
 var desString = "";
 var metas = document.getElementsByTagName("meta");
 for (var x = 0, y = metas.length; x < y; x++) {
 if (metas[x].name.toLowerCase() === "description") {
 description = metas[x];
 }
 }
 if (description) {
 desString = "&amp;amp;description=" + encodeURIComponent(description.content);
 }
 var win = window.open("http://localhost/collect?from=webtool&amp;url=" + encodeURIComponent(document.URL) + desString + "&amp;title=" + encodeURIComponent(document.title) + "&amp;charset=" + document.charset, "_blank");
 win.focus();
 })();*/

function collect() {
    var description;
    var desString = "";
    var metas = document.getElementsByTagName("meta");
    for (var x = 0, y = metas.length; x < y; x++) {
        if (metas[x].name.toLowerCase() === "description") {
            description = metas[x];
        }
    }
    if (description) {
        desString = "&description=" + encodeURIComponent(description.content);
    }
    var win = window.open("http://localhost:8080/user/collect/collect?from=webtool&url=" + encodeURIComponent(document.URL) + desString + "&title=" + encodeURIComponent(document.title) + "&charset=" + document.charset, "_blank");
    win.focus();
}


var t = "javascript:(function(){var description;var desString='';var metas=document.getElementsByTagName('meta');for(var x=0,y=metas.length;x<y;x++){if(metas[x].name.toLowerCase()==='description'){description=metas[x]}}if(description){desString='&description='+encodeURIComponent(description.content)}var win=window.open('http://localhost:8080/user/collect/collect?from=webtool&url='+encodeURIComponent(document.URL)+desString+'&title='+encodeURIComponent(document.title)+'&charset='+document.charset,'_blank');win.focus()})();";
// <a onclick="alert('请把这个按钮拖到您的浏览器书签栏'); return false;" class="btn btn-primary" href="javascript:(function()%7Bvar%20description;var%20desString=%22%22;var%20metas=document.getElementsByTagName('meta');for(var%20x=0,y=metas.length;x%3Cy;x++)%7Bif(metas%5Bx%5D.name.toLowerCase()==%22description%22)%7Bdescription=metas%5Bx%5D;%7D%7Dif(description)%7BdesString=%22&amp;amp;description=%22+encodeURIComponent(description.content);%7Dvar%20win=window.open(%22http://favorites.ren/collect?from=webtool&amp;url=%22+encodeURIComponent(document.URL)+desString+%22&amp;title=%22+encodeURIComponent(document.title)+%22&amp;charset=%22+document.charset,'_blank');win.focus();%7D)();">云收藏</a>
var t1 = "javascript:(function()%7Bvar%20description;var%20desString=%22%22;var%20metas=document.getElementsByTagName('meta');for(var%20x=0,y=metas.length;x%3Cy;x++)%7Bif(metas%5Bx%5D.name.toLowerCase()==%22description%22)%7Bdescription=metas%5Bx%5D;%7D%7Dif(description)%7BdesString=%22&amp;amp;description=%22+encodeURIComponent(description.content);%7Dvar%20win=window.open(%22http://localhost:8080/user/collect/collect?from=webtool&amp;url=%22+encodeURIComponent(document.URL)+desString+%22&amp;title=%22+encodeURIComponent(document.title)+%22&amp;charset=%22+document.charset,'_blank');win.focus();%7D)();";
$("#collect").attr('src', t1);

/*
(function () {
    var description;
    var desString = "";
    var metas = document.getElementsByTagName("meta");
    for (var x = 0, y = metas.length; x < y; x++) {
        if (metas[x].name.toLowerCase() === "description") {
            description = metas[x];
        }
    }
    if (description) {
        desString = "&amp;amp;description=" + encodeURIComponent(description.content);
    }
    var win = window.open("http://localhost/collect?from=webtool&amp;url=" + encodeURIComponent(document.URL) + desString + "&amp;title=" + encodeURIComponent(document.title) + "&amp;charset=" + document.charset, "_blank");
    win.focus();
})();*/

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
var img = "http://localhost:8080/user/collect/favicon.ioc?domain=www.baidu.com";
var image = new Image();
image.src = img;
image.onload = function () {
    var base64 = getBase64Image(image);
    console.log(base64);
};