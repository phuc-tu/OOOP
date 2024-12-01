import java.util.Scanner;

public class ChiTietDonNhapHang {
    private String maPn;
    private String maSp;
    private double sl;
    private double donGia;
    private double tongTien;

    public ChiTietDonNhapHang() {

    }

    public ChiTietDonNhapHang(String maPn, String maSp, double sl, double donGia) {
        this.maPn = maPn;
        this.maSp = maSp;
        this.sl = sl;
        this.donGia = donGia;
        this.tongTien = sl * donGia;
    }

    public String getMaPn() {
        return maPn;
    }

    public void setMaPn(String maPn) {
        this.maPn = maPn;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public double getSl() {
        return sl;
    }

    public void setSl(double sl) {
        this.sl = sl;
        this.tongTien = this.sl * this.donGia;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.tongTien = this.sl * this.donGia;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu: ");
        maPn = sc.nextLine();
        System.out.println("Nhap ma san pham: ");
        maSp = sc.nextLine();
        System.out.println("Nhap so luong: ");
        sl = sc.nextDouble();
        System.out.println("Nhap don gia: ");
        donGia = sc.nextDouble();

        // Tinh lai tong tien
        tongTien = sl * donGia;
    }

    @Override
    public String toString() {
        return "maPn='" + maPn + "', maSp='" + maSp + "', sl=" + sl + ", donGia=" + donGia + ", tongTien=" + tongTien
                + "}";

    }
}