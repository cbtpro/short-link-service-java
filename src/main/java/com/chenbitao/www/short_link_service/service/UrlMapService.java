package com.chenbitao.www.short_link_service.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chenbitao.www.short_link_service.common.Base62Utils;
import com.chenbitao.www.short_link_service.dao.UrlMapDao;
import com.chenbitao.www.short_link_service.model.UrlMap;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UrlMapService {

	@Resource
	UrlMapDao urlMapDao;

	public String encode(String longUrl) {
		UrlMap urlMap = urlMapDao.findFirstByLongUrl(longUrl);
		if (urlMap == null) {
			urlMap = urlMapDao.save(
					UrlMap.builder().longUrl(longUrl).expireTime(Instant.now().plus(30, ChronoUnit.DAYS)).build());
			log.info("创建urlMap:{}", urlMap);
		}
		return Base62Utils.idToShortKey(urlMap.getId());
	}
	public Optional<String> decode(String shortKey) {
		long id = Base62Utils.shortKeyToId(shortKey);
		return urlMapDao.findById(id).map(UrlMap::getLongUrl);
	}
}
