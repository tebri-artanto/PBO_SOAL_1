/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;
import table.TableTransaksi;

/**
 *
 * @author readybos
 */
public class TransaksiControl {
    private TransaksiDAO tDao = new TransaksiDAO();
    
    public void insertDataTransaksi(Transaksi t) {
        tDao.insertTransaksi(t);
    }
    
    public TableTransaksi showTransaksi(String query)
    {
        List<Transaksi> dataTransaksi = tDao.showTransaksi(query);
        TableTransaksi tableTransaksi = new TableTransaksi(dataTransaksi);

        return tableTransaksi;
    }
    
    public void updateDataTransaksi(Transaksi t) {
        tDao.updateTransaksi(t);
    }
    
    public void deleteTransaksi(int id) {
        tDao.deleteTransaksi(id);
    }
}
