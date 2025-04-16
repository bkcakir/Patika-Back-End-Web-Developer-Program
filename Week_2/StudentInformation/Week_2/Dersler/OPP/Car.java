package Week_2.StudentInformation.Week_2.Dersler.OPP;

public class   Car {

    private String Brand;
    private String Model;
    private int MaxSpeed;
    private int HorsePower;
    private  int MaxGearCount=6;
    private  int Gear=0;



    public  void move()
    {
        System.out.println("İleri Gidiyor....");
    }
    public  void IncrementGear(int GearCount)
    {
        if(MaxGearCount >= GearCount)
        {
            this.Gear=GearCount;
            System.out.println("Vites Seviyesi : "+ Gear);
        }
        else {
            System.out.println("Max Vites Boyutunda Fazla giriş yapıldı");
        }
    }

    public  String getBrand()
    {
        return Brand;
    }
    public  void SetBrand(String brand)
    {
        this.Brand=brand;
    }

    public  String getModel()
    {
        return Model;
    }
    public  void SetModel(String Model)
    {
        this.Model=Model;
    }

    public  int getMaxSpeed()
    {
        return MaxSpeed;
    }
    public  void SetMaxSpeed(int MaxSpeed)
    {
        this.MaxSpeed=MaxSpeed;
    }

    public  int getHorsePower()
    {
        return HorsePower;
    }
    public  void SetHorsePower(int HorsePower)
    {
        this.HorsePower=HorsePower;
    }

    public  int getGear()
    {
        return Gear;
    }
    public  void SetGear(int Gear)
    {
        this.Gear=Gear;
    }

}
