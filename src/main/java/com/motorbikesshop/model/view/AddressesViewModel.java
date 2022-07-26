package com.motorbikesshop.model.view;

public class AddressesViewModel {

    private String street;

    private int streetNumber;

    private CityViewModel city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public CityViewModel getCity() {
        return city;
    }

    public void setCity(CityViewModel city) {
        this.city = city;
    }
}
