package arrays2d.TicTacToe;

public class TicTacToeConsole {
    public static void main(String[] args){
        String[][] Board = new String[3][3];
        TicTacToe game = new TicTacToe(Board);
        game.drawBoard();
        System.out.println(game.toString());
        while(game.gameRunning){
            game.playerInput();
            System.out.println(game.toString());
            game.checkWinCons();
            game.checkTie();
        }
    }
}
