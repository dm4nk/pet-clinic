package com.dm4nk.petclinic.services.map;

import com.dm4nk.petclinic.model.Owner;
import com.dm4nk.petclinic.model.Pet;
import com.dm4nk.petclinic.services.OwnerService;
import com.dm4nk.petclinic.services.PetService;
import com.dm4nk.petclinic.services.PetTypeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OwnerServiceMap extends MapService<Owner, Long> implements OwnerService {

    PetTypeService petTypeService;
    PetService petService;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null)
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null)
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    else throw new RuntimeException("pet type is required");

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            return super.save(object);
        } else return null;
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    //todo: implement that
    @Override
    public Owner findByLastName() {
        return null;
    }
}
