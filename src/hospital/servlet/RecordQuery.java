package hospital.servlet;

import hospital.dao.DeptDao;
import hospital.dao.RegDao;
import hospital.model.Dept;
import hospital.model.Doctor;
import hospital.model.Patient;
import hospital.model.Reg;
import hospital.constant.ExamConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query")
public class RecordQuery extends HttpServlet{
    protected void process(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        Object type = request.getSession().getAttribute(ExamConstant.SESSION_LOGIN_TYPE);
        String regDate = request.getParameter("regDate");

        if(ExamConstant.LOGIN_TYPE_DOCTOR.equals(type)) {
            Doctor model = (Doctor) request.getSession().getAttribute(ExamConstant.SESSION_LOGIN_USER);
            List<Reg> reg = RegDao.select(null,null,model.getDeptId(),regDate,null);
            request.setAttribute("reg",reg);
            request.getRequestDispatcher(ExamConstant.HOME_PAGE_DOCTOR).forward(request,response);
        } else if (ExamConstant.LOGIN_TYPE_PATIENT.equals(type)) {
            Patient model = (Patient) request.getSession().getAttribute(ExamConstant.SESSION_LOGIN_USER);
            List<Reg> reg = RegDao.select(null, model.getId(), null,null,null);
            List<Dept> depts = DeptDao.select(null,null,null);
            depts.forEach(System.out::println);
            reg.forEach(System.out::println);
            request.setAttribute("depts",depts);
            request.setAttribute("reg",reg);
            request.getRequestDispatcher(ExamConstant.HOME_PAGE_PATIENT).forward(request,response);
        } else {
            request.setAttribute("error","请先进行登录");
            request.getRequestDispatcher(ExamConstant.HOME_PAGE_LOGIN).forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        process(request,response);
    }
}
