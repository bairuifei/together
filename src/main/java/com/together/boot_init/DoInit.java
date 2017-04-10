package com.together.boot_init;

import com.together.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by BRF on 2017-04-10.
 */
@Component
@Order(value = 1)
public class DoInit implements CommandLineRunner {

    @Autowired
    private StorageService storageService;

    @Override
    public void run(String... args) throws Exception {
        storageService.init();
    }
}
