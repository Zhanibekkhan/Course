package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main.java класс компиляция классы
 * @since 2.0
 * @version 1.0
 * @author sib
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Жаңа ақпаратты еңгізу
        Database db = new Database(); // Database классының объектісін ашу
        ArrayList<Player> players = db.getAllPlayer(); // Тізімге базадағы ақпаратты қосу
        ArrayList<GameResult> gameResults = db.getResult(); // Тізімге базадағы ақпаратты қосу
        int d=1; // айнымалы
        double sum=0; // айнымалы
        String name=""; // айнымалы
        int c=0; // айнымалы
        for (int i=0;i<10;i++){ // цикл 10 рет қайталайды
            System.out.print("-----"); // Консольга шығару
            if (i==4){ // Шартты оператор
                System.out.print(" WELCOME TO GAME "); // Консольға шығару
            }
        }
        System.out.println("""
                \nPRESS 1 TO SIGN IN
                PRESS 2 TO REGISTER
                PRESS 3 LIST OF RECORDS
                PRESS 4 TO EXIT
                """); //Интерфейс
        String choice = in.next(); // Жаңа айнымалыны еңгізу
        if (choice.equals("1")){ // Шартты оператор
            for (int i=0;i<10;i++){ // Цикл
                System.out.print("-----");
                if (i==4){
                    System.out.print(" SIGN IN ");
                }
            }
            System.out.println("\nINSERT NICKNAME:");
            String nickname = in.next(); // Жаңа айнымалыны еңгізу
            System.out.println("INSERT PASSWORD");
            String password = in.next(); // Жаңа айнымалыны еңгізу
            name = nickname;
            for (Player p: players){ // Цикл
                if (p.getNickname().equals(nickname)&&p.getPassword().equals(password)){ // Шартты оператор
                    for (int i=0;i<10;i++){ // Цикл
                        System.out.print("-----");
                        if (i==4){
                            System.out.print(" WELCOME, LETS PLAY ");
                        }
                    }
                    for (int j=0; j<gameResults.size();j++){ // Цикл
                        if (gameResults.get(j).getNickname().equals(nickname)){ // Шартты оператор
                            c = j; // Тізімдегі белгілі бір ақпараттың индексын сақтау
                        }
                    }
                    System.out.println(" \nWELCOME "+name);
                    for (int i=1;i<=2;i++){ // цикл
                        System.out.println("\nLEVEL---"+i);
                        int number = (int) (Math.random()*100+1); // Кездейсоқ санды алу
                        int max=100; // Айнымалы максимум
                        int min=1; // Айнымалы минимум
                        int count=0; // санаушы
                        int result = 0; //
                        boolean rs = true; // логикалық оператор
                        int point = 0; // айнымалы
                        int s = i; // индексты сақтау
                        String choice1 = "2"; // айнымалы
                        while (rs){ // цикл
                            if (i!=2){ // шартты оператор
                                System.out.println("Insert number: ");
                            }
                            if (s==2){
                                System.out.println("""
                                    PRESS 1 TO EXIT
                                    PRESS 2 TO CONTINUE
                                    """);
                                choice1 = in.next(); // Жаңа айнымалы
                                s++; // 1 санын қосу
                            }
                            if (choice1.equals("1")){ // Шартты оператор
                                gameResults.set(c,new GameResult(nickname,password,i,(double)sum,d)); // Тізімге жаңа ақпаратты қосу
                                db.saveGame(gameResults); // Және сол тізімді базаға сақтау
                                System.exit(0); // Программаны тоқтату
                            } else if (choice1.equals("2")){ // Шартты оператор
                                if (s==3){
                                    System.out.println("Insert number:");
                                }
                                int new_num = in.nextInt(); // Жаңа айнымалыны еңгізу
                                if (number==new_num){ // Шартты оператор
                                    System.out.println("WOW, YOU ARE SO SMART");
                                    System.out.println("Attempts -"+count);
                                    rs=false;
                                } else if  (number>new_num){ // Максимумды анықтау
                                    max = new_num;
                                    System.out.println("Number which you are search is Bigger than "+ new_num);
                                    count++; // Санамшыға қосу
                                } else if (number<new_num){ // Минимумды анықтау
                                    min = new_num;
                                    System.out.println("Number which you are search is smaller than "+ new_num);
                                    count++; //Санамшыға қосу
                                }
                            }
                        }
                        for (int k=0;k<gameResults.size();k++){ // Цикл
                            if (count==0){
                                point = 10; // Балл саны
                                sum = point+gameResults.get(c).getPoint(); // Балл санын анықтап жаңадан алынған балды қосу
                            } else if (count>=0&&count<=2){ //Шартты оператор
                                point = 8; // Балл саны
                                sum = point+gameResults.get(c).getPoint(); // Балл санына қосу
                            } else if (count>2&&count<=4){ // Шартты оператор
                                point = 6;  // Балл саны
                                sum = point+gameResults.get(c).getPoint();
                            } else if (count>4&&count<=6){ // Шартты оператор
                                point = 4; // Балл саны
                                sum = point+gameResults.get(c).getPoint(); // Балл санына қосу
                            } else if (count>6) { // Шартты оператор
                                point = 2; // Балл саны
                                sum = point+gameResults.get(c).getPoint(); // Балл санын қосу
                            }
                        }
                        if (i==2){ // Жаңа ақпаратты қосу
                            gameResults.set(c,new GameResult(nickname,password,i,sum,d)); // Тек бір ғана ақпаратты сақтау
                            db.saveGame(gameResults); // Базада жаңа ақпаратты сақтау
                        }
                    }
                }
            }

        } else if (choice.equals("2")){ // Шартты оператор
            for (int i=0;i<10;i++){ // Цикл
                System.out.print("-----");
                if (i==4){
                    System.out.print(" REGISTER ");
                }
            }
            System.out.println("\nInsert nickname");
            String nick = in.next();
            System.out.println("Insert password");
            String password = in.next();
            System.out.println("Insert password");
            String password1 = in.next();
            boolean rs = true;
                for (Player p: players){
                    if (p.getNickname().equals(nick)){
                        System.out.println("! ----- Insert another nickname");
                        rs = false;
                    }
                }
                if (!password1.equals(password)){
                    System.out.println("! ----- Insert same password");
                    rs=false;
                }
            if (rs==true){
                players.add(new Player(nick,password));
                db.savePlayer(players);
            }

        } else if (choice.equals("3")){
            for (int i=0;i<13;i++){
                System.out.print("-----");
                if (i==5){
                    System.out.print(" RESULT  ");
                }
            }
            for (int i=0;i< gameResults.size();i++){
                System.out.println("\n"+gameResults.get(i).getAllDated());
            }
            for (int i=0;i<15;i++){
                System.out.print("-----");
            }

        }
    }
}
