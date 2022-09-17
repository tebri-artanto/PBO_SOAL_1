/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MyLenovo
 */
public class Internasional extends Mahasiswa{
    private String nilaiToefl;

    public Internasional(String nilaiToefl, String nama, String npm, Prodi prodi) {
        super(nama, npm, prodi);
        this.nilaiToefl = nilaiToefl;
    }

    
    
    
}
