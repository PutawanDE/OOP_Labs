package com.PutawanDE.OOP_LabF02;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipper {
    protected final String sourceFileName;
    private final String outFileName = "src/com/PutawanDE/OOP_LabF02/compressed.zip";

    public FileZipper(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public void zipFile() {
        File fileToZip = new File(sourceFileName);
        try (FileInputStream fileInputStream = new FileInputStream(fileToZip);
             FileOutputStream fileOutputStream = new FileOutputStream(outFileName);
             ZipOutputStream zipOut = new ZipOutputStream(fileOutputStream)) {

            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fileInputStream.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
