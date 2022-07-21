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
import javax.persistence.OneToOne;
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
@Table(name = "TRANSFERS")
public class TransferEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRANSFERS_ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "BUDGETS_ID")
  private BudgetEntity budget;

  @Column(name = "TYPE", nullable = false)
  private String type;

  @Column(name = "CONVEYANCE")
  private String conveyance;

  @Column(name = "ORIGIN")
  private String origin;

  @Column(name = "DESTINATION")
  private String destination;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "SUPPLIER_ID")
  private SupplierEntity supplier;

  @Column(name = "VALUE", nullable = false)
  private Double value;

  @Column(name = "TAX")
  private Double tax;

  @Column(name = "DETAIL")
  private String detail;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;

  @Column(name = "SOFT_DELETE")
  private Boolean softDelete;

}
