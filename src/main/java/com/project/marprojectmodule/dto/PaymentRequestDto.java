package com.project.marprojectmodule.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRequestDto {
    private String orderId;
    private long amount;



    //    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public long getAmount() {
//        return amount;
//    }
//
//    public void setAmount(long amount) {
//        this.amount = amount;
//    }
}
