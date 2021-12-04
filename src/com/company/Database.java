package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Database.java классы әдістерді қамтиды
 */
public class Database implements Db{
    public void savePlayer(ArrayList<Player> players){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("player.txt"));
            for (Player p: players){
                bw.write(p.getNickname()+"\n");
                bw.write(p.getPassword()+"\n");
            }
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * GetAllPlayer әдісі базадан ақпаратты алу үшін қолданылады
     * @return players
     */
    public ArrayList<Player> getAllPlayer(){
        ArrayList<Player> players = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("player.txt"));
            String line = "";
            while ((line=br.readLine())!=null){
                String password = br.readLine();
                players.add(new Player(line,password));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return players;
    }

    /**
     * Ақпаратты базадан алу
     * @return gameresult
     */
    public ArrayList<GameResult> getResult(){
        ArrayList<GameResult> gameResults = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("result.txt"));
            String line = "";
            while ((line=br.readLine())!=null){
                String password = br.readLine();
                int max_level = Integer.parseInt(br.readLine());
                double point = Double.parseDouble(br.readLine());
                int place = Integer.parseInt(br.readLine());
                gameResults.add(new GameResult(line,password,max_level,point,place));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return gameResults;
    }

    /**
     * Ақпаратты базаға сақтау әдісі
     * @param gameResults ArrayList<GameResult>
     */
    public void saveGame(ArrayList<GameResult> gameResults){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
            for (GameResult g: gameResults){
                bw.write(g.getNickname()+"\n");
                bw.write(g.getPassword()+"\n");
                bw.write(g.getMax_lever()+"\n");
                bw.write(g.getPoint()+"\n");
                bw.write(g.getPlace()+"\n");
            }
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
