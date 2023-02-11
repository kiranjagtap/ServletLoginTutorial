package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepositoryImpl implements LoginRepository {

    private String jdbcUrl = null;
    private String dbDriver = null;
    private String dBusername = null;
    private String dBpassword = null;

    Connection conn = null;

    public LoginRepositoryImpl(String jdbcUrl, String dbDriver) {
        this.jdbcUrl = jdbcUrl;
        this.dbDriver = dbDriver;
    }

    @Override
    public boolean doLogin(String username, String password) {
        boolean isPresent = false;
        try {
            Class.forName(dbDriver).newInstance();
            conn = DriverManager.getConnection(jdbcUrl);

            PreparedStatement pstmt = conn.prepareStatement("select * from login where name=? and password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                dBusername = resultSet.getString("name");
                dBpassword = resultSet.getString("password");
            }



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Occurred " + e.getMessage());

        }

        if(null != dBpassword){
            return dBpassword.equals(password);
        }
        return false;

    }
}
