package io.datajek.spring.basics.snakeladdergame.model;

public class Ladder {

    private int top;
    private int bottom;

    public Ladder(int top, int bottom){

        if (bottom >= top) {
            throw new IllegalArgumentException("Bottom must be less than top for a ladder.");
        }

        this.bottom = bottom;
        this.top = top;
    }

    public void setTop(int top){
        this.top = top;
    }

    public void setBottom(int bottom){
        this.bottom = bottom;
    }

    public int getTop(){
        return this.top;
    }

    public int getBottom(){
        return this.bottom;
    }
}

