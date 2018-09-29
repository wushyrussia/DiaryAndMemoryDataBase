package com.company.desktop_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Packard Bell on 21.09.2018.

public class MenuBar {
    MenuBar(){
        //creating menuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemNewEntry = new JMenuItem("New Entry");
        JMenuItem itemSaveEntry = new JMenuItem("Save Entry");
        JMenuItem itemExit = new  JMenuItem("Exit");

        menuBar.add(menuFile);
        menuFile.add(itemNewEntry);
        menuFile.add(itemExit);

        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  baseWindow.dispose();
            }
        });
    }
}
*/