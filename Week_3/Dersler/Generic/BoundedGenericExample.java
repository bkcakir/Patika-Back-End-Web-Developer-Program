package Week_3.Dersler.Generic;

public class BoundedGenericExample<T extends  Animal> {
    private  T content;

    public T getContent(Animal animal) {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
