package com.motorbikesshop.Config;

import com.cloudinary.Cloudinary;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Configuration
public class AppConfiguration {

    private final CloudinaryConfig cloudinaryConfig;

    public AppConfiguration(CloudinaryConfig cloudinaryConfig) {
        this.cloudinaryConfig = cloudinaryConfig;
    }

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

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                Map.of(
                        "cloud_name", cloudinaryConfig.getCloudName(),
                        "api_key", cloudinaryConfig.getApiKey(),
                        "api_secret", cloudinaryConfig.getApiSecret()
                )
        );
    }
}
