package Week_5.Examples.Records;

public record Student(int number,String name) {
    public  Student(int number,String name,String surname)
    {
        this(number,name +" "+surname);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int number() {
        return number;
    }
}

