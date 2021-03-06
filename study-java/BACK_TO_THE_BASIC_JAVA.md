# Back to the Basic, JAVA - OOP / JAVA 기본개념

## 데이터 타입
*  Primitive data type
    ```
    - int, boolean과 같은 객체가 아닌 순수한 데이터 타입
    - boolean, char, byte, short, int, long, float, double
    ```
  * Reference data type
    ```
    - Primitive 데이터 타입을 제외한 모든 객체 데이터 타입
    - Primitive 데이터 타입도 각 타입에 해당하는 Wrapper 클래스를 이용해 객체로 변환할 수 있다. 
      (예, Integer, Boolean, Character 등)
    ```

## 생성자(Constructor)
  - new 키워드를 이용하여 객체로 생성
  - 생성자 제약사항 ☝️
    ! 생성자 명은 클래스명과 동일해야 하고, 리턴타입이 없어야 한다.
    ! 접근제한자가 반드시 public 타입이어야 한다.


## 객체지향 프로그래밍이란?
- OOP, Object Oriented Programming


#### OOP 특징
  - 상속성 (Inheritance)
    - 상위 클래스(부모)의 특징을 하위(자식)클래스가 모두 물려받는다.
    - 자식 클래스는 부모 클래스의 멤버변수와 메소드를 모두 물려받아 사용할 수 있다.
    - 요약!
    다른 클래스의 멤버 변수나 메소드를 자신의 것처럼 사용할 수 있다.
    ⭐️ 오버로딩, 오버라이딩, this와 super 등의 문법이 생김
  - 캡슐화 (Encapsulation)
    - <b>실제기능</b>은 숨기고 <b>접근할 방법</b>만 노출
    - 어떻게 구현되어 있는지는 전혀 관심을 두지 않고, 어떻게 접근하여 사용하는 것인지만 중요
    - 대표적인 예는 라이브러리! (사용방법만 궁금하지, 구현체는 궁금해하지 않음)
    - 프로그램의 복잡도를 줄이는데 사용된다. 알 필요가 없는 정보를 숨겨 복잡도를 최소화 한다.
    - 이러한 정보의 노출 여부를 은닉성(Hidden)이라고 한다.
    - 캡슐화를 위해 접근제한자(Access Modifier)를 제공

      ```
        - 접근 가능 범위 (뒤로 갈 수록 범위가 넓어짐)
        private -> default -> protected -> public

        - private : 외부에서 접근 불가
        - default : 같은 패키지의 객체만 접근 가능
        - protected : 상속 관계의 객체만 접근 가능, 일반 객체는 접근 불가
        - public : 모든 객체에서 접근 가능
      ```
  - 추상화 (Abstraction)
    - 객체의 공통적인 특징을 뽑아내는 과정, 객체가 단순하게 표현하는것이 가능해진다.
    - 추상화 과정
      ```
        1. 객체들이 공통적으로 가지고 있는 개념을 추출한다.
        2. 공통 개념이 추출되면, 추출한 개념을 이용해 최소한의 기능을 가진 상위 개념 객체를 만든다.
        3. 나머지 객체는 상위 개념의 객체를 상속받아 구현하는 형태로 변경한다.
      ```
  - 다형성 (Polymorphism)
    - 객체간의 결합도를 줄이기 위해 도입된 개념
    - 상속과 추상화는 다형성 구현과 밀접한 관계가 있다.
    - <b>객체는 여러가지 형태를 가질 수 있다!</b>가 기본 개념
    - 예) Map map = new HashMap(), Map map = new LinkedHashMap() 등

