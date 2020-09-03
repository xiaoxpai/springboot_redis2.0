# springboot_redis2.0

1.开发需求：
  类似热搜，将用户搜索量高的关键词，从高到底排序
2.根据key搜索相关最热的前十名
3.使用redis的ZSet结构
4.用ZSet类型通过键值获取redis列表
5.reverseRange 默认是按照score成绩最高开始排序
