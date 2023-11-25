package com.example.pera_sport_app.Mail;

import com.example.pera_sport_app.Mail.Helper.TableGenerationService;
import com.example.pera_sport_app.Mail.dto.MailData;
import com.example.pera_sport_app.Mail.dto.MailRequest;
import com.example.pera_sport_app.Mail.dto.MailResponse;

import freemarker.template.Configuration;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmailServiceImpl implements  EmailService{


    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;

    @Autowired
    private TableGenerationService tableGenerationService;
    public MailResponse sendEmailWithHtmlContent(MailRequest request, MailData mailData) {
        MailResponse response = new MailResponse();
        MimeMessage message = sender.createMimeMessage();
        try {
            // set mediaType
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            String html = tableGenerationService.generateReportMessage(mailData);
            helper.setTo(request.getTo());
            helper.setText(html, true);
            helper.setSubject(request.getSubject());
            helper.setFrom("samudithawijesundara@gmail.com");
            sender.send(message);

            response.setMessage("mail send to : " + request.getTo());
            log.info("mail send to : " + request.getTo());
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException e) {
            response.setMessage("Mail Sending failure : " + e.getMessage());
            log.info("Mail Sending failure : " + e.getMessage());
            response.setStatus(Boolean.FALSE);
        }

        return response;
    }
}
