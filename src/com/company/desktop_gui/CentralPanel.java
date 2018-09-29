//
//
//package com.company.desktop_gui;

import javax.swing.*;

/**
 * Created by Packard Bell on 21.09.2018.

public class CentralPanel {
    CentralPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));

        JTextField textField = new JTextField(10);
        centerPanel.add(textField);

        JTextArea textAreaOne = new JTextArea(50, 55);
        textAreaOne.setLineWrap(true);
        centerPanel.add(textAreaOne);
    }
}
*/