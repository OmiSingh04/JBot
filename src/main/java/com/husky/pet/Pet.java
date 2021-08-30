package com.husky.pet;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet implements Runnable{

    private String name;
    private int health, hunger;
    private boolean running;

    private String path;

    public Pet(String name, int health){

        this.name = name;
        this.health = health;
        this.hunger = 0;
    }

    public void feed(int level){
        this.hunger -= (level * 10);
    }

    private void tick(){
        this.hunger -= 10;
    }

    private void saveToFile(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd_HH:mm:ss");
        String data[] = new String[4];
        data[0] = dtf.format(LocalDateTime.now());
        data[1] = this.name;
        data[2] = Integer.toString(this.health);
        data[3] = Integer.toString(this.hunger);
        String result  = data[0] + "," + data[1] + "," +data[2] + "," + data[3];
        System.out.println(result);
        try {
            FileWriter fileWriter = new FileWriter(Pet.class.getResource("/pet_log.csv").getPath(), true);
            fileWriter.write('\n' + result);
        } catch (IOException e) {
            System.err.println("BRUHHHHHHHHHHH");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        running = true;
        while(running){
            tick();

            try {
                Thread.sleep(5000);//sleep for a minute bruh
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveToFile();
        }
    }
}
