package com.projectlyrics.todo_demo.domain.user.entity;

import com.projectlyrics.todo_demo.common.entity.EntityCommonField;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserPasswordEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;
  @Column(length = 255, nullable = false)
  private String password;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
  @Embedded
  private EntityCommonField commonField;
}
