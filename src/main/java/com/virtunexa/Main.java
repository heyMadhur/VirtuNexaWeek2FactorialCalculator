package com.virtunexa;

import com.virtunexa.Database.DatabaseManager;

public class Main {
    public static void main(String[] args) {
//        Creating Table, if not exist
        DatabaseManager.createTable();
//        Launching CLI FrontEnd
        CLIFrontend.start();
    }
}