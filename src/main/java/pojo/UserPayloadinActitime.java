package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPayloadinActitime {


    String email;

    int password;
    String username;
    String firstName;
    String lastName;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
