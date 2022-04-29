package com.fc.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
//@Component("localeResolver")
public class I18nResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        获取前端想要切换的语言
        String lang = request.getParameter("lang");
        System.out.println("解析的语言："+lang);
        Locale locale;
        if (lang!=null && !lang.equals("")){
            String[] array = lang.split("_");
            locale = new Locale(array[0], array[1]);
        }else {
//            默认情况下
            locale = new Locale("zh", "CN");

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
