package tech.nevets.lunarbot.gui.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KillBot implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
