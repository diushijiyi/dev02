package com.fc.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@Configuration("localeResolver")
public class MyLocaleResources implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale;
//        如果没有传递，默认使用中文
        if (lang==null||lang.equals("")){
            locale=new Locale("zh","CN");
        }else {
            String[] array = lang.split("_");
            locale=new Locale(array[0],array[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
