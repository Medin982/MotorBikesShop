package com.motorbikesshop.Config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        //Custom Converter: LocalDateTime -> String

        ModelMapper modelMapper = new ModelMapper();
        Converter<LocalDate, String> toLocalDate = new AbstractConverter<LocalDate, String>() {
            @Override
            protected String convert(LocalDate source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateToString = source.format(format);
                return dateToString;
            }
        };
        return modelMapper;
    }
}
