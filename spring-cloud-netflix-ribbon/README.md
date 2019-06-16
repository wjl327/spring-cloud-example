Ribbon增强@RestTemplate的原理：
- 1.获取@LoadBalanced注解标记的RestTemplate。
- 2.RestTemplate添加一个拦截器(filter)，当使用RestTemplate发起http调用时进行拦截。
- 3.在filter拦截到该请求时，获取该次请求服务集群的全部列表信息。
- 4.根据规则从集群中选取一个服务作为此次请求访问的目标。
- 5.访问该目标，并获取返回结果。

Ribbon讲得比较清楚的文章：

http://www.spring4all.com/article/230
https://blog.csdn.net/hry2015/article/details/78357990