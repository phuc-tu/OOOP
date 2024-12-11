
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachChiTietDonNH implements IchiTietHoaDon {
    private static ChiTietHoaDon[] ds = new ChiTietHoaDon[0];
    Scanner sc = new Scanner(System.in);

    // Hàm đọc file
    public void docFile(String filePath, DanhSachSanPham danhSachSanPham) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Bỏ qua các dòng trống
                if (line.trim().isEmpty()) continue;
    
                // Tách dữ liệu theo dấu phẩy
                String[] parts = line.split(",");
                if (parts.length >=3) { // Đảm bảo ít nhất 3 phần tử: MaHD, MaSP, SoLuong
                    try {
                        int maHD = Integer.parseInt(parts[0].trim());
                        int maSP = Integer.parseInt(parts[1].trim());
                        int soLuong = Integer.parseInt(parts[2].trim());

                        // Lấy đơn giá từ danh sách sản phẩm
                        int donGia = danhSachSanPham.FindID(maSP);
    
                        // Tạo đối tượng ChiTietHoaDon
                        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                        chiTietHoaDon.setMaHD(maHD);
                        chiTietHoaDon.setMaSP(maSP);
                        chiTietHoaDon.setSoluong(soLuong);
                        chiTietHoaDon.setDongia(donGia);
    
                        // Tính thành tiền nếu đơn giá hợp lệ
                        if (donGia > 0) {
                            chiTietHoaDon.setThanhtien(soLuong * donGia);
                        } else {
                            chiTietHoaDon.setThanhtien(0); // Nếu không tìm thấy giá
                        }
    
                        // Thêm vào danh sách
                        ds = Arrays.copyOf(ds, ds.length + 1);
                        ds[ds.length - 1] = chiTietHoaDon;
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng dòng: " + line);
                    }
                } else {
                    System.out.println("Dòng không hợp lệ: " + line);
                }
            }
            System.out.println("Đọc file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
    

    public void ghiFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (ChiTietHoaDon ct1 : ds) {
                // Ghi thông tin sản phẩm vào file, cách nhau bởi dấu phẩy
                bw.write(ct1.getMaHD() + "," +
                        ct1.getMaSP() + "," +
                        ct1.getSoluong() + "," +
                        ct1.getThanhtien());
                bw.newLine(); // Xuống dòng sau mỗi sản phẩm
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void taoDS(DanhSachSanPham ds1) {
        int n;
        System.out.println("Nhap vao so luong chi tiet hoa đon:");
        n = sc.nextInt();
        for (int i = ds.length; i < n; i++) {
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = new ChiTietHoaDon();
            ds[i].nhapct(ds1);
        }
    }

    public void xuat() {
        for (ChiTietHoaDon d : ds) {
            d.xuat();
        }
    }

    public int FindMHD(int id1) {
        int l = 0;
        int r = ds.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ds[mid].getMaHD() == id1) {
                return ds[mid].getThanhtien();

            } else if (ds[mid].getMaHD() < id1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    @Override
    public double tongtien(int MaHD) {
        double s = 0;
        for (ChiTietHoaDon d : ds) {
            if (d.getMaHD()==MaHD) {
                s = s + d.getThanhtien();
            }
        }
        return s;
    }
    @Override
    public void Timkiem(){
        int id;
        System.out.println("Nhap vao ma hoa don:");
        id = sc.nextInt();
        int kq = FindMHD(id);
        for(ChiTietHoaDon ct : ds){
      if(ct.getMaHD()==kq)
        ct.xuat(); 
}
}   @Override
      public void xoa() {
    System.out.println("nhap vao maHD can xoa:");
    int id1 = sc.nextInt();
    System.out.println("Nhap ma san pham  can xoa: ");
    int id = sc.nextInt(); // Nhập mã sản phẩm cần xóa
    boolean found = false;

    // Duyệt qua danh sách để tìm sản phẩm cần xóa
    for (int i = 0; i < ds.length; i++) {
        if (ds[i].getMaHD() == id1&&ds[i].getMaSP()==id) {
            found = true;

            // Dịch các phần tử sau vị trí cần xóa lên một vị trí
            for (int j = i; j < ds.length - 1; j++) {
                ds[j] = ds[j + 1];
            }

            // Giảm kích thước mảng và loại bỏ phần tử cuối
            ds = Arrays.copyOf(ds, ds.length - 1);
            System.out.println("da xoa hoa don: " + id);
            break;
        }
    }

    if (!found) {
        System.out.println("Không tìm thấy sản phẩm với mã: " + id);
    }
}

    @Override
    public void nhapthem(DanhSachSanPham sp) {
        int n;
        System.out.println("nhap vao so luong can them :");
        n = sc.nextInt();
        int current = ds.length;
        ds = Arrays.copyOf(ds, current + n);
        for (int i = 0; i < n; i++) {
            ds[current + i] = new ChiTietHoaDon();
            ds[current + i].nhapct(sp);
        }
        sp.showDs();
    }
    @Override
    public void sua()
    {  System.out.println("nhap vao ma hoa don can sua :");
            int maHD=sc.nextInt();
        System.out.println("nhap vao ma san pham :");
        int maSP = sc.nextInt();
        for(ChiTietHoaDon ct1:ds)
        {
            if(ct1.getMaHD()==maHD&&ct1.getMaSP()==maSP)
            {
                System.out.println("nhap vao maHD:");
                ct1.setMaHD(sc.nextInt());
                System.out.println("nhap vao maSP:");
                ct1.setMaSP(sc.nextInt());
                System.out.println("nhap vao so luong:");
                ct1.setSoluong(sc.nextInt());
                break;
            }
        }
       
    }

    public void choose(DanhSachSanPham ds1) {
        int choice;
        do {
            System.out.println("1. Tao danh sach chi tiet hao don ");
            System.out.println("2. Hien danh sach chi tiet hoa don");
            System.out.println("3. Xoa chi tiet don hang");
            System.out.println("4.Them chi tiet");
            System.out.println("5.sua chi tiet hoa don: ");
            System.out.println("6.In ra cac san pham cung qua don");
            System.out.println("0.Thoat");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    taoDS(ds1);
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    nhapthem(ds1);
                    break;
                case 5:
                sua();
                break;
                case 6:
                    Timkiem();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua  chon khong hop le.");
            }
        } while (choice != 0);
    }

}
