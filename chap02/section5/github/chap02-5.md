

# chap 02-5 프래그먼트 이해하기

2021.02.27



### 05-1 프래그먼트란?

* 프래그먼트

  * 하나의 화면을 여러 부분으로 나눠서 보여주거나 각각의 부분 화면 단위로 바꿔서 보여주고 싶을 때 사용함
  * 태블릿처럼 큰 화면의 단말을 지원하려고 시작했는데 지금은 단말의 크기와 상관없이 화면 UI를 만들 때 많이 사용됨
  * 하나의 화면 안에 들어가는 부분 화면과 같아서 하나의 레이아웃처럼 보이지만 액티비티처럼 독립적으로 동작하는 부분 화면을 만들 때 사용됨 

* 프래그먼트 사용 목적 : 분할된 화면들을 독립적으로 구성하고 상태를 관리하기 위해 사용함

* 프래그먼트를 화면에 추가하는 방법 이해하기

  * 프래그먼트 클래스 (Flagment) 주요 메서드

    ```java
    public final Activity getActivity()					// 이 프래그먼트를 포함하는 액티비티를 반홤함
    public final FragmentManager getFragmentManager()	// 액티비티에서 프래그먼트 객체들과 의사소통하는 프래그먼트 매니저를 반환함
    public final Fragment getParentFragment()			// 이 프래그먼트를 포함하는 부모가 프래그먼트일 경우 리턴함 (액티비티는 null)
    public final int getId()							// 이 프래그먼트의 ID를 반환함
    ```

  * 프래그먼트 매니저 : 레이아웃 파일이 아닌 코드에 프래그먼트를 추가하고 싶다면 프래그먼트 관리를 담당하는 프래그먼트 매니저를 사용해야함

  * 프래그먼트 매니저 (FragmentManager) 주요 메서드

    ```java
    public abtract FragementTransaction beginTransaction()		// 프래그먼트를 변경하기 위한 트랜잭션을 시작함
    public abtract Fragement findFragmentById(int id)			// ID를 이용해 프래그먼트 객체를 찾음
    public abtract Fragement findFragmentByTag(String tag)		// 태그 정보를 사용해 프래그먼트 객체를 찾음
    public abtract boolean executePendingTransactions()
    // 트랜잭션은 commit() 메서드를 호출하면 실행되지만 비동기(asynchronous) 방식으로 실행되므로 즉시 실행하고 싶다면 메서드를 추가로 호출해야 함
    ```

  * 프래그먼트의 특성

    |     특성      |                             설명                             |
    | :-----------: | :----------------------------------------------------------: |
    |    뷰 특성    | 뷰그룹에 추가되거나 레이아웃의 일부가 될 수 있음 (뷰에서 상속받은 것은 아니며 뷰를 담고 있는 일종의 틀임) |
    | 액티비티 특성 | 액티비티처럼 수명주기 (Lifecycle) 가지고 있음 (컨텍스트 객체는 아니며 라이프사이클은 액티비티에 종속됨) |

### 05-2 프래그먼트로 화면 만들기

### 05-3 액션바 사용하기

### 05-4 상단 탭과 하단 탭 만들기

### 05-5 뷰페이저 만들기