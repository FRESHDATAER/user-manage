运行步骤：
1. 执行maven命令进行安装编译：
    mvn clean install
2. 在dockerfile目录下进行docker镜像构建
    docker build
3. 运行docker容器
    docker run --name user-manager -p 8080:8080 <docker镜像名称>
