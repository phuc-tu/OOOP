import java.io.File;

public class Main_Cthd {

    public static void main(String[] args) {

        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();

        String sanPhamFilePath = "sanpham.txt";
        danhSachSanPham.docFile(sanPhamFilePath);

        DanhSachChiTietDonNH danhSachChiTietDonNH = new DanhSachChiTietDonNH();

        String chiTietHoaDonFilePath = "chitiethoadon.txt";
        danhSachChiTietDonNH.docFile(chiTietHoaDonFilePath);

        danhSachChiTietDonNH.choose(danhSachSanPham);

        danhSachChiTietDonNH.ghiFile(chiTietHoaDonFilePath);
    }
}
