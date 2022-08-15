package mi.game.BoardGame.Controller;

import mi.game.BoardGame.Models.Board;
import mi.game.BoardGame.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tictactoe")
public class BoardController {

    @Autowired
    BoardService boardService;

    @CrossOrigin(origins = {"http://localhost:4200","http://192.168.29.210:4200","https://tic-tac-frontend.herokuapp.com"})
    @GetMapping
    public Board boardSetUp(){
        return boardService.setBoard();
    }

    @MessageMapping("/update")
    @SendTo("/topic/board")
    public Board updateBoard(){
        boardService.getGameBoard().getBoard()[0][1]=1;
        return boardService.getGameBoard();
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://192.168.29.210:4200","https://tic-tac-frontend.herokuapp.com"})
    @PostMapping(value="/mark", consumes = "application/json")
    @ResponseBody
    public String markBoard(@RequestParam(name="xPos") int xPos, @RequestParam(name="yPos") int yPos){
        System.out.println(xPos+" "+yPos);
        return boardService.markBoard(xPos,yPos);
    }

}
