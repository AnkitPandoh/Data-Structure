package queue;

public class Queue {
	public static void main(String[] args){
		BasicQueue q = new BasicQueue(5);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.deQueue();
		q.deQueue();
	}
	static class BasicQueue{
		int front;
		int rear;
		int[] q;
		int size;
		
		BasicQueue(int size){
			this.front = 0;
			this.rear = 0;
			this.size = size;
			this.q = new int[size];
		}
		
		public void enQueue(int val){
			if(rear == size){
				System.out.println("overflow");
				return;
			}
			q[rear] = val;
			rear++;
		}
		
		public void deQueue(){
			if(front == rear){
				System.out.println("underflow");
			}
			q[front] = -1;
			front++;
		}
	}
}
