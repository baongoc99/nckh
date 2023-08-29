/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.pxu.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectJDBC {

    private static Connection connection;

    public ConnectJDBC() throws SQLException {
        getConnection();
    }

    public static Connection getConnection() throws SQLException {
        try {
            // kết nối với cơ sở dữ liệu
            connection = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/quanlypetshopnckh", "root", "Nguyenbaongoc99");
            //   Statement statement = connection.createStatement();
            // lấy dữ liệu từ cơ sở dữ liệu
            System.out.println("Kết nối thành công !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws Exception {
        new ConnectJDBC();
    }
}
