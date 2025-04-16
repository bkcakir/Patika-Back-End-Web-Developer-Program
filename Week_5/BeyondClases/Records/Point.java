package Week_5.BeyondClases.Records;

public record  Point(int x,int y){

    public  Point{
        if(x==y)
        {
            System.out.println("x ve y Biribirnine Eş olamaz");
        }
    }
}
