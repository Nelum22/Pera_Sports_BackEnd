package com.example.pera_sport_app.Mail.dto;

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


import lombok.Data;

@Data
public class MailData {
    private  String header;
    private String headerDescription;
    private String description;
    private String[] details;
    private String[] detailsDescription1;
    private String[] detailsDescription2;
    private String[] detailsDescription3;
    private String[] detailsDescription4;
}

