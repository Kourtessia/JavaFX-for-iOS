package com.kourtessia.logic;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import com.cedarsoftware.util.io.JsonReader;
//import com.cedarsoftware.util.io.JsonWriter;

public final class AddressBook {
    private ObservableList<AddressBookItem> addresses;

    private static AddressBook instance;

    private AddressBook() {
        addresses = FXCollections.observableArrayList();
    }

    public static AddressBook getInstance() {
        if (AddressBook.instance == null) {
            instance = new AddressBook();
        }
        return instance;
    }

    public void addAddress(final AddressBookItem newItem) {
        addresses.add(newItem);
    }

    public boolean removeAddress(final AddressBookItem removingItem) {
        return addresses.remove(removingItem);
    }

    public AddressBookItem removeAddress(final int removingItemIndex) {
        return addresses.remove(removingItemIndex);
    }

    public AddressBookItem getAddress(final AddressBookItem item) {
        return addresses.get(addresses.indexOf(item));
    }

    public int getAddressIndex(final AddressBookItem address) {
        return addresses.indexOf(address);
    }

    public ObservableList<AddressBookItem> getObservableAddresses() {
        return addresses;
    }

    public String saveToJson() {
        String serialized = null;
        return serialized;
    }

    public void loadFromJson(final String jsonSource) {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (AddressBookItem address : addresses) {
            stringBuilder.append(address.toString());
        }
        return stringBuilder.toString();
    }
}
