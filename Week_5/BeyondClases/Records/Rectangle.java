package Week_5.BeyondClases.Records;

public record Rectangle(int with,int height){

    public  int area()
    {
        return with*height;
    }
}
