import java.util.Scanner;

// 문자열 받고 앞뒤 체크해서 뒤가 더 크면 false로 종료하고 증가


public class Prob1316 {
    static int result = 0;

    static boolean check(String str) {
        int prev = 0;
        boolean[] check = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);    // 문자열 int형으로 저장
            if (prev != now) {    // 현재 문자열이 이전과 같지않다면?
                if (!check[now - 'a']) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String str = sc.nextLine();
            if(check(str)== true) result++;
        }
        System.out.println(result);
    }
}




