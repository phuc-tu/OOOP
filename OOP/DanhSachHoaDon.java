
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHoaDon {
    Scanner sc = new Scanner(System.in);
    private static HoaDon[] dshd = new HoaDon[0];

    // Hàm đọc file
    public void docFile(String filePath) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d"); // Định dạng ngày tháng
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách dữ liệu theo dấu phẩy
                if (parts.length == 5) { // Đảm bảo có đủ 5 phần tử: MaHD, MaNV, MaKH, Ngay, TongTien
                    int maHD = Integer.parseInt(parts[0].trim());
                    int maNV = Integer.parseInt(parts[1].trim());
                    int maKH = Integer.parseInt(parts[2].trim());
                    LocalDate ngayin = LocalDate.parse(parts[3].trim(), dateFormatter);
                    double tongtien = Double.parseDouble(parts[4].trim());

                    // Tạo đối tượng hoadon
                    HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayin, tongtien);

                    // Thêm vào mảng dshd
                    dshd = Arrays.copyOf(dshd, dshd.length + 1);
                    dshd[dshd.length - 1] = hd;
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang du lieu: " + e.getMessage());
        }
    }

    public void ghiFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (HoaDon hd1 : dshd) {
                // Ghi thông tin sản phẩm vào file, cách nhau bởi dấu phẩy
                bw.write(hd1.getMaHD() + "," +
                        hd1.getMaKH() + "," +
                        hd1.getMaNV() + "," +
                        hd1.getNgayin() + "," +
                        hd1.getTongtien());
                bw.newLine(); // Xuống dòng sau mỗi sản phẩm
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void TaoDS(DanhSachChiTietDonNH ds1) {
        int n;
        System.out.println("nhap vao so luong hoadon");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            dshd = Arrays.copyOf(dshd, dshd.length + 1);
            dshd[dshd.length - 1] = new HoaDon();
            dshd[dshd.length - 1].nhap(ds1);
        }
    }

    public void xuat() {
        for (HoaDon dshd1 : dshd) {
            dshd1.xuat();
        }
    }

    public double TongMonth(LocalDate start, LocalDate end) {
        double total = 0;
        for (HoaDon dshd1 : dshd) {
            LocalDate tranDate = dshd1.getNgayin();
            if ((tranDate.isEqual(start) || tranDate.isAfter(start))
                    && (tranDate.isEqual(end) || tranDate.isBefore(end))) {
                total += dshd1.getTongtien();
            }
        }
        return total;
    }

    public void sort() {
        for (int i = 0; i < dshd.length - 1; i++) {
            for (int j = 0; j < dshd.length - 1 - i; j++) {
                if (dshd[j].getMaHD() > dshd[j + 1].getMaHD()) {
                    HoaDon temp = dshd[j];
                    dshd[j] = dshd[j + 1];
                    dshd[j + 1] = temp;
                }
            }
        }
    }

    public HoaDon FindID(int id1) {
        int l = 0;
        int r = dshd.length - 1;
        sort();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (dshd[mid].getMaHD() == id1) {
                return dshd[mid];

            } else if (dshd[mid].getMaHD() < id1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return null;
    }

    public void xoa() {
        System.out.println("Nhap ma san pham can xoa: ");
        int id = sc.nextInt(); // Nhập mã sản phẩm cần xóa
        boolean found = false;

        // Duyệt qua danh sách để tìm sản phẩm cần xóa
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i].getMaHD() == id) {
                found = true;

                // Dịch các phần tử sau vị trí cần xóa lên một vị trí
                for (int j = i; j < dshd.length - 1; j++) {
                    dshd[j] = dshd[j + 1];
                }

                // Giảm kích thước mảng và loại bỏ phần tử cuối
                dshd = Arrays.copyOf(dshd, dshd.length - 1);
                System.out.println("da xoa hoa don: " + id);
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
        }
    }

    public void sua() {
        System.out.println("nhap vao ma hoa don can sua");
        int id = sc.nextInt();
        HoaDon hd = FindID(id);
        if (hd != null) {
            System.out.println("nhap vao ma hoa don moi 1 sua");
            hd.setMaHD(sc.nextInt());
            boolean exist = false;
            for (HoaDon dshd1 : dshd) {
                if (dshd1.getMaHD() == hd.getMaHD() && dshd1 != hd) {
                    exist = false;
                    break;
                }
            }
            if (exist) {
                System.out.println("ma hoa don da ton tai");
                return;
            }
            System.out.println("nhap vao ma khach hang:");
            hd.setMaKH(sc.nextInt());
            System.out.println("nhap vao ma nhan vien:");
            hd.setMaNV(sc.nextInt());
            System.out.println("nhap vao ngay lap:");
            System.out.println("nhap ngay");
            int ngay = sc.nextInt();
            System.out.println("nhap thang");
            int thang = sc.nextInt();
            System.out.println("nhap nam");
            int nam = sc.nextInt();
            hd.setNgayin(ngay, thang, nam);
        }
    }

    public void nhapthem(DanhSachChiTietDonNH ds1) {
        int n;
        System.out.println("nhap vao so luong can them :");
        n = sc.nextInt();
        int current = dshd.length;
        dshd = Arrays.copyOf(dshd, current + n);
        for (int i = 0; i < n; i++) {
            dshd[current + i] = new HoaDon();
            dshd[current + i].nhap(ds1);
        }
    }

    public void tkquy() {
        int quy1 = 0;
        int quy2 = 0;
        int quy3 = 0;
        int quy4 = 0;

        for (HoaDon hd1 : dshd) {
            int month = hd1.getNgayin().getMonthValue();
            if (month <= 3) {
                quy1++;
            } else if (month <= 6) {
                quy2++;
            } else if (month <= 9) {
                quy3++;
            } else {
                quy4++;
            }
        }
        System.out.println("so hoa don trong quy 1 :" + quy1);
        System.out.println("so hoa don trong quy 2 :" + quy2);
        System.out.println("so hoa don trong quy 3 :" + quy3);
        System.out.println("so hoa don trong quy 4 : " + quy4);
    }

    public void choose(DanhSachChiTietDonNH ds1) {
        int choice;
        do {
            System.out.println("\n1. Tao danh sach hoa don");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. sua");
            System.out.println("5.tinh tong trong khoang thoi gian");
            System.out.println("6.them");
            System.out.println("7. thong ke cac quy:");
            System.out.println("8. Thoat");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    TaoDS(ds1);
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    sua();
                    break;
                case 5:
                    LocalDate start;
                    LocalDate end;
                    System.out.println("nhap vao start");
                    int ngay = sc.nextInt();
                    System.out.print("/");
                    int thang = sc.nextInt();
                    System.out.print("/");
                    int nam = sc.nextInt();
                    System.out.println("nhap vao end");
                    int ngay1 = sc.nextInt();
                    System.out.print("/");
                    int thang1 = sc.nextInt();
                    System.out.print("/");
                    int nam1 = sc.nextInt();
                    try {
                        start = LocalDate.of(nam, thang, ngay);
                        end = LocalDate.of(nam1, thang1, ngay1);
                    } catch (DateTimeException e) {
                        System.out.println("Lỗi ngày tháng nhập vào không hợp lệ: " + e.getMessage());
                        return;
                    }
                    System.out.println(" tong: " + TongMonth(start, end));
                    break;
                case 6:
                    nhapthem(ds1);
                    break;
                case 7:
                    tkquy();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 8);
    }

}
