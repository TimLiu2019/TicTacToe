package sample;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Random;

import static sample.FXMLDocumentController.*;


public class Engine implements Runnable {


    /**
     * Random bot, place "O" randomly
     */
    public void randomBot() {
        this.onGameWon();
        if (gameOver) {
            return;
        }
        ArrayList<Integer> goList = new ArrayList<>();
        Random randomGenerator;
        randomGenerator = new Random();
        for (int i = 0; i < 9; i++) {
            if (board.get(i).equals("")) {
                goList.add(i);
            }
        }

        // if no place for "O", tie
        if (goList.size() == 0) {

            tieGame = true;
            botTurn = false;
            return;

        }
        // random choose a space
        int index = randomGenerator.nextInt(goList.size());
        // next "O"
        int next = goList.get(index);

        if (board.get(next).equals("") && gameStart && !gameOver) {
            try {
                int finalI = next;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        board.set(finalI, "O");
                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
            }
            botTurn = false;
            return;

        }
    }

    /**
     * highlight winning buttons
     */
    public void hightligtWinning() {
        String winningStyle =
                "-fx-background-color: #4285F4;" +
                        "-fx-text-fill: #DB4437;" +
                        "-fx-background-insets: 2px;";
        if (gameOver && !tieGame) {
            if (this.onGameWon().length > 0) {
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Integer[] winIndex = onGameWon();
                            for (Integer index : winIndex) {
                                boardStyle.set(index, winningStyle);
                            }

                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
            return;
        }
    }

    /**
     * @return winnding indexes
     * Change game state
     */
    public Integer[] onGameWon() {
        // Diagonal 1
        if (board.get(0).equals(board.get(4)) && board.get(4).equals(board.get(8)) && (!board.get(8).equals(""))) {
            Integer[] w = {0, 4, 8};
            gameOver = true;
            return w;
        }
        // Diagonal 2
        if (board.get(2).equals(board.get(4)) && board.get(4).equals(board.get(6)) && (!board.get(6).equals(""))) {
            Integer[] w = {2, 4, 6};
            gameOver = true;
            return w;
        }
        // row 1
        if (board.get(0).equals(board.get(1)) && board.get(1).equals(board.get(2)) && (!board.get(2).equals(""))) {
            Integer[] w = {0, 1, 2};
            gameOver = true;
            return w;
        }
        // row 2
        if (board.get(3).equals(board.get(4)) && board.get(4).equals(board.get(5)) && (!board.get(5).equals(""))) {
            Integer[] w = {3, 4, 5};
            gameOver = true;
            return w;
        }
        // row 3
        if (board.get(6).equals(board.get(7)) && board.get(7).equals(board.get(8)) && (!board.get(8).equals(""))) {
            Integer[] w = {6, 7, 8};
            gameOver = true;
            return w;
        }
        // column 1
        if (board.get(0).equals(board.get(3)) && board.get(3).equals(board.get(6)) && (!board.get(6).equals(""))) {
            Integer[] w = {0, 3, 6};
            gameOver = true;
            return w;
        }
        // column 2
        if (board.get(1).equals(board.get(4)) && board.get(4).equals(board.get(7)) && (!board.get(7).equals(""))) {
            Integer[] w = {1, 4, 7};
            gameOver = true;
            return w;
        }
        // column 3
        if (board.get(2).equals(board.get(5)) && board.get(5).equals(board.get(8)) && (!board.get(8).equals(""))) {
            Integer[] w = {2, 5, 8};
            gameOver = true;
            return w;
        }

        return null;
    }


    /**
     * Thread run() method
     */

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.onGameWon();

            if (botTurn) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.randomBot();
            }
            if (gameOver && !tieGame) {
                //   System.out.println("game over");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.hightligtWinning();
                return;
            }
            if (tieGame) {
                //  System.out.println("tie");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.hightligtWinning();
                return;
            }
        }


    }
}
