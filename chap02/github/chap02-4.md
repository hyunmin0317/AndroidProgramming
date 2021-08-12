

# chap 02-4 여러 화면 간 전환하기

2021.02.25

<br>

### 04-1 레이아웃 인플레이션 이해하기

* 안드로이드 앱의 기본 파일

  * XML 레이아웃 파일: 화면을 어떻게 배치하고 구성하는지 정의한 파일

  * 소스 코드 파일: 화면을 띄우고 앱을 실행하는 등 화면의 기능을 담당하는 파일

  * XML 레이아웃과 소스 코드 파일을 연결하는 방법

    ```java
    setContentView(R.layout.레이아웃파일명);			// R은 res 폴더를 의미함
    ```

  * 인플레이션 (Inflation): 앱이 실행될때 XML 레이아웃의 내용이 메모리에 객체화되는 과정

    - 객체화된 XML 레이아웃을 소스 파일에서 사용

  

* 메인 레이아웃과 부분 레이아웃을 메모리에 객체화하는 방법

  * 메인 레이아웃 - setContentView() 메서드 사용

    * 액티비티의 화면 전체 (메인 레이아웃)를 설정하는 역할

    * setContentView() 메서드가 정의된 형태 (2가지 역할)

      ```java
      public void setContentView (int layoutResID)							// 레이아웃 내용을 메모리에 객체화하는 역할
      public void setContentView (View view, [ViewGroup.LayoutParams params])	// 화면에 나타낼 뷰를 지정
      ```

  * 부분 레이아웃 - 인플레이터 사용

    * 시스템 서비스로 제공되는 LayoutInflater 클래스를 getSystemService() 메서드를 이용하여 참조한 후 사용

    * 액티비티의 부분 화면 (부분 레이아웃)을 설정하는 역할

    * getSystemService() 메서드가 정의된 형태

      ```java
    getSystemService(Context.LAYOUT_INFLATER_SERVICE)
      ```
  
    * LayoutInflater 객체 정의

      ```java
    static LayoutInflater LayoutInflater.from (Context context)
      ```
  
    * LayoutInflater의 inflate() 메서드 정의

      ```java
      View inflate (int resource, ViewGroup root)
      ```
  
* 화면의 일부분을 XML 레이아웃으로 정의하여 추가 (SampleLayoutInflater)

  ![chap02-4/image01](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section4/image01.png?raw=true)

<br>

### 04-2 여러 화면 만들고 화면 간 전환하기

* 안드로이드 앱의 구성 요소 (앱의 4가지 구성 요소의 정보는 AndroidManifest.xml 파일에 담겨 있음)
  * 액티비티
    * 화면을 구현하는 요소로 화면을 필요에 따라 띄우거나 닫는 과정은 액티비티를 전환하는 것과 같음
  * 서비스
  * 브로드캐스트 수신자
  * 내용 제공자
  
* 액티비티 메서드

  * 액티비티를 소스 코드에 띄우는 메서드 - startActivity()

    * 단순히 액티비티를 띄워 화면에 보이는 메서드

  * 액티비티를 선택하여 띄우며 원래 액티비티로 돌아올 때 응답을 받아 처리하는 메서드 - startActivityForResult()

    *  startActivityForResult() 정의

      ```java
       startActivityForResult(Intent intent, int requestCode)
      ```

    * 새 액티비티에서 원래의 액티비티로 돌아올 때 응답을 받아 처리하고 어떤 액티비티에서 돌아온 응답인지 구분해야 할 때 사용됨

* 화면의 일부분을 XML 레이아웃으로 정의하여 추가 (SampleIntent)

  ![chap02-4/image02](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section4/image02.png?raw=true)


<br>

### 04-3 인텐트 살펴보기

