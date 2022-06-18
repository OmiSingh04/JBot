package com.github.husky.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.util.PSQLException;

import com.github.husky.Constant;
import com.github.husky.command.user.Users;

public class DatabaseHandler {
	public static Connection connection = null;
    public static void makeConnection(){
        Properties prop = new Properties();
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
    }
    public static String insertData(DataClass data){
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
    public static void alterData(DataClass data){
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
    public static DataClass getUser(DataClass data) {
    	DataClass result = new DataClass();
    	PreparedStatement statement;
    	if(checkUser(data)) {
	    	try {
	    		String sql = "SELECT * FROM money;";
	    		statement = connection.prepareStatement(sql);
	    		ResultSet rset = statement.executeQuery();
	            while(rset.next()) {
	            	long fetchUID = rset.getLong("uid");
	            	if(fetchUID == data.getUID()) {
	            		int money = rset.getInt("money");
	            		result.setMoney(money);
	            		break;
	            	}
	            }
	    		rset.close();
	    		statement.close();
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
    	}else {
    		Users.registerUser(data.getUID());
    	}
    	
    	return result;
    }
    
    public static boolean checkUser(DataClass data) {
    	PreparedStatement statement;
    	boolean check=false;
    	try {
    		String sql = "SELECT * FROM money;";
    		statement = connection.prepareStatement(sql);
    		ResultSet rset = statement.executeQuery();
    		while(rset.next()) {
    			long fetchUID = rset.getLong("uid");
    			if(fetchUID == data.getUID()) {
    				check=true;
    				break;
    			}
    		}
    	
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return check;
    }
}
