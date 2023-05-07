//
//  Q11651_HuipyoHong.swift
//
//
//  Created by 홍희표 on 2023/05/07.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 77600KB
 *  - 시간 : 252ms
 */

if
    let readln = readLine(),
    let count = Int(readln)
{
    Array(0..<count).compactMap { _ in readLine()?.split(separator: " ").map { Int($0) ?? 0 } }
        .sorted { o1, o2 in
            if o1[1] != o2[1] {
                return o1[1] < o2[1]
            } else {
                return o1[0] < o2[0]
            }
        }
        .forEach { print("\($0[0]) \($0[1])") }
}
