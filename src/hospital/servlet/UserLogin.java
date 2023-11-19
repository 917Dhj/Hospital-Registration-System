package hospital.servlet;

import hospital.model.Doctor;
import hospital.model.Patient;
import hospital.constant.ExamConstant;
import hospital.service.DoctorService;
import hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/login")
public class UserLogin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String type=request.getParameter("type");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(type);
        System.out.println(username);
        System.out.println(password);

        //判断登录是否成功的标识
        boolean loginFlag=false;
        //判断参数
        if(type != null && username != null && password != null && type.trim().length()>0
         && username.trim().length()>0 && password.trim().length()>0){
            //[0-医生，1-病人] 登录成功则修改登录标识与跳转页面地址，同时传递对应页面默认展示的数据
            if(ExamConstant.LOGIN_TYPE_DOCTOR.equals(type)){
                Doctor model = DoctorService.login(username,password);
                if(model != null){
                    loginFlag = true;
                    request.getSession().setAttribute(ExamConstant.SESSION_LOGIN_USER,model);
                }
            } else if(ExamConstant.LOGIN_TYPE_PATIENT.equals(type)){
                Patient model = PatientService.login(username,password);
                if(model != null){
                    loginFlag = true;
                    request.getSession().setAttribute(ExamConstant.SESSION_LOGIN_USER,model);
                }
            }
        }
        //根据标识来分流登录的成功与失败
        if(loginFlag){
            request.getSession().setAttribute(ExamConstant.SESSION_LOGIN_TYPE,type);
            response.sendRedirect(ExamConstant.HOME_PAGE_QUERY);
        } else {
            request.setAttribute("error","用户名或密码错误，请重新填写");
            request.getRequestDispatcher(ExamConstant.HOME_PAGE_LOGIN).forward(request,response);
        }
    }
}
