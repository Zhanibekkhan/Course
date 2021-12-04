package com.company;

/**
 * Player.java классы ойыншылар туралы ақпаратты сақтайды
 */

public class Player implements getInformation{
    private String nickname;
    private String password;
    private int max_lever;
    private Double point;

    /**
     * Конструктор
     * @param nickname String value
      * @param password String value
     * @param max_lever Integer value
     * @param point Double value
     */
    public Player(String nickname, String password, int max_lever, Double point) {
        this.nickname = nickname;
        this.password = password;
        this.max_lever = max_lever;
        this.point = point;
    }

    /**
     * Конструктор
     */
    public Player() {
    }

    /**
     * Конструктор
     * @param nickname String value
     * @param password String value
     */
    public Player(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    /**
     * Getter
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Setter
     * @param nickname String value
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMax_lever() {
        return max_lever;
    }

    public void setMax_lever(int max_lever) {
        this.max_lever = max_lever;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String getAllDated() {
        return "Player{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", max_lever='" + max_lever + '\'' +
                ", point=" + point +
                '}';
    }
}
