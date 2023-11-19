<%--
  Created by IntelliJ IDEA.
  User: dinghongjing
  Date: 2022/12/28
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>挂号界面</title>
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
<div class="center" style="height: 450px; width: 100%;"><!--白色区域-->
    <div class="center_center" style="width: 70%; height: 450px; display: block; text-align: center; margin-top: 40px; margin-left: 214px; background-color: rgba(255,255,255,0.5);">
        <div class="center_center_top" style=" display: block; width: 100%; height: 120px; margin: auto; text-align: center;">
                <span class="login_title" style="font-size: 40px; margin-top: 40px; text-align: center; line-height: 120px; color: cornflowerblue; font-weight: bold;">挂号</span>
        </div>
        <div class="center_center_middle" style="width: 900px; height: 300px; margin: auto;">
            <table cellpadding="0" cellspacing="0" style=" width: 780px; margin: auto; align-content: center; border: 1px solid;">
                <caption style="font-size: 20px; font-weight: bold;">挂号价格信息表</caption>
                <thead style="border: 1px solid;">
                <tr style="border: 1px solid;">
                    <td style="border: 1px solid;">时间段</td>
                    <td style="border: 1px solid;">挂号价格</td>
                </tr>
                </thead>
                <tbody style="border: 1px solid;">
                <tr style="border: 1px solid;">
                    <td style="border: 1px solid;">0:00-9:00</td>
                    <td style="border: 1px solid;">20.0元</td>
                </tr>
                <tr style="border: 1px solid;">
                    <td style="border: 1px solid;">9:00-17:00</td>
                    <td style="border: 1px solid;">10.0元</td>
                </tr>
                <tr style="border: 1px solid;">
                    <td style="border: 1px solid;">17:00-24:00</td>
                    <td style="border: 1px solid;">20.0元</td>
                </tr>
                </tbody>
            </table>
            <form action="./send" method="post" style="text-align: center; line-height: 60px;">
                <select id="deptId" name="deptId" style="width: 285px; height: 40px; opacity: 0.7; border: none;">
                    <option value="" selected>请选择您要挂号的科室</option>
                    <option value="202200001">儿科门诊</option>
                    <option value="202200002">儿科住院</option>
                    <option value="202200003">骨科门诊</option>
                    <option value="202200004">骨科住院</option>
                    <option value="202200005">眼科门诊</option>
                    <option value="202200006">眼科住院</option>
                    <option value="202200007">内科门诊</option>
                    <option value="202200008">内科住院</option>
                    <option value="202200009">心血管科门诊</option>
                    <option value="202200010">心血管科住院</option>
                </select>
                <br/>
                <button type="submit" id="submit" name="submit" style="width: 280px; height: 35px; color: black; background-color: cyan; font-weight: bold; border: none;">
                    确认挂号
                </button>
            </form>
            <button type="button" onclick="window.location.href = 'http://localhost:8080/TestServlet1_war_exploded/logout.jsp'" style="width: 280px; height: 35px; color: black; background-color: white; font-weight: bold; border: none;">
                退出登录
            </button>
        </div>
    </div>
</div>
<div class="bottom" style="height: 308px; width: 100%;">
</div>
</body>
</html>
