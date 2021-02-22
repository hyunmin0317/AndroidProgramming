# chap 01-3 첫 번째 앱 만들기.

​																																											2021.02.22



### 03-1 첫 프로젝트 만들기

### 03-2 에뮬레이터로 Hello World 앱 실행하기



### 03-3 Hello 프로젝트 하나씩 바꾸어보기

* [확인 1] 버튼 추가

  ![char03-1_1](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap01/section3/github/chap01-3_1.png?raw=true)



### 03-4 여러 개의 버튼 추가하기

* [네이버 접속하기], [전화 걸기] 버튼 추가

  ![char03-1_2](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap01/section3/github/chap01-3_2.png?raw=true)

* [네이버 접속하기] 기능

  ![char03-1_3](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap01/section3/github/chap01-3_3.png?raw=true)

* [전화 걸기] 기능

  ![char03-1_4](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap01/section3/github/chap01-3_4.png?raw=true)

* char01-3 주요 내용 정리

  |            알아둘 내용            |                             설명                             |
  | :-------------------------------: | :----------------------------------------------------------: |
  |          프로젝트 만들기          |  안드로이드 스튜디오에서 안드로이드 프로젝트를 만들 수 있음  |
  |         setContentView()          |         화면에 무엇을 보여줄지 결정하는 함수(메서드)         |
  |      R.layout.activity_main       |         화면에 보여줄 대상이 되는 XML의 위치를 지정          |
  | /app/res/layout/activity_main.xml | 소스에서 R.layout.activity_main이라고 입력하여 가져올 수 있는 프로젝트 안의 파일이며, 화면을 구성할 때 사용 |
  |             text 속성             |         화면에 보이는 글자를 변경할 때 사용하는 속성         |
  |           onClick 속성            | 버튼을 클릭했을 때 어떤 메서드를 실행할 것인지 간단하게 지정할 수 있는 속성 |
  |              Intent               |           어떤 기능을 실행할 것인지 지정할 때 사용           |
  |               Toast               | 화면에 잠깐 보였다 없어지는 메시지를 간단하게 보여주고 싶을 때 사용 |