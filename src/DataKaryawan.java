import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Scanner;

public class DataKaryawan {
    private final ArrayList<Karyawan> dataKaryawan = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    @Contract(" -> new")
    private Karyawan buatData(){
        System.out.print("Kode Karyawan                     : ");
        String kode = sc.nextLine().toUpperCase();
        System.out.print("Nama Karyawan                     : ");
        String nama = sc.nextLine().toUpperCase();
        System.out.print("Alamat Karyawan                   : ");
        String alamat = sc.nextLine().toUpperCase();
        System.out.print("Tanggal Lahir(YYYY-MM-DD)         : ");
        String tanggal = sc.nextLine();
        System.out.print("Masukkan Golongan (A/B/C/D)       : ");
        char gol = sc.nextLine().toUpperCase().charAt(0);
        System.out.print("Sudah Menikah (0:belum | 1:sudah) : ");
        int status = Integer.parseInt(sc.nextLine());
        return new Karyawan(kode, nama, alamat, status, tanggal, gol);
    }
    void Menu(){
        while (true){
            System.out.println("Menu Utama");
            System.out.println("1. Tambah data");
            System.out.println("2. Hapus data");
            System.out.println("3. Cari data");
            System.out.println("4. Tampil data");
            System.out.println("5. Exit");
            System.out.print("Menu Pilihan : ");
            String opsi = sc.nextLine();
            switch (opsi){
                case "1" -> tambahData();
                case "2" -> hapusData();
                case "3" -> cariData();
                case "4" -> tampilData();
                case "5" -> System.exit(0);
                default -> System.out.println("Input tidak valid");
            }
        }

    }
    private void tambahData(){
        String opsi = "";
        while (!opsi.equals("1")){
            this.dataKaryawan.add(buatData());
            System.out.println("Pilih SubMenu");
            System.out.println("1. Kembali ke Menu utama");
            System.out.println("2. Tambah data lagi");
            System.out.print("Menu Pilihan : ");
            opsi = sc.nextLine();
        }

    }

    private void hapusData(){
        System.out.println("Sub Menu Hapus Data");
        String opsi = "";
        while (!opsi.equals("1")){
            System.out.println("Masukkan kode karyawan yang ingin dihapus : ");
            String kode = sc.nextLine();
            this.dataKaryawan.removeIf(item -> item.kodeKaryawan.equals(kode));
            System.out.println("Pilih SubMenu");
            System.out.println("1. Kembali ke Menu utama");
            System.out.println("2. hapus data lagi");
            System.out.print("Menu Pilihan : ");
            opsi = sc.nextLine();
        }


    }

    private void cariData(){
        System.out.println("SubMenu Cari Data");
        System.out.print("Masukkan kode karyawan yang ingin dicari   :");
        String kode = sc.nextLine();
        boolean found = false;
        int index = -1;
        for (int i = 0; i < dataKaryawan.size(); i++) {
            if (this.dataKaryawan.get(i).kodeKaryawan.equals(kode)){
                found = true;
                index = i;
            }
        }
        if (found){
            this.dataKaryawan.get(index).printCari();
        }else {
            System.out.println("Not found");
        }
        String opsi = "";
        while (!opsi.equals("1")){
            System.out.println("Pilih SubMenu");
            System.out.println("1. Kembali ke Menu utama");
            System.out.print("Menu Pilihan : ");
            opsi = sc.nextLine();
        }
    }

    private void tampilData(){
        System.out.println("SubMenu Tampil Data");
        System.out.println("============================================================");
        System.out.println("\t\tDATA KARYAWAN");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("KODE KARY\tNAMA KARY\t\tGOL\t\tUSIA\tSTATUS NIKAH\tJUMLAH ANAK");
        for (Karyawan item:this.dataKaryawan) {
            item.printTampil();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Jumlah Data : " + this.dataKaryawan.size());
        String opsi = "";
        while (!opsi.equals("1")){
            System.out.println("Pilih SubMenu");
            System.out.println("1. Kembali ke Menu utama");
            System.out.print("Menu Pilihan : ");
            opsi = sc.nextLine();
        }
    }
}
