package com.lekmiti.customannotations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {

    private static String OUTPUT_PATH = "./src/main/outputs/JsonFile.json";

    public void writeInFile(String json) throws IOException {

        File file = new File(OUTPUT_PATH);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();

    }
}
