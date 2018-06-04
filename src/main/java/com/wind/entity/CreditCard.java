package com.wind.entity;

import lombok.Data;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-30 15:59
 **/
@Data
public class CreditCard extends BillingDetails {

    private String number;

    private String expMonth;

    private String expYear;

}