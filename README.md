# TNAxisHospital

#### 使用说明（看到有人fork了就更新了一波 :v: ）,要是对你有帮助点个star呗 :joy:，github仓库，码云仓库都行 ，没帮助的没必要划走，可以喷 :full_moon_with_face: 

### 关于如何运行这个项目我写了一个word文档[如何运行该项目.docx](https://gitee.com/jing3wen/TNAxisHospital/blob/master/%E5%A6%82%E4%BD%95%E8%BF%90%E8%A1%8C%E8%AF%A5%E9%A1%B9%E7%9B%AE.docx)，建议直接看word文档，先把代码跑起来，再去看下面的博客了解如何搭建的

### 关于这个项目本人写了个博客
https://www.cnblogs.com/jwAItn/articles/15530103.html

#### 本项目  [_码云仓库_](https://gitee.com/jing3wen/TNAxisHospital)  已与 [_GitHub仓库_](https://github.com/jing3wen/TNAxisHospital) 同步更新，更新以码云仓库为主, 
#### 有啥问题（代码跑不动，看不懂）欢迎留言，基本上24小时上线登陆一次 :full_moon_with_face:  :full_moon_with_face:  :full_moon_with_face: 急的话建议直接邮件1584591284@qq.com

#### 介绍
用Web service开发一个简单的就诊预约系统，实现如下基本功能：

1、预约功能：该系统使用户能够预订明后两天的专家号。首先，用户输入就诊日期和预约部门（内科和外科）。若不在两天之内，返回“不在预订日期内”提示框，提示用户重新输入就诊日期。若在两天之内，判断该部门有没有剩余的预约号，如果没有，返回“暂无预约号”；若有剩余的预约号，提示用户输入手机号码，若为11位有效号码并且此号码没有预约过，则提示“预约成功”，服务器端将此号码存起来作为预约信息，否则，提醒用户重新输入手机号码。

2、取消预约功能：提示用户输入手机号，若为11位有效号码并且此号码预约过，则返回“取消预约成功”，并在服务器端将此号码的预约信息删除；否则，返回“无效号码”或者“此号码尚未预约”，提示用户再次输入手机号码。

3、将该系统部署成Web服务；同时编写一个客户端进行调用。
PS：Web服务和客户端可以都在同一本地计算机；客户端可以是应用程序，也可以是Web页面。客户端要求有简单的用户界面。

#### 软件架构
软件架构说明
服务端：WebService+axis+mybatis

服务端开发环境：jdk8，mysql8.0，tomcat9.0，IDEA2021

客户端：基于Springboot来整合axis客户端

#### 安装教程

后续补上

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request
