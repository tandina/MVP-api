package com.mvp.P6mvpapi.controllers;

import com.mvp.P6mvpapi.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/theme")
@RequiredArgsConstructor
public class ThemeController {
    private final ThemeRepository themeRepository;
}
