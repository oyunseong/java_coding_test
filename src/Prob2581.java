import java.util.Scanner;

/**
 * 입력 : n
 * n < x <= 2n 사이의 소수 값 x의 총 개수를 찾는 문제
 * 수학 공식 : 에라토스테네스의 체를 이용
 * 모든 자연수는 소수들의 곱으로 표현이 됨.
 * <p>
 * 2 ~ n-1 까지의 수 중에서
 * a. 2의 배수를 모두 빼고,
 * b. 3의 배수를 모두 빼고,
 * c. n-1의 배수까지 모두 빼고,
 * 제곱근 n까지 나눠서 걸리지지 않고 남는 수들이 모두 소수
 * <p>
 * 처음엔 0으로 초기화된 배열을 생성
 * 이중포문을 이용해 2,3,4,5...n-1배수까지 빼준다 ( = true )
 * 배열에 남은 false가 소수임.
 */
public class Prob2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int n2 = n * 2;
            int sum = 0;
            if (n == 0) return;
            boolean[] arr = new boolean[n2 + 1];
            for (int i = 2; i <= n2; i++) {
                if (!arr[i])
                    for (int j = i * 2; j <= n2; j = i + j) {
                        arr[j] = true;
                    }
            }
            // n < x <= 2n 이므로 k=n+1부터 시작
            for (int k = n + 1; k <= n2; k++) {
                if (!arr[k]) sum++;
            }

            System.out.println(sum);
        }

    }
}
