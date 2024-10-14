package com.chenbitao.www.short_link_service.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 短链接实体 */
@Entity
@Table(name = "t_url_map", indexes = { @Index(columnList = "longUrl", unique = true),
		@Index(columnList = "expireTime", unique = false) })
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlMap {
	/** 唯一ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 短链接URL */
	private String longUrl;
	/** 过期时间 */
	private Instant expireTime;
	/** 创建时间 */
	@CreationTimestamp
	private Instant creationTime;

}
