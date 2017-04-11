package com.together.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

/**
 * Created by BRF on 2017-04-08.
 */
public interface StorageService {
    void init();

    String store(MultipartFile file);

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
