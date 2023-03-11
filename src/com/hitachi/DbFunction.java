package com.hitachi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunction {
    public Connection connectToDb(String dbName, String username, String password) {
        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

            String dbURL = "jdbc:postgresql://localhost:5432/" + dbName;
            connection = DriverManager.getConnection(dbURL, username, password);

            if (connection != null) System.out.println("Connection established");
            else System.out.println("Connection failed");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void createTable(Connection connection, String tableName) {
        Statement statement;

        try {
//            String query = "create table " + tableName + "(empId SERIAL, name varchar(200), address varchar(200), primary key(empId));";
            String query = String.format("create table %s(empId SERIAL, name varchar(200), address varchar(200), primary key(empId));)", tableName);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert_row(Connection connection, String tableName, String name, String address) {
        Statement statement;

        try {

            String query = String.format("INSERT INTO %s(name, address) VALUES('%s', '%s');", tableName, name, address);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("Row inserted successfully !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_all(Connection connection, String tableName) {
        Statement statement;
        ResultSet resultSet;

        try {

            String query = String.format("select * from %s;", tableName);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                System.out.print(resultSet.getString("empId") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_by_name(Connection connection, String tableName, String name) {
        Statement statement;
        ResultSet resultSet;

        try {
            String query = String.format("Select * from %s where name='%s'",tableName, name);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.print(resultSet.getString("empId") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void select_by_address(Connection connection, String tableName, String address) {
        Statement statement;
        ResultSet resultSet;

        try {
            String query = String.format("Select * from %s where address='%s'",tableName, address);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.print(resultSet.getString("empId") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void select_by_id(Connection connection, String tableName, int empId) {
        Statement statement;
        ResultSet resultSet;

        try {
            String query = String.format("Select * from %s where empId=%s",tableName, empId);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.print(resultSet.getString("empId") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_data(Connection connection, String tableName, String newName, String oldName) {
        Statement statement;

        try {
            String query = String.format("update %s set name='%s' where name='%s'", tableName, newName, oldName);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete_byName(Connection connection, String tableName, String name) {
        Statement statement;
        try {
            String query = String.format("delete from %s where name='%s'", tableName, name);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("successfully deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete_data(Connection connection, String tableName) {
        Statement statement;
        try {

            String query = String.format("drop table %s", tableName);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("Table successfully dropped!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
