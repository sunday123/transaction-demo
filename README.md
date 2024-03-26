# 测试seata全局事务@GlobalTransactional多个接口使用

被问道A调用B，B调用C，能不能这三个接口都有注释@GlobalTransactional
比如A调用B，B调用C，写一个注释@GlobalTransactional，就可以实现全局事务。

想到调用链：A->B->C和B->C相当于A和B都可以有@GlobalTransactional。
推出ABC都可以注释@GlobalTransactional是没问题（虽然不怎么规范）。
