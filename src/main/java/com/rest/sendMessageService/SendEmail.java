package com.rest.sendMessageService;


import com.rest.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class SendEmail {

    @Autowired
    private Weather weather;

    @Autowired
    private MailSender mailSender;

    public void sendMail() throws Exception {

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo("zuradik1000@gmail.com");
        msg.setFrom("zuradik1000@gmail.com");
        msg.setSubject("Привет. Это мое первое тестовое сообщение");
        msg.setText("Температура " + weather.getTemp());


//        System.out.println(" Температура "+weather.getTemp());
      mailSender.send(msg);
    }

}
