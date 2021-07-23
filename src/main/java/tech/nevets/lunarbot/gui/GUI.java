package tech.nevets.lunarbot.gui;

import tech.nevets.lunarbot.gui.commands.KillBot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    public GUI() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel lb1 = new JLabel("Set Bot token Here");
        JButton bt1 = new JButton("Kill Bot and close App");
        JButton bt2 = new JButton("Set Bot Token");
        JFormattedTextField field1 = new JFormattedTextField("");

        panel.setBorder(BorderFactory.createEmptyBorder(200,830,200,830));
        panel.setLayout(new GridLayout(0,1));
        panel.add(lb1);
        panel.add(field1);
        panel.add(bt2);
        panel.add(bt1);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);


        bt1.addActionListener(new KillBot());

    }


    public static void GUI(String[] args) {

        new GUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
