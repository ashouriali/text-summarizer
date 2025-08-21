package com.example.summarizer.common.utils;

import com.example.summarizer.common.exception.GeneralException;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.http.HttpStatus;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static String getContentOfFile(String filePath) {
        try {
            URL resourceUrl = FileUtils.class.getClassLoader().getResource(filePath);
            if (resourceUrl == null)
                throw new GeneralException("File not found: " + filePath, HttpStatus.INTERNAL_SERVER_ERROR);
            return Files.readString(Paths.get(resourceUrl.toURI()));
        } catch (Exception e) {

        }

        return null;
    }
}
