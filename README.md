# 物流系统

## 一、依赖外部包

- dbutils -- 封装了关于 `JDBC` 一系列操作的方法
- druid -- 封装了关于 `数据库连接池` 的相关方法

## 二、项目创建步骤

### 1. 编写工具类 DruidUtil

目的：便捷获取 `数据源`

a. 读取文件，初始化数据源。

    // 获取文件流
    InputStream is = DruidUtil.class.getResourceAsStream("/dp.properties");
    // 读取文件
    properties.load(is);
    // 创建连接池对象
    ds = DruidDataSourceFactory.createDataSource(properties);

b. 提供get方法

    public static DataSource getDataSource() {
    return ds;
    }

### 2. 