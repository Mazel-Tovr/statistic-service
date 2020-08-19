package com.epam.statisticservice.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LogServiceImpl implements ILogService {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Value("${file.name}")
    private String fileName;

    @Override
    public void writeToFile(@Nullable String user, Long productId) {
        try (FileWriter writer = new FileWriter(fileName,true)) {
            if (user != null) {
                writer.write(dateFormat.format(new Date()) +" User: " + user + " interested in product: " + productId +"\n");
            } else {
                writer.write(dateFormat.format(new Date()) +" User: unknown interested in product: " + productId+"\n");
            }
            logger.info("Log saved");
        } catch (IOException e) {
            logger.error(dateFormat.format(new Date()) + " Log doesn't saved: " + e.getMessage()+"\n");
        }

    }

}
