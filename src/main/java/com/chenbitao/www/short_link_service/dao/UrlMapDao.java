package com.chenbitao.www.short_link_service.dao;

import java.time.Instant;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chenbitao.www.short_link_service.model.UrlMap;

public interface UrlMapDao extends CrudRepository<UrlMap, Long> {

	UrlMap findFirstByLongUrl(String url);
	List<UrlMap> findByExpireTimeBefore(Instant instant);
}
