package control;

import dao.ComputerDAO;
import java.util.List;
import model.Computer;

/**
 *
 * @author Ravelino Sebastian
 */
public class ComputerControl {
    private ComputerDAO fDao = new ComputerDAO();
    
    public void insertDataComputer(Computer c) {
        fDao.insertComputer(c);
    }
    
    public String showDataComputerDesktop() {
        List<Computer> dataComputerDesktop = fDao.showComputerDesktop();
        
        String computerString = "";
        for (int i=0; i < dataComputerDesktop.size(); i++) {
            computerString = computerString + dataComputerDesktop.get(i).showData() + "\n";
        }
        
        return computerString;
    }
    
    public String showDataComputerLaptop() {
        List<Computer> dataComputerLaptop = fDao.showComputerLaptop();
        
        String computerString = "";
        for (int i=0; i < dataComputerLaptop.size(); i++) {
            computerString = computerString + dataComputerLaptop.get(i).showData() + "\n";
        }
        
        return computerString;
    }
    
    public List<Computer> showListAllComputer() {
        List<Computer> dataC = fDao.showAllComputerLaptop();
        return dataC;
    }
    
    public Computer searchComputer(String id) {
        Computer c = null;
        c = fDao.searchComputer(id);
        
        return c;
    }
    
    public void updateDataComputer(Computer c, String id) {
        fDao.updateComputer(c, id);   
    }
    
    public void deleteDataComputer(String id) {
        fDao.deleteComputer(id);
    }
    
    public String getLastDesktopId() {
        List<Computer> dataComputerDesktop = fDao.showComputerDesktop();
        Computer c = dataComputerDesktop.get(dataComputerDesktop.size() - 1);
        
        String id = c.getId();
        
        return id;
    }
    
    public String getLastLaptopId() {
        List<Computer> dataComputerLaptop = fDao.showComputerLaptop();
        Computer c = dataComputerLaptop.get(dataComputerLaptop.size() - 1);
        
        String id = c.getId();
        
        return id;
    }
}
