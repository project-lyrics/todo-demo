package com.projectlyrics.todo_demo.domain.user.entity;

import com.projectlyrics.todo_demo.common.entity.EntityCommonField;
import com.projectlyrics.todo_demo.common.exception.BusinessException;
import com.projectlyrics.todo_demo.common.exception.ErrorCode;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;
  @Column(length = 100)
  private String emailAddress;
  @Embedded
  private EntityCommonField commonField;
  @OneToMany(mappedBy = "user")
  private List<UserPasswordEntity> passwords;

  public String getPassword() {
    return passwords.stream()
        .filter(entity -> entity.getCommonField().isInUse())
        .findFirst()
        .orElseThrow(() -> new BusinessException(ErrorCode.PASSWORD_NOT_SET, null))
        .getPassword();
  }
}
