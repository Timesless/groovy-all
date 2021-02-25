package com.yangzl.groovy

/**
 * @author yangzl
 * @date 2021/2/8
 * @desc
 *  groovy 基本数据结构 api
 */
class GroovyDS {

    static void main(String[] args) {
        testRange()
        testFuncDefaultParam()

        // 当参数是map时，可以省略[]
        // 当不产生歧义时，可省略函数调用的()
        testMapFunc([plugin1: 'plugin1', plugin2: 'plugin2'])
        testMapFunc plugin1: 'plugin1', plugin2: 'plugin2'

        testMap()
    }

    static void testMapFunc(Map<String, ?> map) {
        println(map)
    }

    /**
     * groovy 基本数据结构 api
     *  range
     *  map
     */
    static void testRange() {
        def range = 5..10
        range.each { print(it + ' ') }
        println()
        for (i in range) {
            print(i + ' ')
        }
        println()
    }

    static void testMap() {
        def map = [:]
        map.put('k1', 'v1')
        println(map)
    }

    static void testFuncDefaultParam() {
        def rs = defaultParam(4, 2)
        println("rs = " + rs)
    }

    /**
     * groovy函数默认参数
     *
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    static def defaultParam(p1, p2 = 0, p3 = 0) {
        printf("p1: %s, p2: %s, p3: %s\n", p1, p2, p3)
        // 最后一行作为返回值
        p1
    }
}
