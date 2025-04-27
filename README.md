# Spring Project API Request Valid

## 项目概述

本项目是一个基于Spring框架的API请求验证示例项目。它展示了如何在Spring Boot应用中实现请求参数的验证，确保API的安全性和数据完整性。

## 主要功能

使用Spring Validation进行请求参数校验

- 基础校验
- 分组校验
- 嵌套校验
- 嵌套校验集合中的对象
- 自定义校验注解
- 自定义跨字段校验注解
- 处理校验失败的全局异常

## 技术栈

- OpenJDK 24
- Spring Boot 3.4.5
- Spring Validation 3.4.5
- Lombok (简化Java Bean代码)
- Maven (构建工具)

## 项目结构

```
spring-project-api-request-valid
├─fun.maso.demo
│  ├─valid1base                    # 基础校验
│  ├─valid2group                   # 分组校验
│  ├─valid3nested                  # 嵌套校验
│  ├─valid4nestedcollection        # 嵌套校验集合中的对象
│  ├─valid5custom                  # 自定义校验注解
│  ├─valid6customcrossfield        # 自定义跨字段校验注解
│  ├─GlobalExceptionHandler.java   # 全局异常处理
│  └─Application.java              # 启动类
└─README.md
```

## 贡献指南

欢迎提交PR和Issue。请遵循以下步骤：

1. Fork本仓库
2. 创建新分支 (`git checkout -b feature/your-feature`)
3. 提交更改 (`git commit -am 'Add some feature'`)
4. 推送到分支 (`git push origin feature/your-feature`)
5. 创建Pull Request

## 许可证

本项目采用 [MIT License](LICENSE)。