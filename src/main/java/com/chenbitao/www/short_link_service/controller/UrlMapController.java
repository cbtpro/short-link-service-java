package com.chenbitao.www.short_link_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chenbitao.www.short_link_service.common.ResponseResult;
import com.chenbitao.www.short_link_service.common.ResultUtils;
import com.chenbitao.www.short_link_service.configs.AppConfig;
import com.chenbitao.www.short_link_service.service.UrlMapService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UrlMapController {
    @Autowired
    AppConfig appConfig;
 
    @Autowired
	private UrlMapService urlMapService;
	
    private String getDomain() {
        return appConfig.getDomain() + ":" + appConfig.getPort() + "/";
    }

	@PostMapping("/short-link")
	public ResponseResult<Map<String, String>> shortLink(@RequestParam String longUrl) {
		String code = urlMapService.encode(longUrl);
		return ResultUtils.success(Map.of("shortKey", code, "shortUrl", getDomain() + code));
	}

	@GetMapping("/{code}")
	public RedirectView redirect(@PathVariable String code) {
		return urlMapService.decode(code).map(RedirectView::new).orElse(new RedirectView("/sorry"));
	}

	@GetMapping("/sorry")
	public String sorry() {
		return "抱歉，未找到页面！";
	}
}
