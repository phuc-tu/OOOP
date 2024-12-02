
import java.util.Scanner;


public abstract  class sanpham {
    private int MaSP;
    private String  tensp;
    private  int sl;
    private int dongia;
    private String mau;
    private int size;
    private String chatlieu;
    private int dodayde;
    Scanner sc = new Scanner(System.in);
    public sanpham(){
    };
    public sanpham(int MaSP,String tensp, int sl,int dongia,String mau,String chatlieu,int dodayde,int size)
    {
                this.MaSP=MaSP;
                this.tensp=tensp;
                this.sl=sl;
                this.dongia=dongia;
                this.chatlieu=chatlieu;
                this.dodayde=dodayde;
                this.mau=mau;
                this.size=size;
    }
    public sanpham(sanpham sp1){
        this.MaSP=sp1.MaSP;
        this.tensp=sp1.tensp;
        this.sl=sp1.sl;
        this.dongia=sp1.dongia;
        this.chatlieu=sp1.chatlieu;
        this.dodayde=sp1.dodayde;
        this.mau=sp1.mau;
        this.size=sp1.size;

    }
        public void nhap(){
            System.out.print("Nhap Ma SP: ");
            this.MaSP = sc.nextInt();
            sc.nextLine(); 
        
            System.out.print("Nhap Ten SP: ");
            this.tensp = sc.nextLine();
        
            System.out.print("Nhap So Luong: ");
            this.sl = sc.nextInt();
            sc.nextLine(); 
        
            System.out.print("Nhap Don Gia: ");
            this.dongia = sc.nextInt(); //dongia nhap tu bang nhap hang
            sc.nextLine();
        
            System.out.print("Nhap Chat Lieu: ");
            this.chatlieu = sc.nextLine();
        
            System.out.print("Nhap Do Day De: ");
            this.dodayde = sc.nextInt();
            sc.nextLine();
        
            System.out.print("Nhap Mau: ");
            this.mau = sc.nextLine();
            System.out.println("Nhap size giay");
            this.size = sc.nextInt();

        }
        
    
    public void xuat(){
        System.out.println("Ma San pham : "+this.MaSP);
        System.out.println("Ten San pham : "+this.tensp);
        System.out.println("So luong hien co: " +this.sl);
        System.out.println("Mau :" + this.mau);
        System.out.println("Gia: "+this.dongia);
        System.out.println("Chat lieu :"+this.chatlieu);
        System.out.println("Do day cua de :"+this.dodayde);
        System.out.println("Size cua giay : "+this.size);
    }
    public int getMaSP(){
        return this.MaSP;
    }
    public void setMaSP(int msp1)
    {
        this.MaSP=msp1;
    }
    public String  getTensp(){
        return this.tensp;
}
public  void setTensp(String tsp1)
{
    this.tensp=tsp1;
}
public int getSl(){
return this.sl;
}
public void setSl(int sl1)
{
    this.sl=sl1;
}
public String  getChatlieu(){
return this.chatlieu;
}
public void setChatlieu(String chatlieu1){
    this.chatlieu=chatlieu1;
}
public int getDongia(){
    return this.dongia;
}
public void setDongia(int dongia1){
    this.dongia=dongia1;
}
public String  getMau(){
    return this.mau;
}
public void setMau(String mau1){
    this.mau=mau1;
}
public int getDodayde(){
    return this.dodayde;
}
public void  setDodayde(int dodayde1){
   this.dodayde=dodayde1;
}
public int getSize(){
    return this.size;
}
public void setSize(int size1){
    this.size=size1;
}
}