import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(int i=0; i<N; i++)
        {
            int a = Integer.parseInt(br.readLine());

            if(maxPQ.size() == minPQ.size()){
                maxPQ.add(a);

                // poll() : peek 값을 반환하고 제거함 비어있다면 null 반환
                if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            else{
                maxPQ.add(a);

                if(maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            System.out.println(maxPQ.peek());
        }
    }
}
