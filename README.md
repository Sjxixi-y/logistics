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

### 2. 编写实体类

#### 2.1 管理员

### 3. 编写 Dao 层

Dao层：具有与数据库交互的方法，不处理具体逻辑，根据对应的参数返回对应的数据。

#### 2.1 管理员

##### a. 添加
update()
##### b. 删除
update()
##### c. 修改
update()
##### d. 查询
query()

返回一个集合：BeanListHandler

返回一个目标对象：BeanHandler

* 全部查询
* 模糊查询
* 根据用户名称查询
* 根据用户名称、密码查询。

### 4. 编写 server 层

server层：接收传入的数据，执行具体的逻辑，得到 `Dao` 层数据，处理完成后返回至 `controller` 层。

#### 3.1 用户

##### a. 添加用户