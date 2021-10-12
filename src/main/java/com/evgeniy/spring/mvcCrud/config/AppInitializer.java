package com.evgeniy.spring.mvcCrud.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // В этот метод подставляем наш класс SpringConfig
        // Теперь наш MySpringMVCDispatcherServletInitializer знает, где находится Spring конфигурация
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() { // <!-- Любой url который вводит пользователь перенаправляется на наш DespatcherServlet -->
        return new String[] {"/"};
    }
}
