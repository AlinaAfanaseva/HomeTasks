import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder builder = new StringBuilder();
        Path path = Paths.get("data/goodText.txt");


        try {
            List<String> lines = Files.readAllLines(Paths.get("data/goodText.txt"));
            lines.forEach(line -> builder.append(line + "\n"));
            System.out.println("\n Придча о собаке на гвозде:  \n" + builder.toString());

            long dirSize = Files.walk(path)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
            System.out.println("Размер папки modul9 составляет:  " + dirSize / 1024. / 1024. / 1024. + "  Gb");
            System.out.println("Место нахождения файла: " + path.normalize());

        } catch (Exception e) {
            e.printStackTrace();
        }
//=================================================================================================================//

        try {
            System.out.println("Please write something here: ");
            Scanner sc = new Scanner(System.in);
            String words = sc.nextLine();
            ArrayList<String> text = new ArrayList<>();
            text.add(words);
            Files.write(Paths.get("/home/afanaseva/Рабочий стол/modul9/task9.txt"), text);
        } catch (IllegalArgumentException il) {
            il.printStackTrace();

        }
        System.out.println("Please check your file!");
        try {
            Path fromDir = Paths.get("/home/afanaseva/Рабочий стол/modul9/task9.txt");
            Path toDir = Files.createDirectory(Paths.get("/home/afanaseva/Рабочий стол/newFolderWithTask"));
            fromDir = Files.copy(fromDir, Paths.get("/home/afanaseva/Рабочий стол/modul9/task9.txt"),REPLACE_EXISTING);
            System.out.println("Finished! " + Files.exists(Paths.get("/home/afanaseva/Рабочий стол/newFolderWithTask")) + toDir);
//            File folder = new File("/home/afanaseva/Рабочий стол/modul9/task9.txt");
//            File[] listOfFiles = folder.listFiles();
//            Path destDir = Paths.get("home/afanaseva/Рабочий стол/newFolderWithTask");
//            if (listOfFiles != null)
//                for (File file : listOfFiles)
//                    Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IllegalArgumentException io) {
            io.printStackTrace();
        }
    }


//    private static void copyDir() throws IOException {
//        try {
//            Path fromDir = Paths.get("/home/afanaseva/Рабочий стол/modul9/task9.txt");
//            Path toDir = Paths.get(URI.create("home/afanaseva/Рабочий стол/newFolderWithTask"));
//            fromDir.toUri();
//            System.out.println("Finished! " + fromDir.toUri() + "Copy is here: " + toDir.toRealPath());
////            File folder = new File("/home/afanaseva/Рабочий стол/modul9/task9.txt");
////            File[] listOfFiles = folder.listFiles();
////            Path destDir = Paths.get("home/afanaseva/Рабочий стол/newFolderWithTask");
////            if (listOfFiles != null)
////                for (File file : listOfFiles)
////                    Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
//        } catch (FileNotFoundException io) {
//            io.printStackTrace();
//
//
//        }
//    }


}




