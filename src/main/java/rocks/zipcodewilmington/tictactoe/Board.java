package rocks.zipcodewilmington.tictactoe;

import java.util.ArrayList;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    private Character[][] game;
    private String[][] wins = {{"048","012","036"},{"012","147"},{"246","012","258"},
                               {"345","036"},{"048","246","345","147"},{"345","258"},
                               {"246","678","036"},{"678","147"},{"048","678","258"}};

    private ArrayList<Integer> xHas = new ArrayList<Integer>();
    private ArrayList<Integer> oHas = new ArrayList<Integer>();

    public Board(Character[][] matrix) {
        game = matrix;
        buildHands();
    }

    public void buildHands(){

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                if(game[i][j] == 'X'){
                    xHas.add(i*3+j);
                } else if(game[i][j] == 'O'){
                    oHas.add(i*3+j);
                }
            }
        }
    }

    public Boolean victoryPerHand(ArrayList<Integer> hand){
        for(Integer num:hand){
            for(String winningSet: wins[num]){
                Integer inARow = 0;
                for(int i = 0; i < hand.size(); i++){
                    if(winningSet.contains(hand.get(i).toString())){
                        inARow++;
                    }
                    if(inARow == 3) return true;
                }
            }
        }
        return false;
    }

    public Boolean isInFavorOfX() {
        if(victoryPerHand(xHas)){
            return true;
        } else if(victoryPerHand(oHas)) {
            return false;
        } else if(isTie()){
            return false;
        } else {
            Integer xFavorability = 0;
            Integer oFavorability = 0;

            for (Integer xnum : xHas) {
                for (String set : wins[xnum]) {
                    for (Integer onum : oHas) {
                        if (!set.contains(onum.toString())) {
                            xFavorability++;
                        }
                    }
                }
            }

            for (Integer onum : oHas) {
                for (String set : wins[onum]) {
                    for (Integer xnum : xHas) {
                        if (!set.contains(xnum.toString())) {
                            oFavorability++;
                        }
                    }
                }
            }
            return xFavorability > oFavorability;
        }
    }

    public Boolean isInFavorOfO() {
        if(victoryPerHand(oHas)){
            return true;
        } else if(victoryPerHand(xHas)) {
            return false;
        } else if(isTie()){
            return false;
        } else {
            Integer xFavorability = 0;
            Integer oFavorability = 0;

            for (Integer xnum : xHas) {
                for (String set : wins[xnum]) {
                    for (Integer onum : oHas) {
                        if (!set.contains(onum.toString())) {
                            xFavorability++;
                        }
                    }
                }
            }

            for (Integer onum : oHas) {
                for (String set : wins[onum]) {
                    for (Integer xnum : xHas) {
                        if (!set.contains(xnum.toString())) {
                            oFavorability++;
                        }
                    }
                }
            }
            return xFavorability < oFavorability;
        }
    }

    public Boolean isTie() {
        if(xHas.size()+oHas.size() == 9){
            if(!victoryPerHand(xHas) && !victoryPerHand(oHas)){
                return true;
            }
        }
        return false;
    }

    public String getWinner() {
        if(victoryPerHand(xHas)){
            return "X";
        } else if(victoryPerHand(oHas)){
            return "O";
        }
        return "";
    }

    public ArrayList<Integer> getXHand(){
        return xHas;
    }

    public ArrayList<Integer> getOHand(){
        return oHas;
    }

}