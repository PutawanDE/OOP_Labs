package com.PutawanDE.OOP_LabF02;

import java.io.IOException;

public class LabF02 {
    private static String[] downloadFileUrls = new String[]{
            "https://images-assets.nasa.gov/video/" +
                    "ISS%204K%20Crew%20Earth%20Observations/ISS%204K%20Crew%20Earth%20Observations~small.mp4",
            "https://images-assets.nasa.gov/image/hubble-captures-vivid-auroras-in-jupiters-atmosphere_28000029525_o/" +
                    "hubble-captures-vivid-auroras-in-jupiters-atmosphere_28000029525_o~medium.jpg"
    };

    private static String[] downloadFileNames = new String[]{
            "src/com/PutawanDE/OOP_LabF02/earth1.mp4",
            "src/com/PutawanDE/OOP_LabF02/jupiter.jpg"
    };

    private static String toZipFileName = "src/com/PutawanDE/OOP_LabF02/LabF02.java";
    private static String toPingHost = "192.168.0.0";
    private static int toPingHostPort = 80;
    private static int timeout = 30000;

    public static void main(String[] args) {
        System.out.println("Sequential--------------------------------------");
        testSequential();
        System.out.println();
        System.out.println("Concurrent--------------------------------------");
        testConcurrent();
    }

    private static void testSequential() {
        PingHost pingHost = new PingHost(toPingHost, toPingHostPort, timeout);
        FileDownloader fileDownloader1 = new FileDownloader(downloadFileUrls[0], downloadFileNames[0]);
        FileDownloader fileDownloader2 = new FileDownloader(downloadFileUrls[1], downloadFileNames[1]);
        FileZipper fileZipper = new FileZipper(toZipFileName);

        System.out.println("Seq: start ping: " + toPingHost + " " + toPingHostPort);
        if (pingHost.startPing()) {
            System.out.println("Seq: " + toPingHost + " " + toPingHostPort + " is available.");
        } else {
            System.out.println("Seq: " + toPingHost + " " + toPingHostPort + " is not reachable.");
        }

        System.out.println("Seq: start downloading from: " + fileDownloader1.fileUrl);
        fileDownloader1.startDownload();
        System.out.println("Seq: finish downloading from: " + fileDownloader1.fileUrl +
                " will save as: " + fileDownloader1.fileName);

        System.out.println("Seq: start downloading from: " + fileDownloader2.fileUrl);
        fileDownloader2.startDownload();
        System.out.println("Seq: finish downloading from: " + fileDownloader2.fileUrl +
                " will save as: " + fileDownloader2.fileName);

        System.out.println("Seq: start zipping file: " + fileZipper.sourceFileName);
        fileZipper.zipFile();
        System.out.println("Seq: finish zipping file: " + fileZipper.sourceFileName);
    }

    private static void testConcurrent() {
        Thread pingHostThread = new Thread(new PingHostThread(toPingHost, toPingHostPort, timeout, 1));
        Thread fileDownloaderThread1 = new Thread(
                new FileDownloaderThread(downloadFileUrls[0], downloadFileNames[0], 1));
        Thread fileDownloaderThread2 = new Thread(
                new FileDownloaderThread(downloadFileUrls[1], downloadFileNames[1], 2));
        Thread fileZipperThread = new Thread(new FileZipperThread(toZipFileName, 1));

        pingHostThread.start();
        fileDownloaderThread1.start();
        fileDownloaderThread2.start();
        fileZipperThread.start();
    }
}
