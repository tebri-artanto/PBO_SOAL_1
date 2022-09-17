/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyLenovo
 */
public abstract class Mahasiswa {
    protected String nama;
    protected String npm;
    protected Prodi prodi;

    public Mahasiswa(String nama, String npm, Prodi prodi) {
        this.nama = nama;
        this.npm = npm;
        this.prodi = prodi;
    }
  

    
    
}
