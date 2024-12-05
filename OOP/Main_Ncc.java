import java.io.*;
import java.util.Scanner;

public class Main_Ncc {
    public static void main(String[] args) throws IOException {
        DanhSachNhaCungCapImpl danhSach = new DanhSachNhaCungCapImpl();
        Scanner sc = new Scanner(System.in);

        danhSach.docFile("OOP/NhaCungCap.txt");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Them nha cung cap (va luu vao file)");
            System.out.println("2. Sua nha cung cap");
            System.out.println("3. Xoa nha cung cap");
            System.out.println("4. Tim nha cung cap");
            System.out.println("5. Hien thi danh sach nha cung cap");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.nhap();
                    danhSach.themNhaCungCap(ncc);
                    try {
                        danhSach.luuFile("OOP/NhaCungCap.txt");
                        System.out.println("Nha cung cap da duoc them va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nha cung cap vao file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma nha cung cap can sua: ");
                    String maSua = sc.nextLine();
                    NhaCungCap nccMoi = new NhaCungCap();
                    nccMoi.nhap();
                    danhSach.suaNhaCungCap(maSua, nccMoi);
                    try {
                        danhSach.luuFile("OOP/NhaCungCap.txt");
                        System.out.println("Nha cung cap da duoc sua va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nha cung cap vao file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma nha cung cap can xoa: ");
                    String maXoa = sc.nextLine();
                    danhSach.xoaNhaCungCap(maXoa);
                    try {
                        danhSach.luuFile("OOP/NhaCungCap.txt");
                        System.out.println("Nha cung cap da duoc xoa va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nha cung cap vao file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma nha cung cap can tim: ");
                    String maTim = sc.nextLine();
                    NhaCungCap nccTim = danhSach.timNhaCungCap(maTim);
                    System.out.println(nccTim != null ? nccTim : "Khong tim thay nha cung cap voi ma nay.");
                    break;

                case 5:
                    danhSach.hienThiNhaCungCap();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Chuong trinh ket thuc.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        }
        
    }
}
