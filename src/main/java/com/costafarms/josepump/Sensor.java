/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costafarms.josepump;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author ernesto
 */
public class Sensor implements Serializable{
    
    public boolean status;
    public LocalDateTime time;
    
    public Sensor(boolean status, LocalDateTime time){
        this.status = status;
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    
    
    private void changeStatus(){
        if(status)
            status = false;
        else
            status = true;
    }
    
    
}
