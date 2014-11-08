package com.thoughtworks.iamcoach.pos.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {

    public static List<String> get (String filename) throws IOException {

        Path path = Paths.get("src/main/resources",filename);

        return Files.readAllLines(path);
    }
}
