package com.reservationapp.util;


import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmailWithAttachment(String to,String subject,String text,byte[] attachment,String attachmentName){
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            DataSource dataSource = new ByteArrayDataSource(attachment,"application/pdf");
            helper.addAttachment(attachmentName,dataSource);
            emailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
