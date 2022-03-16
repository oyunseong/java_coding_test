import java.util.*;

public class programmers_1 {
    public static int solution(int money, int[] costs) {
        int min = 100000;
        int answer = 0;
        int[] temp = costs;
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, (double) costs[0]);        // 1
        map.put(5, (double) costs[1] / 5);      // 4/5
        map.put(10, (double) costs[2] / 10);    // 9.9
        map.put(50, (double) costs[3] / 50);    // 35/50
        map.put(100, (double) costs[4] / 100);    // 60/100
        map.put(500, (double) costs[5] / 500);      // 500/1000


        List<Map.Entry<Integer, Double>> list_entries = new ArrayList<>(map.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Integer, Double> entry : list_entries) {
            if (money != 0) {
                int a = money / entry.getKey();
                money = money - a * entry.getKey();
                System.out.println(entry.getKey()+"원짜리"+a+"개");
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }else{
                System.out.println("끝!");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] costs = {1, 4, 99, 35, 60, 1000};
        solution(4578, costs);
    }
}
