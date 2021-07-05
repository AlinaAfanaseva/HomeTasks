import org.imgscalr.Scalr;


import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

import static java.awt.AlphaComposite.*;
import static javax.imageio.ImageIO.*;

public class ImageResizer implements Runnable {

    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try
        {
            for (File file: files){
                BufferedImage image = ImageIO.read(file);
                if (image == null){
                    continue;
                }
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage scaledImage = Scalr.resize(image, 200);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(scaledImage, "jpg", newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished: " + (System.currentTimeMillis() - start) + "ms");
    }

}
