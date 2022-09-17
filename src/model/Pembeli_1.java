/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author readybos
 */
public class Pembeli_1 {
    private Integer id;
    private String nama;
    private String alamat;
    private String no_telepon;
    
    @Override
    public String toString(){
        return this.nama;
    }
    
    public Pembeli_1(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Pembeli_1(Integer id, String nama, String alamat, String no_telepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }

    public Pembeli_1(String nama, String alamat, String no_telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String showData()
    {
        return this.id + " | " + this.nama + " | " + this.alamat + " | " + this.no_telepon ;   
    }
}
