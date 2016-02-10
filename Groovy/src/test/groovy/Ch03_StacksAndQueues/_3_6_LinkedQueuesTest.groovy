package Ch03_StacksAndQueues

import groovy.transform.ToString
import spock.lang.Specification

import static java.lang.Thread.sleep

class _3_6_LinkedQueuesTest extends Specification {
    @ToString(includePackage = false) class Dog extends Named {}
    @ToString(includePackage = false) class Cat extends Named {}

    /*@formatter:off*/
    def 'linkedQueues?'() {
        when:   def queue = new LinkedQueues()
                def classes = [Dog,Dog,Cat,Dog,Cat,Cat,Dog,Cat]
                Named[] animals = classes.indexed().collect { index, type -> type.newInstance(name: "${type.name}_$index") }
                animals.each { queue.add(it); sleep(1) }
        then:   !queue.empty

        when:   def removed = (1..3).collect { queue.remove() }
        then:   removed*.class == [Dog,Dog,Cat]

        when:   removed = queue.remove(Cat)
        then:   removed*.class == [Cat]

        when:   removed = (1..2).collect { queue.remove(Dog) }
        then:   removed*.class == [Dog,Dog]

        when:   removed = [queue.remove(), queue.remove(Cat)]
        then:   removed*.class == [Cat,Cat]
                queue.empty
    }
    /*@formatter:on*/
}
