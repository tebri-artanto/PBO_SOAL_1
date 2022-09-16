/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pembeli;

/**
 *
 * @author readybos
 */
public class PembeliDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    //hanya menggunakan read data untuk mengisi value model dropdown nama penanggung jawab di view.
    public List<Pembeli> showPembeli() {
        
        con = dbcon.makeConnection();
        
        String sql = "SELECT p.* FROM computer_pembeli as p ";
            
        System.out.println("Mengambil data pembeli...");
        List<Pembeli> list = new ArrayList();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    //INI UNTUK UGD
                    //Pembeli p = new Pembeli(Integer.parseInt(rs.getString("p.id")), rs.getString("p.nama"));
                    
                    //INI UNTUK TUGAS
                    Pembeli p = new Pembeli(Integer.parseInt(rs.getString("p.id")), rs.getString("p.nama"),
                                    rs.getString("p.alamat"), rs.getString("p.no_telepon"));
                    
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
        
        return list;
    }
    
    public List<Pembeli> showPembeliBySearch(String query) {
        
        con = dbcon.makeConnection();
        
        String sql = "SELECT p.* FROM computer_pembeli as p "
                + "WHERE (p.id LIKE '%" + query + "%'"
                + "OR p.alamat LIKE '%" + query + "%'"
                + "OR p.no_telepon LIKE '%" + query + "%'"
                + "OR p.nama LIKE '%" + query + "%')";
        System.out.println("Mengambil data pembeli...");
        List<Pembeli> list = new ArrayList();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
 
                    Pembeli p = new Pembeli(Integer.parseInt(rs.getString("p.id")), rs.getString("p.nama"), 
                                            rs.getString("p.alamat"), rs.getString("p.no_telepon"));
           
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
        
        return list;
    }
    
    public void insertPembeli(Pembeli p){
        
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO computer_pembeli(nama, alamat, no_telepon) VALUES ('"
                + p.getNama() + "','" + p.getAlamat() + "','" 
                + p.getNo_telepon() + "')";
        
        System.out.println("Adding pembeli...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " pembeli");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Adding pembeli");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public void updatePembeli(Pembeli p, Integer id){
        
        con = dbcon.makeConnection();
        
        String sql = "UPDATE computer_pembeli SET nama ='" + p.getNama() + "', alamat ='" + p.getAlamat()
                + "', no_telepon ='" + p.getNo_telepon()+ "' WHERE id = '" + id + "'";
        System.out.println("Editing pembeli...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Pembeli " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing pembeli...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public Pembeli searchPembeli(Integer id){
        
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM computer_pembeli WHERE id = '" + id + "'";
        System.out.println("Searching pembeli...");
        
        Pembeli p = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    p = new Pembeli(Integer.parseInt(rs.getString("id")) ,
                        rs.getString("nama"), rs.getString("alamat"),
                        rs.getString("no_telepon"));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
        
        return p;
    }
    
    public void deletePembeli(Integer id){
        
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM computer_pembeli WHERE id = '" + id + "'";
        System.out.println("Deleting pembeli...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + "Pembeli" + id );
            statement.close();
        }catch(Exception e){
            System.out.println("Error deleting pembeli...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
}
