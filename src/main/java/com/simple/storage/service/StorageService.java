package com.simple.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class StorageService {

    @Value("${file.storage.path}")
    private String savePath;

    @Autowired
    private UtilService utilService;

    public String storeFile(MultipartFile multipartFile) throws IOException {

        String filename = utilService.getRandomId();
        String extension = multipartFile.getOriginalFilename().split("\\.")[1];

        byte[] bytes = multipartFile.getBytes();
        String savedPath = savePath + utilService.getPathFromID(filename);
        new File(savedPath).mkdirs();
        Path path = Paths.get(savedPath + filename + "." + extension);
        Files.write(path, bytes);
        return filename;
    }

    public File getFile(String id) {
        File directory = new File(savePath + utilService.getPathFromID(id));
        File[] files = directory.listFiles((dir, name) -> name.startsWith(id));
        return Arrays.stream(files).findFirst().orElseThrow();
    }
}

