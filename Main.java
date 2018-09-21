import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args){
        //***** Var's to edit depending on window size of game *****//
        // (assuming top left is 0,0)
        int xMin = 2;       //furthest left pixel
        int xMax = 318;     //furthest right pixel
        int yMin = 48;      //furthest top pixel
        int yMax = 283;     //furthest bottom pixel
        //***********************************************************//



        int clicks = 0;
        //int sweeps = 0;   //Testing purposes

        Color rgb;
        GraphicsDevice myDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Robot robo = null;

        try {
            robo = new Robot(myDevice);
        } catch (AWTException e) {
            System.out.println("e exception!");
        }

        boolean foundKey;

        while(clicks < 140) {
            foundKey = false;

            for (int x = xMin + 2; x < xMax; x+= (xMax-xMin)/32) {         //32
                for (int y = yMin + 2; y < yMax; y+= (yMax-yMin)/25) {     //25
                    rgb = robo.getPixelColor(x, y);

                    //Previous settings:
                    /*rgb.getRed() > 180 && rgb.getRed() < 200 && rgb.getGreen() > 190 && rgb.getGreen() < 205 && rgb.getBlue() > 195 && rgb.getBlue() <210*/

                    if (rgb.getRed() < 20 && rgb.getGreen() < 20 && rgb.getBlue() < 20) {

                        robo.mouseMove(x, y);
                        robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                        foundKey = true;
                        break;
                        //System.out.println("Found color!");   //Testing purposes
                    }
                }
                if(foundKey){
                    break;
                }
            }

            clicks++;
        }
    }
}
