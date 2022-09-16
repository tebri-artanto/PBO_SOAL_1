/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PembeliDAO;
import java.util.List;
import model.Pembeli;
import table.TablePembeli;

/**
 *
 * @author readybos
 */
public class PembeliControl {
    private PembeliDAO pDao = new PembeliDAO();
    
    public List<Pembeli> showListPembeli() {
        List<Pembeli> dataP = pDao.showPembeli();
        return dataP;
    }
    
    public void insertPembeli(Pembeli p){
        pDao.insertPembeli(p);
    }
    
    public TablePembeli showDataPembeli(String query){
        List<Pembeli> data = pDao.showPembeliBySearch(query);
        TablePembeli table = new TablePembeli(data);

        return table;
    }
    
    public Pembeli searchPembeli(Integer id){
        Pembeli p = null;
        p = pDao.searchPembeli(id);
        
        return p;
    }
    
    public void updateDataPembeli(Pembeli p, Integer id){
        pDao.updatePembeli(p, id);
    }
    
    public void deleteDataPembeli(Integer id){
        pDao.deletePembeli(id);
    }
}
