//
//  Q10814_HuipyoHong.swift
//
//
//  Created by 홍희표 on 2023/05/07.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 82288KB
 *  - 시간 : 332ms
 */

if
    let readln = readLine(),
    let count = Int(readln)
{
    Array(0..<count).compactMap { _ in readLine()?.split(separator: " ") }
        .sorted { Int($0[0])! < Int($1[0])! }
        .forEach { print("\($0[0]) \($0[1])") }
}
