package mi.game.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Board {

    @GetMapping("/welcome")
    public String getWelcomeMessage(){
        return "Welcome to board games!!";
    }
}
