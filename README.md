# 💰 로또 게임
> 본 프로젝트는 [JunHoPark93님이 정리하신 우아한 형제들의 프리코스, 3주차 미션인 로또 프로젝트](https://github.com/JunHoPark93/woowacourse-projects) 입니다.	

## 기능 목록	
- 로또 게임 실행 및 종료
- 사용자 구매 금액에 따른 로또종이 발급 (1,000원 기준)
- 8개의 랜덤한 숫자 발급받아 로또종이에 저장
- 사용자가 발급받은 로또종이 묶음 저장
- 사용자로부터 당첨 번호 6개와 보너스 번호 입력 받기
- WinningLotto 클래스를 통해 로또 번호 매칭 시키기
- 사용자가 벌어들인 돈을 저장
- 사용자가 벌어들인 돈과 투자한 돈 비교 후 수익률 반환 (소수점 3자리 까지)

## 프로그램 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
- else 예약어를 쓰지 않는다.
- public/protected/private/package 접근 제어자를 용도에 적합하게 사용해 구현한다.
- **함수의 길이가 10라인을 넘어가지 않도록 구현**한다.
- **indent depth를 2가 넘어가지 않도록 구현한다. 1까지만 허용**한다.
- **함수의 인자 수를 3개까지만 허용**한다. 
- 추가 요구사항

```java
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
}
```
* 다음 Lotto 객체를 활용해 구현해야 한다. 
* Lotto 기본 생성자를 추가할 수 없다. 
* numbers 변수의 접근 제어자인 private을 변경할 수 없다. 
* Lotto에 필드(인스턴스 변수)를 추가할 수 없다.

```java
/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }
}
```
* 다음 WinningLotto 객체를 활용해 구현해야 한다. 
* match() 메소드의 반환 값인 Rank는 저장소에서 제공한다. 
* WinningLotto 기본 생성자를 추가할 수 없다. 
* lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다. 
* WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.

