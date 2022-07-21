package com.melcej.home.infratructure.database.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Data
@Table(name = "ORGANIZATIONS")
public class OrganizationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ORGANIZATION_ID")
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "IMAGE")
  private String image;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "PHONE_NUMBER")
  private String phone;

  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "ABOUT_US_TEXT")
  private String aboutUsText;

  @Column(name = "FACEBOOK_URL")
  private String facebookUrl;

  @Column(name = "INSTAGRAM_URL")
  private String instagramUrl;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;

  @Column(name = "SOFT_DELETE")
  private Boolean softDelete;

}
