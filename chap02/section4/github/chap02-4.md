

# chap 02-4 여러 화면 간 전환하기

2021.02.25



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

  ![chap02-4/01]()

  

### 04-2 여러 화면 만들고 화면 간 전환하기

* 안드로이드 앱의 구성 요소 (앱의 4가지 구성 요소의 정보는 AndroidManifest.xml 파일에 담겨 있음)
  * 액티비티
    * 화면을 구현하는 요소로 화면을 필요에 따라 띄우거나 닫는 과정은 액티비티를 전환하는 것과 같음
  * 서비스
  * 브로드캐스트 수신자
  * 내용 제공자
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ
* ㅇ

### 04-3 인텐트 살펴보기

### 04-4 플래그와 부가 데이터 사용하기

### 04-5 태스크 관리 이해하기

### 04-6 액티비티의 수명주기와 SharedPreferences 이해하기



