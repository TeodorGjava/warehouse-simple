/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames.logic;

/**
 *
 * @author LL
 */
public class CommentsClass {
    private final String IDopakovka;
    private final String comment;
    private final String datestamp;

    public String getIDopakovka() {
        return IDopakovka;
    }

    public String getComment() {
        return comment;
    }


    public String getDatestamp() {
        return datestamp;
    }

    public CommentsClass(String IDopakovka, String comment, String datestamp) {
        this.IDopakovka = IDopakovka;
        this.comment = comment;
        this.datestamp = datestamp;
    }
    
}
