package com.fanindra.MailService.service;

import com.fanindra.MailService.dto.EmailDto;

import java.io.File;
import java.util.List;

public interface EmailService {

    public Integer createEmail(EmailDto emailDto);
    public void sendEmail(Integer id);
    public EmailDto getMail(Integer id);
    public void sendEmail(String to, String subject, String message);
    public void sendEmail(List<String> to, String subject, String message);
    public void sendEmailWithHtml(List<String> to, String subject, String htmlMessage);
    public void sendEmailWithHtml(List<String> to, String subject, String htmlMessage, File file);

}
