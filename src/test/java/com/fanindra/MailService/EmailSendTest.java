package com.fanindra.MailService;

import com.fanindra.MailService.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSendTest {

    @Autowired
    private EmailService emailService;
    @Test
    public void EmailSend(){
        System.out.println("Sending mail");
        emailService.sendEmail("himanshukr115@gmail.com", "Ham Snatosh Pagal Na hayi", "Marem eke fat lagba lahu feke teri ma ki chode");
    }
}
