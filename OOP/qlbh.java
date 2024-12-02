import java.util.Scanner;

public class qlbh {
  public qlbh() {
  };

  public void nhapfile(DanhSachSanPham sp, DanhSachChiTietDonNH ct, DanhSachHoaDon hd) {
    sp.docFile("hoadon/src/sanpham.txt");
    hd.docFile("hoadon/src/hoadon.txt");
    ct.docFile("hoadon/src/chitietdonhang.txt");
  }

  public void ghiFile(DanhSachSanPham sp, DanhSachChiTietDonNH ct, DanhSachHoaDon hd) {
    sp.ghiFile("hoadon/src/sanpham.txt");
    hd.ghiFile("hoadon/src/hoadon.txt");
    ct.ghiFile("hoadon/src/chitietdonhang.txt");

  }

  public void choose(DanhSachSanPham sp, DanhSachChiTietDonNH ct, DanhSachHoaDon hd) {
    int choice;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.println("1.chinh sua danh sach san pham:");
      System.out.println("2.chinh sua chi tiet don hang:");
      System.out.println("3.chinh sua hoa don:");
      System.err.println("nhap vao lua chon: ");
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          sp.choose();
          break;
        case 2:
          ct.choose(sp);
          break;
        case 3:
          hd.choose(ct);
          break;
        case 4:
          System.out.println("thoat chuong trinh");
          break;
        default:
          System.out.println("nhap sai, vui long nhap lai");
      }
    } while (choice != 4);

  }
}
