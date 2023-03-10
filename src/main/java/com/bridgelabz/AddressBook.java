package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class AddressBook {
    Connection connection;

    static Connection getConnection() {
        String URL_JD = "jdbc:mysql://127.0.0.1:3306/addressbook_service?useSSL=false";
        String USER_NAME = "root";
        String PASSWORD = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!!");
            connection = DriverManager.getConnection(URL_JD, USER_NAME, PASSWORD);
            System.out.println("connection Established!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Contacts> retrieveData() {
        ResultSet resultSet = null;
        List<Contacts> addressBookList = new ArrayList<Contacts>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from AddressBook";
            resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()) {
                Contacts contactInfo = new Contacts();
                contactInfo.setFirstName(resultSet.getString("firstName"));
                contactInfo.setLastName(resultSet.getString("Lastname"));
                contactInfo.setAddress(resultSet.getString("address"));
                contactInfo.setCity(resultSet.getString("city"));
                contactInfo.setState(resultSet.getString("state"));
                contactInfo.setZip(resultSet.getInt("zip"));
                contactInfo.setPhoneNo(resultSet.getString("phoneNo"));
                contactInfo.setEmailId(resultSet.getString("email"));
                contactInfo.setName(resultSet.getString("name"));
                contactInfo.setType(resultSet.getString("Type"));

                addressBookList.add(contactInfo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return addressBookList;
    }

    public void updateCityByZip(String address, String city, String state, int zip) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "Update addressBook set address=" + "'" + address + "'" + ", " + "city=" + "'" + city + "'" + ", " + "state=" + "'" + state + "'" + ", " + "zip=" + zip +"";
            int result = statement.executeUpdate(query);
            System.out.println(result);
            if (result > 0) {
                System.out.println("Address Updated Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Contacts> findDataParticularDate(LocalDate date) {
        ResultSet resultSet = null;
        List<Contacts> addressBookList = new ArrayList<Contacts>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from  addressBook where dateadded between cast(' " + date + "'"
                    + " as date)  and date(now());";
            resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()) {
                Contacts contactInfo = new Contacts();
                contactInfo.setFirstName(resultSet.getString("firstName"));
                contactInfo.setLastName(resultSet.getString("lastname"));
                contactInfo.setAddress(resultSet.getString("address"));
                contactInfo.setCity(resultSet.getString("city"));
                contactInfo.setState(resultSet.getString("state"));
                contactInfo.setZip(resultSet.getInt("zip"));
                contactInfo.setPhoneNo(resultSet.getString("PhoneNumber"));
                contactInfo.setEmailId(resultSet.getString("email"));
                contactInfo.setName(resultSet.getString("name"));
                contactInfo.setType(resultSet.getString("Type"));
                contactInfo.setDate(resultSet.getDate("date").toLocalDate());

                addressBookList.add(contactInfo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return addressBookList;
    }
    public int countByCity(String city) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select count(firstname) from addressBook where city=" + "'" + city + "';";
            ResultSet result = statement.executeQuery(sql);
            result.next();
            int count = result.getInt(1);

            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countByState(String state) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select count(firstname) from addressBook where state=" + "'" + state + "';";
            ResultSet result = statement.executeQuery(sql);
            result.next();
            int count = result.getInt(1);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void insertData(Contacts add) throws SQLException {
        Connection connection =getConnection();
        try {
            if (connection != null) {
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();
                String sql = "insert into addressBook(firstname,lastname,address,city,state,zip,phoneNo,email,Name,Type,date)" +
                        "values('" + add.getFirstName() + "','" + add.getLastName() + "','" + add.getAddress() + "','" + add.getCity() +
                        "','" + add.getState() + "','" + add.getZip() + "','" + add.getPhoneNo() + "','" +
                        add.getEmailId() + "','" + add.getName() + "','" + add.getType() + "','" + add.getDate() + "');";
                int result = statement.executeUpdate(sql);
                connection.commit();
                if (result > 0) {
                    System.out.println("Contact Inserted");
                }
                connection.setAutoCommit(true);
            }
        } catch (SQLException sqlException) {
            System.out.println("Insertion Rollbacked");
            connection.rollback();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}