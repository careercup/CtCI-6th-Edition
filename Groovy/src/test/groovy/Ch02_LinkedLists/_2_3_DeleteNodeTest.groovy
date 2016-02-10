package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node
import spock.lang.*

import static java.lang.Math.*
import static Ch02_LinkedLists._2_3_DeleteNode.deleteNode

@Unroll class _2_3_DeleteNodeTest extends Specification {
    /*@formatter:off*/
    def 'delete?'() {
        expect: source.eachWithIndex { _, int i ->
                    def reference = source.toList()
                    reference.remove(i)

                    def head = Node.from(source)
                    deleteNode(head, i)

                    assert head.toList() == reference
                }
        where:  source | _
                "$PI"  | _
                "$E"   | _
    }
    /*@formatter:on*/
}
