const input = require('fs').readFileSync("/dev/stdin").toString().trim().split(" ");
const a = parseInt(input[0]);
const b = parseInt(input[1]);
const c = parseInt(input[2]);
const d = parseInt(input[3]);
const e = parseInt(input[4]);
const f = parseInt(input[5]);

for(let i=-999; i<1000; i++) {
    for(let j=-999; j<1000; j++) {
        if((a*i)+(b*j) === c && (d*i)+(e*j) === f) {
            console.log(`${i} ${j}`);
        }
    }
}
