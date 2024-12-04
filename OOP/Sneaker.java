
import java.util.Scanner;
public class Sneaker extends sanpham {
   private String coGiay;
   private String ungdung;
   public Sneaker(){
}
   public Sneaker(int MaSP,String tensp, int sl,int dongia,String mau,String chatlieu,int dodayde,int size,String coGiay, String ungdung) {
        super(MaSP,tensp,sl,dongia,mau,chatlieu,dodayde,size);
        this.coGiay=coGiay;
        this.ungdung=ungdung;
   }
   public Sneaker(Sneaker  s) {
    super((sanpham)s);
    this.coGiay = s.coGiay;
    this.ungdung=s.ungdung;
   }
   @Override
   public void nhap(){
    @SuppressWarnings("resource")
   Scanner sc = new Scanner(System.in);
    super.nhap();
    System.out.println("Nhap co giay: ");
    this.coGiay=sc.nextLine();
    System.out.println("Nhap vao ung dung");
    this.ungdung=sc.nextLine();
   }
   @Override
   public void xuat(){
    super.xuat();
    System.out.println("Co giay: "+this.coGiay);
    System.out.println("Ung dung : "+this.ungdung);

   }
   public String getCogiay() {
      return coGiay;}
   public void setCogiay(String coGiay) {
      this.coGiay = coGiay;}
      public String getUngdung() {
         return ungdung;}
         public void setUngdung(String ungdung) {
            this.ungdung = ungdung;}
}
