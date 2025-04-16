package Projects.ChortBookShoppingSystem.Service;

import Projects.ChortBookShoppingSystem.Modal.Author;
import Projects.ChortBookShoppingSystem.Modal.Book;
import Projects.ChortBookShoppingSystem.Modal.Magazine;
import Projects.ChortBookShoppingSystem.Modal.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private  static List<Product>productList = new ArrayList<>();
    public  void  create(String name,double price,Author author ,LocalDate publishedDate)
    {
        Product Book = new Book(name,price,author,publishedDate);
        productList.add(Book);
    }
    public  void  create(String name,double price)
    {
        Product Magazine = new Magazine(name,price);
        productList.add(Magazine);
    }

    public  void  list()
    {
        for (Product product :productList)
        {
            System.out.println(product);
        }
    }
}
