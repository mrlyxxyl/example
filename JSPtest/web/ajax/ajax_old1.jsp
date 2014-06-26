<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="../js/jquery.min.js"></script>
    <script>

        var xhr;
        function myfun() {
            var name = document.getElementById("name").value;

            if (window.XMLHttpRequest) {

                //针对IE7、8
                xhr = new XMLHttpRequest();
                if (xhr.overrideMimeType) {
                    //针对一些bug的修复
                    xhr.overrideMimeType("text/html");
                }
            } else if (window.ActiveXObject()) {
                //针对低级IE版本
                var activexName = ["MSXML2.XMLHTTP", "Microsoft.XMLHTTP"];
                for (var i = 0; i < activexName.length; i++) {
                    try {
                        xhr = new ActiveXObject(activexName[i]);
                        break;
                    } catch (e) {
                    }
                }
            }
            if (!xhr) {
                return;
            }
            xhr.onreadystatechange = callback;
            xhr.open("GET", "ajax_old2.jsp?name=" + name, true);
            xhr.send(null);
        }
        function callback() {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    var text = xhr.responseText;
                    document.getElementById("did").innerText = text;
                }
            }
        }
    </script>
</head>
<body>
name:<input type="text" id="name"/><br/>
<button onclick="myfun()">click</button>
<div id="did">

</div>
</body>
</html>