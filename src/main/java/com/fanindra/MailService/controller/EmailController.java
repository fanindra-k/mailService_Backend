package com.fanindra.MailService.controller;

import com.fanindra.MailService.dto.EmailDto;
import com.fanindra.MailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmail(@RequestBody EmailDto emailDto){
        try{
            Integer id = emailService.createEmail(emailDto);
            return ResponseEntity.ok("Email Created successfully with id : "+id);
        }
        catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();

            // Return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create email.");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getMail(@PathVariable Integer id){
        try{
            EmailDto emailDto = emailService.getMail(id);
            return ResponseEntity.ok(emailDto);
        }
        catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();

            // Return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrive email.");
        }
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestBody Integer id){
        try{
            emailService.sendEmail(id);
            return ResponseEntity.ok("Mail sent successfully");
        }
        catch (Exception e) {
            // Log the exception (optional)
            e.printStackTrace();

            // Return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
        }
    }
}
