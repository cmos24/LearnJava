package pers.oyxx.someDemo.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
���������ĿĿ¼�� e:/project���������Ŀ¼�����е�java�ļ����������ļ��У����ҳ��ļ����ݰ��� Magic����Щ�ļ�������ӡ������
public static void search(File folder, String search);
*/
//�����ļ�����
public class Search {

	/**
     * @param file ���ҵ�Ŀ¼
     * @param search ���ҵ��ַ���
     */
    public static void search(File file, String search) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                String fileContent = readFileConent(file);
                if(fileContent.contains(search)){//����ļ������а���search�����ݣ�String.contains(String str)���ж��ַ���String���Ƿ����str����ַ���
                    System.out.printf("�ҵ���Ŀ���ַ���%s,���ļ�:%s%n",search,file);
                }
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }
     
    public static String readFileConent(File file){
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
 
    }
 
    public static void main(String[] args) {
        File folder =new File("h:/TestFolder1");
        search(folder,"out");
    }

}
