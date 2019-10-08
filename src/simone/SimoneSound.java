/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simone;

import java.io.*;
import javax.sound.sampled.*;

public class SimoneSound {

    private Clip clip1 = null;
    private Clip clip2 = null;
    private Clip clip3 = null;
    private Clip clip4 = null;
    private Clip clip5 = null;
    private Clip clip6 = null;
    //initialize clip objects

    public SimoneSound() {
    }

    public void playWinSound() {
        try {
            AudioInputStream winSound = AudioSystem.getAudioInputStream(getClass().getResource("applause.wav"));
            clip1 = AudioSystem.getClip();
            clip1.open(winSound);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        } catch (UnsupportedAudioFileException g) {
            g.printStackTrace();
        }
        clip1.start();
    }//import and play win sound

    public void playLoseSound() {
        try {
            AudioInputStream loseSound = AudioSystem.getAudioInputStream(getClass().getResource("aww.wav"));
            clip2 = AudioSystem.getClip();
            clip2.open(loseSound);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        } catch (UnsupportedAudioFileException g) {
            g.printStackTrace();
        }
        clip2.start();
    }//import and play lose sound

    public void playSound1() {
        try {
            AudioInputStream sound1 = AudioSystem.getAudioInputStream(getClass().getResource("c_sharp.wav"));
            clip3 = AudioSystem.getClip();
            clip3.open(sound1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        } catch (UnsupportedAudioFileException g) {
            g.printStackTrace();
        }
        clip3.start();
    }//import and play sound1

    public void playSound2() {
        try {
            AudioInputStream sound2 = AudioSystem.getAudioInputStream(getClass().getResource("d_sharp.wav"));
            clip4 = AudioSystem.getClip();
            clip4.open(sound2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        } catch (UnsupportedAudioFileException g) {
            g.printStackTrace();
        }
        clip4.start();
    }//import and play sound2

    public void playSound3() {
        try {
            AudioInputStream sound3 = AudioSystem.getAudioInputStream(getClass().getResource("f_sharp.wav"));
            clip5 = AudioSystem.getClip();
            clip5.open(sound3);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        } catch (UnsupportedAudioFileException g) {
            g.printStackTrace();
        }
        clip5.start();
    }//import and play sound3

    public void playSound4() {
        try {
            AudioInputStream sound4 = AudioSystem.getAudioInputStream(getClass().getResource("g_sharp.wav"));
            clip6 = AudioSystem.getClip();
            clip6.open(sound4);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        } catch (UnsupportedAudioFileException g) {
            g.printStackTrace();
        }
        clip6.start();
    }//import and play sound4
}
