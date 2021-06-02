package com.example.freemarkeremaildemo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        publisher.publishEvent(new ReservationCreatedEvent(reservation));
    }
}
