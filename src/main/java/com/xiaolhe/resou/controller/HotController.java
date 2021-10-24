package com.xiaolhe.resou.controller;

import com.xiaolhe.resou.common.ResponseResult;
import com.xiaolhe.resou.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: 小小沠
 * @email: amixiao@qq.com
 * @createTime: 2020-09-01  16:13
 */
@RestController
@RequestMapping("/hots")
public class HotController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HotService hotService;

    /**
     *  redis记录keyword
     *
     * 注解的意思
     *   RequestParam：将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
     *   语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)
     *      value：参数名
     *      required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
     *      defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
     * @param keyword
     * @return
     */
    @GetMapping("/add")
    public ResponseResult search(@RequestParam("keyword") String keyword){
        hotService.addHotWord(keyword);
        return new ResponseResult("操做已完成！👊👊👊");
    }


    /**
     * 根据key，redis使用zset查询所有的热词
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getKey(){
        List<Map<Object, Object>> list = hotService.getAllValue();
        return new ResponseResult(list);
    }


}
