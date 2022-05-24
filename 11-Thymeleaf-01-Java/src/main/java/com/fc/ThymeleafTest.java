package com.fc;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

//测试非web环境下使用thymeleaf
public class ThymeleafTest {
    @Test
    public void testRenderStaticData(){
//        创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();
//        准备一个模板
        String template="<input type='text' th:value='易烊千玺'>";
//        准备一个环境上下文对象
        Context context = new Context();
//        使用模板引擎去处理模板
        String html = engine.process(template, context);
        System.out.println(html);
    }
    @Test
    public void testRenderDynamicData(){
        TemplateEngine engine = new TemplateEngine();
        String template="<input type='text' th:value='${name}'>";
        Context context = new Context();
        context.setVariable("name","迪丽热巴");
        String html = engine.process(template, context);
        System.out.println(html);
    }
    @Test
    public void testRenderHtml(){
        TemplateEngine engine = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        engine.setTemplateResolver(resolver);
        Context context = new Context();
        context.setVariable("name","玛卡巴卡");
        String html = engine.process("index.html", context);
        System.out.println(html);
    }
    @Test
    public void testPrefixAndSuffix(){
        TemplateEngine engine = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        engine.setTemplateResolver(resolver);
        Context context = new Context();
        context.setVariable("name","鱼香肉丝");
        String html = engine.process("main", context);
        System.out.println(html);
    }
}
