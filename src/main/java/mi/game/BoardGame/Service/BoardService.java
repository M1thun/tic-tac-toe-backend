package mi.game.BoardGame.Service;


import lombok.Getter;
import mi.game.BoardGame.Models.Board;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Getter
@Service
public class BoardService {
    Board gameBoard;
    boolean isFirst=true;
    String playerSymbol;
    int noOfMoves;
    int size;
    boolean isGameOver;
    String gameStatus;

    String[] horizontalCheck;
    String[] verticalCheck;
    String leftCross;
    String rightCross;


    public BoardService(){
        this.gameBoard = new Board(3,"TicTacToe");
    }

    public Board setBoard() {
        this.isFirst=true;
        this.playerSymbol="X";
        this.horizontalCheck=new String[gameBoard.getSize()];
        this.verticalCheck=new String[gameBoard.getSize()];
        Arrays.fill(this.horizontalCheck,"ZZZ");
        Arrays.fill(this.verticalCheck,"ZZZ");
        this.leftCross="ZZZ";
        this.rightCross="ZZZ";
        this.noOfMoves=0;
        this.isGameOver=false;
        this.gameStatus="Start Game!";
        this.size=this.gameBoard.getSize();
        return this.gameBoard=new Board(3,"TicTacToe");
    }

    public String markBoard(int x,int y) {
        this.gameStatus="";
        if(isGameOver) return this.gameStatus="Game Over, Click Reset to play again!";

        if(this.gameBoard.getBoard()[x][y]!=0){
            return "Please, fill empty box!!";
        }

        if(isFirst) {
            this.gameBoard.getBoard()[x][y]=1;;
            this.isFirst=false;
        }
        else {
            this.gameBoard.getBoard()[x][y]=2;
            this.isFirst=true;
        }
        this.noOfMoves++;
        if(checkWinner(this.playerSymbol,x,y)){
            this.isGameOver=true;
            return this.gameStatus=this.playerSymbol+" won the game!!";
        }
        if(this.noOfMoves>=this.size*this.size) {
            this.isGameOver=true;
            return this.gameStatus="Game is Draw!! Click Reset to play again!!";
        }
        this.playerSymbol=this.playerSymbol.equals("X")?"O":"X";

        return "";
    }


    public boolean checkWinner(String playerSymbol,int x,int y){
        String winnerPattern=playerSymbol.equals("X")?"XXX":"OOO";

        char[] row=this.horizontalCheck[x].toCharArray();
        row[y]=this.playerSymbol.charAt(0);
        this.horizontalCheck[x]=String.valueOf(row);

        char[] col=this.verticalCheck[y].toCharArray();
        col[x]=this.playerSymbol.charAt(0);
        this.verticalCheck[y]=String.valueOf(col);

        if(x==y) {
            char[] lcross = this.leftCross.toCharArray();
            lcross[x] = this.playerSymbol.charAt(0);
            this.leftCross = String.valueOf(lcross);
        }

        if(x+y==this.size-1) {
            char[] rcross = this.rightCross.toCharArray();
            rcross[x] = this.playerSymbol.charAt(0);
            this.rightCross = String.valueOf(rcross);
        }


        if(horizontalCheck[x].equals(winnerPattern)){
            return true;
        }
        else if(verticalCheck[y].equals(winnerPattern)){
            return true;
        }
        else if(leftCross.equals(winnerPattern)){
            return true;
        }
        else if(rightCross.equals(winnerPattern)){
            return true;
        }
        return false;
    }

}
