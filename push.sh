#!/bin/bash
serviceName="backend"
echo '可选参数'
echo '参数1：服务版本号，如果不填写，默认值为：latest'
version="latest";
if [ -n "$1" ]; then
version=$1;
fi
echo "最终版本:$version";
docker login  -u$docker_hub_uname -p$docker_hub_pwd

localImage="${serviceName}:${version}"
echo "本地镜像名称:${localImage}"
remoteImage="dweizhao/${localImage}"
echo "远程镜像名称:${remoteImage}"
# 这里注意这个当前脚本是在项目的子目录里面，所以才有../
echo "------构建 开始-----"
docker build -t ${localImage} .
docker tag ${localImage} ${remoteImage}
echo "------构建 完成-----"
echo "------开始推送-----"
docker push ${remoteImage}
echo "------推送完成-----"