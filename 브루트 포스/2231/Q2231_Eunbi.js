/**
 *  2231 - 분해합
 *  입력 받은 수를 max로 지정을 하고, 1부터 입력받은 수까지 반복문 실행,
 *  i를 문자열로 변환 후 split을 통해 자른다. 
 *  자른 값은 다시 숫자로 변형하여 i를 초기값으로 주고, reduce를 통해 자른 값을 모두 더한다.
 *  ex ) 198 -> [1,9,8] -> 초기값: 198 + (1+9+8) = 216
 * 
 *  1부터 입력 받은 수까지 반복문을 수행하면서 더해진 값(216)이 입력받은 수와 같으면 i 값을 출력하고 반복문 종료
 *  만약 i 가 입력받은 수와 같다면 0 출력
 * 
 * 	메모리 : 47324KB
 * 	시간 : 916MS
 * 
 */

let fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();
const max = Number(input)

for(let i = 1; i<=max; i++){
    const acc = i.toString().split('').map((i) => Number(i)).reduce((acc, cur) => { return acc+ cur }, i);
    console.log(`i = ${i} -> ${acc}`);
  
    if(acc === max) {
        console.log(i);
        break;
    } 
    if(i === max) {
        console.log(0);
        break;
    }
}
