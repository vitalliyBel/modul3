package com.rest.controller;

import com.rest.entity.Weather;
import com.rest.sendMessageService.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //Класс управляет рест запросами и ответами
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private SendEmail sendEmail;
    @Autowired
    private Weather weather;

//    @Autowired
//    private MailSender mailSender;


    @GetMapping("/send")
    public String showSend() throws Exception {

       sendEmail.sendMail();
        return "Сообщение отправлено" + weather.getTemp();
    }

}
