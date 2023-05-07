//
//  Q2751_HuipyoHong.swift
//
//
//  Created by 홍희표 on 2023/05/07.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 81712KB
 *  - 시간 : 1280ms
 */

let count = Int(readLine()!)!

(0..<count).map { i -> Int in Int(readLine()!)! }.sorted().forEach { print($0) }
