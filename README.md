# 微服务架构项目

这是一个基于 Spring Boot 和 Spring Cloud 构建的微服务架构项目。

## 📋 项目描述

该项目采用微服务架构设计，包含多个独立的服务模块，通过 API 网关实现服务治理和负载均衡，使用 Spring Cloud 组件实现服务间的通信和调度。

**项目版本**: 1.0-SNAPSHOT  
**Java 版本**: 8  
**Spring Boot 版本**: 2.7.10

## 📂 项目结构

```
Microservices_architecture/
├── cloud-gateway/           # API 网关服务
├── cloud-sso/               # 单点登录服务（SSO）
├── cloud-api-market/        # 市场 API 服务
├── cloud-core-market/       # 核心市场业务模块
├── market/                  # 市场主服务
├── cloud-diss/              # 分布式业务服务
├── sql/                     # 数据库脚本
├── docx/                    # 文档目录
└── pom.xml                  # Maven 根配置文件
```

## 🔧 主要模块说明

| 模块 | 描述 |
|------|------|
| **cloud-gateway** | API 网关，负责请求路由和负载均衡 |
| **cloud-sso** | 单点登录服务，统一管理用户认证 |
| **cloud-api-market** | 市场 API 接口层 |
| **cloud-core-market** | 核心业务逻辑实现 |
| **market** | 市场主服务，包含活动分析等功能 |
| **cloud-diss** | 分布式服务，处理分销相关业务 |

## 🌐 Nacos 配置

本项目使用 **Nacos** 作为微服务的注册中心和配置管理平台。

### Nacos 的主要功能

- **服务注册与发现**：各个微服务自动注册到 Nacos，支持服务间的动态调用
- **配置管理**：统一管理各服务的配置，支持动态更新无需重启
- **负载均衡**：结合 Spring Cloud LoadBalancer 实现服务间的负载均衡

### Nacos 配置信息

```yaml
# bootstrap.yml 配置示例
spring:
  application:
    name: service-name  # 服务名称
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848  # Nacos 服务器地址
      config:
        server-addr: localhost:8848
        file-extension: yaml  # 配置文件格式
```

### Nacos 服务列表

| 服务名 | 端口 | 说明 |
|--------|------|------|
| gateway-service | 8080 | API 网关服务 |
| market-service | 8081 | 市场主服务 |
| sso-service | 8082 | 单点登录服务 |

## 🚀 快速开始

### 前置要求

- JDK 8 或更高版本
- Maven 3.6 或更高版本
- MySQL 数据库
- **Nacos 服务器**（版本 2.0.4+）

### 安装步骤

1. **克隆项目**
   ```bash
   git clone https://github.com/shipship22/Microservices_architecture.git
   cd Microservices_architecture
   ```

2. **启动 Nacos 服务器**
   ```bash
   # 下载 Nacos：https://github.com/alibaba/nacos/releases
   # 解压后进入 bin 目录
   
   # Windows
   startup.cmd -m standalone
   
   # Linux/Mac
   ./startup.sh -m standalone
   
   # 登录地址：http://localhost:8848/nacos
   # 默认用户名/密码：nacos/nacos
   ```

3. **初始化数据库**
   ```bash
   # 执行 sql 目录下的数据库脚本
   mysql -u root -p < sql/faw_rawdata_dev_activity_*.sql
   ```

4. **编译项目**
   ```bash
   cd source
   mvn clean package
   ```

5. **启动服务**
   ```bash
   # 启动 API 网关（先启动）
   java -jar modules/cloud-gateway/target/cloud-gateway-*.jar
   
   # 启动其他服务
   java -jar modules/market/target/market-*.jar
   java -jar modules/cloud-sso/target/cloud-sso-*.jar
   # 启动其他服务...
   ```

## 📝 配置文件说明

- **application.yaml/yml** - 服务配置文件
- **bootstrap.yaml/yml** - 启动时加载的配置文件
- **generatorConfig.xml** - MyBatis 代码生成配置
- **sqlMapConfig.xml** - MyBatis SQL 配置

## 🔌 关键依赖

- Spring Boot
- Spring Cloud
- Spring Cloud Gateway
- Spring Security（SSO）
- MyBatis
- MySQL Connector

## 📖 API 接口

各服务通过 API 网关对外暴露接口，详细的接口文档请参考各模块的 API 文档。

## 🛠️ 开发工具

- IntelliJ IDEA / Eclipse
- Maven
- Git
- Postman（API 测试）

## 📄 许可证

请查看项目中的许可证文件。

## 👥 贡献

欢迎提交 Issue 和 Pull Request！

---

**更新时间**: 2026年1月3日
