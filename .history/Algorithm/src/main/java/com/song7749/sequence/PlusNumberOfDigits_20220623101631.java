package com.song7749.sequence;

public class PlusNumberOfDigits {
    
	public static void main(String[] args) {
    
    }

    public int solution(int n) {
        int answer = 0;

  		do {
            answer += n % 10;
            n /=10;
        } while(n > 0) ;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);
        return answer;
    }
}