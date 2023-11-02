package ch.zhaw.nasia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.zhaw.nasia.Bestellung.Bestellung;
import ch.zhaw.nasia.Bestellung.Status;
import ch.zhaw.nasia.Lieferant.Lieferant;
import ch.zhaw.nasia.repository.BestellungRepository;
import ch.zhaw.nasia.repository.LieferantRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service 
public class BestellungService {

    private final BestellungRepository bestellungRepository;
    private final LieferantRepository lieferantRepository;
    private static final Logger logger = LoggerFactory.getLogger(BestellungService.class);

    @Autowired
    public BestellungService(BestellungRepository bestellungRepository, LieferantRepository lieferantRepository) {
        this.bestellungRepository = bestellungRepository;
        this.lieferantRepository = lieferantRepository;
    }

    public Optional<Bestellung> UnterwegsBestellung(String bestellungId, String lieferantId) {
        logger.info("Received request for BestellungId: {}, LieferantId: {}", bestellungId, lieferantId);
        
        Optional<Bestellung> BestellungToUnterwegsOptional = bestellungRepository.findById(bestellungId);
        if (BestellungToUnterwegsOptional.isEmpty()) {
            logger.error("Bestellung not found with ID: {}", bestellungId);
            return Optional.empty();
        }

        Bestellung BestellungToUnterwegs = BestellungToUnterwegsOptional.get();

        if (BestellungToUnterwegs.getStatus() != Status.OFFEN) {
            logger.error("Bestellung with ID {} is not in OFFEN status", bestellungId);
            return Optional.empty();
        }

        Optional<Lieferant> lieferant = lieferantRepository.findById(lieferantId);
        if (lieferant.isEmpty()) {
            logger.error("Lieferant not found with ID: {}", lieferantId);
            return Optional.empty();
        }

        BestellungToUnterwegsOptional.get().setStatus(Status.UNTERWEGS);
        BestellungToUnterwegsOptional.get().setLieferantId(lieferantId);

        Bestellung unterwegsBestellung = bestellungRepository.save(BestellungToUnterwegsOptional.get());

        logger.info("Bestellung with ID {} is now UNTERWEGS with Lieferant ID {}", bestellungId, lieferantId);
        return Optional.of(unterwegsBestellung);
    }
}
