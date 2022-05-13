
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
  * 