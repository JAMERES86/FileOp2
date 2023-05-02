 

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static String intStringFixedLength(int number,int len){
        StringBuilder n= new StringBuilder();
        int iterator=0;
        while (number!=0){
            n.insert(0,number % 10);
            number/=10;
            iterator++;
        }
        if(iterator<len){
            //offSet = Begin Index of Insertion
            n.insert(0, RepeatString("0", len - iterator));
        }
        return n.toString();
    }
    public static String intStringFixedLengthSmarter(int number,int len){
        StringBuilder n= new StringBuilder();
        int iterator=0;
        while (number!=0||iterator<len){
            n.insert(0,number % 10);
            number/=10;
            iterator++;
        }
        return n.toString();
    }
    public static String RepeatString(String m,int times){
        return m.repeat(Math.max(0, times));
    }
    static {

    }
    public static void ReduceAnimatedFX(String rawName,String idName,int period){
        try {
            int index=0;
            for (int i = 1; i <= 133; i+=period) {

                File file = new File("processed" + "/reduced/textures/fxAnimated/"+idName+"/"+idName+"_"+(index++)+".png");
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();

                    ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                    InputStream stream = new FileInputStream(new File("dataBase" + "/fullFX/"+rawName+"/"+rawName+"_frame_"+intStringFixedLengthSmarter(i,3)+".png"));
                    int b;
                    for (; (b = stream.read()) != -1; stream2.write(b));
                    stream.close();
                    byte[] bytes = stream2.toByteArray();

                    FileOutputStream stream1 = new FileOutputStream(file);
                    stream1.write(bytes);
                    stream1.close();
                    stream1.flush();
                }else{
                    System.out.println("SKIP NO:"+i);
                }
            }
        } catch (Throwable err) {
            if (err instanceof RuntimeException) throw (RuntimeException)err;
            throw new RuntimeException(err);
        }
    }
    public static void ModifySuffix(String idName,int len,String from,String to,boolean keep){
        try {
            int index=0;
            for (int i = 0; i < len; i++) {
                System.out.println((1-(double)i/len)+"% left");
                File newfile = new File("processed" + "/reduced/textures/animatedFX/"+idName+"/"+idName+"_"+(i)+to+".png");
                if (!newfile.exists()) {
                    newfile.getParentFile().mkdirs();
                    newfile.createNewFile();

                    ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                    File originalFile=new File("processed" + "/reduced/textures/animatedFX/"+idName+"/"+idName+"_"+(i)+from+".png");
                    InputStream stream = new FileInputStream(originalFile);
                    int b;
                    for (; (b = stream.read()) != -1; stream2.write(b));
                    stream.close();
                    byte[] bytes = stream2.toByteArray();

                    FileOutputStream stream1 = new FileOutputStream(newfile);
                    stream1.write(bytes);
                    stream1.close();
                    stream1.flush();

                    if(!keep){
                        if(originalFile.delete()){
                            System.out.println("DELETED");
                        }else{
                            System.out.println("DELETION Failed");
                        }
                    }else{
                        System.out.println("Copy kept");
                    }
                }else{
                    System.out.println("SKIP NO:"+i);
                }
            }
        } catch (Throwable err) {
            if (err instanceof RuntimeException) throw (RuntimeException)err;
            throw new RuntimeException(err);
        }
    }


    public static void main(String[] args) {
        List<Integer> a= new ArrayList<>(3);
        a.add(0,2);
        a.add(1,3);
        a.add(2,5);
        System.out.println(a);
//        ReduceAnimatedFX("verti_lightning","LightV",7);
//        ReduceAnimatedFX("hori_lightning","LightH",7);
//        ModifySuffix("LightH",19,"_e","",true);
    }
}