/*
 * // *************************************************************************************************
 * //
 * // Copyright(C) 2021 ELYSIAN CREST (PVT) LTD.
 * // All rights reserved.
 * //
 * // THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 * // ELYSIAN CREST (PVT) LTD
 * //
 * // This copy of the Source Code is intended for ELYSIAN CREST (PVT) LTD 's internal use only
 * // and is
 * // intended for view by persons duly authorized by the management of ELYSIAN CREST (PVT) LTD.
 * //No part of this file may be reproduced or distributed in any form or by any
 * // means without the written approval of the Management of ELYSIAN CREST (PVT) LTD.
 * //
 * // *************************************************************************************************
 */

package com.example.pera_sport_app.Mail.Helper;


import com.example.pera_sport_app.Mail.dto.MailRequest;

import freemarker.core.ParseException;
import freemarker.template.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final Configuration configuration;

    public void sendMail(MailRequest request, Map<String, Object> model, String status){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());



                Template template = configuration.getTemplate("email.html");


            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setTo(request.getTo());
            helper.setText(html,true);
            helper.setSubject(request.getSubject());
            helper.setFrom(request.getFrom());

            mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
