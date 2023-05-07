//
//  Q1427_HuipyoHong.swift
//
//
//  Created by 홍희표 on 2023/05/07.
//

/**
 *  [ 효율성 ]
 *  - 메모리: 69104KB
 *  - 시간 : 8ms
 */

print(readLine()!.map { Int(String($0))! }.sorted(by: >).map { String($0) }.joined())
