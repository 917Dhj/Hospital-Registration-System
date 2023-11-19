package hospital.servlet;

import hospital.constant.ExamConstant;
import hospital.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.script.*;

@WebServlet("/registDoctor")
public class RegistDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String  type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int deptId = Integer.parseInt(type);
        //int id = Integer.parseInt(username);
        int sex = Integer.parseInt(gender);
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("deptId="+deptId);
        System.out.println("sex="+sex);
        DoctorService.regist(1,username,password,sex,deptId);
        response.sendRedirect(ExamConstant.HOME_PAGE_LOGIN);
    }
}
