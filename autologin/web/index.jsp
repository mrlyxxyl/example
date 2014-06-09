<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">
    </style>
</head>
<body>
<div style="width: 50%;">
    <div style="background-color: blue;color: white;padding: 8px;">会员登陆</div>
    <form action="welcome.jsp" method="post">
        <table border="1" width="100%" cellpadding="5" cellspacing="0" style="border-color: blue;">
            <tr>
                <td>
                    <input type="radio" name="logintype" value="username" checked="true">用户名
                    <input type="radio" name="logintype" value="UID">UID
                </td>
                <td>
                    <input type="text" name="nameValue" style="width: 150px"><a href="#">用户注册</a>
                </td>
            </tr>
            <tr>
                <td>
                    密码
                </td>
                <td>
                    <input type="password" name="pass" style="width: 150px;"><a href="#">忘记密码</a>
                </td>
            </tr>
            <tr>
                <td>
                    登陆有效期
                </td>
                <td>
                    <input type="radio" name="loginValidate" value="ever">永久
                    <input type="radio" name="loginValidate" value="oneMonth" checked="true">一个月
                    <input type="radio" name="loginValidate" value="oneDay">一天
                    <input type="radio" name="loginValidate" value="oneHour">一小时
                </td>
            </tr>
            <tr>
                <td>
                    隐身登陆
                </td>
                <td>
                    <select name="hiddenLogin">
                        <option value="-使用默认-">-使用默认-</option>
                        <option value="-否-">-否-</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    界面风格
                </td>
                <td>
                    <select name="deskType">
                        <option value="-使用默认-">-使用默认-</option>
                        <option value="-一-">-一-</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" value="登陆"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>