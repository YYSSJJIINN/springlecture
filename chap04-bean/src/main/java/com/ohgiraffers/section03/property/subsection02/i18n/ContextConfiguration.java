package com.ohgiraffers.section03.property.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        /* 접속되는 세션의 로케일(locale)에 따라 자동으로 재로딩(reload)하는 용도의 MessageSource 구현체 */
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();

        /* 다국어 메시지를 읽어 올 properties 파일의 파일명을 경로로 설정한다. */
        messageSource.setBasename("section03/property/subsection02/i18n/message");

        /* 불러온 메시지를 해당 시간동안 캐싱한다. */
        messageSource.setCacheSeconds(10);

        /* 기본 인코딩 설정. */
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
