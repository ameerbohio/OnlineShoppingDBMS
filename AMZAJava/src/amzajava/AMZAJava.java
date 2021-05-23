/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amzajava;

/**
 *
 * @author ameer
 */
import java.sql.*;
import java.util.Scanner;

public class AMZAJava {

    Connection c = null;
    Statement stmt = null;

    public static Connection ConnectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:AMZNCA.db");
            System.out.println("Opened database successfully");
            return c;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Problem Encountered: " + e);
            return null;
        }
    }

    public static ResultSet QueryStatement(Connection c, String statement) {
        try {
            Class.forName("org.sqlite.JDBC");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            System.out.println("\nQuery successful ");
            return rs;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Problem Encountered: " + e);
            return null;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Connection c = ConnectDB();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        while (1 == 1) {
            System.out.println("What products are currently being shipped from warehouse to customer? type 1 \n"
                    + "Who are the sellers of a particular product (e.g a black LED desk lamp)?, type 2 \n"
                    + "What product(s) are sold by a particular seller?, type 3 \n"
                    + "How much does a certain product cost?, type 4 \n"
                    + "What delivery service will bring the product from warehouse to consumer?, type 5 \n"
                    + "What products were sold to a particular buyer?, type 6 \n"
                    + "What products are sold but still in the warehouse waiting for delivery?, type 7 \n"
                    + "What department has the most products sold?, type 8 \n"
                    + "What products are returned?, type 9 \n"
                    + "What is the rating of a particular product from a particular company?, type 10 \n"
                    + "Your command: ");
            String command = myObj.nextLine();  // Read user input
            switch (Integer.parseInt(command)) {
                case 1:
                    try {
                    ResultSet rs = QueryStatement(c, "SELECT ProductName FROM Product WHERE status = \"On delivery\"");
                    while (rs.next()) {
                        System.out.print(rs.getString("ProductName") + "\n");
                    }
                    System.out.print("\nenter to go back to main menu:");
                    String command1 = myObj.nextLine();
                } catch (SQLException e) {
                    System.err.println("Problem Encountered: " + e);
                }
                break;
                case 2: {
                    System.out.println("1 - LED Desk Lamp \n"
                            + "2 - Bicycle \n"
                            + "3 - LED Desk Lamp \n"
                            + "4 - Stratocaster guitar \n"
                            + "5 - Desk \n"
                            + "6 - Desk \n"
                            + "7 - Bicycle \n"
                            + "8 - Cast iron pan \n"
                            + "9 - Cast iron pan \n"
                            + "10 - Desk \n"
                            + "11 - Leather office chair \n"
                            + "Your command (type integer by product: ");
                    String command1 = myObj.nextLine();
                    try {
                        String request = "SELECT CompanyID FROM Product WHERE ProductID = " + command1;
                        System.out.print(request);
                        ResultSet rs = QueryStatement(c, request);
                        ResultSet rs2 = QueryStatement(c, "SELECT CompanyName FROM Company WHERE CompanyID = " + rs.getString("CompanyID"));
                        while (rs.next()) {
                            System.out.print(rs2.getString("CompanyName") + "\n");
                        }
                        System.out.print("\nenter to go back to main menu:");
                        String command2 = myObj.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Problem Encountered: " + e);
                    }
                    break;
                }
                case 3: {
                    System.out.println("1 - ACME Corp \n"
                            + "2 - Stuff Corp \n"
                            + "3 - MoreStuff Corp \n"
                            + "4 - EvenMoreStuff Corp \n"
                            + "5 - Yougetthepoint Corp \n"
                            + "6 - Allthestuff Corp \n"
                            + "7 - Everything Corp \n"
                            + "8 - Anything Corp \n"
                            + "9 - SellStuff Corp \n"
                            + "10 - Finally Corp \n"
                            + "Your command (type integer by product: ");
                    String command1 = myObj.nextLine();
                    try {
                        String request = "SELECT ProductID FROM Product WHERE CompanyID = " + command1;
                        System.out.print(request);
                        ResultSet rs = QueryStatement(c, request);
                        ResultSet rs2 = QueryStatement(c, "SELECT ProductName FROM Product WHERE ProductID = " + rs.getString("ProductID"));
                        while (rs.next()) {
                            System.out.print(rs2.getString("ProductName") + "\n");
                        }
                        System.out.print("\nenter to go back to main menu:");
                        String command2 = myObj.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Problem Encountered: " + e);
                    }
                    break;
                }
                case 4: {
                    System.out.println("1 - LED Desk Lamp \n"
                            + "2 - Bicycle \n"
                            + "3 - LED Desk Lamp \n"
                            + "4 - Stratocaster guitar \n"
                            + "5 - Desk \n"
                            + "6 - Desk \n"
                            + "7 - Bicycle \n"
                            + "8 - Cast iron pan \n"
                            + "9 - Cast iron pan \n"
                            + "10 - Desk \n"
                            + "11 - Leather office chair \n"
                            + "Your command (type integer by product: ");
                    String command1 = myObj.nextLine();
                    try {
                        String request = "SELECT Cost FROM Product WHERE ProductID = " + command1;
                        System.out.print(request);
                        ResultSet rs = QueryStatement(c, request);
                        while (rs.next()) {
                            System.out.print(rs.getString("Cost") + "\n");
                        }
                        System.out.print("\nenter to go back to main menu:");
                        String command2 = myObj.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Problem Encountered: " + e);
                    }
                    break;
                }
                case 5: {
                    System.out.println("1 - LED Desk Lamp \n"
                            + "2 - Bicycle \n"
                            + "3 - LED Desk Lamp \n"
                            + "4 - Stratocaster guitar \n"
                            + "5 - Desk \n"
                            + "6 - Desk \n"
                            + "7 - Bicycle \n"
                            + "8 - Cast iron pan \n"
                            + "9 - Cast iron pan \n"
                            + "10 - Desk \n"
                            + "11 - Leather office chair \n"
                            + "Your command (type integer by product: ");
                    String command1 = myObj.nextLine();
                    try {
                        String request = "SELECT ServiceName FROM Product WHERE ProductID = " + command1;
                        System.out.print(request);
                        ResultSet rs = QueryStatement(c, request);
                        while (rs.next()) {
                            System.out.print(rs.getString("ServiceName") + "\n");
                        }
                        System.out.print("\nenter to go back to main menu:");
                        String command2 = myObj.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Problem Encountered: " + e);
                    }
                    break;
                }
                case 6: {
                    System.out.println("1 - John Langner \n"
                            + "2 - Robert Bobert \n"
                            + "3 - Johnny Gooddeeds \n"
                            + "4 - Ameer Notbohio \n"
                            + "5 - Mike Wazowski \n"
                            + "6 - Robert Bobert \n"
                            + "7 - Bobby Robbinson \n"
                            + "8 - William Shake \n"
                            + "9 - Robin Dabank \n"
                            + "10 - Richy Poor \n"
                            + "Your command (type integer by product: ");
                    String command1 = myObj.nextLine();
                    try {
                        String request = "SELECT OrderID FROM BuyerOrder WHERE BuyerID = " + command1;
                        System.out.print(request);
                        ResultSet rs = QueryStatement(c, request);
                        while (rs.next()) {
                            ResultSet rs2 = QueryStatement(c, "SELECT ProductName FROM Product WHERE OrderID = " + rs.getString("OrderID"));
                            System.out.print(rs2.getString("ProductName") + "\n");
                        }
                        System.out.print("\nenter to go back to main menu:");
                        String command2 = myObj.nextLine();
                    } catch (SQLException e) {
                        System.err.println("Problem Encountered: " + e);
                    }
                    break;
                }
                case 7:
                    try {
                    ResultSet rs = QueryStatement(c, "SELECT ProductName FROM Product WHERE status = \"At warehouse\"");
                    while (rs.next()) {
                        System.out.print(rs.getString("ProductName") + "\n");
                    }
                    System.out.print("\nenter to go back to main menu:");
                    String command1 = myObj.nextLine();
                } catch (SQLException e) {
                    System.err.println("Problem Encountered: " + e);
                }
                break;
                case 8:
                    try {
                    ResultSet rs = QueryStatement(c, "SELECT Department FROM Product");
                    while (rs.next()) {
                        System.out.print(rs.getString("Department") + "\n");
                    }
                    System.out.print("\nenter to go back to main menu:");
                    String command1 = myObj.nextLine();
                } catch (SQLException e) {
                    System.err.println("Problem Encountered: " + e);
                }
                break;
                case 9:
                    try {
                    ResultSet rs = QueryStatement(c, "SELECT ProductName FROM Product WHERE status = \"Returned\"");
                    while (rs.next()) {
                        System.out.print(rs.getString("ProductName") + "\n");
                    }
                    System.out.print("\nenter to go back to main menu:");
                    String command1 = myObj.nextLine();
                } catch (SQLException e) {
                    System.err.println("Problem Encountered: " + e);
                }
                break;
                case 10:
                    try {
                    System.out.println("1 - LED Desk Lamp \n"
                            + "2 - Bicycle \n"
                            + "3 - LED Desk Lamp \n"
                            + "4 - Stratocaster guitar \n"
                            + "5 - Desk \n"
                            + "6 - Desk \n"
                            + "7 - Bicycle \n"
                            + "8 - Cast iron pan \n"
                            + "9 - Cast iron pan \n"
                            + "10 - Desk \n"
                            + "11 - Leather office chair \n"
                            + "Your command (type integer by product: ");
                    String command1 = myObj.nextLine();
                    String request = "SELECT Rating FROM Review WHERE ProductID = " + command1;
                    System.out.print(request);
                    ResultSet rs = QueryStatement(c, request);
                    while (rs.next()) {
                        System.out.print(rs.getString("Rating") + "\n");
                    }
                    System.out.print("\nenter to go back to main menu:");
                    String command2 = myObj.nextLine();
                } catch (SQLException e) {
                    System.err.println("Problem Encountered: " + e);
                }
                break;
                default:
                    break;
            }
        }

    }
}
