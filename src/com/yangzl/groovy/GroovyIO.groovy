package com.yangzl.groovy


/**
 * @author yangzl* @date 2021/2/8
 * @desc
 *
 *  1. groovy读取文件
 *  2. 写文件
 *  3. 文件复制
 *  4. 遍历文件夹
 */
class GroovyIO {

    static String path = System.getProperty("user.dir") + "/resources/"

    static void main(String[] args) {

        readThis()
        writeHello()
        contentCopy()
        visitWithRecurse()
    }

    static def readThis() {
        new File(path + '../src/com/yangzl/groovy/Hello.groovy').each {
            println(it)
        }
    }

    static def writeHello() {
        def list = ["hello groovy", "hello python3", "hello java"]
        new File(path + 'hello.txt').withWriter('utf-8') {
            w ->
                list.each {
                    w.writeLine(it)
                }
        }
    }

    static def contentCopy() {
        def source = new File(path + 'hello.txt')
        def dst = new File(path + 'copy.txt')

        dst << source.text
    }

    /**
     * 递归遍历文件夹与文件
     */
    static def visitWithRecurse() {
        new File(path).eachFileRecurse {
            println(it.getAbsolutePath())
        }
    }

}

