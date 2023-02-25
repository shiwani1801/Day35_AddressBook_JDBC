package com.bridgelabz;
import java.time.LocalDate;
import java.util.*;
public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println(" Press\n 1 -> Retrieve data\n 2 -> Update City\n 3 ->Retrive particular data\n 4 -> Retrieve Count of Contacts for City or State\n 5 -> Exit");
            switch (scanner.nextInt()) {
                case 1:
                    retrieveData();
                    break;
                case 2:
                    updateCity();
                    break;
                case 3:
                    reteriveDataForParticularDate();
                break;
                case 4:retrieveCountByCityOrState();
                break;
                case 5:
                    exit = true;
            }
        }
    }

    private static void retrieveData() {
        AddressBook addressBookRepo = new AddressBook();
        List<Contacts> employeeInfoList = addressBookRepo.retrieveData();
        for (Contacts employee : employeeInfoList) {
            System.out.println(employee + "\n");
        }
    }

    private static void updateCity() {
        AddressBook addressBookRepo = new AddressBook();
        System.out.println("Enter the address,city,state, zip  to Update");
        addressBookRepo.updateCityByZip(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt());
    }
    private static void reteriveDataForParticularDate() {
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter the Date of Joining (DD-MM-YY");
        System.out.println("Enter year , month and Day ex: 02 02 23");
        List<Contacts> employeeInfoList = addressBook
                .findDataParticularDate(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        for (Contacts employee : employeeInfoList) {
            System.out.println(employee + "\n");
        }
    }
    private static void retrieveCountByCityOrState() {
        AddressBook addressBookRepo = new AddressBook();
        System.out.println("Enter 1 -> Contacts count by City\n" + "2 -> Contacts count by State");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter city Name");
                int cityContactsCount = addressBookRepo.countByCity(scanner.next());
                System.out.println("Number of Contacts is Given city= " + cityContactsCount);
                break;
            case 2:
                System.out.println("Enter state name");
                int stateContactsCount = addressBookRepo.countByState(scanner.next());
                System.out.println("Number of Contacts is Given state= " + stateContactsCount);
                break;
        }

    }

}