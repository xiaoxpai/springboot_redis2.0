package com.xiaolhe.resou.service;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: 陆袆 >_<
 * @email: amixiao@qq.com
 * @createTime: 2020-09-01  16:13
 */
@Service
public interface HotService {

    void addHotWord(String keyword);

    List<Map<Object, Object>> getAllValue();

}
