//
//  Q4948_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/06/04.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 79508KB
 *  - 시간 : 880ms
 */

import Foundation

func isPrimeNumber(_ n: Int) -> Bool {
    guard n > 3 else { return true }
    for i in 2...Int(sqrt(Double(n))) {
        if n % i == 0 {
            return false
        }
    }
    return true
}

while
    let input = readLine(),
    var n = Int(input),
    n != 0
{
    var count = 0
    
    for num in n + 1...2 * n {
        if isPrimeNumber(num) {
            count += 1
        }
    }
    print(count)
}
