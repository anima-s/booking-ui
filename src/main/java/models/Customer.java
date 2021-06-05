package models;

public class Customer {
    String name;
    String address;
    String city;
    String state;
    int zipcode;

    public Customer(String name, String address, String city, String state, int zipcode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }
}
