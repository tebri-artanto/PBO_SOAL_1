/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *Ignatius Sodhana Tebri Artanto
 *200710680/PBO B
 */
public class DAO {
    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:/Dufan.mdb";

    public DAO() {
    }
    
    public void makeConnection() 
    {
        System.out.println("Opening database...");
        
        try 
        {
            CON = DriverManager.getConnection(url + path);
            System.out.println("Success opening database!");
        }
        
        catch(Exception e) 
        {
            System.out.println("Failed opening database...");
        }
    }
    
    public void closeConnection() 
    {
        System.out.println("Closing database...");
        try 
        {
            CON.close();
            System.out.println("Success closing database!");
        } 
        catch (Exception e) 
        {
            System.out.println("Failed closing database...");
        }
    }
    
    public void insertBadut(Badut badut)
    {
        String sql ="INSERT INTO Badut (Nama, NoTelp, JenisBadut, LamaKerja, Staff) VALUES ('"+badut.getNama()+"','"+badut.getNoTelp()+"','"+badut.getJenisBadut()+"','"+badut.getLamaKerja()+"','"+badut.isStaff()+"')";
        System.out.println("Adding Badut . . .");

        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added" + result + "Badut\n");
            statement.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error adding a Badut . . .");
            System.out.println(e);
        }
    }
    
    public Badut searchBadut(String Nama)
    {
        String sql="SELECT Nama, NoTelp, JenisBadut, LamaKerja, Staff FROM Badut Where Nama='"+Nama+"'"; 
        System.out.println("Searching Badut . . .");
        
        Badut B = null;
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            if(rs!=null)
            {
                while(rs.next())
                {
                    B = new Badut(rs.getString("Nama"), rs.getString("NoTelp"), rs.getString("JenisSulap"), rs.getInt("LamaKerja"), rs.getBoolean("Staff"));
                }
            }
            rs.close();
            statement.close();
        }
        catch(Exception Ex)
        {
            System.out.println("Error Reading Database Information . . .");
            System.out.println(Ex);
        }
        return B;
    }
    
    public List<Badut> ShowBadut() 
    {
        String sql = "SELECT Nama, NoTelp, JenisBadut, LamaKerja, Staff FROM Badut";
        System.out.println("Daftar Badut . . .");
        
        List<Badut> list = new ArrayList<>();
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null)
            {
            while (rs.next())
            {
                Badut B = new Badut(rs.getString("Nama"),
                        rs.getString("NoTelp"),
                        rs.getString("JenisBadut"),
                        Integer.parseInt(rs.getString("LamaKerja")),
                        rs.getBoolean("Staff"));
                list.add(B);
            }
        }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading Database Information . . .");
            System.out.println(e);
        }
        return list;
    }
    
    public boolean login(String _Username, String _Password)
    {
        boolean hasil = false;
        Login temp = new Login();
        String sql = "SELECT Username, Password from Login"
                    + " Where Username LIKE '%"+_Username+"%' and Password LIKE '%"+_Password+"%'";
        try
        {
            Statement state = CON.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs!=null)
            {
                while (rs.next())
                {
                    temp = new Login(rs.getString("Username"), rs.getString("Password"));
                    hasil = true;   
                }
            }
            rs.close();
            state.close();
        }
        catch(Exception EX)
        {
            System.out.println("Error opening the database...");
            System.out.println(EX);
        }
        return hasil;
    }
    
    public void insertPesulap(Pesulap pesulap)
    {
        String sql ="INSERT INTO Pesulap (Nama, NoTelp, JenisSulap, LamaKerja, Staff) VALUES ('"+pesulap.getNama()+"','"+pesulap.getNoTelp()+"','"+pesulap.getJenisSulap()+"','"+pesulap.getLamaKerja()+"','"+pesulap.isStaff()+"')";
        System.out.println("Adding Pesulap . . .");

        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added" + result + "Pesulap\n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding a Pesulap . . .");
            System.out.println(e);
        }
    }
    
    public Pesulap searchPesulap(String Nama)
    {
        String sql="SELECT Nama, NoTelp, JenisSulap, LamaKerja, Staff FROM Pesulap Where Nama='"+Nama+"'"; 
        System.out.println("Searching Karyawan . . .");
        
        Pesulap P = null;
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            if(rs!=null)
            {
                while(rs.next())
                {
                    P = new Pesulap(rs.getString("Nama"), rs.getString("NoTelp"), rs.getString("JenisSulap"), rs.getInt("LamaKerja"), rs.getBoolean("Staff"));
                }
            }
            rs.close();
            statement.close();
        }
        catch(Exception Ex)
        {
            System.out.println("Error Reading Database Information . . .");
            System.out.println(Ex);
        }
        return P;
    }
    
    public List<Pesulap> ShowPesulap() 
    {
        String sql = "SELECT Nama, Alamat, GajiTetap, Kategori, Kontrak FROM TabelAsisten";
        System.out.println("Daftar Asisten . . .");
        
        List<Pesulap> list = new ArrayList<>();
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null)
            {
            while (rs.next())
            {
                Pesulap P = new Pesulap(rs.getString("Nama"),
                        rs.getString("NoTelp"),
                        rs.getString("JenisPesulap"),
                        Integer.parseInt(rs.getString("LamaKerja")),
                        rs.getBoolean("Staff"));
                list.add(P);
            }
        }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading Database Information . . .");
            System.out.println(e);
        }
        return list;
    }
}
