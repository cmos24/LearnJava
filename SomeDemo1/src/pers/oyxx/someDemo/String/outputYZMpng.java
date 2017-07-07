package pers.oyxx.someDemo.String;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class outputYZMpng {//����������ͼƬ
		// ����Ҫ������ַ������ͼƬ��λ��
    public static void createImage(String str, String outputFile) throws Exception {
    	File outFile = new File(outputFile);
    	Font font =new Font("΢���ź�", Font.PLAIN, 32);
    	int width=100;
    	int height=65;
    	    	
        // ����ͼƬ    
        BufferedImage image = new BufferedImage(width, height,    
                BufferedImage.TYPE_INT_BGR);    
        Graphics g = image.getGraphics();    
        g.setClip(0, 0, width, height);    
        g.setColor(Color.white);    
        g.fillRect(0, 0, width, height);// ���ú�ɫ�������ͼƬ,Ҳ���Ǳ���    
        g.setColor(Color.black);// �ڻ��ɺ�ɫ    
        g.setFont(font);// ���û�������    
        /** ���ڻ�ô�ֱ����y */    
        Rectangle clip = g.getClipBounds();    
        FontMetrics fm = g.getFontMetrics(font);    
        int ascent = fm.getAscent();    
        int descent = fm.getDescent();    
        int y = (clip.height - (ascent + descent)) / 2 + ascent;    
        for (int i = 0; i < 6; i++) {// 256 340 0 680    
            g.drawString(str, i * 680, y);// �����ַ���    
        }    
        g.dispose();    
        ImageIO.write(image, "png", outFile);// ���pngͼƬ    
    }
}
