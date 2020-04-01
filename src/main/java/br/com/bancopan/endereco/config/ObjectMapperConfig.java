package br.com.bancopan.endereco.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class ObjectMapperConfig {

    private ObjectMapper defaultObjectMapper() {
        DateTimeFormatter formaterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formaterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(formaterDate));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(formaterDate));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formaterDateTime));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formaterDateTime));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(javaTimeModule);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean(name="objectMapper")
    public ObjectMapper objectMapper() {
        return defaultObjectMapper();
    }

}
