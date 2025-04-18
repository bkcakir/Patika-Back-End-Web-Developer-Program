package Projects.ChortBookShoppingSystem.Modal;

import Projects.ChortBookShoppingSystem.Modal.enums.Gender;

import java.time.LocalDate;

public class User {

    private String name;
    private  String email;
    private  String password;
    private Gender gender;

    private LocalDate birthDay;
    private  LocalDate createdDate;
    private  boolean isActive;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdDate=LocalDate.now();
        this.isActive=true;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public boolean isActive() {
        return isActive;
    }
}
