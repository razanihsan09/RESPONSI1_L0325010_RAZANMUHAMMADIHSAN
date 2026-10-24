//Razan Muhammad Ihsan
package reponsi1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LogistikService service = new LogistikService();
        boolean isRunning = true;

        System.out.println("=== Sistem Logistik Bantuan 3T ===");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Barang Bantuan");
            System.out.println("2. Selesai dan Cetak Manifes");
            System.out.print("Pilih menu (1/2): ");

            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                try {
                    System.out.print("Masukkan Kode Barang (diawali EDX-): ");
                    String kode = scanner.nextLine();

                    if (!kode.startsWith("EDX-")) {
                        throw new IllegalArgumentException("Kode barang harus diawali EDX-");
                    }

                    System.out.print("Masukkan Nama Barang: ");
                    String nama = scanner.nextLine();

                    System.out.print("Masukkan Kategori: ");
                    String kategori = scanner.nextLine();

                    System.out.print("Masukkan Berat Barang (kg): ");
                    double berat = scanner.nextDouble();
                    scanner.nextLine();

                    if (berat <= 0) {
                        throw new BeratInvalidException("Berat barang tidak boleh bernilai negatif atau nol.");
                    }

                    service.tambahBarang(new BarangBantuan(kode, nama, kategori, berat));
                    System.out.println("-> Barang berhasil ditambahkan!");

                } catch (IllegalArgumentException | BeratInvalidException e) {
                    System.out.println("GALAT VALIDASI: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("GALAT TIPE DATA: Input berat harus berupa angka desimal!");
                    scanner.nextLine();
                } finally {
                    System.out.println("--- Selesai memproses percobaan input ---");
                }

            } else if (pilihan.equals("2")) {
                if (service.isEmpty()) {
                    System.out.println("Daftar barang masih kosong. Manifes dibatalkan.");
                    continue;
                }
                service.cetakManifes();
                isRunning = false;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}
