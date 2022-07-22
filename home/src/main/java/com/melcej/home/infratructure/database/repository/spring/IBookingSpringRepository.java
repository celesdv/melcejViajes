package com.melcej.home.infratructure.database.repository.spring;

import com.melcej.home.infratructure.database.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingSpringRepository extends JpaRepository<BookingEntity, Long> {

}
