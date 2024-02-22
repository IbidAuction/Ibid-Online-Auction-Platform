package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBService {
	public static String DRIVER;
    public static String URL;
    public static String USER;
    public static String PASSWORD;
    
    public static Connection openConnection() {
        try {
            System.out.println("driver " + DRIVER);
            Class.forName(DRIVER);
            System.out.println("beginning database connection...");
            Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
            return c;
        } catch (Exception ex) {
            System.out.println("database connection failed:==> "+ex.getMessage());
        }
        return null;
    }   
}
