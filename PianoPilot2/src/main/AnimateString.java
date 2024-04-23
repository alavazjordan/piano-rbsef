package src.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AnimateString extends JPanel {
    int x, y;

    public AnimateString() {

    }

    public void draw(Graphics2D g2, String str, int x, int y, int charWidth, int charHeight) throws IOException {
        this.x = x;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                x += charWidth;
            } else {
                String imagePath = "/res/Font/" + ch + ".PNG";
                InputStream inputStream = getClass().getResourceAsStream(imagePath);
                if (inputStream != null) {
                    try {
                        BufferedImage image = ImageIO.read(inputStream);
                        if (image != null) {
                            g2.drawImage(image, x, y, charWidth, charHeight, null);
                            x += charWidth;
                        } else {
                            // Handle null image
                            System.err.println("Image is null: " + imagePath);
                        }
                    } finally {
                        inputStream.close(); // Close the input stream
                    }
                } else {
                    // Handle missing input stream
                    System.err.println("Input stream is null: " + imagePath);
                }
            }
        }
    }
}
