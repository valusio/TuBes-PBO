import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

//Class
public class ProgramApp {

    static Connection con;

    public static void main(String[] args) throws Exception {

        Integer pilihan;
        try (Scanner masukkan = new Scanner(System.in)) {
            boolean isLanjutkan = true;

            String url = "jdbc:mysql://localhost/ambatukam";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, "root", "");
                System.out.println("Driver Ready");

                while (isLanjutkan) {
                    System.out.println("");
                    System.out.println("*=======================================================*");
                    System.out.println("*   Cubicle Shop Poal  *");
                    System.out.println("*=======================================================*");
                    System.out.println("1. Produk Rubik yang Tersedia");
                    System.out.println("2. Lihat History Konsumen");
                    System.out.println("3. Input Data Konsumen");
                    System.out.println("4. Ubah Data Konsumen");
                    System.out.println("5. Cari Data Konsumen");
                    System.out.println("6. Hapus Data Konsumen");
                    System.out.println("7. Exit Program");
                    System.out.print("Masukkan Pilihan : ");
                    pilihan = masukkan.nextInt();

                    // Percabangan
                    switch (pilihan) {
                        case 1:
                            System.out.println("\n\tProduk Rubik yang Tersedia");
                            System.out.println("________________________________________\n");
                            PengadaanRubik beli5 = new PengadaanRubik();
                            beli5.tabelProdukRubik();
                            break;

                        case 2:
                            System.out.println("\n\tLihat History Konsumen");
                            System.out.println("________________________________________\n");
                            PengadaanRubik beli4 = new PengadaanRubik();
                            beli4.historyDatabase();
                            break;

                        case 3:
                            System.out.println("\n\tInput Data Belanja Konsumen");
                            System.out.println("________________________________________\n");
                            PengadaanRubik beli = new PengadaanRubik();
                            beli.kodeKonsumen();
                            beli.namaProduk();
                            beli.hargaSatuan();
                            beli.jumlah();
                            beli.hargaAwal();
                            beli.diskonProduk();
                            beli.totalBayar();
                            beli.tampilInfo1();
                            beli.database();

                            System.out.println("Data Berhasil di Inputkan");
                            System.out.println("");
                            break;

                        case 4:
                            System.out.println("\n\tUbah Data Konsumen");
                            System.out.println("________________________________________\n");
                            PengadaanRubik beli1 = new PengadaanRubik();
                            beli1.ubahData();
                            break;

                        case 5:
                            System.out.println("\n\tCari Data Konsumen");
                            System.out.println("________________________________________\n");
                            String cetak = "   pengecekan data konsumen";
                            String cetak1 = "Dicetak Pada";
                            // Method String
                            String GantiKalimat = cetak.replace("pengecekan", "MENAMPILKAN");
                            System.out.println("---------------------------------");
                            // Method String
                            System.out.println(GantiKalimat.toUpperCase());
                            System.out.println("---------------------------------");
                            // Method Date
                            DateFormat formatTanggal = new SimpleDateFormat("E, dd MMMM yyyy");
                            DateFormat formatJam = new SimpleDateFormat("HH:mm:ss");
                            Date tanggal = new Date();

                            PengadaanRubik beli2 = new PengadaanRubik();
                            beli2.tampilInfo();

                            System.out.println("-------------------------------");
                            // Method String
                            System.out.println("\t" + cetak1.toLowerCase());
                            // Method Date
                            System.out.println("Tanggal : " + formatTanggal.format(tanggal));
                            System.out.println("Jam     : " + formatJam.format(tanggal) + " WIB ");
                            System.out.println("-------------------------------");
                            System.out.println("");
                            break;

                        case 6:
                            System.out.println("\n\tHapus Data Konsumen");
                            System.out.println("________________________________________\n");
                            PengadaanRubik beli3 = new PengadaanRubik();
                            beli3.delete();
                            beli3.showdataBase();
                            break;

                        case 7:
                            System.exit(0);
                            break;

                        default:
                            System.out.println("MENU TIDAK TERSEDIA !!!!");
                            System.out.println("");
                            break;
                    }
                }

            }
            // Exception
            catch (ClassNotFoundException ex) {
                System.err.println("Driver error");
                System.exit(0);

            }
            // Exception
            catch (SQLException e) {
                System.err.println("Tidak berhasil Koneksi");
            }

        }
        // Exception
        catch (InputMismatchException e) {
            System.err.println("Inputan harus berupa angka");
        }
        // Exception
        finally {
            System.out.println("\n\tPROGRAM DIAKHIRI!!!");
        }

    }

}
