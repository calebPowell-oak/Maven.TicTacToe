package rocks.zipcodewilmington.tictactoe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    private Character[][] game;

    public Board(Character[][] matrix) {
        game = matrix;
    }

    public Boolean isInFavorOfX() {
        Integer xFavorability = 0;
        Integer oFavorability = 0;
        ArrayList<Integer> xHas = new ArrayList<Integer>();
        ArrayList<Integer> oHas= new ArrayList<Integer>();
        String[][] wins = {{"048","012","036"},{"012","147"},{"246","012","258"},
                {"345","036"},{"048","246","345","147"},{"345","258"},
                {"246","678","036"},{"678","147"},{"048","678","258"}};

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                if(game[i][j] == 'X'){
                    xHas.add(i*3+j);
                } else if(game[i][j] == 'O'){
                    oHas.add(i*3+j);
                }
            }
        }
        System.out.println(xHas);
        System.out.println(oHas);;
        for(Integer xnum:xHas){
            System.out.println("For xnum = " + xnum+" in "+xHas);
            for(String set:wins[xnum]){
                System.out.println("For set: " + set);
                for(Integer onum:oHas){
                    System.out.println("Check for: " + onum + " in set: " + set);
                    if(!set.contains(onum.toString())){
                        System.out.println("Set "+set+" didn't contain: "+onum);
                        System.out.println("Favorability for x went up.");
                        xFavorability++;
                        System.out.println("X favor = "+xFavorability);
                    }
                }
            }
        }

        for(Integer onum:oHas){
            for(String set:wins[onum]){
                for(Integer xnum:xHas){
                    if(!set.contains(xnum.toString())){
                        oFavorability++;
                    }
                }
            }
        }
        System.out.println(xFavorability);
        System.out.println(oFavorability);
        return xFavorability > oFavorability;
    }

    public Boolean isInFavorOfO() {
        return !isInFavorOfX();
    }

    public Boolean isTie() {
        return null;
    }

    public String getWinner() {
        return null;
    }

}
