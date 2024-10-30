package io.datajek.spring.basics.snakeladdergame.service;

import io.datajek.spring.basics.snakeladdergame.model.Board;
import io.datajek.spring.basics.snakeladdergame.model.Ladder;
import io.datajek.spring.basics.snakeladdergame.model.Player;
import io.datajek.spring.basics.snakeladdergame.model.Snake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class GameService {

    @Autowired
    private Board board;
    private Queue<Player> players;
    private boolean isGameCompleted;

    public GameService(Board board, List<Player> playerList){
        this.players = new LinkedList<>(playerList);
        this.board = board;
        this.isGameCompleted = false;
    }

    public void startGame() {

        while(!isGameCompleted){
            Player currentPlayer = players.poll();
            int diceRoll = rollDice();
            movePlayer(currentPlayer, diceRoll);
            if(currentPlayer.getPosition() >= board.getSize()){
                System.out.println(currentPlayer.getName() + "Player wins the game !!!");
                isGameCompleted = true;
            }
            else {
                players.add(currentPlayer);
            }
        }

    }
    public int rollDice() {
        return (int)(Math.random() * 6) + 1;
    }

    public void movePlayer(Player player, int diceRoll){
        int newPosition = player.getPosition() + diceRoll;

        if(newPosition > board.getSize()){
            newPosition = player.getPosition();
        }
        else {
            newPosition = checkForSnakesOrLadders(newPosition);
        }
        player.setPosition(newPosition);
        System.out.println(player.getName() + "moved to postion " + player.getPosition());
    }
    public int checkForSnakesOrLadders(int position) {

        for(Snake snake: board.getSnakes()){

            if(position == snake.getHead()){
                System.out.println("Snake bite -----");
                return snake.getTail();
            }

        }

        for(Ladder ladder: board.getLadders()){
            if(position == ladder.getBottom()){
                System.out.println("Yay! " + "Climbed a ladder at position " + position);
                return ladder.getTop();
            }
        }
        return position;
    }


}
