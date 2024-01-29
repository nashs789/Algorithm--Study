    const [input1, input2] = require('fs').readFileSync("/dev/stdin").toString().split('\n');
    const input = input1.split(" ");
    const n = Number(input[0]); 
    const m = Number(input[1]); 
    const list = input2.split(" ").map((item) => +item);


    let sumList = [];

    for(let i=0; i<list.length; i++) {
      for(let j=i+1; j<list.length; j++) {
         for(let k=j+1; k<list.length; k++) {
            const sum = list[i] + list[j] + list[k];
           
            if(sum <= m) {
               sumList.push(sum);
            }
         }
      }
    }
    console.log(sumList.sort((a,b)=>a-b).pop());
