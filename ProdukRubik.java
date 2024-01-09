import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
 
//Class
public class ProdukRubik implements UserInterface{
    int kodeKons, noProduk, hargaProduk, jumlah, hargaAwal, totalHarga;
    String namaProduk, diskon, kemasan;


    static Connection con;

    Scanner masukkan = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/cubicle";

    @Override
    public void kodeKonsumen() throws SQLException{
        System.out.print("Masukkan Kode Konsumen: ");
        this.kodeKons = masukkan.nextInt();
        
    }

    @Override
    public void namaProduk() {
        System.out.println("\n ***NAMA PRODUK Rubik");
        System.out.println("1. Pocket Cube (2x2x2) ");
        System.out.println("2. Standard Cube (3x3x3) ");
        System.out.println("3. Master Cube (4x4x4) ");
        System.out.println("4. Professor's Cube (5x5x5) ");
        System.out.println("5. V-Cube 6 (6x6x6) ");
  


        System.out.print(" \t--->Pilih nomor produk: ");
        this.noProduk = masukkan.nextInt();
//Percabangan
            if (noProduk == 1) { 
                this.namaProduk = "Pocket Cube (2x2x2)";
            }
            else if (noProduk == 2) {
                this.namaProduk = "Standard Cube (3x3x3)";
            }
            else if (noProduk == 3) {
                this.namaProduk = "Master Cube (4x4x4)";
            }
            else if (noProduk == 4) {
                this.namaProduk = "Professor's Cube (5x5x5)";
            }
            else if (noProduk == 5) {
                this.namaProduk = "V-Cube 6 (6x6x6)";
            }
            else {
                System.out.println("\nNomor yang dimasukkan SALAH, mohon DIULANG kembali");
                
            }
        
    }

    @Override
    public void hargaSatuan() {
//Percabangan
            if (noProduk == 1) { 
                this.hargaProduk = 20000;
            }
            else if (noProduk == 2) {
                this.hargaProduk = 50000;
            }
            else if (noProduk == 3) {
                this.hargaProduk = 90000;
            }
            else if (noProduk == 4) {
                this.hargaProduk = 150000;
            }
            else if (noProduk == 5) {
                this.hargaProduk = 300000;
            }
            else {
                //System.out.println("\nMohon DIULANG kembali dengan cara Discard sistem ini !!!");
//Exception
                throw new IllegalAccessError("\nERROR, Nomor yang dimasukkan SALAH\n");
            }
        
    }

    @Override
    public void jumlah() {
        System.out.print("\nMasukkan jumlah produk rubik yang ingin dibeli: ");
        this.jumlah = masukkan.nextInt();
        
    }


    @Override
    public void hargaAwal() {
//Percabangan
//Proses Matematika
        if (noProduk == 1) {
            this.hargaAwal = 20000 * this.jumlah;
        }
        else if (noProduk == 2) {
            this.hargaAwal = 50000 * this.jumlah;
        }
        else if (noProduk == 3) {
            this.hargaAwal = 90000 * this.jumlah;
        }
        else if (noProduk == 4) {
            this.hargaAwal = 150000 * this.jumlah;
        }
        else if (noProduk == 5) {
            this.hargaAwal = 300000 * this.jumlah;
        }
        else {
            //System.out.println("\nMaaf Sub total tidak valid");
           throw new IllegalArgumentException( "\nERROR, Nomor yang dimasukkan SALAH\n" );
        }
        
    }

    @Override
    public void diskonProduk() {
        
    }

    @Override
    public void totalBayar() {
        
    }

    @Override
    public void tabelProdukRubik() {
        
    }
    

}
