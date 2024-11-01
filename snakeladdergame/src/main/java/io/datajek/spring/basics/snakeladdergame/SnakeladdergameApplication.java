package io.datajek.spring.basics.snakeladdergame;

import io.datajek.spring.basics.snakeladdergame.model.Ladder;
import io.datajek.spring.basics.snakeladdergame.model.Player;
import io.datajek.spring.basics.snakeladdergame.model.Snake;
import io.datajek.spring.basics.snakeladdergame.service.GameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.datajek.spring.basics.snakeladdergame.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SnakeladdergameApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SnakeladdergameApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize the game components
        Board board = initializeBoard();
        GameService gameService = initializeGameService(board);

        // Start the game
        gameService.startGame();
    }

    private Board initializeBoard() {
        Board board = new Board();
        board.setSnakes(Arrays.asList(
                new Snake(99, 54),
                new Snake(70, 55),
                new Snake(52, 42),
                new Snake(25, 2),
                new Snake(75, 20),
                new Snake(96, 15),
                new Snake(93, 8)

        ));
        board.setLadders(Arrays.asList(
                new Ladder(60, 5),
                new Ladder(62, 5),
                new Ladder(68, 15),
                new Ladder(41, 10),
                new Ladder(99, 85),
                new Ladder(94, 90)
        ));
        return board;
    }

    private GameService initializeGameService(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name for Player 1: ");
        String player1Name = "Saurav ";
        System.out.println("Enter name for Player 2: ");
        String player2Name = "Nischi ";

        Player player1 = new Player(player1Name, 0);
        Player player2 = new Player(player2Name, 0);

        GameService gameService = new GameService(board, Arrays.asList(player1, player2));
        return gameService;
    }

}
