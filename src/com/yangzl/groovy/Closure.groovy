package com.yangzl.groovy

/**
 * @author yangzl
 * @date 2021/2/8
 * @desc
 *      groovy 在不产生歧义的情况下，方法调用的括号可以省略
 *      闭包隐式参数 it
 *      如果闭包是函数的最后一个参数，那么可以将闭包写在括号外
 *      test(int i, Closure c) { return c(i) }
 *      可以这样调用：test(1) { it * 2 }
 */
class Closure {

    static void main(String[] args) {
        testClosureApi()
        testClosureDS()
    }

    /**
     * 闭包的基本使用
     *
     * @return
     */
    static def testClosureApi() {
        def cl = { println('hello closure') }
        cl.call()

        // 闭包中的形参
        def c2 = { param -> println("hello $param") }
        c2.call("p1")
        def c3 = { println("hello $it") }
        c3.call("p2")

        // 闭包可以引用外部类的变量，这与lambda不同
        def str = "hello"
        def c4 = {
            println("$str $it")
            /*
                闭包会修改引用的外部变量
                我认为是单线程的缘故，C++ lambda引用外部变量修改的是作为匿名类实例的字段，但不能改外部变量本身，Java则是final捕获的
                Golang闭包修改的也是引用的外部变量作为匿名函数实例的字段的值，外部变量本身的值是不能修改的
                js 和 groovy的闭包则可以修改外部变量本身的值，这应该是单线程的原因
                闭包大约在2003年
             */
            str = "zzz"
        }
        c4.call("param")
        println("==== outer str = " + str)
    }

    /**
     * 在 数据结构中 闭包
     * find
     * findAll
     * any
     * collect 映射 + 收集
     * grep 过滤
     */
    static void testClosureDS() {
        def map = ['tik': 'tok', 'duck': '不必', '不讲': 'wood']
        map.each {
            println(it.key + ": " + it.value)
        }
        def list = [1, 2, 3, 4]
        list.collect { it * it }.each { print it + ' ' }
        println()

        list.grep { it > 2 }.each { print(it + ' ') }
    }
}
