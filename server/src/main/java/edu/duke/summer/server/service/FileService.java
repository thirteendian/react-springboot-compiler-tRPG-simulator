package edu.duke.summer.server.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void store(MultipartFile file);

}
