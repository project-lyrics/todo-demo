package com.projectlyrics.todo_demo.common.entity;

import com.projectlyrics.todo_demo.common.entity.enumerate.EntityStatusEnum;
import com.projectlyrics.todo_demo.common.exception.BusinessException;
import com.projectlyrics.todo_demo.common.exception.ErrorCode;
import com.projectlyrics.todo_demo.domain.user.entity.UserEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.Clock;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class EntityCommonField {

  @Enumerated(EnumType.STRING)
  private EntityStatusEnum status;
  @CreatedDate
  private LocalDateTime createdAt;
  @ManyToOne
  @JoinColumn(name = "created_by", nullable = false)
  @CreatedDate
  private UserEntity createdBy;
  @LastModifiedDate
  private LocalDateTime updatedAt;
  @ManyToOne
  @JoinColumn(name = "updated_by", nullable = false)
  @LastModifiedBy
  private UserEntity updatedBy;
  private LocalDateTime deletedAt;
  @ManyToOne
  @JoinColumn(name = "deleted_by", nullable = false)
  private UserEntity deletedBy;

  public boolean isInUse() {
    return EntityStatusEnum.IN_USE.equals(this.status);
  }

  public void delete(UserEntity deletedBy, Clock clock) {
    if (EntityStatusEnum.DELETE.equals(status)) {
      throw new BusinessException(ErrorCode.BAD_REQUEST, null);
    }
    this.deletedBy = deletedBy;
    this.deletedAt = LocalDateTime.now(clock);
    this.status = EntityStatusEnum.DELETE;
  }
}
