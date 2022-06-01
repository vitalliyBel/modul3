package com.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//вместо файла настроек web.xml

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    } // просто делаем возрвращение null, этот метод не трогаем, т.к. нет рут конфиг классов

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};
    } // ссылка на конфиг класс

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    } //странички начинаем со слэша
}
