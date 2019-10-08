package simone;

/**
 * Write a description of class GamePageVer4 here.
 *
 * @author (Jack Scott) and (Joshua Johnson) and Joshua Owczarek
 * @version (version 5)
 */
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GamePageVer5 extends JFrame {

    JButton start = new JButton("Start Game/New Game"); //Start Button.
    JButton red = new JButton("");  //Color buttons.
    JButton green = new JButton("");
    JButton blue = new JButton("");
    JButton yellow = new JButton("");
    static JLabel corner1 = new JLabel("", SwingConstants.CENTER);  //Blank corners.
    static JTextPane corner2 = new JTextPane();
    static JLabel corner3 = new JLabel("", SwingConstants.CENTER);
    static JTextPane corner4 = new JTextPane();
    Color lightBlue = new Color(0, 0, 255);
    Color darkBlue = new Color(0, 0, 150);
    Color lightGreen = new Color(0, 255, 0);
    Color darkGreen = new Color(0, 150, 0);
    Color lightRed = new Color(255, 0, 0);
    Color darkRed = new Color(150, 0, 0);
    Color lightYellow = new Color(255, 255, 0);
    Color darkYellow = new Color(200, 200, 0);
    Color silver = new Color(235, 235, 235);
    static SimoneSound noise = new SimoneSound();
    static String selectedColor = "none";
    static boolean startGame = false;
    static boolean readyToCompare = false;
    static boolean quit = false;
    static boolean noInput = false;

    public GamePageVer5() {
        setLayout(new GridLayout(3, 3));  //Grid Layout format.
        setSize(1000, 600); //Size of main window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        //Background color of main window.
        setVisible(true);
        JPanel pane = new JPanel();
        pane.setBackground(Color.white); //Color of the main window background.

        class ButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                Object selected = event.getSource();
                selectedColor = "none";
                if (selected.equals(start)) {
                    //method to start new game goes here
                    startGame();
                } else if (selected.equals(blue) && !noInput) {
                    noise.playSound1();
                    selectedColor = "Blue";
                    setReadyToCompare(true);
                } else if (selected.equals(green) && !noInput) {
                    noise.playSound2();
                    selectedColor = "Green";
                    setReadyToCompare(true);
                } else if (selected.equals(red) && !noInput) {
                    noise.playSound3();
                    selectedColor = "Red";
                    setReadyToCompare(true);
                } else if (selected.equals(yellow) && !noInput) {
                    noise.playSound4();
                    selectedColor = "Yellow";
                    setReadyToCompare(true);
                }
            }
        }
        ButtonListener buttonListener = new ButtonListener();

        //Blank corner.
        //Sets the color of the blank button.
        corner1.setFont(new Font("Helvetica", Font.BOLD, 48));
        corner1.setText("SIMONE");
        add(corner1);  //Adds the blank button to the window.
        setVisible(true);

        //Red button
        red.setBackground(darkRed); //Sets the color of the red button.
        add(red);  //Adds the red button to the window.
        red.setBorderPainted(false);
        red.addActionListener(buttonListener);
        setVisible(true);

        //Blank corner.
        //Sets the color of the blank button.
        corner2.setEditable(false);
        add(corner2);  //Adds the blank button to the window.
        setVisible(true);
        corner2.setOpaque(true);
        corner2.setBackground(silver);
        StyledDocument rules = corner2.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        rules.setParagraphAttributes(0, rules.getLength(), center, false);
        corner2.setFont(new Font("Helvetica", Font.BOLD, 20));
        corner2.setText("\nPRESS START FOR NEW GAME:"
                + "\n Repeat Simone's sequence."
                + "\n It gets one longer after each Round!");

        //Green button.
        green.setBackground(darkGreen);  //Sets the color of the green button.
        add(green);  //Adds the green button to the window.
        green.setBorderPainted(false);
        green.addActionListener(buttonListener);
        setVisible(true);

        //Start button.
        start.setFont(new Font("Helvetica", Font.BOLD, 24));
        start.setBackground(Color.white);  //Sets the color of the start button.
        add(start);  //Adds the start button to the window.
        setVisible(true);

        //Yellow button.
        yellow.setBackground(darkYellow);  //Sets the color of the yellow button.
        add(yellow);  //Adds the yellow button to the window.
        yellow.setBorderPainted(false);
        yellow.addActionListener(buttonListener);
        setVisible(true);

        //Blank corner.
        add(corner3);  //Adds the blank button to the window.
        corner3.setFont(new Font("Helvetica", Font.BOLD, 20));
        corner3.setOpaque(true);
        setVisible(true);

        //Blue button.
        blue.setBackground(darkBlue);  //Sets the color of the blue button.
        add(blue);  //Adds the blue button to the window.
        blue.setBorderPainted(false);
        blue.addActionListener(buttonListener);
        setVisible(true);

        //Blank corner with score box.
        corner4.setEditable(false);
        add(corner4);  //Adds the blank button to the window.
        setVisible(true);
        corner4.setBackground(silver);
        StyledDocument rules2 = corner4.getStyledDocument();
        SimpleAttributeSet center1 = new SimpleAttributeSet();
        StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
        rules2.setParagraphAttributes(0, rules.getLength(), center1, false);
        corner4.setFont(new Font("Helvetica", Font.BOLD, 20));
        corner4.setText("\nMake one mistake and the game is over!"
                + "\nComplete 18 Rounds to win.");
        start.addActionListener(buttonListener);

    }

    public void startGame() {
        startGame = true;
    }

    public String getColor() {
        return selectedColor;
    }

    public void setQuit() {
        quit = true;
    }

    public void setNoInput(boolean b) {
        noInput = b;
    }

    public boolean getNoInput() {
        return noInput;
    }

    static public void setReadyToCompare(boolean value) {
        readyToCompare = value;

    }

    public void pressButton(String color) {
        if (color.equals("Blue")) {
            blue.setBackground(lightBlue);
            noise.playSound1();
            try {
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            blue.setBackground(darkBlue);
        } else if (color.equals("Green")) {
            green.setBackground(lightGreen);
            noise.playSound2();
            try {
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            green.setBackground(darkGreen);
        } else if (color.equals("Red")) {
            red.setBackground(lightRed);
            noise.playSound3();
            try {
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            red.setBackground(darkRed);
        } else if (color.equals("Yellow")) {
            yellow.setBackground(lightYellow);
            noise.playSound4();
            try {
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        yellow.setBackground(darkYellow);
    }

    //LookAndFeel method.
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(" ");
        } catch (Exception exc) {
            //Ignore error.
        }
    }

    //Main method.
    public static void main(String[] args) throws InterruptedException {
        GamePageVer5 sim = new GamePageVer5();
        int leaderboard = 0;

        while (!quit) {
            while (startGame == false) {
                java.lang.Thread.sleep(1000);
            }
//Creating a random array of the four colors the game will use.
//There are 18, one to add for each round played in the game
            String[] color = {"Red", "Yellow", "Green", "Blue"};
            String[] gameColors = new String[18];
            Random rand = new Random();
            for (int i = 0; i < 18; i++) {              //Simon goes up to 18 times
                int numOFWhatz = (rand.nextInt(4));
                gameColors[i] = color[numOFWhatz];
            }
//Color array close///////////////////////////////////////////////////////////

//This is where the game driver code starts.
            int sleepTime = 750;
            int turn = 0;
            boolean userCorrect = true;
            do {
                corner3.setText("ROUND: " + Integer.toString(turn + 1)); //This is temp fot testing.

                if (turn == 4 || turn == 8 || turn == 12) {     //Speed up game starting rounds 5,9,13
                    sleepTime = (sleepTime - 150);
                }
                ///////////This for loop outputs the colors to the colored buttons for the user to see the pattern play back
                sim.setNoInput(true);
                for (int i = 0; i <= turn; i++) {

                    java.lang.Thread.sleep(sleepTime);
                    //sendStringToColoredButton(gameColors[i]) //This is to send to button to perform pattern.
                    sim.pressButton(gameColors[i]);
                }
                sim.setNoInput(false);
///////This ends pattern playback/////////////////////////////////////////////
//This is to check the user input against the array that stores the patterns to follow
                int j = 0;
                while (j <= turn && userCorrect == true) {
                    while (!readyToCompare) {
                        java.lang.Thread.sleep(500);
                    }
                    setReadyToCompare(false);
                    if (!selectedColor.equals("none")) {
                        userCorrect = selectedColor.equals(gameColors[j]);
                        //This is to check user is doing the right pattern.
                        j++;
                    }
                }

                //String testHold = user_input.next();
//This ends the chekcing of the user input against the pattern array. /////////
                turn++;
            } while (turn < 18 && userCorrect);
//////////////////////////This is to notify the user whether they won or lost
            if (userCorrect) {
                //Play user win sound and pop up win window
                corner4.setText("\nMake one mistake and the game is over!"
                        + "\nComplete 18 Round to win."
                        + "\nYOU WON YOUR LAST GAME!");
                noise.playWinSound();
            } else if (!userCorrect) {
                corner4.setText("\nMake one mistake and the game is over!"
                        + "\nComplete 18 Round to win."
                        + "\nYOU LOST YOUR LAST GAME!");
                // Play user lose sound and lose pop up.
                noise.playLoseSound();
            }
            if (turn > leaderboard) {
                leaderboard = turn;
            }
            corner3.setText("Your Top Score: " + Integer.toString(leaderboard));
            startGame = false;
///////////////////////////This is the end of notification of won/lost
        }
    }
}
