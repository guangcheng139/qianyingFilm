 (function(window) {

    function _registerEvent(target, eventType, cb) {
        if (target.addEventListener) {
            target.addEventListener(eventType, cb);
            return {
                remove: function () {
                    target.removeEventListener(eventType, cb);
                }
            };
        } else {
            target.attachEvent(eventType, cb);
            return {
                remove: function () {
                    target.detachEvent(eventType, cb);
                }
            };
        }
    }

    function _createHiddenIframe(target, uri) {
        var iframe = document.createElement("iframe");
        iframe.src = uri;
        iframe.id = "hiddenIframe";
        iframe.style.display = "none";
        target.appendChild(iframe);

        return iframe;
    }

    function openUriWithHiddenFrame(uri, failCb, successCb) {

        var timeout = setTimeout(function () {
            failCb();
            handler.remove();
        }, 1000);

        var iframe = document.querySelector("#hiddenIframe");
        if (!iframe) {
            iframe = _createHiddenIframe(document.body, "about:blank");
        }

        var handler = _registerEvent(window, "blur", onBlur);

        function onBlur() {
            clearTimeout(timeout);
            handler.remove();
            successCb();
        }

        iframe.contentWindow.location.href = uri;
    }

    function openUriWithTimeoutHack(uri, failCb, successCb) {
        
        var timeout = setTimeout(function () {
            failCb();
            handler.remove();
        }, 1000);

        //handle page running in an iframe (blur must be registered with top level window)
        var target = window;
        while (target != target.parent) {
            target = target.parent;
        }

        var handler = _registerEvent(target, "blur", onBlur);

        function onBlur() {
            clearTimeout(timeout);
            handler.remove();
            successCb();
        }

        window.location = uri;
    }

    function openUriUsingFirefox(uri, failCb, successCb) {
        var iframe = document.querySelector("#hiddenIframe");

        if (!iframe) {
            iframe = _createHiddenIframe(document.body, "about:blank");
        }

        try {
            iframe.contentWindow.location.href = uri;
            successCb();
        } catch (e) {
            if (e.name == "NS_ERROR_UNKNOWN_PROTOCOL") {
                failCb();
            }
        }
    }

    function openUriUsingIEInOlderWindows(uri, failCb, successCb) {
        if (getInternetExplorerVersion() === 10) {
            openUriUsingIE10InWindows7(uri, failCb, successCb);
        } else if (getInternetExplorerVersion() === 9 || getInternetExplorerVersion() === 11) {
            openUriWithHiddenFrame(uri, failCb, successCb);
        } else {
            openUriInNewWindowHack(uri, failCb, successCb);
        }
    }

    function openUriUsingIE10InWindows7(uri, failCb, successCb) {
        var timeout = setTimeout(failCb, 1000);
        window.addEventListener("blur", function () {
            clearTimeout(timeout);
            successCb();
        });

        var iframe = document.querySelector("#hiddenIframe");
        if (!iframe) {
            iframe = _createHiddenIframe(document.body, "about:blank");
        }
        try {
            iframe.contentWindow.location.href = uri;
        } catch (e) {
            failCb();
            clearTimeout(timeout);
        }
    }

    function openUriInNewWindowHack(uri, failCb, successCb) {
        failCb()
        /*var myWindow = window.open('', '', 'width=0,height=0');

        myWindow.document.write("<iframe src='" + uri + "'></iframe>");

        setTimeout(function () {
            try {
                myWindow.location.href;
                myWindow.setTimeout("window.close()", 1000);
                successCb();
            } catch (e) {
                myWindow.close();
                failCb();
            }
        }, 1000);*/
    }
    
    function openUriWithMsLaunchUri(uri, failCb, successCb) {
        if (navigator.userAgent.indexOf("Edge") > -1) {
            openUriWithHiddenFrame(uri, failCb, successCb);
        }
        else {
            navigator.msLaunchUri(uri,
                successCb,
                failCb
            );
        }
    }
    
    function checkBrowser() {
        var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
        return {
            isOpera   : isOpera,
            isFirefox : typeof InstallTrigger !== 'undefined',
            isSafari  : Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0,
            isChrome  : !!window.chrome && !isOpera,
            isIE      : /*@cc_on!@*/false || !!document.documentMode // At least IE6
        }
    }

    function getInternetExplorerVersion() {
        var rv = -1;
        if (navigator.appName === "Microsoft Internet Explorer") {
            var ua = navigator.userAgent;
            var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
            if (re.exec(ua) != null)
                rv = parseFloat(RegExp.$1);
        }
        else if (navigator.appName === "Netscape") {
            var ua = navigator.userAgent;
            var re = new RegExp("Trident/.*rv:([0-9]{1,}[\.0-9]{0,})");
            if (re.exec(ua) != null) {
                rv = parseFloat(RegExp.$1);
            }
        }
        return rv;
    }

    window.protocolCheck = function(uri, failCb, successCb) {
        function failCallback() {
            failCb && failCb();
        }

        function successCallback() {
            successCb && successCb();
        }

        if (navigator.msLaunchUri) { //for IE and Edge in Win 8 and Win 10
            openUriWithMsLaunchUri(uri, failCb, successCb);
        } else {
            var browser = checkBrowser();

            if (browser.isFirefox) {
                openUriUsingFirefox(uri, failCallback, successCallback);
            } else if (browser.isChrome) {
                openUriWithTimeoutHack(uri, failCallback, successCallback);
            } else if (browser.isIE) {
                openUriUsingIEInOlderWindows(uri, failCallback, successCallback);
            } else {
                //not supported, implement please
            }
        }
    }
} (window));


function OnDownloadClick(href) {
 var url = href.getAttribute("src")
        Download(url, function () {
            alert("您还没安装飘花下载工具，无法下载该文件！飘花下载工具为下载平均加速80%，安装即可体验高速下载！");
            if(IsMobile()){
            window.location.href="http://xzxb.zjzlb.com/piaohua34.apk";
            }else {
            window.location.href="http://xzxb.zjzlb.com/piaohuaSetup_1.1.0.78.exe";
            }
        })
        return false;
   }
$("a").each(function(){
    if(!this.href.indexOf("ftp://")||!this.href.indexOf("magnet:?xt=")||!this.href.indexOf("fcd://")||!this.href.indexOf("btbo://")){
    this.outerHTML='<a onclick="return OnDownloadClick(this)" href ="javascript:void(0)" src="'+this.href.replace("fcd://","btbo://")+'">'+this.innerText.replace("fcd://","btbo://")+'</a>'
    }
});

$(".bot").eq(0).html("如果使用迅雷请选用磁力链接"); 
if(IsMobile() ==false &&window.location.hostname=='www.piaohua.com'){ document.writeln("<script type='text/javascript' charset='utf-8' src='https://img.xiacaidd.com/xiacai/ad/t2018.js'></scr"+"ipt>"); }