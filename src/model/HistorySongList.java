package model;

public class HistorySongList {
    //Queue Implementation
    private String arr[] = new String[1000];
    private int front;
    private int rear;
    private int capacity;
    private int count;

        //Constructor
        public HistorySongList() {
            capacity = 1000;
            front = 0;
            rear = -1;
            count = 0;
        }

        //Adding element to the queue
        public void addSong(String item) {
            //Queue flow check
            if (isFull()) {
                System.out.println("Error: Overflow");
                System.exit(1);
            }

            rear = (rear + 1) % capacity;
            arr[rear] = item;
            count++;
        }

        //Removing element
        public void dequeue() {
            //Queue underflow check
            if (isEmpty()) {
                System.out.println("Error: Underflow");
                System.exit(1);
            }

            front = (front + 1) % capacity;
            count--;
        }

        //Return from element
        public String lastListened() {
            if (isEmpty()) {
                System.out.println("Error: Underflow");
                System.exit(1);
            }
            return arr[rear];
        }

        //Return size
        public int size() {
            return count;
        }

        //Empty check
        public Boolean isEmpty() {
            return (size() == 0);
        }

        //Full check
        public Boolean isFull() {
            return (size() == capacity);
        }
}

