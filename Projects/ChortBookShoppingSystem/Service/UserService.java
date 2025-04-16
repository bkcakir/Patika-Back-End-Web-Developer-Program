package Projects.ChortBookShoppingSystem.Service;

import Projects.ChortBookShoppingSystem.Modal.User;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    private static Set<User> users = new HashSet<>();

    public boolean created(String name, String email, String password) {
        // Kullanıcı mevcutsa, false döndür
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return false; // Kullanıcı zaten var
            }
        }

        // Yeni kullanıcıyı ekle
        User newUser = new User(name, email, password);
        users.add(newUser);
        return true; // Kayıt başarılı
    }


    public  void  list(){
        for(User user:users){
            System.out.println(user.getName()+" --> "+user.getEmail());
        }
    }
    public Boolean islogin(String email,String password)
    {
       for (User user:users)
       {
           if(user.getEmail().equals(email)&& user.getPassword().equals(password))
           {
               return true;
           }
       }
       return false;
    }
}
