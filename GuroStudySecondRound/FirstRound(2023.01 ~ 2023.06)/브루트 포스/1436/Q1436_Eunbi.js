const n = require('fs').readFileSync('/dev/stdin').toString();

let count = 0;

for(let i=665; i++;) {
    if(Number(n) === count) {
      console.log(i-1);
      break;
    }
    if (i.toString().includes("666")) {
      count++;
    }
}
