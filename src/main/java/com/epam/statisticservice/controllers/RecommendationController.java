package com.epam.statisticservice.controllers;

import com.epam.statisticservice.service.ILogService;
import com.epam.statisticservice.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController
{
    @Autowired
    private ILogService logService;

    @PostMapping("/save")
    public void getRecommendedProductsId(@Nullable @RequestParam String user, @RequestParam Long productId)
    {
        logService.writeToFile(user,productId);
    }
}
