import java.io.*;
import java.util.*;
/**
 *
 * @author jay
 */


//push:
//enqueue in queue1
//pop:
//while size of queue1 is bigger than 1, pipe dequeued items from queue1 into queue2
//dequeue and return the last item of queue1, then switch the names of queue1 and queue2
class Stack2<E>{
    
    Queue <E> queue1 = new LinkedList<E>();
    Queue <E> queue2 = new LinkedList<E>();
    public void push(E item)
    {
        if(queue1.isEmpty())
        {
            queue2.add(item);
        }
        else
        {
            queue1.add(item);
        }
        
    }
    
    public E pop()
    {
        if(queue2.isEmpty())
        {
            while(queue1.size()>1)
            {
                queue2.add(queue1.remove());
            }

            E returnedItem = queue1.remove();

            Queue <E> temp = new LinkedList<>();
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return returnedItem;
            
        }
        else
        {
            while(queue2.size()>1)
            {
                queue1.add(queue2.remove());
            }

            E returnedItem = queue2.remove();

            Queue <E> temp = new LinkedList<>();
            temp = queue2;
            queue2 = queue1;
            queue1 = temp;
            return returnedItem;
        }
        
        
    }
    
}
public class StackUsingQueues 

{
    public static void main(String args[])throws IOException
    {
        
    }


}
