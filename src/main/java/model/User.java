package model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO try to use another data str. for tasks and users
//TODO auto_increment realisation ? interaction with data from database ?

@Component
public class User {
    private Integer idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private List<Task> tasks = new ArrayList<>();

    public User(Integer idUser, String firstName, String lastName,
                String email, String password) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDate = LocalDate.now();
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate() {
        this.registrationDate = LocalDate.now();
    }

}
