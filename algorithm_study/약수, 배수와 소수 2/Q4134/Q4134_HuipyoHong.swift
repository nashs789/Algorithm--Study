//
//  Q4134_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/05/31.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 79508KB
 *  - 시간 : 136ms
 */

import Foundation

func isPrimeNumber(_ n: Int) -> Bool {
    for i in 2...Int(Double(n).squareRoot()) {
        if n % i == 0 {
            return false
        }
    }
    return true
}

if
    let readln = readLine(),
    let count = Int(readln)
{
    for _ in 0..<count {
        guard let input = readLine(), var n = Int(input) else {
            break
        }
        if n > 3 {
            while !isPrimeNumber(n) {
                n += 1
            }
        }
        print(n < 2 ? 2 : n)
    }
}
