//
//  Q1934_HuipyoHong.swift
//  
//
//  Created by 홍희표 on 2023/05/29.
//

import Foundation

guard let count = readLine() else {
    fatalError()
}

func gcd(_ a: Int, _ b: Int) -> Int {
    return 0 == a % b ? min(a, b) : gcd(b, a % b)
}

func lcm(_ a: Int, _ b: Int) -> Int {
    return a * b / gcd(a, b)
}

for _ in 0..<Int(count)! {
    let input = readLine()!
    let array = input.split(separator: " ").map { Int($0) ?? 0 }
    
    print(lcm(array.first ?? 0, array.last ?? 0))
}
