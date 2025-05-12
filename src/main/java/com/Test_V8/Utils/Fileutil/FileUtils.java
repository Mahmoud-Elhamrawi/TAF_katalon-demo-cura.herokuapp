package com.Test_V8.Utils.Fileutil;

import com.Test_V8.Utils.LogUtil.LogUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {

    // get last log file
    public static File getLastLogFile(String file) {
        File dir = new File(file);
        if (!dir.exists()) {
            LogUtils.error("file not exist");
            return null;
        }
        File[] files = dir.listFiles();
        Arrays.sort(files, Comparator.comparing(File::lastModified).reversed());
        return files[0];

    }


    // delete file allure
    public static void deleteFile(File file) {
        if (!file.exists()) {
            LogUtils.error("file not exist");
        }

        File[] files = file.listFiles();
        if (files == null) {
            LogUtils.error("file not exist");
        }
        assert files != null;
        for (File f : files) {
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                try {
                    Files.delete(f.toPath());
                } catch (IOException e) {
                    LogUtils.error("file not delete", e.getMessage());
                }
            }
        }

    }


    //clean Directory
    public static void cleanDirectory(File file) {
        try {
            org.apache.commons.io.FileUtils.deleteQuietly(file);
        } catch (Exception e) {
            LogUtils.error("files not delete", e.getMessage());

        }
    }

    }
