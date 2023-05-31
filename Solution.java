import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int queries = input.nextInt(), queryId, value;
        Queue queue = new Queue();
        
        for (int i=0; i < queries; i++) {
            queryId = input.nextInt();
            
            switch (queryId) { 
                case 1:
                    value = input.nextInt();
                    queue.enqueue(value);
                    break;
                
                case 2:
                    queue.dequeue();
                    break;
                
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
            
        }
        input.close();
    }
    
    
}

class Queue {
    private Stack<Integer> s1 = new Stack<>()  , s2 = new Stack<>();
        
    public Queue() {
    }
        
    public void enqueue(int num) {
        s2.push(num);
    }
        
    public void dequeue() {
        if(s1.isEmpty()&&s2.isEmpty()){
                System.out.println("Empty");
                return;
            }
        if(s1.isEmpty()) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        s1.pop();
    }
        
    public int peek() {
        
        if(s1.isEmpty()) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        
        return s1.peek();
    }
}