* 인텐트의 역할과 사용 방식
  * 앱 구성 요소 간에 작업 수행을 위한 정보를 전달하는 역할을 하며 android.content 패키지 안에 정의되어 있음
  
  * 다른 앱 구성 요소에 인텐트를 전달할 수 있는 대표적인 메서드
  
    * startActivity() 또는 startActivityForResult() : 액티비티를 화면에 띄울 때 사용
    * startService() 또는 bindService() : 서비스를 시작할 때 사용
    * broadcastIntent() 인텐트 객체를 브로드캐스팅 방식으로 전송할 때 사용 
  
  * 인텐트의 기본 구성 요소
  
    * 액션 (Action) : 수행할 기능
  
    * 데이터 (Data) : 액션이 수행될 대상의 데이터
  
    * 액션과 데이터를 사용하는 대표적인 예
  
      |                  속성                   |                             설명                             |
      | :-------------------------------------: | :----------------------------------------------------------: |
      |       ACTION_DIAL tel:01077881234       |       주어진 전화번호를 이용해 전화걸기 화면을 보여줌        |
      |       ACTION_VIEW tel:01077881234       | 전화걸기 화면을 보여줌, URL 값의 유형에 따라 VIEW 액션이 다른 기능을 수행함 |
      | ACTION_EDIT content://contacts/people/2 | 전화번호부 데이터베이스에 있는 정보 중에서 ID 값이 2인 정보를 편집하기 위한 화면을 보여줌 |
      |  ACTION_VIEW content://contacts/people  |           전화번호부 데이터베이스의 내용을 보여줌            |
  
  * 인텐트의 생성자
  
    ```java
    Intent()
    Intent(Intent o)
    Intent(String action [,URI uri])
    Intent(Context packageContext, Class<?> cls)
    Intent(String action, Uri uri, Context packageContext, Class<?> cls)
    ```
  
* 명시적 인텐트 (Explicit Intent) : 인텐트에 클래스 객체나 컴포넌트 이름을 지정하여 호출할 대상을 확실히 알 수 있는 경우

* 암시적 인텐트 (Implicit Intent) : 액션과 데이터를 지정하긴 했지만 호출할 대상이 달라질 수 있는 경우

  * MIME 타입에 따라 시스템에서 적절한 다른 앱의 액티비티를 찾은 후 띄우는 방식
  * 암시적 인텐트의 대표적인 속성
    * 범주 (Category) : 액션이 실행되는 데 필요한 추가적인 정보를 제공
    * 타입 (Type) : 인텐트에 들어가는 데이터의 MIME 타입을 명시적으로 지정
    * 컴포넌트 (Component) : 인텐트에 사용될 컴포넌트 클래스 이름을 명시적으로 지정
    * 부가 데이터 (Extra Data) : 인텐트의 번들 객체에 담을 수 있는 추가적인 정보

* 인텐트의 액션을 이용한 전화걸기 (SampleCallIntent)

  ![chap02-4/image03](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section4/image03.png?raw=true)


<br>

### 04-4 플래그와 부가 데이터 사용하기

* 플래그

  * 동일한 액티비티를 여러 번 실행하여 동시에 데이터를 여러 번 접근하거나 리소스를 여러 번 사용하는 문제를 해결할 수 있도록 도와줌
  * 대표적인 플래그들
    * FLAG_ACTIVITY_SINGLE_TOP : 액티비티를 생성할 때 이미 생성된 액티비티가 있으면 그대로 사용하라는 플래그
    * FLAG_ACTIVITY_NO_HISTORY : 처음 이후에 실행된 액티비티는 액티비티 스택에 추가되지 않는 플래그
    * FLAG_ACTIVITY_CLEAR_TOP : 이 액티비티 위에 있는 다른 액티비티를 모두 종료시키는 플래그

