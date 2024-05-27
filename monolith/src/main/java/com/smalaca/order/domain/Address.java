package com.smalaca.order.domain;

class Address {
    private final String street;
    private final String postalCode;
    private final String city;

    Address(String street, String postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }
}
