package project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final LocalDate registrationDate;

    public User(int id, String firstName, String lastName,
                String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDate = LocalDate.now();
    }
}
