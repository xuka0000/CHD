package Hero;

import DataMask.Img;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public class ImageDeal {


    /*
     *
     * 镜像处理，输入image和方式，返回翻转的新image
     * type = 0 表示上下翻转，type = 1 表示左右翻转
     */
    public static Image imageMisro(Image image, int type )
    {
        try
        {
            //用到了自己写的方法
            BufferedImage bufferedimage = ImageToBufferedImage(image);


            int w = bufferedimage.getWidth();
            int h = bufferedimage.getHeight();

            int[][] datas = new int[w][h];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    datas[j][i] = bufferedimage.getRGB(j, i);
                }
            }
            int[][] tmps = new int[w][h];
            if (type == 0) {
                for (int i = 0, a = h - 1; i < h; i++, a--) {
                    for (int j = 0; j < w; j++) {
                        tmps[j][a] = datas[j][i];
                    }
                }
            } else if (type == 1) {
                for (int i = 0; i < h; i++) {
                    for (int j = 0, b = w - 1; j < w; j++, b--) {
                        tmps[b][i] = datas[j][i];
                    }
                }
            }
            for (int i = 0; i < h; i++){
                for (int j = 0; j<w ;j++){
                    bufferedimage.setRGB(j, i, tmps[j][i]);
                }
            }


            Image newImage = (Image)bufferedimage;
            return newImage;
            //ImageIO.write(bufferedimage, "jpg", file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Image转换成BufferedImage
    public static BufferedImage ImageToBufferedImage( Image image )
    {
        BufferedImage bufferedimage = new BufferedImage
                (image.getWidth(null), image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedimage.createGraphics();
        g.drawImage(image, 0, 0, null); //这里，大家可能会有疑问，似乎没有对bufferedimage干啥
        g.dispose();  //但是是正确的，g调用drawImage就自动保存了
        return bufferedimage;
    }
}
