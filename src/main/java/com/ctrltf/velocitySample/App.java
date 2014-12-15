package com.ctrltf.velocitySample;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class App {
    public static void main( String[] args ) {
        // init
        Velocity.init();
        Properties p = new Properties();  
        p.setProperty("resource.loader", "class");  
        p.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");  
        p.setProperty("input.encoding", "UTF-8");  
        Velocity.init(p);
     
        VelocityContext context = new VelocityContext();
        context.put("item", "ボールペン");
        context.put("price", "1000");
     
        Template template = Velocity.getTemplate("assets/velocity-template/alert-mail.vm", "UTF-8");
     
        //テンプレートへ値を出力します。
        StringWriter sw = new StringWriter();
        template.merge(context,sw);
        sw.flush();
     
        System.out.println(sw.toString());
    }
}
