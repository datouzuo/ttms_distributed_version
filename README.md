# TTMS分布式版本

#### 介绍
{**网上购票系统，以及后台管理系统}
  采用spring boot 和 spring cloud 完成的微服务的架构。包括服务注册，服务发现，熔断，网关等；
   **基础服务** ：xin.menzuo.ttms-customer （单点登录，采用邮箱进行账号激活，redis存取session），studio-manager （电影管理,以及座位管理），movie-manager （电影管理以及座位管理），buyTicketsAndStatistic （购票管理，评论管理），business （异步的统计和异步的影票解锁业务）， Ticket-manager （电影场次和影票的管理，根据传入电影和比重，自动生成电影场次）。
  ** 前置服务** ：通过调用调用基础服务完成业务对基础服务存在熔断和负载均衡。（不需要登录的前置服务），（需要管理员权限的前置服务），（需要顾客的登录的前置服务）；
   **网关** ：采用spring cloud zuul，路由到3个前置服务，对前置业务存在熔断和负载均衡。

#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 使用说明

1. xxxx
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/) **粗体** 