package models;

import lombok.*;
import screens.HomeScreeen;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String email;
    private String password;


}
