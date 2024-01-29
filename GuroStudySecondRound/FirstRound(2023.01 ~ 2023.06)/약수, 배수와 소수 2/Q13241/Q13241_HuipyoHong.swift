//
//  Q13241_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/06/06.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 69104KB
 *  - 시간 : 8ms
 */

import Foundation

guard let input = readLine() else {
    fatalError()
}

let array = input.split(separator: " ").map { Int($0) ?? 0 }

func gcd(_ a: Int, _ b: Int) -> Int {
    return 0 == a % b ? min(a, b) : gcd(b, a % b)
}

func lcm(_ a: Int, _ b: Int) -> Int {
    return a * b / gcd(a, b)
}

print(lcm(array.first ?? 0, array.last ?? 0))
