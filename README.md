# DavidEventBusDemo
EventBus简单使用实例,学习使用开源库，提高开发效率与速度

作者：程序员小冰，CSDN博客：http://blog.csdn.net/qq_21376985， 

新浪微博：http://weibo.com/mcxiaobing

此实例比较简单，可以教你简单的使用eventbus，效果如下：

![这里写图片描述](http://img.blog.csdn.net/20160905104057953)

注意事项：

由于以前我用eventBus的jar包写得项目demo，前几天就写了一个EventBus的实例，

这次我没用jar包，直接用gradle引用的，可是demo写完了，报错：

its super classes have no public methods with the @Subscribe annotation

所以就用google搜索了一下，找到了解决方法，那就是在接受者

onEvent()方法添加注解：  @Subscribe 然后问题解决，如：

```

    /**
     *
     * 从发布者那里得到eventbus传送过来的数据
     *
     * 加上@Subscribe以防报错：its super classes have no public methods with the @Subscribe annotation
     *
     * @param event
     */
    @Subscribe
    public void onEvent(String event){
        tv.setText(event);
    }
```
