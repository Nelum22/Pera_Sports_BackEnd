package com.example.pera_sport_app.Mail;



import com.example.pera_sport_app.Mail.dto.MailData;
import com.example.pera_sport_app.Mail.dto.MailRequest;
import com.example.pera_sport_app.Mail.dto.MailResponse;


public interface EmailService {

    MailResponse sendEmailWithHtmlContent(MailRequest request, MailData mailData);


}
