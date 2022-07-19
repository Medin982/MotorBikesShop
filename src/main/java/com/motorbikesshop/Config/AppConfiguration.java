package com.motorbikesshop.Config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        //Custom Converter: String -> LocalDate

        ModelMapper modelMapper = new ModelMapper();
        Converter<String, LocalDate> toLocalDate = new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(source ,format);
                return date;
            }
        };
        return modelMapper;
    }
}