* 부가 데이터

  * 한 액티비티에서 다른  액티비티를 띄울 때 데이터를 전달해야 하는 경우에 사용됨 

  * 시스템에서는 건드리지 않고 다른 앱 구성 요소로 전달되며 번들 객체 안에 넣은 데이터

  * 부가 데이터를 사용하는 대표적인 메서드

    ```java
    Intent putExtra(String name, String value)
    Intent putExtra(String name, int value)
    Intent putExtra(String name, boolean value)
    
    String getStringExtra(String name)
    int getIntExtra(String name, int defaultValue)
    boolean getBooleanExtra(String name, boolean defaultValue)
    ```

<br>

### 04-5 태스크 관리 이해하기

* 프로세스와 태스크

  * 프로세스 : 독립적인 하나의 상자로 다른 프로세스와 어떤 정보를 공유할 수 없음
  * 태스크 : 시스템에서 액티비티의 각종 정보를 저장하기 위해 만드는 것

* 프로세스와 태스크를 이용한 앱을 실행한 화면 (SampleTatk)

  ![chap02-4/image04](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section4/image04.png?raw=true)


<br>

### 04-6 액티비티의 수명주기와 SharedPreferences 이해하기

* 액티비티의 대표적인 상태 정보

  |        상태        |                             설명                             |
  | :----------------: | :----------------------------------------------------------: |
  |   실행 (Running)   | 화면상에 액티비티가 보이면서 실행되어 있는 상태, 액티비티 스택의 최상위에 있으며 포커스를 가지고 있음 |
  | 일시 정지 (Paused) | 사용자에게 보이지만 다른 액티비티가 위에 있어 포커스를 받지 못하는 상태, 대화상자가 위에 있어 일부가 가려진 경우에 해당함 |
  |   중지 (Stopped)   |     다른 액티비티에 의해 완전히 가려져 보이지 않는 상태      |

* 액티비티의 상태 메서드

  * onCreate()
    * 액티비티가 처음에 만들어졌을 때 호출되며 화면에 보이는 뷰들의 일반적인 상태를 설정하는 부분
    * 이전 상태가 저장되어 있는 경우에는 번들 객체를 참조하여 이전 상태 복원 가능하며 이 메서드 다음에는 항상 onStart() 메서드가 호출됨
  * onStart()
    * 액티비티가 화면에 보이기 바로 전에 호출되고 액티비티가 화면 상에 보이면 이 메서드 다음에 onResume() 메서드가 호출됨
    * 액티비티가 화면에서 가려지게 되면 이 메서드 다음에 onStop() 메서드가 호출됨
  * onResume() 
    *  액티비티가 사용자와 상호작용하기 바로 전에 호출됨
  * onPause()  
    * 또 다른 액티비티를 시작하려고 할 때 호출됨 
    * 저장되지 않은 데이터를 저장소에 저장하거나 애니메이션 중인 작업을 중지하는 등의 기능을 수행하는 메서드
    * 메서드가 리턴하기 전에는 다음 액티비티가 시작될 수 없으므로 이 작업은 매우 빨리 수행된 후 리턴되어야 함
    * 액티비티가 이 상태에 들어가면 시스템은 액티비티를 강제 종료할 수 있음  
  * onStop()  
    * 액티비티가 사용자에게 더 이상 보이지 않을 때나 액티비티가 소멸되거나 또 다른 액티비티가 화면을 가릴 때 호출됨 
    * 액티비티가 이 상태에 들어가면 시스템은 액티비티를 강제 종료할 수 있음   
  * onDestroy()  
    * 액티비티가 소멸되어 없어지기 전에 호출됨
    * 이 메서드는 액티비티가 받는 마지막 호출이 됨 액티비티가 앱에 의해 종료되거나 시스템이 강제로 종료시키는 경우에 호출됨
    * 위 두 가지 경우를 구분할 때 isFinishing() 메서드를 이용함
    * 액티비티가 이 상태에 들어가면 시스템은 액티비티를 강제 종료할 수 있음

* 액티비티 수명주기를 보여주는 앱 실행 화면

  ![chap02-4/image05](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section4/image05.png?raw=true)

  