//package edu.duke.summer.client.config;
//
//
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//public class CorsConfig implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        System.out.println("Create Filter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request = (HttpServletRequest) req;
//        String path = request.getServletPath();
//        //front end react domain
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        //Allow visit cookie
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//        if (request.getMethod().equals("OPTIONS")) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }else{
//            chain.doFilter(request, res);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//        System.out.println("Filter destroied");
//    }
//}
