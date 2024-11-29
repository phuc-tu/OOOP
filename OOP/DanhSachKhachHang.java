public interface DanhSachKhachHang {
    void themKhachhang(KhachHang kh);

    void xoaKhachhang(String id);

    void suaKhachhang(String id, KhachHang kh);

    KhachHang timKhachHang(String id);

    void hienThiKhachhang();

}
