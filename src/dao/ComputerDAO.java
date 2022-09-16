package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Computer;

/**
 *
 * @author Ravelino Sebastian
 */
public class ComputerDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertComputer(Computer c) {
        con = dbCon.makeConnection();
        String sql = null;
        
        if(c.getJenis().equalsIgnoreCase("Desktop"))
        {
            sql = "INSERT INTO computer(id, nama, processor, kapasitasRAM, jenis, dayaListrik) VALUES ('" 
                    + c.getId() + "','" + c.getNama()+ "','" + c.getProcessor()+ "',"
                    + c.getKapasitasRAM()+ ",'" + c.getJenis()+ "'," + c.getDayaListrik()+ ")";
        }
        else if(c.getJenis().equalsIgnoreCase("Laptop"))
        {
            sql = "INSERT INTO computer(id, nama, processor, kapasitasRAM, jenis, kapasitasBaterai) VALUES ('" 
                    + c.getId() + "','" + c.getNama()+ "','" + c.getProcessor()+ "',"
                    + c.getKapasitasRAM()+ ",'" + c.getJenis()+ "'," + c.getKapasitasBaterai()+ ")";
        }
        
        System.out.println("Adding Computer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Computer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Computer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Computer> showComputerDesktop() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer WHERE jenis = 'desktop'";
        System.out.println("Mengambil data Computer...");
        
        List<Computer> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    Computer c = new Computer(
                            rs.getString("id"), 
                            rs.getString("nama"), 
                            rs.getString("processor"),
                            rs.getInt("kapasitasRAM"), 
                            rs.getString("jenis"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai")
                    );
                    list.add(c);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public List<Computer> showComputerLaptop() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer WHERE jenis = 'laptop'";
        System.out.println("Mengambil data Computer...");
        
        List<Computer> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    Computer c = new Computer(
                            rs.getString("id"), 
                            rs.getString("nama"), 
                            rs.getString("processor"),
                            rs.getInt("kapasitasRAM"), 
                            rs.getString("jenis"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai")
                    );
                    list.add(c);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public List<Computer> showAllComputerLaptop() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer ";
        System.out.println("Mengambil data Computer...");
        
        List<Computer> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    Computer c = new Computer(
                            rs.getString("id"), 
                            rs.getString("nama"), 
                            rs.getString("processor"),
                            rs.getInt("kapasitasRAM"), 
                            rs.getString("jenis"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai")
                    );
                    list.add(c);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public Computer searchComputer(String id) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer WHERE id = '"+ id + "'";
        System.out.println("Searching Computer...");
        Computer c = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    c = new Computer(
                            rs.getString("id"), 
                            rs.getString("nama"), 
                            rs.getString("processor"),
                            rs.getInt("kapasitasRAM"), 
                            rs.getString("jenis"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai")
                    );
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return c;
    }
    
    public void updateComputer(Computer c, String id) {
        con = dbCon.makeConnection();
        String sql = null;
        
        if(c.getJenis().equalsIgnoreCase("Desktop"))
        {
            sql = "UPDATE computer SET nama = '" + c.getNama() + "', "
                    + "processor = '" + c.getProcessor() + "', "
                    + "kapasitasRAM = " + c.getKapasitasRAM() + ", "
                    + "jenis = '" + c.getJenis() + "', "
                    + "dayaListrik = " + c.getDayaListrik()+ " "
                    + "WHERE id = '" + id + "'";
        }
        else if(c.getJenis().equalsIgnoreCase("Laptop"))
        {
            sql = "UPDATE computer SET nama = '" + c.getNama() + "', "
                    + "processor = '" + c.getProcessor() + "', "
                    + "kapasitasRAM = " + c.getKapasitasRAM() + ", "
                    + "jenis = '" + c.getJenis() + "', "
                    + "kapasitasBaterai = " + c.getKapasitasBaterai()+ " "
                    + "WHERE id = '" + id + "'";
        }
        System.out.println("Editing Computer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Computer" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Computer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteComputer(String id) {
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM computer WHERE id = '" + id + "'";
        System.out.println("Deleting Computer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Computer" + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Computer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
