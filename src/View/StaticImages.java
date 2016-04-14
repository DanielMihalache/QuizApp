package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class StaticImages {
    private static ArrayList<BufferedImage> bufferedImages;
    public static BufferedImage IMAGE_CHOSEN;
    public StaticImages(){
        try {
            bufferedImages = new ArrayList<>();
            bufferedImages.add(javax.imageio.ImageIO.read(new File("./Images/RandomBackground/img1.jpg")));
            bufferedImages.add(javax.imageio.ImageIO.read(new File("./Images/RandomBackground/img2.jpg")));
            bufferedImages.add(javax.imageio.ImageIO.read(new File("./Images/RandomBackground/img3.jpg")));
            bufferedImages.add(javax.imageio.ImageIO.read(new File("./Images/RandomBackground/img4.jpg")));
            bufferedImages.add(javax.imageio.ImageIO.read(new File("./Images/RandomBackground/img5.jpg")));
            bufferedImages.add(javax.imageio.ImageIO.read(new File("./Images/RandomBackground/img6.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static BufferedImage randomImg(){
        return bufferedImages.get((int)Math.round(Math.random() * 4.99 ));
    }
}
