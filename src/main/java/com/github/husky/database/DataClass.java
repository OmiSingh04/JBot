package com.github.husky.database;

public class DataClass {
    private long uid;
    private int money;

    public DataClass(long uid, int money){
        this.uid = uid;
        this.money = money;
    }
    
    public DataClass(long uid) {
    	this.uid = uid;
    }
    
    public long getUID() {
    	return uid;
    }
    
    public int getMoney() {
    	return money;
    }
    
    public void setMoney(int value) {
    	money = value;
    }
    
    public void setUID(long id) {
    	uid = id;
    }
}
