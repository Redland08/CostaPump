/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costafarms.josepump;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernesto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LocalDateTime time_now = LocalDateTime.now();
        boolean current_status = false;
        Sensor last_status = new Sensor(current_status, time_now);
        String file_name = "file_pump.txt";

        File f = new File(file_name);
        if (f.isFile()) {
            System.out.println("The file exists");
            last_status = (Sensor) SerializableTools.deserializable(file_name);
            System.out.println("BEFORE: The value of last_status is: " + last_status.isStatus() 
             + " and the current status is: "+current_status);
            if (last_status.isStatus() != current_status) {
                if (last_status.isStatus() == true && current_status == false) {
                    //We have to end and safe the time
                    System.out.println("Pump ON at: "+last_status.getTime());
                    System.out.println("Pump OFF at: "+time_now);
                }
                else if (last_status.isStatus() == false && current_status == true) {
                    //We have to start the time
                    System.out.println("The pump was detected ON at: "+time_now);  
                }
                
                last_status.setStatus(current_status);
                last_status.setTime(time_now);
                SerializableTools.serializable(last_status, file_name);
            }
        } else {
            System.out.println("The file does not exists, we'll create the file using default values in Sensor class");
            //last_status.setStatus(current_status);
            SerializableTools.serializable(last_status, file_name);
        }
        
        System.out.println("AFTER: The value of sensor_test is: " + last_status.isStatus() 
             + " and the current status is: "+current_status);

    }

}
