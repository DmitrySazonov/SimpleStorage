package com.simple.storage.controller;

import com.simple.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/store")
    public String storeFile(@RequestParam("file") MultipartFile file) throws IOException {
        return storageService.storeFile(file);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@PathVariable String id) throws IOException {
        File result = storageService.getFile(id);
        String mimeType = URLConnection.guessContentTypeFromName(result.getName());
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .body(Files.readAllBytes(result.toPath()));

    }

    @ExceptionHandler
    public ResponseEntity<Void> notFoundExceptionHandler(NoSuchElementException ex) {
        return ResponseEntity.notFound().build();
    }
}
