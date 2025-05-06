// File: JavaApplication2.java
package javaapplication2;

import java.util.Scanner;

class DataCatatan {
    int id;
    String judul;
    String isi;

    // Constructor default
    public DataCatatan() {}

    // Constructor dengan parameter
    public DataCatatan(int id, String judul, String isi) {
        this.id = id;
        this.judul = judul;
        this.isi = isi;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Judul: " + judul);
        System.out.println("Isi: " + isi);
    }

    public void edit(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }

    // Overriding toString
    @Override
    public String toString() {
        return "ID: " + id + " | Judul: " + judul + " | Isi: " + isi;
    }
}

public class JavaApplication2 {
    static Scanner input = new Scanner(System.in);
    static DataCatatan[] catatan = new DataCatatan[100];
    static int count = 0;

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\nMenu Aplikasi Catatan:");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Tampilkan Semua Catatan");
            System.out.println("3. Ubah Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // buffer

            switch (pilihan) {
                case 1: tambahCatatan(); break;
                case 2: tampilCatatan(); break;
                case 3: ubahCatatan(); break;
                case 4: hapusCatatan(); break;
                case 5: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);
    }

    static void tambahCatatan() {
        System.out.print("Masukkan judul: ");
        String judul = input.nextLine();
        System.out.print("Masukkan isi: ");
        String isi = input.nextLine();
        catatan[count] = new DataCatatan(count + 1, judul, isi);
        count++;
        System.out.println("Catatan berhasil ditambahkan!");
    }

    static void tampilCatatan() {
        if (count == 0) {
            System.out.println("Belum ada catatan.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(catatan[i]);
        }
    }

    static void ubahCatatan() {
        System.out.print("Masukkan ID catatan yang akan diubah: ");
        int id = input.nextInt(); input.nextLine();

        for (int i = 0; i < count; i++) {
            if (catatan[i].id == id) {
                System.out.print("Masukkan judul baru: ");
                String judul = input.nextLine();
                System.out.print("Masukkan isi baru: ");
                String isi = input.nextLine();
                catatan[i].edit(judul, isi);
                System.out.println("Catatan berhasil diubah!");
                return;
            }
        }
        System.out.println("Catatan tidak ditemukan.");
    }

    static void hapusCatatan() {
        System.out.print("Masukkan ID catatan yang akan dihapus: ");
        int id = input.nextInt(); input.nextLine();

        for (int i = 0; i < count; i++) {
            if (catatan[i].id == id) {
                for (int j = i; j < count - 1; j++) {
                    catatan[j] = catatan[j + 1];
                }
                catatan[count - 1] = null;
                count--;
                System.out.println("Catatan berhasil dihapus!");
                return;
            }
        }
        System.out.println("Catatan tidak ditemukan.");
    }
}
