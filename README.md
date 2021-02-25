# java-calculator
문자열 계산기 미션 저장소

## 단위 테스트 실습 - 문자열 계산기
- 다음 요구사항을 junit을 활용해 단위 테스트 코드를 추가해 구현한다.
## 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

---

## 힌트
- 문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.
```java
String value = scanner.nextLine();
String[] values = value.split(" ");
```
- 문자열을 숫자로 변경하는 방법

`int number = Integer.parseInt("문자열");`

---

### 기능
- 예외
  - [x] 숫자로 시작하지 않을 경우
  - [x] 띄어쓰기가 잘 안 돼서 숫자와 문자가 섞였을 경우(공백문자 미사용)
  - [x] 숫자와 연산자 이외의 문자
  - [x] 연산자나 숫자가 두 번 이상 연속으로 나올 경우
- 순서
  - [x] 문자열 입력 받기
  - [x] 띄어쓰기로 분리해서 배열에 넣기
    - [x] 예외 처리
  - [x] 피연산자(operand 숫자)와 연산자(operator +-/*)로 나누기
  - [x] 계산하기
