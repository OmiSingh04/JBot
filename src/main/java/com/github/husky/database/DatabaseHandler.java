package com.github.husky.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.util.PSQLException;

import com.github.husky.Constant;

public class DatabaseHandler {
    public static Connection makeConnection(){
        Properties prop = new Properties();
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            prop.setProperty("port", "5432");
            prop.setProperty("user", Constant.DB_USERNAME);
            prop.setProperty("password", Constant.DB_PASSWORD);
            connection = DriverManager.getConnection(Constant.DB_URL, prop);
            
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+" : "+e.getMessage());
            System.exit(0);
        }
        return connection;
    }
    public static String insertData(Connection connection, DataClass data){
        PreparedStatement statement;
        try{
            String sql = "INSERT INTO money(uid, money) "+"VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, data.getUID());
            statement.setInt(2, data.getMoney());
            statement.executeUpdate();
            statement.close();

        }catch(PSQLException e) {
//        	e.printStackTrace();
        	if(e.toString().equals("org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint \"money_pkey\"\n"
        			+ "  Detail: Key (uid)=(874183946060046376) already exists.")) {
        		return "Already Registered!";
        	}
        }
        catch(SQLException e){
            	e.printStackTrace();
        }
        return "Registered!";
    }
    public static void alterData(Connection connection, DataClass data){
        PreparedStatement statement;
        try{
            String sql = "UPDATE money SET money=? WHERE uid=? ;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, data.getMoney());
            statement.setLong(2, data.getUID());
            statement.executeUpdate();
            statement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
