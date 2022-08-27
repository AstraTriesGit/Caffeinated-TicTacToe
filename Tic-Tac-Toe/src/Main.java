import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static int turns = 0;
    public static boolean victory = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String game = "_________";
        while (!X_wins(game) && !O_wins(game) && turns != 9){
            printState(game);
            game = userInput(game);
        }
        printState(game);
        gameState(game);
    }

    public static void printState(String symbols){
        System.out.println("---------");
        for (int i = 0; i < symbols.length(); i += 3) {
            System.out.print("| "+symbols.charAt(i)+" "+symbols.charAt(i+1)+" "+symbols.charAt(i+2)+" |\n");
        }
        System.out.println("---------");
    }

    public static void gameState(String symbols){
        // mirrors
        String x_mirror = "XXX";
        String o_mirror = "OOO";

        // illegal gameplay - too many of one char
        int x_count = 0;
        int o_count = 0;
        for (int i = 0; i < symbols.length(); i++) {
            if (symbols.charAt(i) == 'X'){
                x_count += 1;
            } else if (symbols.charAt(i) == 'O') {
                o_count += 1;
            }
        }
        if (x_count - o_count > 1 || x_count - o_count < -1){
            System.out.println("Impossible");
            return;
        }
        // illegal gameplay - both win
        if (X_wins(symbols) && O_wins(symbols)){
            System.out.println("Impossible");
            return;
        }

        // player wins
        if (X_wins(symbols)){
            System.out.println("X wins");
            return;
        }
        else if (O_wins(symbols)) {
            System.out.println("O wins");
            return;
        }

        // draw or unfinished?
        if (symbols.contains("_")){
            System.out.println("Game not finished");
        }else {
            System.out.println("Draw");
        }
    }

    public static boolean X_wins(String symbols){
        // row victory
        for (int i = 0; i < 9; i += 3) {
            if (symbols.charAt(i) == 'X' && symbols.charAt(i+1) == 'X' && symbols.charAt(i+2) == 'X'){
                return true;
            }
        }
        // column victory
        for (int i = 0; i < 3; i += 1) {
            if (symbols.charAt(i) == 'X' && symbols.charAt(i+3) == 'X' && symbols.charAt(i+6) == 'X'){
                return true;
            }
        }
        // diagonal victory
        if (symbols.charAt(0) == 'X' && symbols.charAt(4) == 'X' && symbols.charAt(8) == 'X'){
            return true;
        }
        else return symbols.charAt(2) == 'X' && symbols.charAt(4) == 'X' && symbols.charAt(6) == 'X';
    }

    public static boolean O_wins(String symbols){
        // row victory
        for (int i = 0; i < 9; i += 3) {
            if (symbols.charAt(i) == 'O' && symbols.charAt(i+1) == 'O' && symbols.charAt(i+2) == 'O'){
                return true;
            }
        }
        // column victory
        for (int i = 0; i < 3; i += 1) {
            if (symbols.charAt(i) == 'O' && symbols.charAt(i+3) == 'O' && symbols.charAt(i+6) == 'O'){
                return true;
            }
        }
        // diagonal victory
        if (symbols.charAt(0) == 'O' && symbols.charAt(4) == 'O' && symbols.charAt(8) == 'O'){
            return true;
        }
        else return symbols.charAt(2) == 'O' && symbols.charAt(4) == 'O' && symbols.charAt(6) == 'O';
    }

    public static String userInput(String symbols) {
        boolean legitinput = false;
        Scanner read = new Scanner(System.in);
        do {

            try {
                String x_str = read.next();
                String y_str = read.next();

                //if (){}
                int x = Integer.parseInt(x_str);
                int y = Integer.parseInt(y_str);


                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                int change_this = (x - 1) * (3) + (y - 1);
                boolean addX = true;
                if (symbols.charAt(change_this) == '_') {
                    String edited = "";
                    for (int i = 0; i < symbols.length(); i++) {
                        if (i == change_this && turns%2 == 0) {
                            edited += 'X';
                            addX = false;
                        } else if (i == change_this && turns%2 == 1) {
                            edited += 'O';
                        } else {
                            edited += symbols.charAt(i);
                        }
                    }
                    turns += 1;
                    return edited;
                } else {
                    //boolean legitinput = true;
                    System.out.println("This cell is occupied!");
                }
            } catch (NumberFormatException youthought) {
                System.out.println("You should enter numbers!");
                //legitinput = true;
            }
        } while (!legitinput);
        return symbols;
    }

}





