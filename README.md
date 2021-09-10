# spring-cloud-demo
eureka实现注册中心，并且两个服务端形成集群

两个提供者

初步使用Ribbon来实现负载均衡，

使用spring security添加认证
注意配置文件中的
spring:
  security:
    user:
      name: wrj
      password: wrj

所有像集群中注册的服务都要在配置文件中增加 http://wrj:wrj@peer1:8080/eureka/ 这种 在ip前面增加 name:password 的认证

参考：https://mrbird.cc/Spring-Cloud-Eureka.html
