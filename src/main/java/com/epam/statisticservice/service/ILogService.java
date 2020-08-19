package com.epam.statisticservice.service;

import org.springframework.lang.Nullable;

public interface ILogService {

    void writeToFile(@Nullable String user, Long productId);
}
