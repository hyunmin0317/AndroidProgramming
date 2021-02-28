

# chap 02-5 프래그먼트 이해하기

2021.02.28



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

* 프래그먼트를 만들어 사용하는 과정

  1. 프래그먼트를 위한 XML 레이아웃 만들기
  2. 프래그먼트 클래스 만들기
  3. 액티비티를 XML 레이아웃에 추가하기

* 화면에 뷰를 추가하는 방법

  1. XML 레이아웃에 추가하는 방법
  2. 자바 소스 코드로 추가하는 방법

* 메인 액티비티에서 프래그먼트를 다루기 위해서 매니저 객체를 참조하는 메서드

  ```java
  public FragmentManager getFragmentManager()
  ```

* 프래그먼트로 화면 만들기 (SampleFragment)

  ![chap02-5/image01](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image01.png?raw=true)

* 프래그먼트가 화면에 보이기 전까지 호출될 수 있는 수명주기 메서드

  |                     메서드                     |                             설명                             |
  | :--------------------------------------------: | :----------------------------------------------------------: |
  |               onAttach(Activity)               |           프래그먼트가 액티비티와 연결될 때 호출됨           |
  |                onCreate(Bundle)                | 프래그먼트가 초기화될 때 호출됨 (새로운 프래그먼트 객체를 만드는 시점 X) |
  | onCreateView(LayoutInflator,ViewGroup, Bundle) |       프래그먼트와 관련되는 뷰 계층을 만들어서 리턴함        |
  |           onActivityCreated(Bundle)            | 프래그먼트와 연결된 액티비티가 onCreate() 메서드의 작업을 완료했을 때 호출됨 |
  |                   onStart()                    | 프래그먼트와 연결된 액티비티가 onStart() 되어 사용자에게 프래그먼트가 보일 때 호출됨 |
  |                   onResume()                   | 프래그먼트와 연결된 액티비티가 onResume() 되어 사용자와 상호작용할 수 있을 때 호출됨 |

* 프래그먼트가 화면에 보이지 않게 되면서 호출되는 상태 메서드

  |     메서드      |                             설명                             |
  | :-------------: | :----------------------------------------------------------: |
  |    onPause()    | 프래그먼트와 연결된 액티비티가 onPause() 되어 사용자와 상호작용을 중지할 때 호출됨 |
  |    onStop()     | 프래그먼트와 연결된 액티비티가 onStop() 되어 화면에서 더 이상 보이지 않을 때나 프래그먼트의 기능이 중지되었을 때 호출됨 |
  | onDestroyView() |   프래그먼트와 관련된 뷰 리소스를 해체할 수 있도록 호출됨    |
  |   onDestroy()   |    프래그먼트의 상태를 마지막으로 정리할 수 있도록 호출됨    |
  |   onDetach()    |     프래그먼트가 액티비티와 연결을 끊기 바로 전에 호출됨     |

* 프래그먼트 객체가 new 연산자로 만들어져도 액티비티 위에 올라가기 전까지는 프래그먼트로 동작하지 않음

  ```java
  MyFragement fragment = new MyFragment();								// 프래그먼트 객체는 만들어졌지만 프래그먼트로 동작하지는 않음
  getSupportFragmentManager().beginTransaction().add(fragment).commit();	// 액티비티에 추가된 후 프래그먼트로 동작함
  ```



### 05-2 프래그먼트로 화면 만들기

* 프래그먼트로 화면 만들기

  ![chap02-5/image02](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image02.png?raw=true)

  

### 05-3 액션바 사용하기

* 화면에 메뉴 기능 넣기

  * 메뉴 기능

    |     속성      |                             설명                             |
    | :-----------: | :----------------------------------------------------------: |
    |   옵션 메뉴   | 시스템 [메뉴] 버튼을 눌렀을 때 나타나는 메뉴로 각 화면마다 설정할 수 있는 주요 메뉴 |
    | 컨텍스트 메뉴 | 화면을 길게 누르면 나타나는 메뉴로 뷰에 설정하여 나타나게 할 수 있고 텍스트뷰의 편집 상태를 바꿀 때 사용함 |

  * 메뉴에 액티비티를 추가하고 싶을 때 사용하는 메서드

    ```java
    public boolean onCreateOptionsMenu(Menu menu)
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    ```

  * 메뉴 아이템을 추가할 수 있는 대표적인 메서드

    ```java
    MenuItem add(int groupId, int itemId, int order, CharSequence title)
    MenuItem add(int groupId, int itemId, int order, int titleRes)
    SubMenu addSubMenu(int titleRes)
    ```

  * showAsAction 속성에 설정할 수 있는 값

    | showAsAction 속성 값 |                             설명                             |
    | :------------------: | :----------------------------------------------------------: |
    |        always        |             항상 액션바에 아이템을 추가하여 표시             |
    |        never         |     액션바에 아이템을 추가하여 표시하지 않음 (디폴트 값)     |
    |        ifRoom        |         액션바에 여유 공간이 있을 때만 아이템을 표시         |
    |       withText       |            title 속성으로 설정된 제목을 같이 표시            |
    |  collapseActionView  | 아이템에 설정한 뷰 (actionViewLayout으로 설정한 뷰)의 아이콘만 표시 |

  * 상단의 액션바에 보이는 메뉴 (SampleOptionMenu)

    ![chap02-5/image03](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image03.png?raw=true)

* 액션바 좀 더 살펴보기

  * 액션바 : 기본적으로 제목을 보여주는 타이틀의 기능을 하고 앱의 제목을 보이거나 보이지 않도록 설정

  * 액션바의 대표 메서드

    ```java
    ActionBar abar = getActionBar();
    abar.show();	// 액션바를 보이게 하는 메서드
    abar.hide();	// 액션바를 감추는 메서드
    ```

  * 액션바의 디스플레이 옵션으로 설정할 수 있는 상수들

    | 디스플레이 옵션 상수 |                       설명                        |
    | :------------------: | :-----------------------------------------------: |
    |   DISPLAY_USE_LOGO   |        홈 아이콘 부분에 로고 아이콘을 사용        |
    |  DISPLAY_SHOW_HOME   |                 홈 아이콘을 표시                  |
    |  DISPLAY_HOME_AS_UP  | 홈 아이콘에 뒤로 가기 모양의 < 아이콘을 같이 표시 |
    |  DISPLAY_SHOW_TITLE  |                   타이틀을 표시                   |

  * 버튼을 눌러 액션바에 아이콘을 표시한 화면

    ![chap02-5/image04](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image04.png?raw=true)

  * 액션바에 보이는 검색어 입력상자

    ![chap02-5/image05](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image05.png?raw=true)

### 05-4 상단 탭과 하단 탭 만들기

* 상단 탭 보여주기
  * 탭 (Tab) : 하나의 뷰에서 여러 개의 정보를 볼 때 일반적으로 사용하는 뷰
  
  * 상단 탭을 눌렀을 때 프래그먼트가 바뀌는 화면 (SampleTab)
  
    ![chap02-5/image06](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image06.png?raw=true)
  
* 하단 탭 보여주기

  * 하단 탭을 눌렀을 때 프래그먼트가 바뀌는 화면 (SampleTab2)

    ![chap02-5/image06](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section5/github/image06.png?raw=true)

    

### 05-5 뷰페이저 만들기

### 05-6 바로가기 메뉴 만들기

