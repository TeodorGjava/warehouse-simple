/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames.logic;

/**
 * @author LL
 */
public class ProblemPacksClass {
    private final String IDopakovka;
    private final String newID;
    private final String datestamp;

    public ProblemPacksClass(String IDopakovka, String newID, String datestamp) {
        this.IDopakovka = IDopakovka;
        this.newID = newID;
        this.datestamp = datestamp;
    }

    public String getIDopakovka() {
        return IDopakovka;
    }

    public String getNewID() {
        return newID;
    }

    public String getDatestamp() {
        return datestamp;
    }

}
