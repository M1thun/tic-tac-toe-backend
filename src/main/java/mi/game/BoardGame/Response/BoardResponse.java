package mi.game.BoardGame.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mi.game.BoardGame.Models.Board;
import mi.game.BoardGame.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardResponse {

    Board board;
    String gameStatus;
    String playerSymbol;

}
