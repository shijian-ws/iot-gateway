# 网关设备TCP服务端

### 下载项目
git clone https://github.com/shijian-ws/iot-gateway.git

### 编译项目, 需要先安装iot-util, iot-comm依赖到本地仓库
mvn clean package

### 运行项目, 没有使用Spring Boot 监控模块, 需要手动关闭
java -Dspring.profiles.active=local -jar target/iot-gateway-0.1.jar
