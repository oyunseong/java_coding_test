import java.util.Scanner;

class Prob12865 {
    static int n, k;
    static int dp[][], w[], v[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 물품의 수
        k = sc.nextInt();   // 버틸 수 있는 무게

        // 0,0은 버림, 0,0의 공간은 낭비하지만 버림으로써 계산이 쉬워지고 얻는 이점이 많음
        dp = new int[n + 1][k + 1]; // ex 4,7

        w = new int[n + 1];   // 무게
        v = new int[n + 1];   // 가치

        // 물품의 수만큼 무게와 가치 입력받기
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // n x k의 배열 생성
        for (int i = 1; i <= n; i++) // i는 물품의 개수까지
        {
            for (int j = 1; j <= k; j++) // 최대 버틸 수 있는 무게까지
            {
                dp[i][j] = dp[i - 1][j];  // 기본적으로 이전 아이템의 가치를 저장한다.
                if (j - w[i] >= 0) {  // 무게에서 자신의 무게를 뺐을 대 남는 무게가 존재한다면,
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);  // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값 대입
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}