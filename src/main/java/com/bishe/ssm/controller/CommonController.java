package com.bishe.ssm.controller;

import com.bishe.ssm.service.ManageService;
import com.bishe.ssm.utils.FileUtil;
import com.mysql.jdbc.StringUtils;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Controller
public class CommonController {

    @Autowired
    ManageService manageService;

    /**
     * 发送邮件
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param model
     * @return
     * @throws GeneralSecurityException
     * @throws MessagingException
     */
    @RequestMapping(value = "/sendmail")
    public String sendmail(String from, String to, String subject, String content, Model model) throws GeneralSecurityException, MessagingException {
        Properties prop = new Properties();
        //设置QQ邮件服务器（设置邮件服务器主机名）
        prop.setProperty("mail.host", "smtp.qq.com");
        prop.setProperty("mail.smtp.socketFactory.port", "587");
        //邮件发送协议（发送邮件协议名称）
        prop.setProperty("mail.transport.protocol", "smtp");
        //需要验证用户名密码（发送服务器需要身份验证）
        prop.setProperty("mail.smtp.auth", "true");
        //关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //使用JavaMail发送邮件的5个步骤
        //1.txt、创建定义整个应用程序所需的环境信息的Session对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("1506362626@qq.com",
                        "evyinbskxekwhejc");
            }
        });
        //开启Session的debug模式，这样xx就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "1506362626@qq.com", "evyinbskxekwhejc");
        //4，创建邮件
        //4-1.txt，创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //4-2，指明邮件的发件人
        message.setFrom(new InternetAddress(from));
        //4-3，指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //4-4，邮件标题
        message.setSubject(subject);
        //4-5，邮件文本内容
        message.setContent(content,"text/html;charset=UTF-8");
        //4-6，发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        //5，关闭连接
        ts.close();
        model.addAttribute("success","发送成功！");
        return "mailsuccess";
    }

    /**
     * 获取图片地址，显示已存在图片
     * @param response
     * @param manageid
     * @throws Exception
     */
    @RequestMapping(value = "/downloadPhoto")
    public void downloadPhoto(HttpServletResponse response,String manageid) throws Exception {
        //获得图片地址
        String filePath = manageService.getPhotoAddr(manageid);
        File file = new File(filePath);
        FileUtil.downloadFile(file,response);
    }

    /**
     * 判断是否已存在头像
     * @param manageid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectAddr", method = RequestMethod.GET)
    @ResponseBody
    public int selectAddr(String manageid) throws Exception {
        String addr = manageService.selectAddr(manageid);
        if(StringUtils.isNullOrEmpty(addr)){
            return 0;
        }else{
            return 1;
        }

    }

}
