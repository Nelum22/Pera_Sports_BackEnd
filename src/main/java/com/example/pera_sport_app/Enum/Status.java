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

package com.example.pera_sport_app.Enum;

public enum Status {

    DUE("DUE"),
    BILL_PAYMENT_VERIFIED("BILL_PAYMENT_VERIFIED"),APPLY("APPLY"),TEMPORARY("TEMPORARY"),READY_TO_REAPPLY("READY_TO_REAPPLY"),PENDING("PENDING"), CHECKED("CHECKED") ,REJECTED("REJECTED") ,APPROVED("APPROVED"), RECOMMENDED("RECOMMENDED"),
    VACATION("VACATION"), AVAILABLE("AVAILABLE"),
    CRO_APPROVED("CRO_APPROVED"),CRO_REJECTED("CRO_REJECTED"),AD_APPROVED("AD_APPROVED"),AD_REJECTED("AD_REJECTED"),DC_REJECTED("DC_REJECTED"),
    DG_APPROVED("DG_APPROVED"),DG_REJECTED("DG_REJECTED"),RESUBMISSION("RESUBMISSION"), ALL("ALL"),
    ELIGIBLE("ELIGIBLE"), NOT_ELIGIBLE("NOT_ELIGIBLE"), READY_TO_COLLECT("READY_TO_COLLECT"),
    READY_TO_ISSUE("READY_TO_ISSUE"), CONFIRM_TO_ISSUE("CONFIRM_TO_ISSUE"), ISSUED("ISSUED"), CREATED("CREATED"), PAID("PAID"),
    DISABLED("DISABLED"),
    EXPIRED("EXPIRED"), ACTIVE("ACTIVE"),INACTIVE("INACTIVE"),
    SUCCESS("SUCCESS"), SUSPENDED("SUSPENDED"),INCOMPLETE("INCOMPLETE"),
    FAILED("FAILED"),
    REPLIED("REPLIED"),
    CONFIRM_TO_CANCEL("CONFIRM_TO_CANCEL"),CONFIRM_TO_DUPLICATE("CONFIRM_TO_DUPLICATE"),READY_TO_PENDING("READY_TO_PENDING"),
    CANCELED("CANCELED"),DUPLICATED("DUPLICATED"),

    HOLD("HOLD"),PENDING_TO_CLARIFY("PENDING_TO_CLARIFY"), CLARIFIED("CLARIFIED"),REVIEWED("REVIEWED"),

    FULL_VALIDATION("FULL_VALIDATION"), SIGNATURE_VALIDATION("SIGNATURE_VALIDATION");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}