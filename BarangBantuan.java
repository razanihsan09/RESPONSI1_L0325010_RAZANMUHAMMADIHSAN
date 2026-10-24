//L0325010 Razan Muhammad Ihsan//
package reponsi1;

public class BarangBantuan {
    private String kodeBarang;
    private String namaBarang;
    private String kategori;
    private double beratKg;

    public BarangBantuan(String kodeBarang, String namaBarang, String kategori, double beratKg) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.beratKg = beratKg;
    }

    public double getBeratKg() {
        return beratKg;
    }

    @Override
    public String toString() {
        return "- " + kodeBarang + " | " + namaBarang + " (" + kategori + ") | " + beratKg + " kg";
    }
}
