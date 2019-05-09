package com.abstractclasses.application;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.abstractclasses.filereaders.BaseFileReader;
import com.abstractclasses.filereaders.LowercaseFileReader;
import com.abstractclasses.filereaders.UppercaseFileReader;

public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Application application = new Application();
        Path path = application.getPathFromResourcesFile("files/test.txt");
        System.out.println(path.getFileName());
        BaseFileReader lowercaseFileReader = new LowercaseFileReader(path);
        lowercaseFileReader.readFile().forEach(line -> System.out.println(line));
        
        BaseFileReader uppercaseFileReader = new UppercaseFileReader(path);
        uppercaseFileReader.readFile().forEach(line -> System.out.println(line));

    }
    
    private Path getPathFromResourcesFile(String filePath) throws URISyntaxException {
        return Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
         
    }
}
