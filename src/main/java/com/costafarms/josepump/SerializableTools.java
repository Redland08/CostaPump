/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costafarms.josepump;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernesto
 */
public class SerializableTools {
    
    public static void serializable(Object obj, String name){
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(obj);
            //The object has been serialized
            out.close();
            file.close();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
    }
    
    public static Object deserializable(String name){
        Object obj = null;
        try {
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream input = new ObjectInputStream(file);
            try {
                obj = (Object)input.readObject();
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException is caught");
            }
            input.close();
            file.close();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
        return obj;
    }
}
