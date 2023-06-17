//
//  Q2485_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/06/06.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 70672KB
 *  - 시간 : 68ms
 */

let n = Int(readLine()!)!

var trees: [Int] = []

var mid = 0

func gcd(_ a: Int, _ b: Int) -> Int {
    return b == 0 ? a : gcd(b, a % b)
}

for _ in 0..<n {
    trees.append(Int(readLine()!)!)
}
trees.sort()

// 간격들 최대 공약수 구하기
for i in 0..<n - 1 {
    mid = gcd(mid, trees[i + 1] - trees[i])
}
print((trees.last! - trees.first!) / mid - n + 1)
