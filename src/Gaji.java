public class Gaji {
    protected int gajiPokok;
    protected double tunjanganPasangan, tunjanganPegawai, tunjanganAnak;


    protected int getGajiPokok(char golongan){
        switch (golongan){
            case 'A' -> this.gajiPokok = 5000000;
            case 'B' -> this.gajiPokok = 6000000;
            case 'C' -> this.gajiPokok = 7000000;
            case 'D' -> this.gajiPokok = 8000000;
            default -> this.gajiPokok = 0;
        }
        return this.gajiPokok;
    }

    protected double getTunjanganPasangan(int status){
        if (status == 1) this.tunjanganPasangan = 0.1*this.gajiPokok;
        else this.tunjanganPasangan =0;
        return this.tunjanganPasangan;
    }

    protected double getTunjanganPegawai(int usia){
        if (usia > 30) this.tunjanganPegawai = 0.15*this.gajiPokok;
        else this.tunjanganPegawai =0;
        return this.tunjanganPegawai;
    }

    protected double getTunjanganAnak(int anak){
        return this.tunjanganAnak = 0.05*anak*this.gajiPokok;
    }

    protected double GajiKotor(){
        return this.gajiPokok + this.tunjanganPasangan + this.tunjanganPegawai + this.tunjanganAnak;
    }

    protected double Potongan(){
        return 0.025* this.GajiKotor();
    }

    protected double Gajibersih(){
        return this.GajiKotor() - this.Potongan();
    }

}
