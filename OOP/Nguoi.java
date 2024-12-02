import java.util.Scanner;

public abstract class Nguoi {
    private String ten;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;

    public Nguoi() {
    }

    public Nguoi(String ten, int tuoi, String gioiTinh, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten: ");
        this.ten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        this.tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap gioi tinh: ");
        this.gioiTinh = sc.nextLine();

        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
    }

    public String toString() {
        return "Ten: " + ten + ", Tuoi: " + tuoi + ", Gioi tinh: " + gioiTinh + ", Dia chi: " + diaChi;
    }

    public abstract void hienThiThongTin();
}
