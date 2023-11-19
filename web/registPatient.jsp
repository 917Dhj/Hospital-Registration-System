<%--
  Created by IntelliJ IDEA.
  User: dinghongjing
  Date: 2022/12/27
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>病人注册界面</title>
</head>
<body background="./image/background_image.jpg" style="background-repeat:no-repeat; background-attachment:fixed; background-size:100% 100%;">
<div class="header" style="height: 160px; width: 100%;">
    <div class="header_top" style="width: 100%; height: 20px; color: white; background-color: green; opacity: 0.6;">
        <div class="juzhong" style="width: 960px; margin: 0px auto;">
            <div class="left-juzhong" style="float: left;">
                <span style="font-weight: bold;">设为首页</span>
                <span style="font-weight: bold;">收藏本站</span>
            </div>
            <div class="right-juzhong" style="float: right;">
                <span style="font-weight: bold;">今天温度28</span>
            </div>
        </div>
    </div>
    <div class="header_bottom" style="height: 140px; width: 100%; background-color: rgba(0,255,255,0.7)">
        <div class="header_bottom_left" style="margin-top: 35px; float: left;">
            <span class="welcome" style="font-size: 40px; display: block; color: cornflowerblue; font-weight: bolder;">欢迎登录叮叮车医院挂号系统</span>
        </div>
    </div>
</div>
<div class="center" style="height: 960px; width: 100%;">
    <div class="center_center" style="width: 50%; height: 560px; display: block; text-align: center; margin-top: 40px; margin-left: 356px; background-color: rgba(255,255,255,0.5);">
        <div class="center_center_top" style=" display: block; width: 360px; height: 120px; margin: auto; text-align: center;">
            <span class="login_title" style="font-size: 40px; margin-top: 40px; text-align: center; line-height: 120px; color: cornflowerblue; font-weight: bold;">病人账号注册</span>
        </div>
        <div class="center_center_middle" style="width: 420px; height: 360px; margin: auto;">
            <form action="./registPatient" method="post" style="text-align: center; line-height: 60px;">
                <input type="text" name="id" placeholder="账号(不超过8位的数字)" style="width: 280px; height: 35px; opacity: 0.7; border: none;">
                <br/>
                <input type="text" name="username" placeholder="姓名" style="width: 280px; height: 35px; opacity: 0.7; border: none;">
                <br/>
                <input type="password" name="password" placeholder="设置登录密码(8位以下数字)" style="width: 280px; height: 35px; opacity: 0.7; border: none;">
                <br/>
                <input type="text" name="age" placeholder="年龄" style="width: 280px; height: 35px; opacity: 0.7; border: none;">
                <br/>
                性别：
                男     <input type="radio" value="1" name="gender" style="opacity: 0.7;">
                女     <input type="radio" value="2" name="gender" style="opacity: 0.7;">
                <br/>
                <button type="submit" id="submit" name="submit" style="width: 280px; height: 35px; color: black; background-color: cyan; font-weight: bold; border: none;">
                    立即注册
                </button>
            </form>
            <button type="button" onclick="window.location.href = 'http://localhost:8080/TestServlet1_war_exploded/login.jsp'" style="width: 280px; height: 35px; color: black; background-color: white; font-weight: bold; border: none;">
                返回登录页面
            </button>
        </div>
    </div>
</div>
<div class="bottom" style="height: 308px; width: 100%;">

</div>
</body>
</html>