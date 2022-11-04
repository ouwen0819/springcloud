# springcloud

微服务框架 mzq第一个微服务自学框架

@resource和@autowired的区别 @restcontroller和@controller的区别 @requestbody和@requestparam @requestmapping和@postmapping

权限管理 spring security shiro OAuth2

1.eureka服务注册中心集群 互相注册 2.修改host文件 3.eureka自我保护模式 4.zookeeper没看 5.consul agent -dev

eureka java AP  
consul go CP zookeeper java CP

C：consistency 强一致性  
A：availability 可用性 P：partition tolerance 分区容错性 CAP理论关注粒度是数据，不是整体系统设计策略

ribbon 负载均衡 ribbon客户端 进程内lb vs nginx服务端 集中式lb

ribbon负载规则

rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标

总服务器：2 list=0 1%2=1 index=1 list.get(index)

openfegin默认等待1s，超时会报错

openfegin远程调用其他微服务  用@RequestMapping()注解

openfegin自带ribbon

hystrix 服务降级：fallback：默认返回一个结果，类似于挡板（程序异长，网络超时，服务熔断触发服务降级，线程池打满导致服务降级） 服务熔断：break：达到最大服务访问量后，直接拒绝访问，拉闸，调用服务降级返回友好提示
服务限流：flowlimit：秒杀高并发操作，禁止同时发出过多请求，排队，一秒N个，有序进行

jmeter高并发压力测试

hystrix图形监控测试平台 微服务流量和压力 ----》 服务熔断 限流 降级

gateway网关：路由 断言 过滤

curl http://localhost:9527/payment/lb --cookie "username=mzq"

springcloud config配置中心

label：分支（branch） application：服务名 profile：环境（dev/test/prod）

读取规则 /{label}/{application}-{profile}.yml /{application}-{profile}.yml /{application}-{profile}.yml/{label}

application.yml 用户级资源配置 bootstrap.yml 系统级 优先级更高

动态刷新配置文件 运维人员手动发送post请求 curl -X POST http://localhost:3355/actuator/refresh

springcloud bus 支持两种消息代理：rabbitMQ 和kafka

rabbitmq环境配置 安装erlang   http://erlang.org/download/
安装rabbitmq   https://www.rabbitmq.com/news.html

命令：rabbitmq-plugins enable rabbitmq_management
http://localhost:15672/
账号：guest 密码：guest

监听的topic默认名称是springCloudBus

curl -X POST http://localhost:3355/actuator/refresh/{destination}

cloud stream消息驱动： 屏蔽底层mq（activemq，rabbitmq,rocketmq,kafka）消息中间件的细节差异，降低切换成本，统一消息的编程模型

通过定义绑定器binder作为中间层，实现应用程序和消息中间件细节之间的隔离

spring cloud stream 1.重复消费问题：分组和持久化属性group 不同组是可以全面消费的（重复消费） 同一组存在竞争关系，之后一个可以消费

studyExchange.anonymous.2R0HoDxBRJCd6Gbu-oRijg 组流水号不同  
自定义分组 分为同一个组解决重复消费问题

2.消息持久化问题 group属性

spring cloud sleuth:分布式请求链路跟踪

zipkin：  https://repo1.maven.org/maven2/io/zipkin/zipkin-server/

http://localhost:9411/zipkin/

spring cloud alibaba

服务注册和配置中心nacos： 下载：https://nacos.io/zh-cn/
http://localhost:8848/nacos
账号：nacos 密码：nacos

@EnableDiscoveryClient 这个注解要放在上面 @SpringBootApplication

nacos支持AP和CP的切换

dataId完整格式 ${prefix} 默认是spring.application.name，也可以配置spring.cloud.nacos.config.prefix来配置 ${spring.profiles.active}
当前环境对应的profile （dev，prod等） ${file-extension}:目前支持properties和yaml

${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
nacos-config-client-prod.properties

nacos分类配置 nacos默认命名空间是public，namespace用来实现隔离的 开发 测试 生产 三个命名空间

group：可以把不同的微服务划分到同一个组里

service：一个service可以包含多个Cluster（集群）

instance：微服务的实例

nacos集群和持久化配置 默认自带的是嵌入式数据库derby 采用集中式存储的方式支持集群化部署，目前只支持mysql

nacos client -》 nginx -》nacos server（多台，集群）-》mysql数据库存储配置

sentinel:服务熔断,降级,限流，监控平台
http://localhost:8080
账号：sentinel 密码：sentinel

懒加载，需要访问一次微服务才能监控到

QPS:(每秒请求数量)：当调用该api的QPS达到阈值时，进行限流 线程数：当调用该api的线程数达到阈值时，进行限流

RT:平均响应时间 秒级 超出阈值且时间窗口内通过的请求大于等于5，两个条件同时满足触发降级

异常比例：秒级 qps大于等于5且异常比例超过阈值时，触发降级；时间窗口结束后，关闭降级

异常数：分钟级 异常数超过阈值时，触发降级，时间窗口结束后，关闭降级

sentinel断路器没有半开状态 @sentinelResource：某个具体方法出错，找对应降级方法

sentinel持久化： sentinel 配置写进nacos里
"resource":"/rateLimit/byUrl", 资源名称
"limitApp":"default", 来源应用
"grade":1, 阈值类型 0表示线程数，1表示QPS
"count":1, 单机阈值
"strategy":0, 流控模式 0表示直接，1表示关联，2表示链路
"controlBehavior":0, 流控效果 0表示快速失败，1表示warm up，2表示排队等待
"clusterMode":false 是否集群

seata 分布式事务   一ID+三组件模型
ID：全局唯一事务ID

TC (Transaction Coordinator) - 事务协调者
维护全局和分支事务的状态，驱动全局事务提交或回滚。

TM (Transaction Manager) - 事务管理器
定义全局事务的范围：开始全局事务、提交或回滚全局事务。

RM (Resource Manager) - 资源管理器
管理分支事务处理的资源，与TC交谈以注册分支事务和报告分支事务的状态，并驱动分支事务提交或回滚。

seata服务端是TC
@GlobalTransactional 是TM
近似理解多个数据库是RM

分组：异地机房停电容错机制

vgroupMapping.xm_tx_group=xiamen-->registry.conf的nacos的cluster="xiamen"

spring.cloud.alibaba.seata.tx-service-group=xm_tx_group