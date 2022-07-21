package com.melcej.home.infratructure.database.entity;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ORDERS")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ORDER_ID")
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "DESTINATION", nullable = false)
  private String destination;

  @Column(name = "NIGHTS", nullable = false)
  private Integer nights;

  @Column(name = "DATE", nullable = false)
  private String date;

  @Column(name = "TODDLER")
  private Integer toddler;

  @Column(name = "CHILD")
  private Integer child;

  @Column(name = "TEEN")
  private Integer teen;

  @Column(name = "ADULT")
  private Integer adult;

  @Column(name = "SENIOR")
  private Integer senior;

  @Column(name = "DETAIL")
  private String detail;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "USER_ID")
  private UserEntity user;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;

  @Column(name = "SOFT_DELETE")
  private Boolean softDelete;

}
