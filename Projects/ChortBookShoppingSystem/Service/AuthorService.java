package Projects.ChortBookShoppingSystem.Service;

import Projects.ChortBookShoppingSystem.Modal.Author;
import Projects.ChortBookShoppingSystem.Modal.Product;
import Projects.ChortBookShoppingSystem.Modal.enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class AuthorService {

    private Map<String,Author> authors = new HashMap();
    public  void  created(String name,String surname,Gender gender)
    {
        Author author = new Author(name,surname,gender);
        authors.put(author.getName(),author);
    }

    public  Author findAuthor(String name)
    {
        return authors.get(name);
    }

    public  void  list()
    {
        for (Author author : authors.values())
            System.out.println(author);
    }
}
