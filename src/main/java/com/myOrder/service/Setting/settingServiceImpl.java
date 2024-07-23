package com.myOrder.service.Setting;


import com.myOrder.repositories.category.CategoryRepository;
import com.myOrder.service.Setting.settingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

@Service
@Slf4j
public class settingServiceImpl implements settingService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private HttpServletRequest request;

}

