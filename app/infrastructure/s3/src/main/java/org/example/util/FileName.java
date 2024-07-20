package org.example.util;

public final class FileName {

    private FileName() {
    }

    public static String build(String directory, String originalFileName) {
        int fileExtensionIndex = originalFileName.lastIndexOf(".");
        String fileExtension = originalFileName.substring(fileExtensionIndex);
        String fileName = originalFileName.substring(0, fileExtensionIndex);
        String now = String.valueOf(System.currentTimeMillis());

        return directory + "/" + fileName + "_" + now + fileExtension;
    }

}
