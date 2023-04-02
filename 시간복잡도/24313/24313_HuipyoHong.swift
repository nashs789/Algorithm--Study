//
//  24313_HuipyoHong.swift
//
//
//  Created by 홍희표 on 2023/04/01.
//

import Foundation

guard
    let first = readLine(),
    let second = readLine(),
    let third = readLine()
else {
    fatalError()
}
let ab = first.split(separator: " ")

let a = Int(ab[0]) ?? 0, b = Int(ab[1]) ?? 0, c = Int(second) ?? 0, d = Int(third) ?? 0

func f(_ a: Int, _ b: Int, n: Int) -> Int {
    return a * n + b
}

func g(_ c: Int, n: Int) -> Int {
    return c * n
}

print(f(a, b, n: c) <= g(c, n: d) ? 1 : 0)
