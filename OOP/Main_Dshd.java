public class Main_Dshd {

    public static void main(String[] args) {
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();


        DanhSachSanPham ds = new DanhSachSanPham();
        ds.docFile("OOP/sanpham.txt");
        DanhSachChiTietDonNH danhSachChiTietDonNH = new DanhSachChiTietDonNH();
        danhSachChiTietDonNH.docFile("OOP/chitiethoadon.txt",ds);
        danhSachHoaDon.docFile("OOP/hoaddon.txt",danhSachChiTietDonNH);
        danhSachHoaDon.choose(danhSachChiTietDonNH);

        danhSachHoaDon.ghiFile("OOP/hoaddon.txt");
    }
}