## JVM 메모리 구조
- 자바 소스코드의 컴파일 결과물인 바이트 코드를 실행하기 위한, 일종의 가상 OS
- JVM 안에는 Java SE API가 모두 구현되어 있다.
- 런타임 데이터 영역
  - 메소드 영역
    ```
    - 런타임 시 생성된 모든 스레드가 공유하는 영역
    - 클래스로더에서 읽어 들인 바이트 코드를 저장해 두고 이용해 모든 클래스를 분석한다.
    - 분석이 완료되면 클래스 정보와 메소드 정보등을 생성하고 Static 변수를 생성한다.
    - OutOfMemory 원인 : 분석된 클래스 정보가 메소드 영역에서 클래스 분석 때 사용하는 메모리 공간보다 크기 때문에

    - JVM이 기본적으로 할당받는 메소드 영역의 메모리 자이즈는 일정하게 정해져 있다.
    OOM 발생 시 옵션을 이용해 사이즈를 늘리면 된다.
    ```
  - 스택 영역
    ```
    - JVM 스택, 호출 스택(Call Stack)등의 이름으로 불린다.
    - 프로세스 내부에 생성된 스레드마다 생성되며 메소드 동작을 위한 메모리 공간을 제공한다.

    - 이 영역에 메소드 정보, 지역변수 정보, 파라미터 값 등이 저장된다.
    - 호출된 메소드가 실행되면 스택프레임 이라는 자료구조가 생성되고, 실행 순서에 따라 동작을 수행하다가 완료되면 메모리에서 사라진다.

    - 프로그램 실행 시 예외(Exception)가 발생하면 printStackTrace() 등의 메소드로 예외가 발생한 스택 프레임 정보를 볼 수 있다.
    ```
  - 힙 영역
    ```
    - new 키워드를 이용하여 객체를 생성하면 생성된 객체는 힙영역에 저장된다.
    - 이 영역은 런타임 시 생성되는 객체를 저장하는 공간으로, 자바에서 가비지 컬렉션(GC)이 수행되는 영역이다.

    - 힙 영역이 가득차면 가비지 컬렉터가 실행되는데, 빈번하게 발생하면 성능이 저하되기 때문에 힙 사이즈를 적절히 변경해야 한다.
    ```
    - 가비지 컬렉션 : 메모리 상의 쓰레기를 제거하는 작업으로 불필요한 메모리 공간을 정리하는 역할을 한다.
  - 정리 !
    - 메소드 영역 : 분석이 완료 된 클래스와 메소드 정보를 생성하고 Static 변수를 생성
    - 스택 영역 : 메소드 동작을 위한 공간을 제공, 호출된 메소드, 변수정보, 파라미터 값 등이 저장되고 동작이 완료되면 사라진다.
    - 힙 영역 : 생성자를 이용해 성생된 객체는 힙 영역에 저장, 가비지 컬렉션(GC)를 수행

    # Back to the Basic, JAVA - Java Collection

    ## Collection 프레임워크, JCF
      - java.util.Collection 인터페이스를 상속받은 Set, List 계열의 자료구조와 java.util.Map 인터페이스를 상속받은 Map계열의 자료 구조로 나눌 수 있다.

      | 계열 | 인터페이스 | 특 징 |
      | :----- | :---:| ------------- |
      |Collection|Set|중복을 허용하지 않고 순서가 없다.|
      |Collection|List|중복을 허용하고 순서가 있다.|
      |Collection|Queue|FIFO방식으로 처음 넣은 자료가 처음 나온다.|
      |Map|Map|키(Key)와 값(Value)가 하나의 자료로 저장된다.|


      - Vector 클래스와 HashTable 클래스를 사용하지 않는 이유
        - 성능을 보강한 다양한 자료구조가 추가되면서 권장하지 않는다.
        - <b>멀티스레드 상황에서 안전하게 동작하기 위해 내부적으로 동기화 작업을 수행</b>한다.
        하지만 멀티스레드 환경이 아닌 경우가 대부분이라서 이는 오히려 성능을 떨어뜨리는 중요한 요인으로 작용한다.
        - 하위 호환을 위해 남겨두었지만 Vector 대신 ArrayList 클래스를, HashTable 클래스 대신 HashMap 클래스를 사용하길 권장한다.

    ### 컬렉션 뷰(Collection View)
      - Enumeration(구)과 Iterator(신)의 차이
        - Iterator에서만 remove() 제공한다.
        - Iterator에서는 앞방향으로 이동이 가능하다.
          - hasPrevious(), previous()

    ### 컬렌션 정렬
    - 가장 손쉬운 방법은 기본 정렬을 제공하는 TreeSet이나 TreeMap 컬렉션을 이용한다.
    - Comparable, Comparator 인터페이스를 이용해 정렬 가능하다.
    - Comparator의 compare을 이용해 원하는 조건으로 정렬이 가능하다.

    ### JCF 유틸리티
    - sort : 리스트를 정렬한다.
    - binarySearch : Binary Search 알고리즘을 이용하여 리스트에서 원하는 객체를 찾아준다.
    - reverse : 정렬된 리스트를 반대로 재정렬한다.
    - suffle : 정렬된 리스트를 무작위로 섞는다.
    - fill : 리스트의 모든 객체를 인자로 넘어온 객체로 변경한다.
    - copy : 리스트를 복사한다.
    - min : 컬렉션에서 가장 작은 객체를 리턴한다.
    - max : 컬렉션에서 가장 큰 객체를 리턴한다.
    - rotate : 리스트를 distance만큼 순환시킨다.
    - replaceAll : 리스트에 있는 oldValue를 newValue로 교체한다.
    - indexOfSubList : target 리스트에서 source리스트를 포함하고 있을 경우 source리스트의 종료위치를 리턴한다.
    - swap : 리스트의 x와 y위치의 객체를 교환한다.
    - addAll : 모든 인자를 합한다.
