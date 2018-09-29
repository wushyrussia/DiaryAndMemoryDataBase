package com.company.desktop_gui;

import javax.swing.*;

/**
 * Created by Packard Bell on 19.09.2018.
 */
public class DesktopGui {
    JFrame baseWindow = new JFrame();

    DesktopGui(){
        baseWindow.setVisible(true);
        baseWindow.setSize(800,600);
        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
