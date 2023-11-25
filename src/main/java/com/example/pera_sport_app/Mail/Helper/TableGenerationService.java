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

import com.example.pera_sport_app.Mail.dto.MailData;
import org.springframework.stereotype.Service;

@Service
public class TableGenerationService {


    public String generateReportMessagee(MailData mailData) {
        StringBuilder stringBuilder = generateCommonHtmlHead(mailData);
        stringBuilder.append("  <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\"\n" +
                "                                           class=\"list_block\" role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td>\n" +
                "                                                <ul start=\"1\"\n" +
                "                                                    style=\"margin: 0; padding: 0; margin-left: 20px; color: #000000; direction: ltr; font-family: Arial; font-size: 14px; font-weight: 400; letter-spacing: 0px; line-height: 120%; text-align: left;\">\n");
        // Set the detail of the email
        for (int i = 0; i < mailData.getDetails().length; i++) {
            if (mailData.getDetails()[i] != null) {
                stringBuilder.append("<li  style=\"margin: 0; padding: 0; color: #000000; margin-bottom: 3px;\" >").append(mailData.getDetails()[i]).append("</li>");
            }
            if (i == 0) {
                stringBuilder.append("<ul start=\"1\"\n" +
                        "style=\"margin: 0; padding: 0; margin-left: 20px; color: #000000; direction: ltr; font-family: Arial; font-size: 14px; font-weight: 400; letter-spacing: 0px; line-height: 120%; text-align: left;\">\n");

                for (String detail1 : mailData.getDetailsDescription1()) {
                    if (detail1 != null) {
                        stringBuilder.append("<li style=\"margin: 0; padding: 0; color: #000000; margin-bottom: 3px;\" >").append(detail1).append("</li>");
                    }
                }
                stringBuilder.append("</ul>");
            } else if (i == 1) {
                stringBuilder.append("<ul start=\"1\"\n" +
                        "style=\"margin: 0; padding: 0; margin-left: 20px; color: #000000; direction: ltr; font-family: Arial; font-size: 14px; font-weight: 400; letter-spacing: 0px; line-height: 120%; text-align: left;\">\n");
                for (String detail1 : mailData.getDetailsDescription2()) {
                    if (detail1 != null) {
                        stringBuilder.append("<li style=\"margin: 0; padding: 0; color: #000000; margin-bottom: 3px;\" >").append(detail1).append("</li>");
                    }
                }
                stringBuilder.append("</ul>");
            } else if (i == 2) {
                stringBuilder.append("<ul start=\"1\"\n" +
                        "style=\"margin: 0; padding: 0; margin-left: 20px; color: #000000; direction: ltr; font-family: Arial; font-size: 14px; font-weight: 400; letter-spacing: 0px; line-height: 120%; text-align: left;\">\n");
                for (String detail1 : mailData.getDetailsDescription3()) {
                    if (detail1 != null) {
                        stringBuilder.append("<li  style=\"margin: 0; padding: 0; color: #000000; margin-bottom: 3px;\" >").append(detail1).append("</li>");
                    }
                }
                stringBuilder.append("</ul>");
            } else {
                stringBuilder.append("<ul start=\"1\"\n" +
                        "style=\"margin: 0; padding: 0; margin-left: 20px; color: #000000; direction: ltr; font-family: Arial; font-size: 14px; font-weight: 400; letter-spacing: 0px; line-height: 120%; text-align: left;\">\n");
                for (String detail1 : mailData.getDetailsDescription4()) {
                    if (detail1 != null) {
                        stringBuilder.append("<li  style=\"margin: 0; padding: 0; color: #000000; margin-bottom: 3px;\" >").append(detail1).append("</li>");
                    }
                }
                stringBuilder.append("</ul>");
            }
        }

        stringBuilder.append("</ul></td></tr></table>");

        generateCommonFooter(stringBuilder);
        return stringBuilder.toString();
    }


