package server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.transfer.TokenDto;

@Data
@AllArgsConstructor
public class Login {
    TokenDto tokenDto;
    User user;
}
