//
//  Q1929_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/06/06.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 106572KB
 *  - 시간 : 344ms
 */

import Foundation

func getPrimeNumberSet(_ n: Int) -> Set<Int> {
    var visitedSet = Set<Int>()
    var primeNumberSet = Set<Int>()
    
    for num in 2...n {
        guard !visitedSet.contains(num) else {
            continue
        }
        for p in stride(from: num, through: n, by: num) {
            visitedSet.insert(p)
        }
        primeNumberSet.insert(num)
    }
    return primeNumberSet
}

if
    let readln = readLine()
{
    let rangeArray = readln.split(separator: " ").compactMap { Int($0) }
    let primeNumberSet = getPrimeNumberSet(rangeArray[1])
    
    Array(rangeArray[0]...rangeArray[1]).filter { primeNumberSet.contains($0) }.forEach { print($0) }
}