    private StringBuilder generateCommonHtmlHead(MailData mailData) {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append("<!DOCTYPE html>\n" +
                        "\n" +
                        "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                        "\n" +
                        "<head>\n" +
                        "  <title></title>\n" +
                        "  <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                        "  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\" />\n" +
                        "  <!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "  <style>\n" +
                        "\t\t* {\n" +
                        "\t\t\tbox-sizing: border-box;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: inherit !important;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t#MessageViewBody a {\n" +
                        "\t\t\tcolor: inherit;\n" +
                        "\t\t\ttext-decoration: none;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\tp {\n" +
                        "\t\t\tline-height: inherit\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t.desktop_hide,\n" +
                        "\t\t.desktop_hide table {\n" +
                        "\t\t\tmso-hide: all;\n" +
                        "\t\t\tdisplay: none;\n" +
                        "\t\t\tmax-height: 0px;\n" +
                        "\t\t\toverflow: hidden;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t@media (max-width:520px) {\n" +
                        "\t\t\t.desktop_hide table.icons-inner {\n" +
                        "\t\t\t\tdisplay: inline-block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.icons-inner {\n" +
                        "\t\t\t\ttext-align: center;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.icons-inner td {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.row-content {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.column .border,\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\ttable {\n" +
                        "\t\t\t\ttable-layout: fixed !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.stack .column {\n" +
                        "\t\t\t\twidth: 100%;\n" +
                        "\t\t\t\tdisplay: block;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0;\n" +
                        "\t\t\t\tmax-height: 0;\n" +
                        "\t\t\t\tmax-width: 0;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide,\n" +
                        "\t\t\t.desktop_hide table {\n" +
                        "\t\t\t\tdisplay: table !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                        "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\" width=\"100%\">\n" +
                        "  <tbody>\n" +
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\"\n" +
                        "             role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "        <tbody>\n" +
                        "        <tr>\n" +
                        "          <td>\n" +
                        "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                        "                   class=\"row-content stack\" role=\"presentation\"\n" +
                        "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                        "                   width=\"500\">\n" +
                        "              <tbody>\n" +
                        "              <tr>\n" +
                        "                <td class=\"column column-1\"\n" +
                        "                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                        "                    width=\"100%\">\n" +
                        "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                        "                         class=\"image_block\" role=\"presentation\"\n" +
                        "                         style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                        "                         width=\"100%\">\n" +
                        "                    <tr>\n" +
                        "                      <td style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                        "                        <div align=\"center\" style=\"line-height:10px\"><img\n" +
                        "                                src=\"https://media.licdn.com/dms/image/C510BAQF5vnmMNlE1HA/company-logo_200_200/0/1567406906095?e=2147483647&v=beta&t=8RNfAlz2JWBbxldXFzAKEFatS9xmyfOcRBCQabgMy9U\"\n" +
                        "                                style=\"display: block; height: auto; border: 0; width: 100px; max-width: 100%;\"\n" +
                        "                                width=\"100\" /></div>\n" +
                        "                      </td>\n" +
                        "                    </tr>\n" +
                        "                  </table>\n" +
                        "                </td>\n" +
                        "              </tr>\n" +
                        "              </tbody>\n" +
                        "            </table>\n" +
                        "          </td>\n" +
                        "        </tr>\n" +
                        "        </tbody>\n" +
                        "      </table>\n" +
                        "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\"\n" +
                        "             role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "        <tbody>\n" +
                        "        <tr>\n" +
                        "          <td>\n" +
                        "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                        "                   class=\"row-content stack\" role=\"presentation\"\n" +
                        "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                        "                   width=\"500\">\n" +
                        "              <tbody>\n" +
                        "              <tr>\n" +
                        "                <td class=\"column column-1\"\n" +
                        "                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                        "                    width=\"100%\">\n" +
                        "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                        "                         class=\"heading_block\" role=\"presentation\"\n" +
                        "                         style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                        "                         width=\"100%\">\n" +
                        "                    <tr>\n" +
                        "                      <td style=\"text-align:center;width:100%;\">\n" +
                        "                        <h1\n" +
                        "                                style=\"margin: 0; color: #000000; direction: ltr; font-family: Arial; font-size: 22px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n")
                .append(mailData.getHeader())
                .append("</span></h1>\n" +
                        "                      </td>\n" +
                        "                    </tr>\n" +
                        "                  </table>\n" +
                        "                </td>\n" +
                        "              </tr>\n" +
                        "              </tbody>\n" +
                        "            </table>\n" +
                        "          </td>\n" +
                        "        </tr>\n" +
                        "        </tbody>\n" +
                        "      </table>\n" +
                        "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\"\n" +
                        "             role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "        <tbody>\n" +
                        "        <tr>\n" +
                        "          <td>\n" +
                        "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                        "                   class=\"row-content stack\" role=\"presentation\"\n" +
                        "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                        "                   width=\"500\">\n" +
                        "              <tbody>\n" +
                        "              <tr>\n" +
                        "                <td class=\"column column-1\"\n" +
                        "                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                        "                    width=\"100%\">\n" +
                        "                  <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\"\n" +
                        "                         class=\"paragraph_block\" role=\"presentation\"\n" +
                        "                         style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                        "                         width=\"100%\">\n" +
                        "                    <tr>\n" +
                        "                      <td>\n" +
                        "                        <div\n" +
                        "                                style=\"color:#000000;direction:ltr;font-family:Arial;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;\">\n" +
                        "                          <p style=\"margin: 0; margin-bottom: 16px;\">\n")
                .append(mailData.getHeaderDescription())
                .append("</p>\n" +
                        "                        </div>\n" +
                        "                        <div\n" +
                        "                                style=\"color:#000000;direction:ltr;font-family:Arial;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;\">\n" +
                        "                          <p style=\"margin: 0; margin-bottom: 16px;\">\n")
                .append(mailData.getDescription())
                .append("</p>\n" +
                        "                        </div>\n" +
                        "                      </td>\n" +
                        "                    </tr>\n" +
                        "                  </table>\n" +
                        "                </td>\n" +
                        "              </tr>\n" +
                        "              </tbody>\n" +
                        "            </table>\n" +
                        "          </td>\n" +
                        "        </tr>\n" +
                        "        </tbody>\n" +
                        "      </table>\n" +
                        "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\"\n" +
                        "             role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "        <tbody>\n" +
                        "        <tr>\n" +
                        "          <td>\n" +
                        "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                        "                   class=\"row-content stack\" role=\"presentation\"\n" +
                        "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                        "                   width=\"500\">\n" +
                        "              <tbody>\n" +
                        "              <tr>\n" +
                        "                <td class=\"column column-1\"\n" +
                        "                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                        "                    width=\"100%\">");
    }

