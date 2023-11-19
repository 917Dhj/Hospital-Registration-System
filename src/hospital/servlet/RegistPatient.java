package hospital.servlet;

import hospital.constant.ExamConstant;
import hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registPatient")
public class RegistPatient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String patientId = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String old = request.getParameter("age");
        String gender = request.getParameter("gender");
        int id = Integer.parseInt(patientId);
        int age = Integer.parseInt(old);
        int sex = Integer.parseInt(gender);
        PatientService.regist(id,username,password,sex,age);
        response.sendRedirect(ExamConstant.HOME_PAGE_LOGIN);
    }
}
