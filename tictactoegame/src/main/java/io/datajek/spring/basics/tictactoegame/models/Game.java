package io.datajek.spring.basics.tictactoegame.models;

public class Game {

    private char[][] board;
    private char currentPlayer;
    private  boolean gameOver;

    private String message;

    public Game(){
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        message = "Player " + currentPlayer + "'s turn.";
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char board[][]){
        this.board = board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }


    public void setGameOver(boolean b) {
        gameOver = b;
    }
}
