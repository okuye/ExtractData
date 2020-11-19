package org.example;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

public class SevenZProgram {

    public static void main(String[] args) throws IOException {

//        File file = new File("c:\\Interview\\Equal-Experts\\Input-Data");
//
//        fetchFiles(file, f -> {
//            try {
//                SevenZ.decompress(f.getAbsolutePath(), new File("C:\\Interview\\Equal-Experts\\output-data"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });


        File file = new File(args[0]);

        fetchFiles(file, f -> {
            try {
                SevenZ.decompress(f.getAbsolutePath(), new File(args[1]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public static void fetchFiles(File dir, Consumer<File> fileConsumer) {

        if (dir.isDirectory()) {
            for (File file1 : dir.listFiles()) {
                fetchFiles(file1, fileConsumer);
            }
        } else {
            fileConsumer.accept(dir);
        }
    }
}
