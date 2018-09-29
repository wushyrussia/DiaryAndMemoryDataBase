package com.company.desktop_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Packard Bell on 19.09.2018.

public class MainWindowGui {

   public MainWindowGui() {
        //Creating the Frame
        JFrame baseWindow = new JFrame();
    //   baseWindow.setLayout(new BorderLayout());

        baseWindow.setSize(800, 600);
        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     MenuBar menuBar = new MenuBar();
       // Text Area at the Center

       //creating panel
       JPanel leftPanel = new JPanel();
       leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.LINE_AXIS));
       leftPanel.setSize(0,600);

       //creating button to the left panel
        JButton buttonSave = new JButton("View All Entry");
        leftPanel.add(buttonSave);
        //adding components to the Frame
       baseWindow.getContentPane().add(BorderLayout.PAGE_START, menuBar);
       baseWindow.getContentPane().add(BorderLayout.WEST,leftPanel);
       baseWindow.getContentPane().add(BorderLayout.CENTER, centerPanel);
       baseWindow.setVisible(true);

    }


}
*/