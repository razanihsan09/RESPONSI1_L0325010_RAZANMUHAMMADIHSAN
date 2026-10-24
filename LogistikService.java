//Razan Muhammad Ihsan
package reponsi1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogistikService {
    private ArrayList<BarangBantuan> daftarBarang = new ArrayList<>();

    public void tambahBarang(BarangBantuan barang) {
        daftarBarang.add(barang);
    }

    public boolean isEmpty() {
        return daftarBarang.isEmpty();
    }

    public void cetakManifes() {
        double totalBerat = 0;
        for (BarangBantuan b : daftarBarang) {
            totalBerat += b.getBeratKg();
        }

        String armada = (totalBerat <= 50) ? "Mobil Pickup" : "Truk Ekspedisi";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("manifest_pengiriman.txt"))) {
            writer.write("=== MANIFES PENGIRIMAN BANTUAN 3T ===\n");
            writer.write("Total Barang : " + daftarBarang.size() + " Item\n");
            writer.write("Total Berat  : " + totalBerat + " kg\n");
            writer.write("Label Armada : " + armada + "\n");
            writer.write("=====================================\n");
            writer.write("Daftar Muatan:\n");

            for (BarangBantuan b : daftarBarang) {
                writer.write(b.toString() + "\n");
            }

            System.out.println("Data manifes berhasil diekspor ke manifest_pengiriman.txt");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file manifes: " + e.getMessage());
        }
    }
}