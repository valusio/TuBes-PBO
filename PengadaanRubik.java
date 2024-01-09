import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

//Class
//Inheritance
public class PengadaanRubik extends ProdukRubik {

    String url = "jdbc:mysql://localhost:3306/ambatukam";
    Scanner input = new Scanner(System.in);
    int totalBayar, hargaDiskon, kodeKons2, jumlahProd;

    public String kode, namaRubik, diskonRubik;
    public int harga, no;

    // Constructor
    public PengadaanRubik(String kodeBar, String namaBar, String diskonRubik, int harga) {
        this.kode = kodeBar;
        this.namaRubik = namaBar;
        this.harga = harga;
        this.diskonRubik = diskonRubik;
    }

    // Constructor
    public PengadaanRubik() {
    }

    @Override
    public void diskonProduk() {
        // Percabangan
        // Proses Matematika
        if (noProduk == 1) {
            this.diskon = "2%";
            this.hargaDiskon = this.hargaAwal * 2 / 100;
        } else if (noProduk == 2) {
            this.diskon = "2%";
            this.hargaDiskon = this.hargaAwal * 2 / 100;
        } else if (noProduk == 3) {
            this.diskon = "-";
            this.hargaDiskon = 0;
        } else if (noProduk == 4) {
            this.diskon = "3%";
            this.hargaDiskon = this.hargaAwal * 3 / 100;
        } else if (noProduk == 5) {
            this.diskon = "3%";
            this.hargaDiskon = this.hargaAwal * 3 / 100;
        }
    }

