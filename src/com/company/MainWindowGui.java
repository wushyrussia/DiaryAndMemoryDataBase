package com.company;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Packard Bell on 19.09.2018.
 */
public class MainWindowGui {

   MainWindowGui() {
        //Creating the Frame
        JFrame baseWindow = new JFrame();

        baseWindow.setSize(800, 600);
        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating menuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemNewEntry = new JMenuItem("New Entry");
        JMenuItem itemSaveEntry = new JMenuItem("Save Entry");
        JMenuItem itemExit = new  JMenuItem("Exit");

        menuBar.add(menuFile);
        menuFile.add(itemNewEntry);
        menuFile.add(itemExit);
       // Text Area at the Center
       JTextArea ta = new JTextArea();
       //creating panel
       JPanel leftPanel = new JPanel();
       leftPanel.setSize(0,600);

       //creating button to the left panel
        JButton buttonSave = new JButton("View All Entry");
        leftPanel.add(buttonSave);
        //adding components to the Frame
       baseWindow.getContentPane().add(BorderLayout.PAGE_START,menuBar);
       baseWindow.getContentPane().add(BorderLayout.WEST,leftPanel);
       baseWindow.getContentPane().add(BorderLayout.CENTER, ta);
       baseWindow.setVisible(true);

    }


}
