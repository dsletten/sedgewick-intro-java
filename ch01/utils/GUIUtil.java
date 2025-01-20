//////////////////////////////////////////////////////////////////////////////
//
//   GUIUtil.java
//
//   Description
//
//   Started:           Tue Oct 18 12:58:02 2005
//   Modifications:
//
//   Purpose:
//
//   Calling Sequence:
//
//
//   Inputs:
//
//
//   Outputs:
//
//
//   Example:
//
//   Notes:
//
//////////////////////////////////////////////////////////////////////////////
package utils;

import java.awt.*;

public class GUIUtil {
    public static void center(Frame f) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = f.getSize();

        f.setLocation((screenSize.width - frameSize.width)   / 2,
                      (screenSize.height - frameSize.height) / 2);
    }
}
