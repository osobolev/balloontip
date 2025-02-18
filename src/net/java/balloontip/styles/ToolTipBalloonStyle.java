/**
 * Copyright (c) 2011-2013 Bernhard Pauler, Tim Molderez.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the 3-Clause BSD License
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/BSD-3-Clause
 */

package net.java.balloontip.styles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 * A balloon tip style that looks like a tool tip (i.e. just a plain old rectangle) 
 * @author Bernhard Pauler
 * @author Tim Molderez
 */
public class ToolTipBalloonStyle extends BalloonTipStyle {

    private final Color borderColor;
    private final Color fillColor;

    /**
     * Constructor
     * @param borderColor    border line color
     * @param fillColor        fill color
     */
    public ToolTipBalloonStyle(Color fillColor, Color borderColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public Insets getBorderInsets(Component c) {
        if (flipY) {
            return new Insets(verticalOffset + 1, 1, 1, 1);
        }
        return new Insets(1, 1, verticalOffset + 1, 1);
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        width -= 1;
        height -= 1;

        int yTop;        // Y-coordinate of the top side of the balloon
        int yBottom;    // Y-coordinate of the bottom side of the balloon
        if (flipY) {
            yTop = y + verticalOffset;
            yBottom = y + height;
        } else {
            yTop = y;
            yBottom = y + height - verticalOffset;
        }

        // Draw the outline of the balloon
        g2d.setPaint(fillColor);
        g2d.fillRect(x, yTop, width, yBottom);
        g2d.setPaint(borderColor);
        g2d.drawRect(x, yTop, width, yBottom);
    }
}
