package ch.zhaw.nasia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.zhaw.nasia.Lieferant.Lieferant;
import ch.zhaw.nasia.Lieferant.Verfügbarkeit;
import ch.zhaw.nasia.repository.LieferantRepository;
import java.util.List;
import java.util.Optional;

@Service
public class LieferantService {

    private final LieferantRepository lieferantRepository;

    @Autowired
    public LieferantService(LieferantRepository lieferantRepository) {
        this.lieferantRepository = lieferantRepository;
    }

    public Optional<Lieferant> LieferantUnterwegs(String lieferantId) {
        Optional<Lieferant> lieferantOptional = lieferantRepository.findById(lieferantId);
        if (lieferantOptional.isPresent()) {
            Lieferant lieferant = lieferantOptional.get();
            if (lieferant.getVerfügbarkeit() == Verfügbarkeit.VERFÜGBAR) {
                lieferant.setVerfügbarkeit(Verfügbarkeit.UNTERWEGS);
                return Optional.of(lieferantRepository.save(lieferant));
            }
        }
        return Optional.empty(); // Lieferant nicht gefunden oder nicht verfügbar
    }


}
