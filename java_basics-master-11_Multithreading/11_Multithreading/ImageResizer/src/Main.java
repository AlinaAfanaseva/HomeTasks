
import java.io.File;

public class Main {

    private static int newWidth = 300;
    public static void main(String[] args){

        String srcFolder = "/home/afanaseva/Рабочий стол/11Module/srcFolder";
        String dstFolder = "/home/afanaseva/Рабочий стол/11Module/dstFolder";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / 2;


        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0 , files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();

        File[] files2 = new File[files.length - middle];
        System.arraycopy(files, 0, files2, 0, files2.length);
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();
    }


}
