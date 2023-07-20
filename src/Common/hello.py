# 배열 인덱싱
hello = "hello";

print("========== [ 배열 인덱싱 ] ==========");
print(hello[0], hello[1], hello[2], hello[3], hello[4]);
print(hello[-1], hello[-2], hello[-3], hello[-4], hello[-5]);

# 문자열 슬라이싱
print("========== [ 문자열 슬라이싱 ] ==========");
print(hello[0:4]);    # 0 ~ 3
print(hello[3:]);    # 3 ~ 4 (생략시 문자열 끝까지)

# 문자열 길이
print("========== [ 문자열 길이 ] ==========");
print(len(hello));

# 숫자(정수, 실수)
num1 = 625;
num2 = 6.25;

print("========== [ 숫자(정수, 실수) ] ==========");
print(type(num1));
print(type(num2));
print(1 + 1.3);    # 정수 + 실수 연산
print(3 / 2);    # 정수 / 정수 (나눗셈)
print(3 // 2);    # 정수 // 정수 (소수점 제외)
print(3 ** 2);    # 제곱 연산자

# 복합 대입 연산자 ex) +=
print("========== [ 복합 대입 연산자 ] ==========");
num3 = 3;
num3 **= 3;

print(num3);

# 콘솔 입력
print("========== [ 콘솔 입력 ] ==========");
#inp = input();

#print(inp);
#print(type(inp));

# 캐스팅 (캐스팅 불가 ===> ValueError)
string = "123";
num4 = "52.2";

print("========== [ 캐스팅 ] ==========");
print(str(num3) + "333");
print(int(string) + 100);
print(type(num4));
print(type(float(num4)));

# format (매개변수와 {}의 개수가 맞지 않으면 ===> IndexError)
print("========== [ format ] ==========");
print("test={}".format(19));
print("00000");
print("{:10d}".format(10000));    # 특정 칸에 출력하기
print("{:05d}".format(33));    # 빈 칸 0으로 채우기
print("{:+d}".format(77));    # 기호 같이 출력하기
print("{: d}".format(77));    # 공백이랑 출력하기
print("{:=+5d}".format(77));    # 기호랑 숫자 사이에 공백 출력하기 == 기호를 앞으로 밀기
print("{:+010}".format(19));    # 기호랑 숫자 사이에 공백 채우기
print("{:f}".format(52.55));    # 실수: f, 정수: d

# 대소문자
print("========== [ upper, lower ] ==========");
print("hello".upper());
print("HELLO".lower());

# 공백 제거하기
print("========== [ strip ] ==========");
print("   hello world!!!   ".strip());    # 양옆
print("   hello world!!!   ".lstrip());    # 왼쪽 공백 제거
print("   hello world!!!   ".rstrip());    # 오른쪽 공백 제거

# 문자열 구성 파악
print("========== [ is{something} ] ==========");
print("asd214".isalnum());    # 알파벳과 숫자로 구성되어 있는지 확인