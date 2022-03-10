# 편하지만 조심하기! - lombok

## @Data

- @RequiredArgsConstructor + @Getter + @Setter + @ToString + @EqualsAndHashCode
- 각 어노테이션의 주의사항을 모두 포함한다
- 편리해서 쉽게 사용하지만 모든 단점을 동반하기에, 가급적 필요한 어노테이션만 각각 선언해서 사용하도록!

## @AllArgsConstructor / @RequiredArgsConstructor

- @AllArgsConstructor : 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성한다.
- @RequiredArgsConstructor: 클래스에 존재하는 필드에서 final, @Notnull 이 붙은 인스턴스 멤버들에 대해 생성자를 생성한다.
- 단점 : 필드들의 순서가 바뀔경우 컴파일 오류는 발생하지 않지만, 순서에 영향을 받기때문에 값이 바뀌는 상황이 발생할 수 있다.

## @NoArgsConstructor

- 파라미터가 없는 생성자를 생성한다.
- 필드들이 final로 생성되어잇는 경우에는 필드를 초기화할 수 없기 때문에 생성자를 만들 수 없고 에러 발생
    - @NoArgsConstructor(force=true)옵션을 이용해 final 필드를 강제 초기화 시켜 생성자를 만들 순 있다.
- @Nonnull 같이 필드에 제약조건이 설정되어 있는 경우, 추후 초기화를 진행하기 전까지 생성자 내 null-check 로직이 생성되지 않는다.

## @Builder

- 객체 생성이 명확해진다. 가급적 클래스 보다는 직접 만든 생성자, 또는 static 객체 생성 메소드에 붙이는것을 원장한다.
- 파라미터 순서가 아닌, 이름으로 값을 설정하기 때문에 AllArgsConstructor나 RequiredArgsConstructor에서의 필드 순서에 영향을 받지 않기 때문에 리팩토링에 유연하게 대응할 수 있고, 필드 순서가 변경되어도 문제가 없다.

## @Getter / @Setter

- @Getter : 값에 접근은 가능하지만 변경할 수 없다.
- @Setter : 꼭 필요한 경우에만 설정한다, 값을 바꿀 수 있는 어노테이션이기 때문에 값을 바꿀 수 있는 경우에만 설정한다. (데이터의 안전성을 보장받지 못함!)
