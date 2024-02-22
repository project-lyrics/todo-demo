package com.projectlyrics.todo_demo.common.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {

  @Bean
  public JPAQueryFactory queryFactory(EntityManager em) {
    return new JPAQueryFactory(em);
  }
}