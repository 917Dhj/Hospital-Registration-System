package hospital.intercepter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/EncodingFilter")
public class LoginInterceptor implements Filter{
    private String loginUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        this.loginUrl=filterConfig.getInitParameter("过滤器初始化");
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,FilterChain filterChain) throws IOException,ServletException{
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String uri=((HttpServletRequest) servletRequest).getRequestURI();
        if(session.getAttribute("index") == null && !loginUrl.contains(uri)) {
            ((HttpServletResponse) servletResponse).sendRedirect("/web/index.jsp");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy(){
        System.out.println("过滤器销毁");
        //TODO Auto-generated method stub
    }
}
