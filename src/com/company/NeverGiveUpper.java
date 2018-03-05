package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NeverGiveUpper {
    private String[] advices = {"It's a bad idea to give up!", "I think you can reach whatever you want!",
    "Nobody said it would be simple, bro!", "95% of people doing nothing to improve themselves, do not be one of them!",
    "Everything in your life depends on you!", "If you step over your fears, you'll get a result!",
    "If you don't know what to do, just start to do something!",
    "There is two ways: you'will keep on going or you'll give up as most of people do!"};

    private JTextArea adviceArea;


    private void go(){
        createGui();
        getAnAdvice();
    }


    private void createGui(){
        JFrame frame = new JFrame("NeverGiveUpper 1.0");
        JPanel mainPanel = new JPanel();
        JButton thankYouButton = new JButton("Thanks!");

        adviceArea = new JTextArea(3, 10);
        adviceArea.setBackground(Color.BLUE);
        adviceArea.setLineWrap(true);
        adviceArea.setWrapStyleWord(true);
        adviceArea.setFont(new Font(Font.SERIF, Font.BOLD, 17));

        thankYouButton.addActionListener(new ThankYouButtonListener());
        adviceArea.setEditable(false);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(adviceArea);
        mainPanel.add(thankYouButton);
        frame.getContentPane().add(mainPanel);

        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private void getAnAdvice(){
        Random random = new Random();

        String advice = advices[random.nextInt(advices.length)];
        adviceArea.append("     ");
        adviceArea.append(advice);
    }


    private class ThankYouButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new NeverGiveUpper().go();
    }
}
