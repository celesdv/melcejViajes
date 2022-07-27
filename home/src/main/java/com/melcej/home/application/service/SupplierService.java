package com.melcej.home.application.service;

import com.melcej.home.application.exception.RecordNotFoundException;
import com.melcej.home.application.repository.ISupplierRepository;
import com.melcej.home.application.service.usecase.add.ICreateSupplierUseCase;
import com.melcej.home.application.service.usecase.delete.IDeleteSupplierUseCase;
import com.melcej.home.application.service.usecase.get.IGetSupplierUseCase;
import com.melcej.home.application.service.usecase.list.IListSupplierUseCase;
import com.melcej.home.application.service.usecase.update.IUpdateSupplierUseCase;
import com.melcej.home.domain.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
public class SupplierService implements ICreateSupplierUseCase, IDeleteSupplierUseCase,
    IGetSupplierUseCase, IListSupplierUseCase, IUpdateSupplierUseCase {

  private final ISupplierRepository supplierRepository;

  @Override
  public Supplier add(Supplier supplier) {
    supplier.setSoftDelete(false);
    return supplierRepository.add(supplier);
  }

  @Override
  public void delete(Long id) {
    if (!supplierRepository.existsById(id) || supplierRepository.isDeleted(id)){
      throw new RecordNotFoundException("Supplier not found");
    }
    supplierRepository.delete(id);
  }

  @Override
  public Supplier find(@PathVariable Long id) {
    Supplier supplier = supplierRepository.findBy(id);
    if (supplier == null || Boolean.TRUE.equals(supplier.getSoftDelete())) {
      throw new RecordNotFoundException("Supplier not found");
    }
    return supplier;
  }

  @Override
  public List<Supplier> findAll() {
    // TODO: 27/7/2022
    return null;
  }

  @Override
  public Supplier update(Supplier supplierUpdate) {
    Supplier supplierSaved = find(supplierUpdate.getId());
    supplierSaved.setSoftDelete(false);
    updateValues(supplierSaved, supplierUpdate);
    return supplierRepository.update(supplierSaved);
  }

  private void updateValues(Supplier supplierSaved, Supplier supplierUpdate) {
    String name = supplierUpdate.getName();
    if (name != null) {
      supplierSaved.setName(name);
    }

    String email = supplierUpdate.getEmail();
    if (email != null) {
      supplierSaved.setEmail(email);
    }

    String phone = supplierUpdate.getPhone();
    if (phone != null) {
      supplierSaved.setPhone(phone);
    }

    String cbu = supplierUpdate.getCbu();
    if (cbu != null) {
      supplierSaved.setCbu(cbu);
    }
  }
}
