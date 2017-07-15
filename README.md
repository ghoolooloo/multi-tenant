# 项目说明

注意：开发人员不能自己安装第三方库，必须向主管申请，由主管指定的人选统一安装。

## 运行

    mvn wildfly-swarm:run

按 Ctrl-C停止运行。

## 单元测试

    mvn clean test

## 生成Docker镜像并推送到私有仓库

    mvn clean package docker:build  -DskipTests -DpushImage

需要在Maven的settings.xml中添加如下配置：

```xml
<server>
    <id>docker-registry</id>
    <username>sa</username>
    <password>Maks.reg</password>
    <configuration>
        <email>zhouq@mayocase.com</email>
    </configuration>
</server>
```