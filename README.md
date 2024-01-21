# 🚗 자동차 경주 게임
초간단 자동차 경주 게임을 구현한다.

## 🛞 기능 요구 사항
### 게임 시작
- [X] 자동차 이름을 입력할 수 있다.
  - [X] 자동차 이름을 입력할 수 있도록 안내한다.
- [X] 시도 횟수를 입력할 수 있다.
  - [X] 이동을 시도할 횟수를 입력할 수 있도록 안내한다.
### 게임 진행
- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - [X] 0에서 9 사이의 무작위 값이 주어진다.
  - [X] 무작위 값이 4 이상인 경우 전진한다.
- [X] 매 시도마다 실행 결과를 출력한다.
  - [X] 자동차 이름과 해당 자동차의 전진 횟수만큼의 붙임표(-)를 함께 출력한다.
### 자동차
- [X] 자동차는 이름을 가질 수 있다.
  - [X] 자동차 이름은 5자를 초과할 수 없다.
- [X] 자동차는 두 개 이상 입력받아야 한다.
- [X] 여러 대의 자동차들을 입출력할 시 이름을 쉼표(,)를 기준으로 구분한다.
### 게임 종료
- [X] 최종 우승자를 출력한다.
  - [X] 우승자는 한 명 이상일 수 있다.

## 🚘 실행 결과
위 요구 사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

---
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).</br>
pobi,woni,jun</br>
시도할 횟수는 몇 회인가요?</br>
5</br>

실행 결과</br>
pobi : -</br>
woni :</br>
jun : -</br>

pobi : --</br>
woni : -</br>
jun : --</br>

pobi : ---</br>
woni : --</br>
jun : ---</br>

pobi : ----</br>
woni : ---</br>
jun : ----</br>

pobi : -----</br>
woni : ----</br>
jun : -----</br>

최종 우승자: pobi, jun

---