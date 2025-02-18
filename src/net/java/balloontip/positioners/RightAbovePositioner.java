/**
 * Copyright (c) 2011-2013 Bernhard Pauler, Tim Molderez.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the 3-Clause BSD License
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/BSD-3-Clause
 */

package net.java.balloontip.positioners;

import java.awt.Rectangle;

/**
 * This class positions a balloon tip above the component it's attached to, with the tip on the right
 * @author Tim Molderez
 */
public class RightAbovePositioner extends BasicBalloonTipPositioner {

    public RightAbovePositioner(int hO, int vO) {
        super(hO, vO);
    }

    protected void determineLocation(Rectangle attached) {
        // First calculate the location, without applying any correction tricks
        int balloonWidth = balloonTip.getPreferredSize().width;
        int balloonHeight = balloonTip.getPreferredSize().height;
        flipX = true;
        flipY = false;

        hOffset = balloonWidth - preferredHorizontalOffset;
        if (fixedAttachLocation) {
            x = (int) (attached.x + attached.width * attachLocationX) - hOffset;
            y = (int) (attached.y + attached.height * attachLocationY) - balloonHeight;
        } else {
            x = attached.x + attached.width - balloonWidth;
            y = attached.y - balloonHeight;
        }
        // Apply orientation correction
        if (orientationCorrection) {
            // Check collision with the top of the window
            if (y < 0) {
                flipY = true;
                if (fixedAttachLocation) {
                    y += balloonHeight;
                } else {
                    y = attached.y + attached.height;
                }
            }

            // Check collision with the right side of the window
            if (x + balloonWidth > balloonTip.getTopLevelContainer().getWidth()) {
                flipX = false;
                hOffset = balloonWidth - hOffset;
                if (fixedAttachLocation) {
                    x += balloonWidth - 2 * hOffset;
                } else {
                    x = attached.x;
                }
            }
        }

        // Apply offset correction
        if (offsetCorrection) {
            applyOffsetCorrection();
        }
    }
}
