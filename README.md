# springboot_redis2.0

>开发需求：
  类似热搜，将用户搜索量高的关键词，从高到底排序<br>
>

>🍎 提交时间 2020-09-01 ©陆袆 email：xiaolhe_shiro@126.com

<p>
1.根据key搜索相关最热的前十名<br>
2.使用redis的ZSet结构<br>
3.用ZSet类型通过键值获取redis列表<br>
4.reverseRange 默认是按照score成绩最高开始排序<br>
</p>


