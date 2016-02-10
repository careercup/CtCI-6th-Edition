package Ch03_StacksAndQueues

import spock.lang.*

@Unroll class _3_1_MultiStackTest extends Specification {
    /*@formatter:off*/
    def 'multiStack?'() {
        when:   def multiStack = new MultiStack(stackContents.size(), stackSizes)
        then:   stackContents.indices.every { stackId -> multiStack.isEmpty(stackId) }

        when:   stackContents.eachWithIndex { List values, int stackId ->
                    values.reverseEach { value ->
                        multiStack.push(stackId, value)
                        assert !multiStack.isEmpty(stackId)
                    }
                }
        then:   stackContents.eachWithIndex { List values, int stackId ->
                    assert values.every { it == multiStack.pop(stackId) }
                    assert multiStack.isEmpty(stackId)
                }

        where:  stackContents             | stackSizes
                [[]]                      | 1
                [[1],[2]]                 | 1
                [[1,2],[3,4],[5,6]]       | 2
                [[1,2,3,4],[5,6],[7],[8]] | 10
    }

    def "multiStack pushes don't override next stack elements?"() {
        when:   def multiStack = new MultiStack(stackContents.size(), stackSizes)
                stackContents[0].each { value -> multiStack.push(0, value) }
        then:   thrown(AssertionError)
                multiStack.isEmpty(1)

        where:  stackContents | stackSizes
                [[1,2,3],[]]  | 2

    }
    /*@formatter:on*/
}
