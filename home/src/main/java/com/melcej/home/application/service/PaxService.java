package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.IPaxRepository;
import com.melcej.home.application.service.usecase.add.ICreatePaxUseCase;
import com.melcej.home.application.service.usecase.delete.IDeletePaxUseCase;
import com.melcej.home.application.service.usecase.get.IGetPaxUseCase;
import com.melcej.home.application.service.usecase.list.IListPaxUseCase;
import com.melcej.home.application.service.usecase.update.IUpdatePaxUseCase;
import com.melcej.home.domain.Booking;
import com.melcej.home.domain.Pax;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class PaxService implements ICreatePaxUseCase, IDeletePaxUseCase, IGetPaxUseCase,
    IListPaxUseCase, IUpdatePaxUseCase {

  private final IPaxRepository paxRepository;

  @Override
  public Pax add(Pax pax) {
    pax.setSoftDelete(false);
    return paxRepository.add(pax);
  }

  @Override
  public void delete(Long id) {
    if (!paxRepository.existsById(id) || paxRepository.isDeleted(id)){
      throw new RecordNotFoundException("Pax not found");
    }
    paxRepository.delete(id);
  }

  @Override
  public Pax find(@PathVariable Long id) {
    Pax pax = paxRepository.findBy(id);
    if (pax == null || Boolean.TRUE.equals(pax.getSoftDelete())){
      throw new RecordNotFoundException("Pax not found");
    }
    return pax;
  }

  @Override
  public Page<Pax> findAll(PageRequest pageRequest) {
    return paxRepository.findAll(pageRequest);
  }

  @Override
  public Pax update(Pax paxUpdate) {
    Pax paxSaved = find(paxUpdate.getId());
    paxSaved.setSoftDelete(false);
    updateValues(paxSaved, paxUpdate);
    return paxRepository.update(paxSaved);
  }

  private void updateValues(Pax paxSaved, Pax paxUpdate) {
    Booking booking = paxUpdate.getBooking();
    if (booking != null){
      paxSaved.setBooking(booking);
    }

    String firstName = paxUpdate.getFirstName();
    if (firstName != null) {
      paxSaved.setFirstName(firstName);
    }

    String lastName = paxUpdate.getLastName();
    if (lastName != null) {
      paxSaved.setLastName(lastName);
    }

    String dni = paxUpdate.getDni();
    if (dni != null) {
      paxSaved.setDni(dni);
    }

    String passport = paxUpdate.getPassport();
    if (passport != null) {
      paxSaved.setPassport(passport);
    }

    LocalDate passportExpiration = paxUpdate.getPassportExpiration();
    if (passportExpiration != null){
      paxSaved.setPassportExpiration(passportExpiration);
    }

    LocalDate birthDate = paxUpdate.getBirthDate();
    if (birthDate != null){
      paxSaved.setBirthDate(birthDate);
    }
  }
}
