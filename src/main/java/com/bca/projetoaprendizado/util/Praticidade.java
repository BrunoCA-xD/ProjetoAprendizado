/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.util;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class Praticidade {

    public boolean fieldsFilled(Container container) {
        Component[] components = container.getComponents();

        for (Component c : components) {
            if (c instanceof JTextField) {
                if (((JTextField) c).getText().trim().equals("")) {
                    c.requestFocus();
                    return false;
                }
            }
        }
        return true;
    }

    public void clearFields(Container container) {
        Component[] components = container.getComponents();

        for (Component c : components) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");

            }
        }
    }
}
