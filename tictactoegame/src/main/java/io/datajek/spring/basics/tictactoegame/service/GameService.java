package io.datajek.spring.basics.tictactoegame.service;

import io.datajek.spring.basics.tictactoegame.models.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public void makeMove(Game game, int row, int col) {
        if(game.isGameOver() || game.getBoard()[row][col] != '\0'){
            return;
        }
        game.getBoard()[row][col] = game.getCurrentPlayer();

        if(checkWin(game)){
            game.setGameOver(true);
            game.setMessage("Player " + game.getCurrentPlayer() + "wins" );
        }
        else if(isBoardFull(game)) {
            game.setGameOver(true);
            game.setMessage("Its a draw !!");
        }
        else {
            switchPlayer(game);
            game.setMessage("Player " + game.getCurrentPlayer() + "'s turn.");
        }

    }

    private boolean isBoardFull(Game game){
        for(char[] row: game.getBoard()){
            for(char cell: row){
                if(cell == '\0')return false;
            }
        }
        return true;
    }

    public void switchPlayer(Game game){
        game.setCurrentPlayer(game.getCurrentPlayer() == 'X' ? 'O' : 'X');
    }

    private boolean checkWin(Game game) {
        char[][] b = game.getBoard();
        char p = game.getCurrentPlayer();

        for(int i = 0; i < 3; i++){
            if((b[i][0] == p && b[i][1] == p && b[i][2] == p)|| (b[0][i] == p && b[1][i] == p && b[2][i] == p))return true;
        }
        if ((b[0][0] == p && b[1][1] == p && b[2][2] == p) ||
                (b[0][2] == p && b[1][1] == p && b[2][0] == p)) {
            return true;
        }
        return false;
    }
}
