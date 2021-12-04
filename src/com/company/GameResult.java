package com.company;

/**
 * GameResult.java Player.java классының мұрагері
 */
public class GameResult extends Player implements getInformation{
    int place;

    /**
     * Конструктор
     * @param nickname String value
     * @param password String value
     * @param max_lever Integer value
     * @param point Double value
     * @param place Integer value
     */
    public GameResult(String nickname, String password, int max_lever, Double point, int place) {
        super(nickname, password, max_lever, point);
        this.place = place;
    }

    /**
     * Конструктор
     * @param nickname String value
     * @param password String value
     * @param place Integer value
     */
    public GameResult(String nickname, String password, int place) {
        super(nickname, password);
        this.place = place;
    }

    public GameResult() {
    }

    /**
     * Getter
     * @return place
     */
    public int getPlace() {
        return place;
    }

    /**
     * Setter
     * @param place Integer value
     */
    public void setPlace(int place) {
        this.place = place;
    }

    /**
     * getAllDated() әдісі
     * @return Player
     */
    @Override
    public String getAllDated() {
        return  "Player[" +
                "nickname='" + getNickname() + '\'' +
                ", max_lever='" + getMax_lever() + '\'' +
                ", point=" + getPoint() +
                ']' +
                "GameResult[" +
                "place=" + place +
                ']';
    }

}