    private void generateCommonFooter(StringBuilder stringBuilder) {
        stringBuilder.append("</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-7\"\n" +
                "       role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                   class=\"row-content stack\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                "                   width=\"500\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"column column-1\"\n" +
                "                        style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                        width=\"100%\">\n" +
                "                        <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\"\n" +
                "                               class=\"button_block\" role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                               width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <div align=\"center\"> <a\n");

                    stringBuilder.append("href=\"https://npqs-web-qa-release.netlify.app/auth/login\"");

                stringBuilder.append("style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#4c9345;border-radius:4px;width:auto;border-top:1px solid #8a3b8f;font-weight:400;border-right:1px solid #8a3b8f;border-bottom:1px solid #8a3b8f;border-left:1px solid #8a3b8f;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"\n" +
                "                                            target=\"_blank\"><span\n" +
                "                                            style=\"padding-left:20px;padding-right:20px;font-size:12px;display:inline-block;letter-spacing:normal;\"><span\n");
                    stringBuilder.append("style=\\\"font-size: 12px; line-height: 2; word-break: break-word; mso-line-height-alt: 24px;\\\">Login</span></span></a>");

                stringBuilder.append(
                "                                    </div>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-8\"\n" +
                "       role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                   class=\"row-content stack\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px;\"\n" +
                "                   width=\"500\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"column column-1\"\n" +
                "                        style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                        width=\"100%\">\n" +
                "                        <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\"\n" +
                "                               class=\"paragraph_block\" role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                               width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <div\n" +
                "                                            style=\"color:#000000;direction:ltr;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:13px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;\">\n" +
                "                                        <p style=\"margin: 0;\">\n" +
                "                                            <em>______________________________________________<br />This\n" +
                "                                                is system generated e-mail. Please do not\n" +
                "                                                reply.</em></p>\n" +
                "                                    </div>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "\n" +
                "</html>");
    }


    public String generateReportMessage(MailData mailData) {
//        List<Mark> all = markRepository.findAll();
        return generateReportMessagee(mailData);
    }
}
