import java.util.Scanner;

public class ChiTietHoaDon {
    private int MaHD;
    private int MaSP;
    private int soluong;
    private int dongia;
    private int thanhtien;

    public int tinhtien(DanhSachSanPham ds1){
        this.thanhtien = soluong * ds1.FindID(this.MaSP);
        return thanhtien;
    }

    public void nhapct(DanhSachSanPham ds1) {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don : ");
        this.MaHD = sc.nextInt();
        System.out.println("Nhap ma san pham :");
        this.MaSP = sc.nextInt();
        System.out.println("Nhap  so luong :");
        this.soluong = sc.nextInt();
        ds1.updatesl(MaSP, soluong);
        this.dongia = ds1.FindID(this.MaSP);
        this.thanhtien = tinhtien(ds1);
    }

    public void xuat() {
        System.out.println("MaHD: "+this.MaHD + " MaSP :" + this.MaSP+ " So luong :" + this.soluong +" Don gia :" + this.dongia+" Thanh tien :" + this.thanhtien);

        
    }

    public int getThanhtien() {
        return this.thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getMaHD() {
        return this.MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getSoluong() {
        return this.soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMaSP() {
        return this.MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }
    public int getDongia(){
        return this.dongia;
    }
    public void setDongia(int dongia){
        this.dongia = dongia;
    }

}
