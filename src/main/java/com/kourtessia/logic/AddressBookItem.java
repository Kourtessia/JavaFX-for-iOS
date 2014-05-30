package com.kourtessia.logic;

public class AddressBookItem {
    private String firstName = "";
    private String lastName = "";
    private String fullAddress = "";
//
//    private String phoneNumber = "";
//    private String emailAddress = "";

    public AddressBookItem(String firstName, String lastName,
            String fullAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullAddress = fullAddress;
//        this.phoneNumber = phoneNumber;
//        this.emailAddress = emailAddress;
    }

    public String toString() {
        return String.format("%s %s %s", firstName, lastName,
                fullAddress);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
}
