<%--
  Created by IntelliJ IDEA.
  User: dinghongjing
  Date: 2022/12/27
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>医生主页</title>
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
<div class="center" style="height: 960px; width: 100%;"><!--白色区域-->
    <div class="center_center" style="width: 70%; height: 960px; display: block; text-align: center; margin-top: 40px; margin-left: 214px; background-color: rgba(255,255,255,0.5);">
        <div class="center_center_top" style=" display: block; width: 100%; height: 100px; margin: auto; text-align: center;">
            <span class="login_title" style="font-size: 40px; margin-top: 40px; text-align: center; line-height: 100px; color: cornflowerblue; font-weight: bold;">${sessionScope.user.name}医生，欢迎你</span>
        </div>
        <div class="center_center_middle" style="width: 900px; height: 720px; margin: auto;">
            <form action="./query" method="get" style="line-height: 60px;">
                <input type="text" name="regDate" placeholder="输入挂号时间查询yyyy-mm-dd" style="width: 280px; height: 35px; opacity: 0.7; border: none;">
                <!--<input type="submit" name="search" placeholder="啊这" style="width: 80px; height: 35px; font-weight: bold; color: white; background-color: cornflowerblue;">-->
                <button type="submit" id="submit" name="submit" style="width: 80px; height: 35px; font-weight: bold; color: white; background-color: cornflowerblue; border: none;">
                    查询
                </button>
            </form>
            <table cellpadding="0" cellspacing="0" style=" width: 780px; margin: auto; align-content: center; border: 1px solid;">
                <caption style="font-size: 20px; font-weight: bold;">当前科室的所有挂号记录</caption>
                <thead style="border: 1px solid;">
                <tr style="border: 1px solid;">
                    <td style="border: 1px solid;">编号</td>
                    <td style="border: 1px solid;">病人账号</td>
                    <td style="border: 1px solid;">科室编号</td>
                    <td style="border: 1px solid;">挂号时间</td>
                    <td style="border: 1px solid;">挂号费用</td>
                </tr>
                </thead>
                <tbody style="border: 1px solid;">
                <c:forEach var="reg" items="${requestScope.reg}">
                    <tr style="border: 1px solid;">
                        <td style="border: 1px solid;">${reg.id}</td>
                        <td style="border: 1px solid;">${reg.patientId}</td>
                        <td style="border: 1px solid;">${reg.deptId}</td>
                        <td style="border: 1px solid;">${reg.regTime}</td>
                        <td style="border: 1px solid;">${reg.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="height: 20px;"></div>
            <button type="button" onclick="window.location.href = 'http://localhost:8080/TestServlet1_war_exploded/login.jsp'" style="width: 280px; height: 35px; color: black; background-color: cyan; font-weight: bold; border: none;">
                返回登录页面
            </button>
        </div>
    </div>
</div>
<div class="bottom" style="height: 308px; width: 100%;">
</div>
</body>
</html>
