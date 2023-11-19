package hospital.servlet;

import hospital.model.Patient;
import hospital.constant.ExamConstant;
import hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/send")
public class SendRecord extends HttpServlet{

    protected void process(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        Object type = request.getSession().getAttribute(ExamConstant.SESSION_LOGIN_TYPE);
        //int deptId = Integer.parseInt("deptId");
        String deptId = request.getParameter("deptId");
        System.out.println(deptId);
        if(ExamConstant.LOGIN_TYPE_PATIENT.equals(type)) {
            if((deptId == null) || deptId.trim().length() == 0) {
                request.setAttribute("error","科室选择有误");
                request.getRequestDispatcher(ExamConstant.HOME_PAGE_QUERY).forward(request,response);
            } else {
                Patient model = (Patient) request.getSession().getAttribute(ExamConstant.SESSION_LOGIN_USER);
                PatientService.sendReg(model.getId(), Integer.valueOf(deptId));
                response.sendRedirect(ExamConstant.HOME_PAGE_QUERY);
            }
        } else {
            request.setAttribute("error","请先进行登录");
            request.getRequestDispatcher(ExamConstant.HOME_PAGE_LOGIN).forward(request,response);
        }
    }

    @Override
    protected  void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        process(request,response);
    }

    @Override
    protected  void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        process(request,response);
    }
}

