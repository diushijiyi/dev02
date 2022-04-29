package com.fc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSender sender;
    @Test
    void testHtmlMail(){
//        创建一个邮件对象
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom("3513972901@qq.com");
//            设置发送的时间（定时邮件）
            helper.setSentDate(new Date());
            helper.setTo(new String[]{
                    "1808791639@qq.com",
                    "3049455007@qq.com",
                    "3525264314@qq.com",
                    "3557001653@qq.com"
            });
            helper.setCc(new String[]{
                    "3022941680@qq.com",
                    "2084145913@qq.com"
            });
            helper.setBcc("877875806@qq.com");
            helper.setSubject("重金求子");
            helper.setText("<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0522%252F9917f389j00qthov60027c000m800hkm.jpg%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653736180&t=9d4a571d5510afbd35b23ec5886b6d96' " +
                    "alt='图片'><br/>" +
                    "<font align='center' color='red'>" +
                    "大家好，我是秦始皇，其实我并没有死。" +
                    "我找到了长生不老药活到了现在，我的葬礼是个骗局，其实我埋葬了大量的财富。" +
                    " 我现在手机没流量了，谁给我充100元话费，待我打个滴滴去咸阳，保你荣华富贵。" +
                    "</font>",true);
            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testSimple(){
//        简单的邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
//        发送人
        message.setFrom("3513972901@qq.com");
//        接收人
        message.setTo("1808791639@qq.com",
                "3049455007@qq.com",
                "3525264314@qq.com",
                "3557001653@qq.com");
//        抄送人
        message.setCc("3022941680@qq.com",
                "2084145913@qq.com");
//        秘密抄送，只有发送人和密抄者能够看到
        message.setBcc("877875806@qq.com");
//        邮件主题
        message.setSubject("您有一条新的邮件，请注意查收~");
//        邮件内容
        message.setText("给你一个大嘴巴子");
//        message.setText("您已经成为失信人员，请速给我转账5000解除限制，否则将查封您的号");
//        发送文件
        sender.send(message);
    }
}
