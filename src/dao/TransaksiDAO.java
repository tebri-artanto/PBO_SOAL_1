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
import model.Computer;
import model.Pembeli;
import model.Transaksi;

/**
 *
 * @author readybos
 */
public class TransaksiDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    
    public void insertTransaksi(Transaksi t) {
        
        con = dbcon.makeConnection();
        String sql = null;
        
        sql = "INSERT INTO computer_transaksi(id_computer, id_pembeli, tanggal_transaksi, total_harga, bonus) VALUES ('"
                + t.getComputer().getId() + "','"
                + t.getPembeli().getId()+ "','"
                + t.getTanggal_transaksi()+ "','"
                + t.getTotal_harga()+ "','"
                + t.getBonus()+ "')";

        System.out.println("Adding transaksi...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding transaksi...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public List<Transaksi> showTransaksi(String query) {
        
        Integer dayaListrik;
        Integer kapasitasBaterai;
        con = dbcon.makeConnection();
        
        String sql = "SELECT t.*, c.*, p.* FROM computer_transaksi as t "
                + "JOIN computer as c ON c.id = t.id_computer "
                + "JOIN computer_pembeli as p ON p.id = t.id_pembeli "
                + "WHERE (t.tanggal_transaksi LIKE '%" + query + "%'"
                + "OR t.total_harga LIKE '%" + query + "%'"
                + "OR t.bonus LIKE '%" + query + "%'"
                + "OR c.nama LIKE '%" + query + "%'"
                + "OR c.dayaListrik LIKE '%" + query + "%'"
                + "OR c.kapasitasBaterai LIKE '%" + query + "%'"
                + "OR c.jenis LIKE '%" + query + "%'"
                + "OR p.nama LIKE '%" + query + "%')";
        System.out.println("Mengambil data transaksi...");
        List<Transaksi> list = new ArrayList();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Integer temp = rs.getInt("c.dayaListrik");
                    if(Integer.valueOf(temp).equals(0)){
                        dayaListrik = 0;
                        kapasitasBaterai = Integer.parseInt(rs.getString("c.kapasitasBaterai"));
                    }else{
                        dayaListrik =  Integer.parseInt(rs.getString("c.dayaListrik"));
                        kapasitasBaterai = 0;
                    }
                    
                    Computer c = new Computer(rs.getString("c.id"),rs.getString("c.nama"),
                            rs.getString("c.processor"), Integer.parseInt(rs.getString("c.kapasitasRam")),
                            rs.getString("c.jenis"), dayaListrik, kapasitasBaterai);

                    //INI UNTUK UGD
                    //Pembeli p = new Pembeli(Integer.parseInt(rs.getString("p.id")), rs.getString("p.nama"));
                    
                    //INI UNTUK TUGAS
                    Pembeli p = new Pembeli(Integer.parseInt(rs.getString("p.id")), rs.getString("p.nama"),
                                    rs.getString("p.alamat"), rs.getString("p.no_telepon"));
                    
                    Transaksi t = new Transaksi(Integer.parseInt(rs.getString("t.id")),
                            rs.getString("t.tanggal_transaksi"), rs.getString("t.total_harga"),
                            rs.getString("t.bonus"), c, p);
                    
                    list.add(t);
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
    
    public void updateTransaksi(Transaksi t) {
        
        con = dbcon.makeConnection();
        
        String sql = "UPDATE computer_transaksi SET id_computer = '" + t.getComputer().getId()
                + "', id_pembeli = '" + t.getPembeli().getId()
                + "', tanggal_transaksi = '" + t.getTanggal_transaksi()
                + "', total_harga = '" + t.getTotal_harga()
                + "', bonus = '" + t.getBonus()
                + "' WHERE id = '" + t.getId() + "'";
        System.out.println("Editing jadwal tayang...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " transaksi " + t.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing transaksi...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public void deleteTransaksi(int id) {
        
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM computer_transaksi WHERE id = " + id + "";
        System.out.println("Deleting transaksi...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " transaksi " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting transaksi...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
}
