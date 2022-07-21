package com.melcej.home.infratructure.database.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "PAX")
public class PaxEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PAX_ID")
  private Long id;

  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false)
  private String lastName;

  @Column(name = "dni", nullable = false, unique = true)
  private String dni;

  @Column(name = "PASSPORT")
  private String passport;

  @Column(name = "PASSPORT_EXPIRATION")
  private LocalDate passportExpiration;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;

  @Column(name = "SOFT_DELETE")
  private Boolean softDelete;
}
