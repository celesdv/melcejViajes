package com.melcej.home.infratructure.database.mapper;

import com.melcej.home.domain.Supplier;
import com.melcej.home.infratructure.database.entity.SupplierEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SupplierEntityMapper {

  public Supplier toDomain(SupplierEntity supplierEntity){
    if (supplierEntity == null){
      return null;
    }
    return Supplier.builder()
        .id(supplierEntity.getId())
        .name(supplierEntity.getName())
        .email(supplierEntity.getPhone())
        .phone(supplierEntity.getPhone())
        .cbu(supplierEntity.getCbu())
        .build();
  }

  public List<Supplier> toDomain(List<SupplierEntity> supplierEntities){
    if (supplierEntities == null || supplierEntities.isEmpty()){
      return Collections.emptyList();
    }
    List<Supplier> suppliers = new ArrayList<>(supplierEntities.size());
    for (SupplierEntity supplierEntity: supplierEntities) {
      suppliers.add(toDomain(supplierEntity));
    }
    return suppliers;
  }

  public SupplierEntity toEntity(Supplier supplier){
    if (supplier == null){
      return null;
    }
    return SupplierEntity.builder()
        .id(supplier.getId())
        .name(supplier.getName())
        .email(supplier.getPhone())
        .phone(supplier.getPhone())
        .cbu(supplier.getCbu())
        .build();
  }

}
