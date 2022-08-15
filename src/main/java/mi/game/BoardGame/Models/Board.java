package mi.game.BoardGame.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Setter
public class Board {
    int size;
    String gameName;
    int[][] board;

    public Board(int size,String gameName){
        this.size=size;
        this.gameName=gameName;
        board=new int[size][size];
    }
}
