package Projects.ChortBookShoppingSystem.UserService;

import Projects.ChortBookShoppingSystem.Modal.User;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    private  static Set<User> users = new HashSet<>();

    public  void  created(String name,String email,String password){

        User user = new User(name,email,password);
        users.add(user);

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
