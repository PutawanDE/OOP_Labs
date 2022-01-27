package com.PutawanDE.OOP_LabF02;

public class FileDownloaderThread extends FileDownloader implements Runnable {
    private final int threadNum;

    public FileDownloaderThread(String FILE_URL, String FILE_NAME, int threadNum) {
        super(FILE_URL, FILE_NAME);
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        System.out.println("FileDownloaderThread Number: " + threadNum + " start downloading from: " + super.fileUrl);
        super.startDownload();
        System.out.println("FileDownloaderThread Number: " + threadNum + " finish downloading from: " + super.fileUrl +
                " will save as: " + super.fileName);
    }
}
