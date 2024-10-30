package io.datajek.spring.basics.snakeladdergame.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Board {

    private final int size = 100;
    private List<Snake> snakes;
    private List<Ladder> ladders;

//    Board(Snake snakes, Ladder ladders){
//        this.snakes = (List<Snake>) snakes;
//        this.ladders = (List<Ladder>) ladders;
//    }

    public int getSize() {
        return size;
    }

    public void setSnakes(List<Snake> snakes){
        this.snakes = snakes;
    }

    public void setLadders(List<Ladder> ladders){
        this.ladders = ladders;
    }

    public List<Snake> getSnakes(){
        return snakes;
    }

    public List<Ladder> getLadders(){
        return ladders;
    }




}
