package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Speciality;
import com.dm4nk.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialitiesMapService extends MapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {


        return super.save(object);
    }

    @Override
    public Speciality findByID(Long id) {
        return super.findByID(id);
    }
}
