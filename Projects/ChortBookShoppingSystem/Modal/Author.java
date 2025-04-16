package Projects.ChortBookShoppingSystem.Modal;

import Projects.ChortBookShoppingSystem.Modal.enums.Gender;

import java.time.LocalDate;

public class Author {
    public Author(String name, String surname , Gender gender) {
        this.surname = surname;
        this.name = name;
    }

    private  String name;
    private  String surname;
    private  Gender gender;


    private LocalDate birthday;
    private  String bio;

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getBio() {
        return bio;
    }
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", bio='" + bio + '\'' +
                '}';
    }

}
