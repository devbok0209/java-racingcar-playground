
---
## 문자열 덧셈 계산기를 통한 TDD 리팩토링

---
1. 기능 요구사항 분석
```
1. 쉼표, 콜론이 있는 문자열 -> 숫자 합으로 반환
2. //{?}\n -> ? = 커스텀 구분자 체크
3. 숫자 이외의 값, 음수는 -> RunTimeException throw
```

* 왜 matcher는 find -> group?
* @MethodSource 사용 계기
* Dangling meta character
* https://www.yawintutor.com/java-util-regex-patternsyntaxexception-dangling-meta-character-near-index-0/
* RunTimeException을 사용하지 않는 이유
  * http://cris.joongbu.ac.kr/course/java/api/java/lang/IllegalArgumentException.html
  * https://cwe.mitre.org/data/definitions/397.html
  * https://wiki.sei.cmu.edu/confluence/display/java/ERR07-J.+Do+not+throw+RuntimeException%2C+Exception%2C+or+Throwable

---

### 레이싱 카
1. 기능 요구사항 분석
   자동차 이름 길이 체크 테스트 구현 √
   차이름 : --(전진 길이) 출력 테스트 구현
   자동차 ',' 쪼갰을때 3대 자동차 인지 체크 테스트 √
   전진 여부는 랜덤 값중 값이 4 이상일 때만 하도록 체크 테스트 √
   자동차 우승자 1명 이상인지 체크 √
   우승한 자동차 이름 체크 :: pobi, honux가 최종 우승했습니다.


N번 반복 수행시, 가장 큰 place = 우승자
우승자 리스트에 담는다
리스트가 1보다 크거나 같아야한다.


경주 후 가장 큰 place 값을 기준으로 
리스트에 갸보다 큰 거나 같은 것을 넣는다.