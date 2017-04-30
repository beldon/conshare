(function() {
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
})();