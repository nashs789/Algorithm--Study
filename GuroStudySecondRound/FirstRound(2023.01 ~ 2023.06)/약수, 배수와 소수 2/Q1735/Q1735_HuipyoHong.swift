//
//  Q1735_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/05/29.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 69104KB
 *  - 시간 : 8ms
 */

import Foundation

func gcd(_ a: Int, _ b: Int) -> Int {
    return 0 == a % b ? min(a, b) : gcd(b, a % b)
}

if
    let readlnFirst = readLine(),
    let readlnSecond = readLine()
{
    let first = readlnFirst.split(separator: " ").compactMap { Int($0) }
    let second = readlnSecond.split(separator: " ").compactMap { Int($0) }
    let (a, b, c, d) = (first[0], first[1], second[0], second[1])
    var numberator = a * d + c * b // 두 분수의 분자의 합
    var denominator = b * d // 두 분수의 분모의 곱
    let gcd = gcd(numberator, denominator) // 최대공약수 구하기
    numberator /= gcd
    denominator /= gcd
    
    print(numberator, denominator)
}
