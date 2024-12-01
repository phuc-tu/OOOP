import java.io.*;
import java.util.Scanner;

public class Main_Pnh {
    public static void main(String[] args) throws IOException {
        DanhSachPhieuNhapHangImpl danhSach = new DanhSachPhieuNhapHangImpl();
        Scanner sc = new Scanner(System.in);

        // Doc du lieu tu file (neu co)
        try {
            danhSach.docFile("PhieuNhap.txt");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Them phieu nhap (va luu vao file)");
            System.out.println("2. Sua phieu nhap");
            System.out.println("3. Xoa phieu nhap");
            System.out.println("4. Tim phieu nhap");
            System.out.println("5. Hien thi danh sach phieu nhap");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Doc ky tu newline con lai

            switch (choice) {
                case 1:
                    // Them phieu nhap moi
                    PhieuNhapHang phieu = new PhieuNhapHang();
                    phieu.nhap(); // Nhap thong tin phieu nhap moi
                    danhSach.themPhieu(phieu); // Them phieu nhap vao danh sach
                    try {
                        danhSach.luuFile("PhieuNhap.txt"); // Ghi danh sach phieu nhap vao file
                        System.out.println("Phieu nhap da duoc them va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu phieu nhap vao file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma phieu can sua: ");
                    String maSua = sc.nextLine();
                    PhieuNhapHang phieuMoi = new PhieuNhapHang();
                    phieuMoi.nhap();
                    danhSach.suaPhieu(maSua, phieuMoi);
                    try {
                        danhSach.luuFile("PhieuNhap.txt"); // Luu lai danh sach phieu nhap sau khi sua
                        System.out.println("Phieu nhap da duoc sua va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu phieu nhap vao file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma phieu can xoa: ");
                    String maXoa = sc.nextLine();
                    danhSach.xoaPhieu(maXoa);
                    try {
                        danhSach.luuFile("PhieuNhap.txt"); // Luu lai danh sach phieu nhap sau khi xoa
                        System.out.println("Phieu nhap da duoc xoa va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu phieu nhap vao file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma phieu can tim: ");
                    String maTim = sc.nextLine();
                    PhieuNhapHang phieuTim = danhSach.timPhieu(maTim);
                    System.out.println(phieuTim != null ? phieuTim : "Khong tim thay phieu nhap voi ma nay.");
                    break;

                case 5:
                    System.out.println("Danh sach phieu nhap:");
                    danhSach.hienThiPhieu();
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
        sc.close();
    }
}
