package com.example.superbank.model;

import lombok.Data;

import java.math.BigDecimal;


public class TransferBalance {

    private Long to;
    private Long from;
    private BigDecimal amount;

    public TransferBalance(Long to, Long from, BigDecimal amount) {
        this.to = to;
        this.from = from;
        this.amount = amount;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
