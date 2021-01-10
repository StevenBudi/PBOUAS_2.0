import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public final class Karyawan extends Gaji{
    String kodeKaryawan, namaKaryawan, alamatKaryawan;
    int statusKaryawan, anakKaryawan, usiaKaryawan;
    Date tanggalLahirKaryawan;
    Scanner sc = new Scanner(System.in);
    char golonganKaryawan;

    Karyawan(String kode, String nama, String alamat, int status, String tanggal, char golongan){
        this.kodeKaryawan = kode;
        this.namaKaryawan = nama;
        this.alamatKaryawan = alamat;
        if (status == 1){
            System.out.print("Masukkan jumlah anak              : ");
            this.anakKaryawan = Integer.parseInt(sc.nextLine());
            this.statusKaryawan = 1;
        } else {
            this.statusKaryawan = 0;
            this.anakKaryawan = 0;
        }
        try {
            this.tanggalLahirKaryawan = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
            LocalDate now = LocalDate.now();
            LocalDate birth = Instant.ofEpochMilli(this.tanggalLahirKaryawan.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            Period age = Period.between(birth, now);
            this.usiaKaryawan = age.getYears();
        }catch (Exception e){
            System.out.println("error");
        }
        this.golonganKaryawan = golongan;
    }

    void printTampil(){
        String statusNikah = (this.statusKaryawan == 1) ? "Sudah Menikah" : "Belum Menikah";
        System.out.println(this.kodeKaryawan + "\t\t" + this.namaKaryawan + "\t\t\t"
                + this.golonganKaryawan + "\t\t" + this.usiaKaryawan + "\t\t" + statusNikah + "\t" + this.anakKaryawan);

    }

    void printCari(){
        System.out.println("Kode Karyawan       : " + this.kodeKaryawan);
        System.out.println("Nama Karyawan       : " + this.namaKaryawan);
        System.out.println("Tanggal Lahir       : " + this.tanggalLahirKaryawan);
        System.out.println("Alamat              : " + this.alamatKaryawan);
        System.out.println("Usia                : " + this.usiaKaryawan);
        String statusNikah = (this.statusKaryawan == 1) ? "Sudah Menikah" : "Belum Menikah";
        System.out.println("Status Menikah      : " + statusNikah);
        System.out.println("Jumlah Anak         : " + this.anakKaryawan);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Gaji Pokok          : " + super.getGajiPokok(this.golonganKaryawan));
        System.out.println("Tunjangan Pasangan  : " + super.getTunjanganPasangan(this.statusKaryawan));
        System.out.println("Tunjangan Pegawai   : " + super.getTunjanganPegawai(this.usiaKaryawan));
        System.out.println("Tunjangan Anak      : " + super.getTunjanganAnak(this.anakKaryawan));
        System.out.println("------------------------------------------------------------------------ +");
        System.out.println("Gaji Kotor          : " + super.GajiKotor());
        System.out.println("Potongan            : " + super.Potongan());
        System.out.println("------------------------------------------------------------------------ -");
        System.out.println("Gaji Bersih         : " + super.Gajibersih());
    }
}
