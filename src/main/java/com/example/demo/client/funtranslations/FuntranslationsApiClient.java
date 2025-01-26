package com.example.demo.client.funtranslations;

import com.example.demo.client.funtranslations.bean.FuntranslationTranslateRequestBean;
import com.example.demo.client.funtranslations.bean.FuntranslationTranslateResponseBean;
import com.example.demo.exception.FuntranslationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FuntranslationsApiClient {

    private final WebClient webClient;

    public FuntranslationsApiClient() {
        this.webClient = WebClient.create("https://api.funtranslations.com/translate/");
    }

    public FuntranslationTranslateResponseBean getTranslation(FuntranslationTranslateRequestBean translateRequestBean, String language) {
        return webClient.post()
                .uri(language + ".json")
                .bodyValue(translateRequestBean)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        clientResponse -> Mono.error(new FuntranslationException())
                )
                .bodyToMono(FuntranslationTranslateResponseBean.class)
                .block()
                ;
    }
}
