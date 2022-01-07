package com.michellibrito.msemail.applicationcore.ports;


import com.michellibrito.msemail.applicationcore.domain.Email;

public interface SendEmailServicePort {

    void sendEmailSmtp(Email email);
}