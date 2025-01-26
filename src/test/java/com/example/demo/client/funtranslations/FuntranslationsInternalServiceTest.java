package com.example.demo.client.funtranslations;

import com.example.demo.client.funtranslations.bean.FuntranslationTranslateContents;
import com.example.demo.client.funtranslations.bean.FuntranslationTranslateRequestBean;
import com.example.demo.client.funtranslations.bean.FuntranslationTranslateResponseBean;
import com.example.demo.enums.FuntranslationsLanguageEnum;
import com.example.demo.exception.FuntranslationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FuntranslationsInternalServiceTest {
    @Mock
    private FuntranslationsApiClient client;
    @InjectMocks
    private FuntranslationsInternalService sut;

    @Test
    void should_getTranslation() {
        //given
        String text = "description";
        FuntranslationTranslateRequestBean requestBean = new FuntranslationTranslateRequestBean(text);

        FuntranslationTranslateResponseBean responseBean = new FuntranslationTranslateResponseBean(new FuntranslationTranslateContents("translatedText"));
        when(client.getTranslation(refEq(requestBean), any())).thenReturn(responseBean);

        //when
        String translatedText = sut.getTranslation(text, FuntranslationsLanguageEnum.YODA);

        //then
        assertEquals(translatedText, responseBean.getContents().getTranslated());
    }

    @Test
    void should_returnNull_when_notAbleToTranslate() {
        // given
        String text = "description";

        when(client.getTranslation(any(), any())).thenThrow(FuntranslationException.class);
        //when
        String result = sut.getTranslation(text, FuntranslationsLanguageEnum.YODA);

        //then
        assertNull(result);
    }
}