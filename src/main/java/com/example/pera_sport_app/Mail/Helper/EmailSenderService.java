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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderService {

    private final JavaMailSender mailSender;


    public void sendEmail(String email, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("samudithawijesundara@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        log.info("mail sent successfully");
    }

}
