package queue;

public class CircularQueue {
	int[] arr;
	int front, rear, size, count;
	
	CircularQueue(int size){
		this.front = 0;
		this.rear= 0;
		this.size = size;
		arr = new int[size];
	}
	
	public boolean isEmpty(){
		return (count==0);
	}
	
	public void enQueue(int value){
		if(size == count){
			return;
		}
		arr[rear] = value;
		rear = (rear+1)%size;
		count++;
	}
	
	public int deQueue(){
		if(isEmpty()){
			return -1;
		}
		int val = arr[front];
		arr[front] = -1;
		front = (front+1)%size;
		count--;
		return val;
	}
	
	public int front(){
		return arr[front];
	}
}
