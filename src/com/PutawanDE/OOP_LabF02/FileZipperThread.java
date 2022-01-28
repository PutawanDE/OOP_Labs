package com.PutawanDE.OOP_LabF02;

import java.io.IOException;

public class FileZipperThread extends FileZipper implements Runnable {
    private final int threadNum;

    public FileZipperThread(String sourceFileName, int threadNum) {
        super(sourceFileName);
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        System.out.println("FileZipperThread Number: " + threadNum + " start zipping file: " + sourceFileName);
        zipFile();
        System.out.println("FileZipperThread Number: " + threadNum + " finish zipping file: " + sourceFileName);
    }
}
