public interface DanhSachChiTietDonNhapHang {
    void themChiTietDonNhapHang(ChiTietDonNhapHang ctnh);

    void suaChiTietDonNhapHang(ChiTietDonNhapHang ctnh, String maNh);

    void xoaChiTietDonNhapHang(String maNh);

    ChiTietDonNhapHang timChiTietDonNhapHang(String maNh);

    void hienThiDonChiTietNhapHang();

}
