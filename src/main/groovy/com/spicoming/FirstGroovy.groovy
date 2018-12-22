package com.spicoming

import groovy.transform.PackageScope

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created by NJTZ on 2018/12/21.
 */
//1 动态数据类型
/*
println 'hello world'
int method(String arg){
    return 1;
}
int method(Object arg){
    return 2;
}
Object obj="Object";
int result=method(obj)
println result*/

//2 数组定义
/*
int[] arr=[1,2,3];
println arr*/

//3 POJO 隐式创建getter setter和有参构造器，默认public，使用@PackageScope注解限定其他访问权限
/*
class Person {
    @PackageScope String name
    int age
}
def person=new Person(name:"zhangsan")
person.age=20
println person.name
println person.age*/

//4 ARM语句块 自动资源管理-Automatic Resource Management，groovy不支持，使用闭包
// 格式1
/*
new File('H:/git_repository/helloworld/build/resources/main/test.txt').eachLine('UTF-8'){
    println it;
}
*/
//格式2
/*
new File("H:/git_repository/helloworld/build/resources/main/test.txt").withReader('UTF-8') {
    reader->reader.eachLine {
        println it
    }
}
*/
//格式3
/*
print new File("H:/git_repository/helloworld/build/resources/main/test.txt").text
*/

//5 内部类 groovy中内部类类似groovy.lang.Closure类的实现
/*CountDownLatch called = new CountDownLatch(1)
Timer timer = new Timer()
timer.schedule(
        new TimerTask() {
            @Override
            void run() {
                called.countDown()
            }
        },0
)
println called.await(10,TimeUnit.SECONDS)*/

//6 Lambda groovy 没有采用这种语法，使用闭包实现
/*Runnable run={println 'Run'}
run()
def list=['lili','limi','john']
list.each{
    println it
}
list.each (this.&println)*/
//7 GString 双引号内的字符串字面量，都会被解释成GString-Groovy String 类型
//          某个类的String字面量含有美元字符$时，groovy和java的编译结果可能不同
//如果某个API声明了形参的类型，groovy会自动转换GString和String
//要小心那些形参为Object的Java API，需要检查它们的实际类型

//8 字符串和字符字面量
//groovy中，单引号内字面量属于String类型对象，双引号内字面量
//可能是String类型或GString类型，具体分类由字面量中是否有插值决定
/*println 'A'.getClass()
println "A".getClass()
println "A${1}".getClass()
println "A${2}"*/

//9 基础语法
// groovy 不需使用；结尾，兼容；
// groovy 中== 等价于java中equals方法
// 注释一样，另外支持Shebang line 特殊的一行单行注释，用于指明脚本运行环境 例如 #!/usr/bin/env groovy
// 变量 默认访问修饰符public，命名规范一致，def关键字定义，变量值决定类型
//      浮点数默认类型为BigDecimal
//      数字类型使用类型后缀声明类型
//      Integer I or i       Long L or l
//      BigInteger G or g    BigDecimal G or g
//      普通字符串 String ''  插值字符串 "" $  三引号写法 ''' ''' 保留换行及缩进
/*
def a=897897489273489573248975289
println a.class
a=3.23948293
println a instanceof BigDecimal*/
/*
println '''
1 + 1
=
2
'''
def name='李四'
println "你好，${name}"*/
//方法  默认访问修饰符public ，返回类型不需声明时，加def关键字
//      return可省略，默认返回最后一行的运行结果
//      使用了return关键字，则返回指定的返回值
//      参数类型可省略，默认Object
/*String method1(){
    return 'hello'
}
def method2(a,b){
    a+b;
}
println method1()
println method2(4,'h')*/

//闭包  定义：闭包就是一段可执行的代码块或指针。
//      闭包在groovy中是groovy.lang.Closure类的实例，
//      可赋值给变量或者作为参数传递
//      语法如下：
//      def closure={[closureParameters->] statements}
//          参数可选，如果没有参数，可省略->,多个参数之间用,分隔
//          只有一个参数，可省略，使用it代替
//      闭包可访问外部变量，而方法/函数不能
//      两种调用方式： closure(params) or closure.call(params)

/*def str = 'hello'
def closure = {
    println(str)
}
def closure2 = { obj ->
    obj.each { println it }
}
//执行闭包
closure();
closure2.call("groovy")
closure2 'java'*/
/*def add={
    a,b->
        a+b
}
println add (1,4)*/
//闭包作为参数传入时，作为方法的唯一参数或最后一个参数时，可省略括号
/*
def eachLine(lines,closure){
    for(String line:lines){
        closure line
    }
}
eachLine('a'..'f',{println it})
//省略括号
eachLine ('b'..'i'){println it}
*/
//List   groovy 定义List非常灵活，以[]包含元素，以，分隔即可

/*def numbers=[1,2,3,4]
println numbers.getClass();
println numbers.size()*/

//Array  groovy定义数组类型，与List非常类似，区别在于定义数据组
//       时，必须指定直接定义类型 或者使用def定义 ad关键字指定
/*int [] nums=[1,2,3]
println( nums.class instanceof Object[])
def strs=['aa','bb','cc'] as String[]
println strs.getClass() instanceof List*/

//Map   groovy定义Map非常简洁，中括号中 [key:value]即可
/*def colors=[red:'#FF0000',green:'#00FF00',blue:'#0000FF'];
println colors.red
println(colors['blue'])
//添加元素
colors.pink='#FF00FF'
println(colors['pink'])
colors['yellow']='#FFFF00'
println colors.yellow*/
//Map 的key默认语法不支持变量，要使用变量作为key，需要使用括号()

/*
def keyStr='pink'
def colorOther=[keyStr:'#FF00FF']
println colorOther.pink
println colorOther['keyStr']
def colorReal=[(keyStr):'RealColor']
println colorReal['pink']*/

//Range     groovy中，可以使用 ... 操作符来定义一个区间对象，简化范围操作的代码

/*def range=0..8;
range.each {
    println it
}
println (0..<5) //左闭右开区间
println ((0..<5) instanceof List) //左闭右开区间*/

/*for(x in 'a'..'f'){
    println x
}*/

/*def age = 30
switch (age) {
    case 1..17:
        println '未成年'
        break
    case 18..40:
        println '青年'
        break
    case 40..60:
        println '中年'
        break
    default: '中年后'
}*/

// 常见使用场景
// Gradle  Gradle 是基于Ant和Maven概念的项目自动化构建工具，
//         使用一种基于Groovy的特定领域DSL来进行构建，抛弃
//         了基于XML的各种繁琐配置，面向java为主，支持Maven仓
//         库下载，下一代项目构建工具

// Spring支持  <lang:groovy/>标签来定义 Groovy Bean
//             Groovy Bean 通过 script-source 属性加载脚本文件，
//