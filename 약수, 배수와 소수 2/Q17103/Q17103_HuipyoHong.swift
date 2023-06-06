//
//  Q17103_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/06/07.
//

/**
 * [ 접근 순서 ]
 * 1. 처음에 set으로 에라토스테네스채를 구현하였지만 n만큼 카운트 돌리기엔 시간제한이 빡세다 그러므로 squareroot n 만큼 카운트 해주고 에라토스테네스채 를 구현해야하지만 set으로는 배수 카운팅을 하지 못함 
 *
 * 2. getPrimeNumberSet메소드에서 에라토스테네스의 채, set화 시켜서 반환
 *
 * 3. getPrimeNumberSum메소드에서 이중 for 문을 돌려도 시간초과, 그래서 원래값 n 에서 첫번째값 f 를 빼준 값이 소수인지 확인하면 골드바흐추측만족
 * 
 * 4. 골드바흐추측의 설명은 링크 참조: https://www.acmicpc.net/problem/9020
 * 
 * ps. 너무 통과되지 않아서 욕하면서 풀었습니다
 *
 *  [ 효율성 ]
 *  - 메모리: 82592KB
 *  - 시간 : 316ms
 */

import Foundation

func getPrimeNumberSet(_ n: Int) -> Set<Int> {
    var array = [Bool](repeating: true, count: n + 1)
    
    for num in 2...Int(sqrt(Double(n))) where array[num] {
        for p in stride(from: num * num, through: n, by: num) {
            array[p] = false
        }
    }
    return Set<Int>((2...n).filter { array[$0] })
}

func getPrimeNumberSum(_ n: Int, _ primeNumberSet: Set<Int>) -> Set<Pair> {
    var pairs = Set<Pair>()
    
    for f in primeNumberSet {
        let s = n - f
        
        if primeNumberSet.contains(s) {
            pairs.insert(Pair(first: min(f, s), second: max(f, s)))
        }
    }
    return pairs
}

func initArray(count n: Int) -> [Int] {
    var inputs = Array(repeating: 0, count: n)
    
    for i in 0..<n {
        guard let input = readLine(), let num = Int(input) else {
            break
        }
        inputs[i] = num
    }
    return inputs
}

if
    let readln = readLine(),
    let count = Int(readln)
{
    let numbers = initArray(count: count)
    let primeNumberSet = getPrimeNumberSet(numbers.max() ?? 1_000_001)

    for num in numbers {
        let result = getPrimeNumberSum(num, primeNumberSet)
        
        print(result.count)
    }
}
        
struct Pair: Hashable {
    let first: Int
    
    let second: Int
}
