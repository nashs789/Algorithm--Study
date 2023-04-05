guard let input = readLine()?.split(separator: " ") else {
    fatalError()
}

let array = input.map { Int($0) ?? 0 }

print((array[4] * array[2] - array[1] * array[5]) / (array[0] * array[4] - array[1] * array[3]), (array[0] * array[5] - array[3] * array[2]) / (array[0] * array[4] - array[1] * array[3]))