import java.io.*;
import java.util.Scanner;

public class Main_Nv {
    public static void main(String[] args) throws IOException {
        DanhSachNhanVienImpl danhSach = new DanhSachNhanVienImpl();
        Scanner sc = new Scanner(System.in);

        try {
            danhSach.docFile("NhanVien.txt");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n========== QUAN LY NHAN VIEN ==========");
            System.out.println("1. Them nhan vien (va luu vao file)");
            System.out.println("2. Sua nhan vien");
            System.out.println("3. Xoa nhan vien");
            System.out.println("4. Tim nhan vien theo ma");
            System.out.println("5. Tim nhan vien gan dung theo ten");
            System.out.println("6. Hien thi danh sach nhan vien");
            System.out.println("7. Thoat");
            System.out.print("Chon: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
                continue;
            }

            switch (choice) {
                case 1:
                    NhanVien nv = new NhanVien();
                    nv.nhap();
                    danhSach.themNhanvien(nv);
                    try {
                        danhSach.luuFile("NhanVien.txt");
                        System.out.println("Nhan vien da duoc them va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nhan vien vao file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String idSua = sc.nextLine();
                    NhanVien nvMoi = new NhanVien();
                    nvMoi.nhap();
                    danhSach.suaNhanvien(idSua, nvMoi);
                    try {
                        danhSach.luuFile("NhanVien.txt");
                        System.out.println("Nhan vien da duoc sua va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nhan vien vao file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String idXoa = sc.nextLine();
                    danhSach.xoaNhanvien(idXoa);
                    try {
                        danhSach.luuFile("NhanVien.txt");
                        System.out.println("Nhan vien da duoc xoa va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nhan vien vao file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String idTim = sc.nextLine();
                    NhanVien nvTim = danhSach.timNhanvien(idTim);
                    System.out.println(nvTim != null ? nvTim : "Khong tim thay nhan vien voi ma nay.");
                    break;

                case 5:
                    System.out.print("Nhap ten gan dung can tim: ");
                    String tenGanDung = sc.nextLine();
                    NhanVien[] ketQuaTam = danhSach.timTenNhanvienGanDung(tenGanDung);
                    if (ketQuaTam.length > 0) {
                        System.out.println("Ket qua tim kiem:");
                        for (NhanVien nvGanDung : ketQuaTam) {
                            if (nvGanDung != null) {
                                System.out.println(nvGanDung);
                            }
                        }
                    } else {
                        System.out.println("Khong tim thay nhan vien co ten gan dung voi '" + tenGanDung + "'.");
                    }
                    break;

                case 6:
                    System.out.println("Danh sach nhan vien:");
                    danhSach.hienThiNhanvien();
                    break;

                case 7:
                    exit = true;
                    System.out.println("Chuong trinh ket thuc.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }
}
