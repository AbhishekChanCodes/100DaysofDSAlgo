/*

Implement a Queue using Singly Linked List

*/



/*

A queue is a FIFO(First In First Out) data structure.
A queue has to maintain two pointers, front and back. New elements are inserted from the back and elements are deleted
from the front.

The two operations mentioned here are push and pop, which are actually given in reference to a stack, but apply to a queue
as well.

I have also defined the peek operation which is just returning the value at the front of the queue without removing it.

The benefit of implementing a Queue using a Linked List is that memory use is optimum. We create new nodes when we are inserting
and memory is allocated then.

*/

class QueueNode {

  int val;
  QueueNode next;

  public QueueNode(int val) {

    this.val = val;
    this.next = null;

  }
}

class Queue {

  QueueNode front, back;

  public Queue() {

    this.front = this.back = null;

  }

  // Push a value onto the queue and update the back pointer.
  void push(int val) {

    QueueNode newNode = new QueueNode(val);

    if(this.back == null) {

      this.front = this.back = newNode;

    } else {

      this.back.next = newNode;
      this.back = newNode;

    }
  }

  // Remove the value at the front of the queue, if exists and return it. Update the front pointer.
  void pop() {

    if(this.front == null)
      return;

    QueueNode temp = this.front;
    this.front = this.front.next;

    // In the event, the removed node was the only node in the list and the queue is now empty.
    if(this.front == null)
      this.back = null;

  }

  // Return the value at the front of the queue, without removing the node.
  int peek() {

    return this.front.val;
  }
}
