# springcloud
微服务框架
mzq第一个微服务自学框架



@resource和@autowired的区别
@restcontroller和@controller的区别
@requestbody和@requestparam
@requestmapping和@postmapping

权限管理   spring security shiro  OAuth2


1.eureka服务注册中心集群   互相注册
2.修改host文件
3.eureka自我保护模式
4.zookeeper没看
5.consul agent -dev

eureka   	java  	  AP  
consul       go       CP
zookeeper   java      CP

C：consistency  强一致性  
A：availability  可用性
P：partition tolerance 分区容错性
CAP理论关注粒度是数据，不是整体系统设计策略

ribbon 负载均衡
ribbon客户端 进程内lb   vs   nginx服务端 集中式lb

ribbon负载规则

rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标

总服务器：2
list=0
1%2=1 index=1 list.get(index)

openfegin默认等待1s，超时会报错

openfegin自带ribbon

hystrix
服务降级：fallback：默认返回一个结果，类似于挡板（程序异长，网络超时，服务熔断触发服务降级，线程池打满导致服务降级）
服务熔断：break：达到最大服务访问量后，直接拒绝访问，拉闸，调用服务降级返回友好提示
服务限流：flowlimit：秒杀高并发操作，禁止同时发出过多请求，排队，一秒N个，有序进行

jmeter高并发压力测试

hystrix图形监控测试平台  微服务流量和压力  ----》  服务熔断  限流 降级

gateway网关：路由 断言 过滤

curl http://localhost:9527/payment/lb --cookie "username=mzq"

springcloud config配置中心

label：分支（branch）
application：服务名
profile：环境（dev/test/prod）

读取规则
/{label}/{application}-{profile}.yml
/{application}-{profile}.yml
/{application}-{profile}.yml/{label}


application.yml  用户级资源配置
bootstrap.yml  系统级   优先级更高

动态刷新配置文件
运维人员手动发送post请求
curl -X POST http://localhost:3355/actuator/refresh

springcloud bus 支持两种消息代理：rabbitMQ 和kafka


rabbitmq环境配置
安装erlang   http://erlang.org/download/
安装rabbitmq   https://www.rabbitmq.com/news.html

命令：rabbitmq-plugins enable rabbitmq_management
http://localhost:15672/
guest
guest

监听的topic默认名称是springCloudBus

curl -X POST http://localhost:3355/actuator/refresh/{destination}

cloud stream消息驱动： 屏蔽底层mq（activemq，rabbitmq,rocketmq,kafka）消息中间件的细节差异，降低切换成本，统一消息的编程模型

通过定义绑定器binder作为中间层，实现应用程序和消息中间件细节之间的隔离
