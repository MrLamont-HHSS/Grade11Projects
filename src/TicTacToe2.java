
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author lamonta
 */
public class TicTacToe2 implements Runnable, ActionListener {

    // Class Variables  
    JPanel mainPanel;
    JPanel gameGrid;
    JButton[] gridButtons = new JButton[9];
    JTextField instructions;
    
    JLabel pictureLabel;
    ImageIcon pic;

    char[] board = new char[9];
    char player = 'X';

    boolean runGame = true;
    
    Font biggerText = new Font("arial", Font.BOLD, 145);

    // Method to assemble our GUI
    public void run() {
        // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
        JFrame frame = new JFrame("Title");
        // Makes the X button close the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // makes the windows 800 pixel wide by 600 pixels tall
        frame.setSize(800, 600);
        // shows the window
        frame.setVisible(true);

        // make the overall panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // grid for the buttons
        gameGrid = new JPanel();
        gameGrid.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            // make the button
            gridButtons[i] = new JButton();
            // set the actionListener
            gridButtons[i].addActionListener(this);
            // set the action command
            gridButtons[i].setActionCommand("" + i);
            // set to a bigger font
            gridButtons[i].setFont(biggerText);
            // add them to the grid
            gameGrid.add(gridButtons[i]);
        }

        // add gamegrid to main panel center spot
        mainPanel.add(gameGrid, BorderLayout.CENTER);

        // create the instructions text
        instructions = new JTextField("Player X goes first");
        mainPanel.add(instructions, BorderLayout.PAGE_END);

        pic = new ImageIcon("husky.png");
        pictureLabel = new JLabel(pic);
        mainPanel.add(pictureLabel, BorderLayout.LINE_START);
        
        pictureLabel.setIcon(pic);
        
        // put the main panel in the frame to see
        frame.add(mainPanel);

        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
            gridButtons[i].setText("");
        }
    }

    public boolean placePiece(int spot) {
        if (spot < 0 || spot > 8 || !isFree(spot)) {
            instructions.setText("Invalid choice. Try again");
            return false;
        }
        board[spot] = player;
        gridButtons[spot].setText("" + player);
        return true;
    }

    public void changeTurns() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
        instructions.setText("It is " + player + "'s turn!");
    }

    public boolean checkForWin() {
        // check vertical and horizontal
        for (int i = 0; i < 3; i++) {
            if (board[3 * i] == player
                    && board[3 * i + 1] == player
                    && board[3 * i + 2] == player) {
                return true;
            }

            if (board[i] == player
                    && board[i + 3] == player
                    && board[i + 6] == player) {
                return true;
            }
        }
        // diagonals
        if (board[0] == player
                && board[4] == player
                && board[8] == player) {
            return true;
        }
        if (board[2] == player
                && board[4] == player
                && board[6] == player) {
            return true;
        }
        // no one has won...yet
        return false;
    }

    public boolean checkForTie() {
        for (int i = 0; i < board.length; i++) {
            // if we find a blank, can't be a tie game
            if (board[i] == ' ') {
                return false;
            }
        }
        // every spot filled
        return true;
    }

    public boolean isFree(int spot) {
        if (board[spot] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    // method called when a button is pressed
    public void actionPerformed(ActionEvent e) {
        // get the command from the action
        String command = e.getActionCommand();

        if (runGame) {
            // get the number from the command
            int spot = Integer.parseInt(command);
            
            // if we can place a piece at that spot
            if (placePiece(spot)) {
                // did they win?
                if (checkForWin()) {
                    instructions.setText("Player " + player + " wins!!!");
                    runGame = false;
                    // did they tie?
                } else if (checkForTie()) {
                    instructions.setText("Tie game!");
                    runGame = false;
                    // keep going
                } else {
                    changeTurns();
                }
            }
        }

    }

    // Main method to start our program
    public static void main(String[] args) {
        // Creates an instance of our program
        TicTacToe2 gui = new TicTacToe2();
        // Lets the computer know to start it in the event thread
        SwingUtilities.invokeLater(gui);
    }
}
