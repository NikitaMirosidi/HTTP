package Petstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class User {

    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String phone;
    private int userStatus;
}