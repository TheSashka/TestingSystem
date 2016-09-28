package com.alexander.testingsystem.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("customEmail")
public class CustomMailAPI {

    @Autowired
    private JavaMailSender mailSender;;


    private void customMailReadyToSend(String toAddress, String fromAddress,
                                      String subject, String msgBody){
        SimpleMailMessage customMsg = new SimpleMailMessage();
        customMsg.setFrom(fromAddress);
        customMsg.setTo(toAddress);
        customMsg.setSubject(subject);
        customMsg.setText(msgBody);
        mailSender.send(customMsg);
    }

    public void noticeOfRegistration(String toAddress, String login) {
        String fromAddress = "SanyaXP2012@gmail.com";
        String subject = "Уведомление о регистрации";
        StringBuilder msgBody = new StringBuilder();
        msgBody.append("Добро пожаловать в Testing System, ");
        msgBody.append(login);
        customMailReadyToSend(toAddress, fromAddress, subject, msgBody.toString());
    }

    public void resetPasswordMail(String email) {
        MimeMessage message =  this.mailSender.createMimeMessage();
        MimeMessageHelper mimeHelper;
        try {
            mimeHelper = new MimeMessageHelper(message,true);
            mimeHelper.setTo(email);
            mimeHelper.setFrom("SanyaXP2012@gmail.com");
            mimeHelper.setSubject("Password Reset");
            mimeHelper.setText("<html><body>hi,<br/><a href='http://localhost:8080/newPassword/"+email+"/'> Click here</a> to reset password</body></html>",true);
            mailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("Error Sending email "+ e.getMessage());
        }
    }
}
