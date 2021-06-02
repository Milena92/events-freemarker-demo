package com.example.freemarkeremaildemo;

import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ReservationCreatedListener {

    private final EmailService emailService;

    @EventListener
    @Async
    public void onReservationCreated(ReservationCreatedEvent event) throws TemplateException, IOException {
        final var reservation = (Reservation) event.getSource();

        Map<String, Object> model = new HashMap<>();
        model.put("reservation", reservation);
        Map<String, String> images = new HashMap<>();
        images.put("menu1.png", "/static/images/menu1.png");
        images.put("menu2.png", "/static/images/menu2.png");
        images.put("people.jpg", "/static/images/people.jpg");

        var mailData = new MailData.MailDataBuilder()
                .subject("Reservation confirmation")
                .toEmail(reservation.getEmail())
                .model(model)
                .template("reservation-confirmation")
                .images(images)
                .build();

        emailService.sendEmail(mailData);
    }
}
