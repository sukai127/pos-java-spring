package com.thoughtworks.iamcoach.pos.utils;

import java.io.*;
import java.util.*;

public class FileUtils {

    public static List<String> get (String filename) throws IOException {

        List<String> barcodeList = new ArrayList<String>();
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String barcode;

        while ((barcode = reader.readLine()) != null){
            barcodeList.add(barcode);
        }

        reader.close();
        return barcodeList;
    }
}
