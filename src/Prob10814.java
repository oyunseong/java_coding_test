import java.util.*;

public class Prob10814 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        String[][] arr= new String[n][2];   // 2차원 배열 생성 [나이, 이름] 저장
        for(int i=0; i<n; i++)
        {
            arr[i][0] = sc.next();  // 나이 입력
            arr[i][1] = sc.next();  // 이름 입력
        }

        //  arr 내림차순 정렬
        //  String name을 int형으로 변환해서 값을 비교
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] age1, String[] age2) {
                return Integer.compare(Integer.parseInt(age1[0]), Integer.parseInt(age2[0]));
            }
        });

        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i][0] +" "+ arr[i][1]);
        }
    }
}
