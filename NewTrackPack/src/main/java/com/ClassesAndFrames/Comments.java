/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames;

/**
 *
 * @author LL
 */
public class Comments {
    String IDopakovka;
    String comment;
    String datestamp;

    public String getIDopakovka() {
        return IDopakovka;
    }

    public void setIDopakovka(String IDopakovka) {
        this.IDopakovka = IDopakovka;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }

    public Comments(String IDopakovka, String comment, String datestamp) {
        this.IDopakovka = IDopakovka;
        this.comment = comment;
        this.datestamp = datestamp;
    }
    
}
