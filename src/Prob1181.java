import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1181번 문제 : 단어 정렬
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 *
 * Arrays.sort() 함수를 이용해 단어 길이가 일치하는지 파악하고 다를 경우 정렬해주었다.
 * 중복되는 단어는 출력하지 않기 위해서 출력 직전에 처리를 해주었다.
 * 정렬하면서 새로운 배열을 할당해서 저장하기엔 공간을 하나 더 써야하기 때문에 비 효율적일 것같았다.
 *
 * */

public class Prob1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        sc.nextLine();  // 개행 버림

        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }

        Arrays.sort(str, (s1,s2)->{
            if(s1.length() == s2.length()){
                return s1.compareTo(s2);
            }else{
                return s1.length() - s2.length();
            }
        });

//        Arrays.sort(str, (e1, e2) -> {
//            int len = e1.length() - e2.length();
//            if (len < 0) {
//                return e1.length() - e2.length();
//            } else if (e1.length() == e2.length()) {
//                if (e1.compareTo(e2) != 0) {
//                    for (int i = 0; i < e1.length(); i++) {
//                        if (e1.charAt(i) == e2.charAt(i)) continue;
//                        else {
//                            return (int) (e1.charAt(i) - e2.charAt(i));
//                        }
//                    }
//                }
//            }
//            return 0;
//        });

        System.out.println(str[0]);
        for (int i = 1; i < n; i++) {
            if (!str[i].equals(str[i - 1])) {
                System.out.println(str[i]);
            }
        }
    }
}
