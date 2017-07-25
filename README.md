# 项目说明

注意：开发人员不能自己安装第三方库，必须向主管申请，由主管指定的人选统一安装。

## 启动 Keycloak 服务器

    ./standalone.sh

管理控制台：http://localhost:8080/auth/admin
用户名：admin
密码：admin

## 运行

    mvn wildfly-swarm:run
    或
    mvn clean package
    java -jar ./target/multitenant-swarm.jar -Dswarm.http.port=8090

按 Ctrl-C停止运行。

访问：
http://localhost:8090/multitenant/tenant1/hello
用户名：user-tenant1
密码：user-tenant1

http://localhost:8090/multitenant/tenant2/hello
用户名：user-tenant2
密码：user-tenant2

## 单元测试

    mvn clean test

## 生成Docker镜像并推送到私有仓库

    mvn clean package docker:build  -DskipTests -DpushImage

需要在Maven的settings.xml中添加如下配置：

```xml
<server>
    <id>docker-registry</id>
    <username>sa</username>
    <password>xxx</password>
    <configuration>
        <email>jo@yohol.net</email>
    </configuration>
</server>
```