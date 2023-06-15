package arrays2d.TicTacToe;
import java.util.Scanner;
public class TicTacToe{
    public String[][] board = new String[3][3];
    private String currentPlayer = "X";
    public boolean gameRunning = true;
    private String winner = "";
    private boolean TIE;
    public TicTacToe(String[][] board){
        this.board = board;
    }
    //initializes the board with "-"'s in all spaces
    public void drawBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = "-";
            }
        }
    }
    //switches the turn
    public void switchPlayer(){
        if(currentPlayer == "X")
            currentPlayer = "O";
        else if(currentPlayer == "O")
            currentPlayer = "X";
    }

    //getters
    public String getCurrentPlayer(){
        return currentPlayer;
    }
    public String[][] getBoard(){
        return board;
    }

    public String getWinner(){
        return winner;
    }

    public boolean getTIE(){
        return TIE;
    }


    //Console Function. Display needs it own methods, so it's in the Display class. Similar method, just with images and for loop
    public void playerInput(){
        try {
            System.out.println(currentPlayer + "'s Turn");
            Scanner sc = new Scanner((System.in));
            int r = sc.nextInt();
            Scanner sc1 = new Scanner(System.in);
            int c = sc1.nextInt();

            if (board[r][c] == "-") {
                board[r][c] = currentPlayer;
                this.switchPlayer();
            } else {
                System.out.println("Invalid Spot");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Spot");
        }
    }
    //checks Rows
    public void checkRow(){
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == board[2][0] && board[0][0] != "-" ){
            winner = board[0][0];
            confirmWin();
        }
        else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[1][1] == board[2][1] && board[2][1] != "-" ) {
            winner = board[2][1];
            confirmWin();
        }
        else if(board[0][2] == board[1][2] && board[1][2] == board[2][2]  && board[0][2] == board[2][2] && board[0][2] != "-") {
            winner = board[0][2];
            confirmWin();
        }

    }
    //checks Columns
    public void checkCol(){
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == board[0][2] && board[0][0] != "-" ){
            winner = board[0][0];
            confirmWin();
        }
        else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == board[1][2] && board[1][0] != "-" ){
            winner = board[1][0];
            confirmWin();
        }
        else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == board[2][2] && board[2][0] != "-" ){
            winner = board[2][0];
            confirmWin();
        }
    }
    //checks diagonally
    public void checkDiagonal(){
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == board[2][2] && board[0][0] != "-"){
            winner = board[0][0];
            confirmWin();
        }
        else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] == board[0][2] && board[0][2] != "-"){
           winner = board[2][0];
           confirmWin();
        }
    }
    //Prints out message and stops game running
    public void confirmWin(){
        if(winner == "X" || winner == "O") {
            System.out.println("Congrats " + winner + ", You Win!");
            gameRunning = false;
        }
    }


    //saves future typing (checks all win conditions at once)
    public void checkWinCons(){
        checkRow();
        checkCol();
        checkDiagonal();
    }
    //checks for ties
    public void checkTie(){
        int count = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] == "-"){
                    count++;
                }
            }
        }

        //basically if there are no "-"'s left then it would be a tie. Call the function after checking for wins, so that the last move doesn't
        //get rendered as tie if it is a winning move.
        if(count == 0){
            TIE = true;
            System.out.println("It's a tie!");
            gameRunning = false;
        }
        else
            TIE = false;

    }
    //for console main and debugging
    @Override
    public String toString(){
        return                           "[ " + this.board[0][0] + " " + this.board[1][0] + " " + this.board[2][0] + " ] \n" +
                                         "[ " + this.board[0][1] + " " + this.board[1][1] + " " + this.board[2][1] + " ] \n" +
                                         "[ " + this.board[0][2] + " " + this.board[1][2] + " " + this.board[2][2] + " ]";

    }
}
