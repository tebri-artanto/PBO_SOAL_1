/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pembeli;

/**
 *
 * @author readybos
 */
public class TablePembeli extends AbstractTableModel{
    private List<Pembeli> list;
    
    public TablePembeli(List<Pembeli> list){
        this.list = list;
    }
    
    public int getRowCount() {
        return list.size();
    }
    
    public int getColumnCount() { //nama,email,id,no_telepon
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getNo_telepon();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            case 3:
                return "No. Telepon";
            default:
                return null;
        }
    }
}
