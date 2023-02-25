package com.bridgelabz;
import java.time.LocalDate;
import java.util.*;
public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println(" Press\n 1 -> Retrieve data\n 2 -> Update City\n 3 ->Retrive particular data\n 4 -> Exit");
            switch (scanner.nextInt()) {
                case 1:
                    retrieveData();
                    break;
                case 2:
                    updateCity();
                    break;
                case 3:reteriveDataForParticularDate();
                break;
                case 4:
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
}