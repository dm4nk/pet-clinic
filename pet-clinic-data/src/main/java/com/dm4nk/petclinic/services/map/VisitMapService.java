package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Visit;
import com.dm4nk.petclinic.services.VisitService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VisitMapService extends MapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findByID(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null ||
                visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return null;
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
