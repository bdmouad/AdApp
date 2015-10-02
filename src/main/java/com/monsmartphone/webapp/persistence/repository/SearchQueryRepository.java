package com.monsmartphone.webapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monsmartphone.webapp.persistence.entity.SearchQuery;

public interface SearchQueryRepository extends JpaRepository<SearchQuery, Long> {

	List<SearchQuery> findByQueryLike(String string);

}
