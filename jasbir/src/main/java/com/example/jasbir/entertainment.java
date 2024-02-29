package com.example.jasbir;

public class entertainment {
    private String game;
    private String hobby;
    private String movie;


    public entertainment(String game, String hobby, String movie) {
        this.game = game;
        this.hobby = hobby;
        this.movie = movie;
    }


    public String getGame() {
        return game;
    }

    public String getHobby() {
        return hobby;
    }

    public String getMovie() {
        return movie;
    }


    public void setGame(String game) {
        this.game = game;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
