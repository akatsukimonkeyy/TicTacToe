package arrays2d.TicTacToe;

import processing.core.PApplet;
import processing.core.PImage;
public class TicTacToeDisplay extends PApplet {
    public static void main(String[] args) {
        //if you download then change this to where the display class is in
        PApplet.main("arrays2d.TicTacToe.TicTacToeDisplay");
    }
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    String[][] board = new String[3][3];
    TicTacToe game = new TicTacToe(board);
    final int WIDTH = 800;
    final int HEIGHT = 800;
    final int BLOCKX = WIDTH / 3;
    final int BLOCKY = HEIGHT / 3;
    PImage X;
    PImage O;
    public void setup() {
        //if you download this then change these to where the folder is
        X = loadImage("arrays2d/TicTacToe/Images/X.png");
        O = loadImage("arrays2d/TicTacToe/Images/O.png");
        X.resize(BLOCKX, BLOCKY);
        O.resize(BLOCKX, BLOCKY);
        drawBoard();
        game.drawBoard();
        //draws the board in display and initializes the board that runs in the background.
        frameRate = 60;
    }
    //draws message on screen if there is a winner or Tie
    public void draw() {
        if(game.getWinner() == "X"){
            background(255);
            fill(0);
            textSize(128);
            text("Congrats X!", 0, 400);
        }
        else if(game.getWinner() == "O"){
            background(255);
            fill(0);
            textSize(128);
            text("Congrats O!", 0, 400);
            //debugging System.out.println(game.toString());
        }
        else if(game.getTIE() == true){
            background(255);
            fill(0);
            textSize(128);
            text("   It's a TIE!", 0, 400);
        }
    }
    //draws the grid
    public void drawBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                fill(255);
                rect(row * BLOCKX, col * BLOCKY, (row + 1) * BLOCKX, (col + 1) * BLOCKY);
            }
        }
    }
    public void mouseClicked() {
        //while the game is running, if the mouse is in any of the boxes and I click, the box that my mouse is hovering over will be either
        //an X or an O. Switches player after drawing X/O. Makes sure that you can't draw on preoccupied spaces, which is why you can only
        //draw where it has an "-" on the board. Updates the board as well as the display.
        if (game.gameRunning == true) {
            for (int row = 0; row < game.getBoard().length; row++) {
                for (int col = 0; col < game.getBoard()[row].length; col++) {
                    if (mouseX > (col * BLOCKX) && mouseX < ((col + 1) * BLOCKX)
                            && mouseY > (row * BLOCKY) && mouseY < ((row + 1) * BLOCKY)) {
                        if (game.getBoard()[col][row] == "-") {
                            game.getBoard()[col][row] = game.getCurrentPlayer();
                            if (game.getBoard()[col][row] == "X") {
                                image(X, col * BLOCKX, row * BLOCKY);
                                game.switchPlayer();
                            }
                            else if (game.getBoard()[col][row] == "O") {
                                image(O, col * BLOCKX, row * BLOCKY);
                                game.switchPlayer();
                            }
                            System.out.println(game.toString());
                        }
                    }
                }
            }
            game.checkWinCons();
            game.checkTie();
            //always keeps checking for potential Win or Tie
        }
    }
}
