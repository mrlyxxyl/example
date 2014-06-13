<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("td:gt(4)").click(function () {
                var td = $(event.srcElement);
                var td_value = td.text();
                td.html("<input type='text' onkeyup='saveVal();'value='" + td_value + "' name='name'/> ");
            });
        });

        function saveVal() {
            if (event.keyCode == 13) {
                var td_value = $(event.srcElement).val();
                var td = $(event.srcElement.parentNode);
                td.html(td_value);
            }
        }

        function addRow() {
            $("table:first").append($("<tr><td></td><td></td><td></td><td></td><td></td></tr>"));
        }
    </script>
    <style type="text/css">
        td {
            height: 30px;
            width: 20%;
            text-align: center;
        }

        input {
            width: 100%;
            height: 100%;
            border: 0px;
            text-overflow: ellipsis;
            overflow: hidden;
        }
    </style>
</head>
<body>
<button onclick="addRow()">增加一行</button>
<table border="1" align="center" cellspacing="0" cellspadding="0" width="600">
    <tr style="background: #2f4f4f;color: white">
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>sex</td>
        <td>address</td>
    </tr>

    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
</body>
</html>