/**
 *  2839 - 설탕 배달
 * 
 *  먼저, 가장 적은 봉지를 배달 할 수 있는 5의 배수인지 확인 후, 5의 배수이면 5로 나눈 값만큼 counter에 더한다.
 *  5로 나누어떨어지면 더이상 계산할 필요가 없으니 반복문 종료한다.
 * 
 *  만약 5의 배수가 아닌 경우 
 *  3을 빼고 뺀 값이 0보다 작은 경우 -1을 counter에 담고 반복문을 종료한다.
 *  그렇지 않으면 counter에 1씩 더하고 다음 반복문을 실행한다.
 * 
 *  메모리 : 9348KB
 *  시간  : 188MS
 */

let n = require('fs').readFileSync('/dev/stdin')

let counter = 0;
    while(n>0) {
        if(n%5 === 0) {
            n = n/5;
            counter += n;
            break;
        } else {
            n= n-3;
            if(n<0) {
                counter = -1;
                break;
            }
            counter ++;
        } 
    }
console.log(counter);
