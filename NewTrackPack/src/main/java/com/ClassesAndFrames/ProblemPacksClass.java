/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames;

/**
 *
 * @author LL
 */
public class ProblemPacksClass {
    private String IDopakovka;
    private String newID;
    private String datestamp;

    public String getIDopakovka() {
        return IDopakovka;
    }

    public void setIDopakovka(String IDopakovka) {
        this.IDopakovka = IDopakovka;
    }

    public String getNewID() {
        return newID;
    }

    public void setNewID(String newID) {
        this.newID = newID;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public ProblemPacksClass(String IDopakovka, String newID, String datestamp) {
        this.IDopakovka = IDopakovka;
        this.newID = newID;
        this.datestamp = datestamp;
    }
}
