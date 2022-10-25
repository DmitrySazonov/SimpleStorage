package com.simple.storage.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilService {
    private final static String ID_CHARS = "abcdefghijklmnopqrstuvxyz0123456789";
    private final static int ID_LENGTH = 12;
    private final static int FOLDER_NAME_SIZE = 2;
    private final static int FOLDER_DEPTH = 3;

    public String getRandomId() {
        return RandomStringUtils.random(ID_LENGTH, ID_CHARS);
    }

    public String getPathFromID(String fileId) {
        return getPathFromID( fileId, FOLDER_DEPTH, FOLDER_NAME_SIZE);
    }

    public String getPathFromID(String fileId, int folderDepth, int folderNameSize){
        String savedPath = "";
        int start = 0;
        for (int i = 0; i < folderDepth; i++) {
            savedPath = savedPath + fileId.substring(start, start + folderNameSize) + "\\";
            start = start + folderNameSize;
        }
        return savedPath;
    }
}
