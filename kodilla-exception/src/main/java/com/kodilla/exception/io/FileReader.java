package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        Path path = Paths.get(file.getPath());

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(System.out::println);

        } catch (IOException e) {
            throw new FileReaderException();
 //           System.out.println("Something went Wrong, error:" + e);

        } finally {
            System.out.println("\nIm going to be here always");
        }



//        try {
//            Stream<String> fileLines = Files.lines(path);
//            fileLines.forEach(System.out::println);
//
//        } catch (IOException e) {
//            System.out.println("Something went WRONG, error:" +e);
//        }
//
//
//        System.out.println(file.getPath());

    }
}