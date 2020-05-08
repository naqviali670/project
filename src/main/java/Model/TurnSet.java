package Model;

public class TurnSet {
    private static int turn=1;
    public static  int getTurn(){
        return turn;
    }
    public static void setTurn(int t){
        turn =t;
    }
}
