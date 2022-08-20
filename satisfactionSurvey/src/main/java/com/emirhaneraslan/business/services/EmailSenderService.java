package com.emirhaneraslan.business.services;

public interface EmailSenderService {
    void sendEmail (String to, String subject,String message);
}