    @Override
    public void totalBayar() {
        // Percabangan
        // Proses Matematika
        if (noProduk == 1) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 2) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 3) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 4) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 5) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        }
    }

    // Collection Framework
    @Override
    public void tabelProdukRubik() {
        HashSet<PengadaanRubik> data = new HashSet<PengadaanRubik>();
        // Membuat daftar PengadaanRubik
        PengadaanRubik b1 = new PengadaanRubik("   Pocket    ", " Pocket Cube (2x2x2) ", "  2%    ", 20000);
        PengadaanRubik b2 = new PengadaanRubik("   Standard    ", " Standard Cube (3x3x3) ", "  2%    ", 50000);
        PengadaanRubik b3 = new PengadaanRubik("   Master  ", " Master Cube (4x4x4) ", "  -     ", 90000);
        PengadaanRubik b4 = new PengadaanRubik("   Professor  ", " Professor's Cube (5x5x5) ", "  3%    ", 150000);
        PengadaanRubik b5 = new PengadaanRubik("   V-cube ", " V-Cube 6 (6x6x6) ", "  3%    ", 300000);

        // Menambahkan PengadaanRubik ke HashSet
        data.add(b1);
        data.add(b2);
        data.add(b3);
        data.add(b4);
        data.add(b5);

        System.out.println("\n\t\t\t###        DAFTAR TABEL PRODUK RUBIK        ###");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "   Kode Rubik   |          Nama Rubik          |      Diskon     |   Harga Satuan");
        System.out.println(
                "_______________________________________________________________________________________________________________________");

        // Transversing (lintas) PengadaanRubik
        // Perulangan
        for (PengadaanRubik b : data) {
            System.out.println(
                    b.kode + "\t|" + b.namaRubik + "  \t|   " + b.diskonRubik + "\t|    Rp." + b.harga + ",-");
        }
    }

    // Pengolahan Database (CRUD)
    public void database() throws SQLException {
        String sql = "INSERT INTO cube (kode_konsumen, nama_produk, harga_satuan, jumlah, diskon, total_bayar) VALUES ('"
                + kodeKons + "', '" + namaProduk + "', '" + hargaProduk + "','" + jumlah + "','" + diskon + "','"
                + totalBayar + "')";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil input data!!!");
    }

    // Pengolahan Database (CRUD)
    public void tampilInfo() throws SQLException {

        System.out.print("Masukkan Kode Konsumen: ");
        kodeKons2 = input.nextInt();

        String sql = "SELECT * FROM cube WHERE kode_konsumen = " + kodeKons2;
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.println("\n**--------------------------------------------------------**");
            System.out.println("** \t INFORMASI KONSUMEN RUBIK\t  **");
            System.out.println("**--------------------------------------------------------**\n");
            System.out.print("Kode Konsumen   : ");
            System.out.println(result.getInt("kode_konsumen"));
            System.out.print("Nama Produk     : ");
            System.out.println(result.getString("nama_produk"));
            System.out.print("Harga Satuan    : Rp ");
            System.out.println(result.getInt("harga_satuan") + ",-");
            System.out.print("Jumlah          : ");
            System.out.println(result.getInt("jumlah") + " buah");
            System.out.print("Discount        : ");
            System.out.println(result.getString("diskon"));
            System.out.print("Total Bayar     : Rp ");
            System.out.println(result.getInt("total_bayar") + ",-\n");
        }
    }

    // Pengolahan Database (CRUD)
    public void tampilInfo1() throws SQLException {

        String sql = "SELECT * FROM cube WHERE kode_konsumen = " + kodeKons2;
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.println("\n**--------------------------------------------------------**");
            System.out.println("** \t INFORMASI KONSUMEN RUBIK\t  **");
            System.out.println("**--------------------------------------------------------**\n");
            System.out.print("Kode Konsumen   : ");
            System.out.println(result.getInt("kode_konsumen"));
            System.out.print("Nama Produk     : ");
            System.out.println(result.getString("nama_produk"));
            System.out.print("Harga Satuan    : Rp ");
            System.out.println(result.getInt("harga_satuan") + ",-");
            System.out.print("Jumlah          : ");
            System.out.println(result.getInt("jumlah") + " buah");
            System.out.print("Discount        : ");
            System.out.println(result.getString("diskon"));
            System.out.print("Total Bayar     : Rp ");
            System.out.println(result.getInt("total_bayar") + ",-\n");
        }
    }

    // Pengolahan Database (CRUD)
    public void ubahData() throws SQLException {
        String text3 = "\nPengubahan hisTory Konsumen";
        // Method String
        System.out.println(text3.toUpperCase());

        try {
            System.out.print("Masukkan kode konsumen yang akan di ubah : ");
            kodeKons2 = 0;
            kodeKons2 = input.nextInt();

            String sql = "SELECT * FROM cube WHERE kode_konsumen = " + kodeKons2;
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {

                System.out.println("\n ***NAMA PRODUK RUBIK");
                System.out.println("1. Pocket Cube (2x2x2) ");
                System.out.println("2. Standard Cube (3x3x3) ");
                System.out.println("3. Master Cube (4x4x4) ");
                System.out.println("4. Professor's Cube (5x5x5) ");
                System.out.println("5. V-Cube 6 (6x6x6) ");

                System.out.println("\n Nama Produk [" + result.getString("nama_produk") + "]\t: ");
                this.noProduk = masukkan.nextInt();
                // Percabangan
                if (noProduk == 1) {
                    this.namaProduk = "Pocket Cube (2x2x2)";
                } else if (noProduk == 2) {
                    this.namaProduk = "Standard Cube (3x3x3)";
                } else if (noProduk == 3) {
                    this.namaProduk = "Master Cube (4x4x4)";
                } else if (noProduk == 4) {
                    this.namaProduk = "Professor's Cube (5x5x5)";
                } else if (noProduk == 5) {
                    this.namaProduk = "V-Cube 6 (6x6x6)";
                } else {
                    System.out.println("\nNomor yang dimasukkan SALAH, mohon DIULANG kembali");

                }

                System.out.print("Jumlah produk [" + result.getInt("jumlah") + "]\t: ");
                int jumlahBar = input.nextInt();

                System.out.println("\n Harga Satuan [" + result.getInt("harga_satuan")
                        + "] (masukkan dg nomor produk sesuai)\t: ");
                this.noProduk = masukkan.nextInt();
                // Percabangan
                // Proses Matematika
                if (noProduk == 1) {
                    this.hargaProduk = 20000;
                } else if (noProduk == 2) {
                    this.hargaProduk = 50000;
                } else if (noProduk == 3) {
                    this.hargaProduk = 90000;
                } else if (noProduk == 4) {
                    this.hargaProduk = 150000;
                } else if (noProduk == 5) {
                    this.hargaProduk = 300000;
                }

                System.out.println("\n Total Harga yang Dibayar [" + result.getInt("total_bayar")
                        + "] (masukkan dg nomor produk sesuai)\t: ");
                this.noProduk = masukkan.nextInt();
                // Percabangan
                // Proses Matematika
                if (noProduk == 1) {
                    this.totalBayar = (20000 * jumlahBar) - (20000 * jumlahBar * 2 / 100);
                } else if (noProduk == 2) {
                    this.totalBayar = (50000 * jumlahBar) - (50000 * jumlahBar * 2 / 100);
                } else if (noProduk == 3) {
                    this.totalBayar = (90000 * jumlahBar) - (90000 * jumlahBar * 0 / 100);
                } else if (noProduk == 4) {
                    this.totalBayar = (150000 * jumlahBar) - (150000 * jumlahBar * 3 / 100);
                } else if (noProduk == 5) {
                    this.totalBayar = (300000 * jumlahBar) - (300000 * jumlahBar * 3 / 100);
                } else {
                    // System.out.println("\nMaaf Sub total tidak valid");
                    // Exception
                    throw new IllegalArgumentException("\nERROR, Nomor yang dimasukkan SALAH\n");
                }

                diskonProduk();

                sql = "UPDATE cube SET nama_produk='" + namaProduk + "', harga_satuan= '"
                        + hargaProduk + "', jumlah= '" + jumlahBar + "', diskon ='" + diskon + "', total_bayar ='"
                        + totalBayar + "' WHERE kode_konsumen='" + kodeKons2 + "'";

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("Berhasil memperbaharui data produk rubik (Kode Konsumen " + kodeKons2 + ")");
                }
            }
            statement.close();
        }
        // Exception
        catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
    }

    // Pengolahan Database (CRUD)
    public void showdataBase() throws SQLException {
        String sql = "SELECT kode_konsumen, nama_produk FROM cube";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nKode Konsumen\t  : ");
            System.out.print(result.getInt("kode_konsumen"));
            System.out.print("\nNama Produk\t : ");
            System.out.print(result.getString("nama_produk"));
            System.out.println("");
        }

    }

    // Pengolahan Database (CRUD)
    public void delete() {
        String text4 = "\nPenghapusan hisTory Konsumen";
        // Method String
        System.out.println(text4.toUpperCase());

        try {
            showdataBase();
            System.out.print("\nMasukan kode konsumen yang akan di Hapus : ");
            Integer kodeKons2 = Integer.parseInt(input.nextLine());

            String sql = "DELETE FROM cube WHERE kode_konsumen = " + kodeKons2;
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil menghapus data pemesanan konsumen (kode konsumen " + kodeKons2 + ")");
            }
        }
        // Exception
        catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam menghapus data");
        } catch (Exception e) {
            System.out.println("masukan data yang benar");
        }
    }

    // Pengolahan Database (CRUD)
    public void historyDatabase() throws SQLException {
        String sql = "SELECT kode_konsumen, nama_produk, diskon, jumlah, total_bayar FROM cube";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nKode Konsumen\t\t  : ");
            System.out.print(result.getInt("kode_konsumen"));
            System.out.print("\nNama Produk\t\t  : ");
            System.out.print(result.getString("nama_produk"));
            System.out.print("\nJumlah\t\t\t  : ");
            System.out.print(result.getInt("jumlah"));
            System.out.print("\nDiscount\t\t  : ");
            System.out.print(result.getString("diskon"));
            System.out.print("\nTotal Bayar Konsumen\t  : ");
            System.out.print(result.getInt("total_bayar"));
            System.out.println("\n-----------------------------------------\n");
        }

    }

}
