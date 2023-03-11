package com.hitachi;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbFunction db = new DbFunction();
        Connection connection = db.connectToDb("demo", "postgres", "postgres");

        String tableName = "employee";
        // 1. Creates database ;
        //  db.createTable(connection, tableName);

        /** 2. Insert into database :
         db.insert_row(connection, tableName, "Shreyash", "India");
         db.insert_row(connection, tableName, "Sachin", "USA");
         db.insert_row(connection, tableName, "Mohit", "Indonesia");
         */

        /** 3. Read data and Search data : */
//        db.select_all(connection, tableName);
        /**output :
         * 2 Shreyash India
         * 3 Sachin USA
         * 4 Mohit Indonesia
         */

//        db.select_by_name(connection, tableName,"Shreyash");
        /**output :
         * 2 Shreyash India
         */

//        db.select_by_address(connection, tableName,"USA");
        /**
         * 3 Sachin USA
         */

//        db.select_by_id(connection, tableName, 4);
        /**
         * 4 Mohit Indonesia
         */

        //  4. update data :
//        db.update_data(connection, tableName, "Sai", "Mohit");
//        db.select_all(connection, tableName);
        /**
         * Successfully updated!
         * 2 Shreyash India
         * 3 Sachin USA
         * 4 Sai Indonesia
         */

        // 5. Delete data :
//        db.delete_byName(connection, tableName, "Sachin");
//        db.select_all(connection, tableName);
        /**
         * successfully deleted!
         * 2 Shreyash India
         * 4 Sai Indonesia
         */

        // 6. Delete complete table :
        db.delete_data(connection, tableName);
    }
}
