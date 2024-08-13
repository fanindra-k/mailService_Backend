package com.fanindra.MailService.serviceImpl;

import com.fanindra.MailService.dto.EmailDto;
import com.fanindra.MailService.entity.Email;
import com.fanindra.MailService.repository.EmailRepository;
import com.fanindra.MailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailRepository emailRepository;

   public Integer createEmail(EmailDto emailDto){
       Email email = new Email();
       email.setBody(emailDto.getBody());
       email.setRecipients(emailDto.getTo());
       email.setSubject(emailDto.getSubject());
       Email persisted = emailRepository.save(email);
       return persisted.getId();
   }

   public EmailDto getMail(Integer id){
       Email email = emailRepository.getEmailById(id);
       EmailDto emailDto = new EmailDto();
       emailDto.setId(email.getId());
       emailDto.setBody(email.getBody());
       emailDto.setSubject(email.getSubject());
       emailDto.setTo(email.getRecipients());
       return emailDto;

   }
    public void sendEmail(Integer id) {
        Email email =emailRepository.getEmailById(id);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getRecipients().toArray(new String[0]));
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getBody());
        mailSender.send(simpleMailMessage);

    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);

    }


    @Override
    public void sendEmail(List<String> to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to.toArray(new String[0]));
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailWithHtml(List<String> to, String subject, String htmlMessage) {

    }

    @Override
    public void sendEmailWithHtml(List<String> to, String subject, String htmlMessage, File file) {

    }
}
