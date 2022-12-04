package com.dt.invoicecalculator.currency;

public final class MalformedCurrencyListException extends Exception {

    public MalformedCurrencyListException(String list) {
        super("Malformed currency list provided: " + list);
    }
}
