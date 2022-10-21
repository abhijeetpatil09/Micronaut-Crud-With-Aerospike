package com.micronaut_aerospike.services;

import io.micronaut.email.Email;
import io.micronaut.email.EmailException;
import io.micronaut.email.EmailSender;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Singleton
public class EmailServices {

    @Inject
    private EmailSender emailSender;
    private static final Logger LOGGER = LogManager.getLogger(EmailServices.class.getName());

    public void sendMail(String to, String msg, String subject) {
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Email Send");
        try {
            Email.Builder email = Email.builder()
                    .subject(subject)
                    .to(to)
                    .body(msg);
            emailSender.send(email);
        } catch (EmailException e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("Email notification failed");
            }
        }
    }
}
