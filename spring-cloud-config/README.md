springboot2 actuator 改动较大，整合了所有actuator的端点。

单节点刷新配置，改为：/actuator/refresh。
http://localhost:35100/actuator/refresh

集群刷新配置，改为：/actuator/bus-refresh。例如：
http://localhost:35000/actuator/bus-refresh