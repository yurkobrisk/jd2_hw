package jd2_hw.spring_mvc_topic8;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//@Override
//protected Class<?>[] getRootConfigClasses() {
//        return new Class[] {WebConfiguration.class};
//        }
//
//@Override
//protected Class<?>[] getServletConfigClasses() {
//        return null;
//        }
//
//@Override
//protected String[] getServletMappings() {
//        return new String[] {"/"};
//        }
//        }

public class WebInitializer implements WebApplicationInitializer {

        public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);

        DispatcherServlet servlet = new DispatcherServlet(context);

        final ServletRegistration.Dynamic registration =
                container.addServlet("dispatcher", servlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
