package com.example.demo.client.funtranslations;

import com.example.demo.client.funtranslations.bean.FuntranslationTranslateRequestBean;
import com.example.demo.client.funtranslations.bean.FuntranslationTranslateResponseBean;
import com.example.demo.enums.FuntranslationsLanguageEnum;
import com.example.demo.exception.FuntranslationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FuntranslationsInternalService {
    private final static Logger logger = LoggerFactory.getLogger(FuntranslationsInternalService.class);
    private final FuntranslationsApiClient client;

    public FuntranslationsInternalService(FuntranslationsApiClient client) {
        this.client = client;
    }

    public String getTranslation(String text, FuntranslationsLanguageEnum into) {
        FuntranslationTranslateRequestBean request = new FuntranslationTranslateRequestBean(text);
        try {
            FuntranslationTranslateResponseBean response = client.getTranslation(request, into.getLanguage());
            logger.info("successfully got a translation into {} language from funtranslations external service ", into);
            return response.getContents().getTranslated();
        } catch (FuntranslationException ex) {
            logger.error("error while translating text into {} language ", into.getLanguage(), ex);
            return null;
        }
    }
}
