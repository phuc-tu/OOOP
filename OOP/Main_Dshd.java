public class Main_Dshd {

    public static void main(String[] args) {
        DanhSachHoaDon danhSachHoaDon = new DanhSachHoaDon();

        String hoaDonFilePath = "hoadon.txt";
        danhSachHoaDon.docFile(hoaDonFilePath);

        DanhSachChiTietDonNH danhSachChiTietDonNH = new DanhSachChiTietDonNH();

        danhSachHoaDon.choose(danhSachChiTietDonNH);

        danhSachHoaDon.ghiFile(hoaDonFilePath);
    }
}
