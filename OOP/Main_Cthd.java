
public class Main_Cthd {

    public static void main(String[] args) {

        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();

    
        danhSachSanPham.docFile("./OOP/sanpham.txt");

        DanhSachChiTietDonNH danhSachChiTietDonNH = new DanhSachChiTietDonNH();
        danhSachChiTietDonNH.docFile("./OOP/chitiethoadon.txt",danhSachSanPham);

        danhSachChiTietDonNH.choose(danhSachSanPham);
        danhSachSanPham.ghiFile("OOP/sanpham.txt");
        danhSachChiTietDonNH.ghiFile("./OOP/chitiethoadon.txt");
    }
}
