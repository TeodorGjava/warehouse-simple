/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames;


public class AllPacksClass {
    private String IDopakovka;
    private String Status;

    public AllPacksClass(String IDopakovka, String Status, String Location, String datestamp, String numWh) {
        this.IDopakovka = IDopakovka;
        this.Status = Status;
        this.Location = Location;
        this.datestamp = datestamp;
        this.numWh = numWh;
    }
    private String Location;
    private String datestamp;
    private String numWh;

    public String getIDopakovka() {
        return IDopakovka;
    }

    public String setIDopakovka(String str) {
        return str;
    }

    public String getStatus() {
        return Status;
    }

    public String setStatus(String str) {
        return str;
    }

    public String getLocation() {
        return Location;
    }

    public String setLocation(String str) {
        return str;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public String getNumWh() {
        return numWh;
    }

    public String setNumWh(String str) {
        return str;
    }
   
    
}
