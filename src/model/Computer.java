package model;

/**
 *
 * @author Ravelino Sebastian
 */
public class Computer {
    private String id;
    private String nama;
    private String processor;
    private int kapasitasRAM;
    private String jenis;
    private int dayaListrik;
    private int kapasitasBaterai;
    
    public Computer(String id, String nama, String processor, int kapasitasRAM, String jenis, int dayaListrik, int kapasitasBaterai) {
        this.id = id;
        this.nama = nama;
        this.processor = processor;
        this.kapasitasRAM = kapasitasRAM;
        this.jenis = jenis;
        this.dayaListrik = dayaListrik;
        this.kapasitasBaterai = kapasitasBaterai;
    }

    @Override
    public String toString(){
        return this.nama;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getKapasitasRAM() {
        return kapasitasRAM;
    }

    public void setKapasitasRAM(int kapasitasRAM) {
        this.kapasitasRAM = kapasitasRAM;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getDayaListrik() {
        return dayaListrik;
    }

    public void setDayaListrik(int dayaListrik) {
        this.dayaListrik = dayaListrik;
    }

    public int getKapasitasBaterai() {
        return kapasitasBaterai;
    }

    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }
    
    public String showData()
    {
        if(this.jenis.equalsIgnoreCase("Desktop"))
        {
            return this.id + " | " + this.nama + " | " + this.processor + " | " + 
                    this.kapasitasRAM + " | " + this.dayaListrik;
        }
        else if(this.jenis.equalsIgnoreCase("Laptop"))
        {
            return this.id + " | " + this.nama + " | " + this.processor + " | " + 
                    this.kapasitasRAM + " | " + this.kapasitasBaterai;
        }
        return null;
    }
}
