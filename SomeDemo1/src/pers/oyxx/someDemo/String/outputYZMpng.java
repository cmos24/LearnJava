package pers.oyxx.someDemo.String;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class outputYZMpng {//将文字生成图片
		// 设置要输出的字符和输出图片的位置
    public static void createImage(String str, String outputFile) throws Exception {
    	File outFile = new File(outputFile);
    	Font font =new Font("微软雅黑", Font.PLAIN, 32);
    	int width=100;
    	int height=65;
    	    	
        // 创建图片    
        BufferedImage image = new BufferedImage(width, height,    
                BufferedImage.TYPE_INT_BGR);    
        Graphics g = image.getGraphics();    
        g.setClip(0, 0, width, height);    
        g.setColor(Color.white);    
        g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景    
        g.setColor(Color.black);// 在换成黑色    
        g.setFont(font);// 设置画笔字体    
        /** 用于获得垂直居中y */    
        Rectangle clip = g.getClipBounds();    
        FontMetrics fm = g.getFontMetrics(font);    
        int ascent = fm.getAscent();    
        int descent = fm.getDescent();    
        int y = (clip.height - (ascent + descent)) / 2 + ascent;    
        for (int i = 0; i < 6; i++) {// 256 340 0 680    
            g.drawString(str, i * 680, y);// 画出字符串    
        }    
        g.dispose();    
        ImageIO.write(image, "png", outFile);// 输出png图片    
    }
}
