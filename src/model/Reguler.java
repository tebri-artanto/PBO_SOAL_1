/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyLenovo
 */
public class Reguler extends Mahasiswa{
    private String IPK;

    public Reguler(String IPK, String nama, String npm, Prodi prodi) {
        super(nama, npm, prodi);
        this.IPK = IPK;
    }
    
    
    
}
