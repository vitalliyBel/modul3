package com.rest.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "com.rest")
@EnableWebMvc //включение спринг-mvc
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public MailSender mailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("zuradik1000@gmail.com");
        mailSender.setPassword("oblltwsgeillmxhv");

        Properties properties = new Properties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(properties);

        return mailSender;

    }

    //для отображения русских символов
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(converter -> {
            if (converter instanceof AbstractHttpMessageConverter) {
                ((AbstractHttpMessageConverter) converter)
                        .setDefaultCharset(StandardCharsets.UTF_8);
                if (converter instanceof StringHttpMessageConverter) {
                    ((StringHttpMessageConverter) converter)
                            .setWriteAcceptCharset(false);
                }
            } else if (converter instanceof FormHttpMessageConverter) {
                ((FormHttpMessageConverter) converter)
                        .setCharset(StandardCharsets.UTF_8);
                ((FormHttpMessageConverter) converter)
                        .setMultipartCharset(StandardCharsets.UTF_8);
            }
        });
    }
}
