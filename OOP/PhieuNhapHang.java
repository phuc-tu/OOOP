import java.util.Scanner;

public class PhieuNhapHang {
    private String maPhieu;
    private String maNcc;
    private String ngayNhap;
    private double tongTien;


    public PhieuNhapHang() {
    }

    
    public PhieuNhapHang(String maPhieu, String maNcc, String ngayNhap, double tongTien) {
        this.maPhieu = maPhieu;
        this.maNcc = maNcc;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma phieu ");
        maPhieu = sc.nextLine();

        System.out.print("Nhap ma nha cung cap ");
        maNcc = sc.nextLine();

        System.out.print("Nhap ngay nhap (dd/mm/yyyy): ");
        ngayNhap = sc.nextLine();

        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "Ma phieu: " + maPhieu + ", Ma NCC: " + maNcc + ", Ngay nhap: " + ngayNhap + ", Tong tien: " + tongTien;
    }
}
