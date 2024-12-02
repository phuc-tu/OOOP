import java.io.*;
import java.util.Scanner;

public class Main_Kh {
    public static void main(String[] args) throws IOException {
        DanhSachKhachHangImpl danhSach = new DanhSachKhachHangImpl();
        Scanner sc = new Scanner(System.in);

        // Doc du lieu tu file (neu co)
        try {
            danhSach.docFile("KhachHang.txt");
        } catch (IOException e) {
            System.out.println("Loi khi doc File: " + e.getMessage());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Them khach hang (va luu vao file)");
            System.out.println("2. Sua khach hang");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Tim khach hang");
            System.out.println("5. Hien thi danh sach khach hang");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    KhachHang kh = new KhachHang();
                    kh.nhap();
                    danhSach.themKhachhang(kh);
                    try {
                        danhSach.luuFile("KhachHang.txt");
                        System.out.println("Khach hang da duoc them va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu khach hang vao file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma khach hang can sua: ");
                    String idSua = sc.nextLine();
                    KhachHang khMoi = new KhachHang();
                    khMoi.nhap();
                    danhSach.suaKhachhang(idSua, khMoi);
                    try {
                        danhSach.luuFile("KhachHang.txt");
                        System.out.println("Khach hang da duoc sua va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu khach hang vao file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String idXoa = sc.nextLine();
                    danhSach.xoaKhachhang(idXoa);
                    try {
                        danhSach.luuFile("KhachHang.txt");
                        System.out.println("Khach hang da duoc xoa va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu khach hang vao file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma khach hang can tim: ");
                    String idTim = sc.nextLine();
                    KhachHang khTim = danhSach.timKhachHang(idTim);
                    System.out.println(khTim != null ? khTim : "Khong tim thay khach hang voi ma nay.");
                    break;

                case 5:
                    System.out.println("Danh sach khach hang:");
                    danhSach.hienThiKhachhang();
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
