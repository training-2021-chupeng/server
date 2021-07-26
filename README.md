# Server

## 本地环境安装

- Java JDK 1.8
- IntelliJ IDEA
- Docker

## 模块

- application 应用，包括Spring服务、JPA实现等
- domain 业务领域，纯业务逻辑部分

## 测试

- application 使用 MockMvc 测试
- domain 使用 JUnit5

## 命令行操作

#### 1、运行测试

* 运行测试

```shell
mvn clean test
```

* 运行指定模块测试

```shell
mvn clean test -pl application
```

#### 2、编译项目

* 编译打包

```shell
mvn clean package
```

* 编译指定模块

```shell
mvn clean package -pl application
```

#### 3、本地运行项目

* 本地启动MySQL和数据库查看工具

```shell
docker-compose -f env/local/docker-compose.yml up
```

test

* 运行项目

```shell
mvn clean install
mvn spring-boot:run -pl application
 ```

* 访问swagger-ui

```shell
http://localhost:8011/doc.html
```
