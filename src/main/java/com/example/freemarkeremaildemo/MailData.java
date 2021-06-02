package com.example.freemarkeremaildemo;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class MailData {
    String toEmail;
    String subject;
    String template;
    Map<String, Object> model;
    Map<String, String> images;
}
