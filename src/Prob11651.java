import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * 문제 : 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * <p>
 * 이번 문제는 간단한 정렬문제인데 아직 정렬하는 실력이 없어서 이중 포문을(선택 정렬) 이용해 느리지만 문제에서 요구하는 답을 구할 수 있었다.
 * 내 풀이는 2차원 배열을 선언하고 [0][0]번쨰 인덱스에는 x좌표, [0][1]에는 y 좌표를 저장해서 값을 비교하고 정렬하였다.
 * <p>
 * <p>
 * Arrays.sort()라는 라이브러리 정렬 함수를 사용하였다.
 * TimSort라는 알고리즘인데 insertion + merge sort 라고 한다.
 * <p>
 * sort 함수 내부 구조를 보면
 * public static <T> void sort(T[] a, Comparator<? super T> c) {
 * T[] a 는 제네릭 타입 배열을 입력해주면된다.
 * Comparator 내부로 들어가보면 인터페이스로 구현되어있는걸 보니 람다식으로도 표현이 가능하다.
 * compare를 오버라이드 해야하는데 return 값은 음수, 0, 양수로 반환한다.
 * 양수를 반환해야 sort 객체 교환 ( sort ) 가 일어난다.
 */

public class Prob11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        int[][] temp = new int[1][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        /**
         * 람다식 표현
         * */
//        Arrays.sort(arr, (e1, e2) -> {
//            if (e1[0] == e2[0]) {
//                return e1[1] - e2[1];
//            } else {
//                return e1[0] - e2[0];
//            }
//        });

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    // 반환하는 값은 0, 음의정수, 양의정수 중 하나인데 양의 정수일 때만 두 객체의 위치를 바꿔준다.
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });


// 선택정렬
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i][1] > arr[j][1]) {
//                    temp[0][0] = arr[i][0];
//                    temp[0][1] = arr[i][1];
//
//                    arr[i][0] = arr[j][0];
//                    arr[i][1] = arr[j][1];
//
//                    arr[j][0] = temp[0][0];
//                    arr[j][1] = temp[0][1];
//                }
//            }
//        }
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i][1] == arr[j][1]) {
//                    if (arr[i][0] > arr[j][0]) {
//                        temp[0][0] = arr[i][0];
//                        temp[0][1] = arr[i][1];
//
//                        arr[i][0] = arr[j][0];
//                        arr[i][1] = arr[j][1];
//
//                        arr[j][0] = temp[0][0];
//                        arr[j][1] = temp[0][1];
//                    }
//                }
//            }
//        }

        for (int i = 0; i < n; i++)
            System.out.println(arr[i][0] + " " + arr[i][1]);
    }

}
