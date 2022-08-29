/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames.logic;

/**
 * @author LL
 */
public class ClientsClass {
    private final String IDopakovka;
    private final String Status;
    private final String Location;
    private String datestamp;
    private final String numWh;

    public ClientsClass(String IDopakovka, String Status, String Location, String datestamp, String numWh) {
        this.IDopakovka = IDopakovka;
        this.Status = Status;
        this.Location = Location;
        this.datestamp = datestamp;
        this.numWh = numWh;
    }

    public String getIDopakovka() {
        return IDopakovka;
    }

    public String getStatus() {
        return Status;
    }

    public String getLocation() {
        return Location;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public String getNumWh() {
        return numWh;
    }


}
