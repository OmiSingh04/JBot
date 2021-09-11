package com.husky.pet;

public class randomTick {
    public static void tickController(int value){
        int ran = (int)(10*Math.random());
        int ticks = value*(5*6*(7/3)-10*value+ran*6*(7/3))*ran/10;
        System.out.println(ticks);
    }
    public static void main(String[] args){
        tickController(5);
    }
}
