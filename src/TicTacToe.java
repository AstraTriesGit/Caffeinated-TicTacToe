import java.util.Scanner;

public class TicTacToe {
    protected String game;
    protected int turns;
    protected boolean victory = false;

    public TicTacToe() {
        this.game = "_________";
        this.turns = 0;
    }

    public boolean isVictory() {
        return victory;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        while (game.isVictory()) {

        }

    }

    protected void printGame() {
        System.out.println("---------");
        for (int i = 0; i < game.length(); i += 3) {
            System.out.print("| "+game.charAt(i)+" "+game.charAt(i+1)+" "+game.charAt(i+2)+" |\n");
        }
        System.out.println("---------");
    }

    protected void setVictory() {
        // row victory
        for (int i = 0; i < 9; i += 3) {
            if (game.charAt(i) == 'X' && game.charAt(i+1) == 'X' && game.charAt(i+2) == 'X'){
                victory = true;
                break;
            }
        }
        // column victory
        for (int i = 0; i < 3; i += 1) {
            if (game.charAt(i) == 'X' && game.charAt(i+3) == 'X' && game.charAt(i+6) == 'X'){
                victory = true;
                break;
            }
        }
        // diagonal victory
        if (game.charAt(0) == 'X' && game.charAt(4) == 'X' && game.charAt(8) == 'X'){
            victory = true;
        }
        if (victory) {
            System.out.println("X wins");
            return;
        }
        // row victory
        for (int i = 0; i < 9; i += 3) {
            if (game.charAt(i) == 'O' && game.charAt(i+1) == 'O' && game.charAt(i+2) == 'O'){
                victory = true;
                break;
            }
        }
        // column victory
        for (int i = 0; i < 3; i += 1) {
            if (game.charAt(i) == 'O' && game.charAt(i+3) == 'O' && game.charAt(i+6) == 'O'){
                victory = true;
                break;
            }
        }
        // diagonal victory
        if (game.charAt(0) == 'O' && game.charAt(4) == 'O' && game.charAt(8) == 'O'){
            victory = true;
        }
        if (victory) {
            System.out.println("O wins");
            return;
        }




    }

    protected void userInput() {
        boolean legitinput = false;
        Scanner read = new Scanner(System.in);
        do {

            try {
                String x_str = read.next();
                String y_str = read.next();

                int x = Integer.parseInt(x_str);
                int y = Integer.parseInt(y_str);

                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                int change_this = (x - 1) * (3) + (y - 1);
                boolean addX = true;
                if (game.charAt(change_this) == '_') {
                    String edited = "";
                    for (int i = 0; i < game.length(); i++) {
                        if (i == change_this && turns%2 == 0) {
                            edited += 'X';
                            addX = false;
                        } else if (i == change_this && turns%2 == 1) {
                            edited += 'O';
                        } else {
                            edited += game.charAt(i);
                        }
                    }
                    turns += 1;
                    game = edited;
                } else {
                    System.out.println("This cell is occupied!");
                }
            } catch (NumberFormatException BadIdea) {
                System.out.println("You should enter numbers!");
            }
        } while (!legitinput);
    }
}

