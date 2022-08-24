package com.davProject.RAD_PROJECT.controller;

import com.davProject.RAD_PROJECT.configuration.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Accepte");
        message.setText("Passer une bonne journee");

        // Send Message!
        this.emailSender.send(message);
        return "Validation réussis";
    }

    @ResponseBody
    @RequestMapping("/sendEmail2")
    public String sendEmail2() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Refus");
        message.setText("CAUSE: ");

        // Send Message!
        this.emailSender.send(message);
        return "Refus reussis";
    }

}