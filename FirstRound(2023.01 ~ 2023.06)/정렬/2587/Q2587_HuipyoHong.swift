//
//  Q2587_HuipyoHong.swift
//
//
//  Created by 홍희표 on 2023/05/07.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 69104KB
 *  - 시간 : 8ms
 */

var array: [Int] = []

for _ in 0..<5 {
    array.append(Int(readLine() ?? "0") ?? 0)
}
print(array.reduce(0, +) / array.count)
print(array.sorted()[array.count / 2])
