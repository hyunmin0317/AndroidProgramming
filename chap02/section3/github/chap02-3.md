# chap 02-3 기본 위젯과 드로어블 사용하기

​																																											2021.02.24



### 03-1 기본 위젯 다시 한 번 자세히 공부하기

* 텍스트뷰에 maxLines 속성을 설정한 결과

  ![chap02-3_1](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_1.png?raw=true)

* 라디오 버튼과 체크 박스를 추가한 화면 레이아웃

  ![chap02-3_2](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_2.png?raw=true)

* 에디트텍스트를 추가한 화면 레이아웃

  ![chap02-3_3](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_3.png?raw=true)

* 이미지 버튼과 이미지뷰를 추가한 화면 레이아웃

  ![chap02-3_4](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_4.png?raw=true)

### 03-2 드로어블 만들기

* 다양한 기능의 드로어블

  |    드로어블     |                             설명                             |
  | :-------------: | :----------------------------------------------------------: |
  | 비트맵 드로어블 | 이미지 파일을 보여줄 때 사용하며 비트맵 그래픽 파일 (png, jpg 등)을 사용해서 생성 |
  |  상태 드로어블  |             상태별로 다른 비트맵 그래픽을 참조함             |
  |  전환 드로어블  |            두 개의 드로어블을 서로 전환할 수 있음            |
  | 셰이프 드로어블 |   색상과 그러데이션을 포함하여 도형 모양을 정의할 수 있음    |
  |  인셋 드로어블  |    지정된 거리만큼 다른 드로어블을 들어서 보여줄 수 있음     |
  |  클립 드로어블  |     레벨 값을 기준으로 다른 드로어블을 클리핑할 수 있음      |
  | 스케일 드로어블 |   레벨 값을 기준으로 다른 드로어블의 크기를 변경할 수 있음   |

* 상태 드로어블 만들기

  ![chap02-3_5](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_5.png?raw=true)

* 셰이프 드로어블 만들기

  ![chap02-3_6](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_6.png?raw=true)

### 03-3 이벤트 처리 이해하기

* 대표적인 이벤트 유형

  |      속성      |                             설명                             |
  | :------------: | :----------------------------------------------------------: |
  |  터치 이벤트   |          화면을 손가락으로 누를 때 발생하는 이벤트           |
  |   키 이벤트    |       키패드나 하드웨어 버튼을 누를 때 발생하는 이벤트       |
  | 제스처 이벤트  | 터치 이벤트 중에서 스크롤과 같이 일정 패턴으로 구분되는 이벤트 |
  |     포커스     |               뷰마다 순서대로 주어지는 포커스                |
  | 화면 방향 변경 |   화면의 방향이 가로와 세로로 바뀜에 따라 발생하는 이벤트    |

* 제스처 이벤트를 통해 처리할 수 있는 이벤트 유형

  |         메서드         |                         이벤트 유형                          |
  | :--------------------: | :----------------------------------------------------------: |
  |        onDown()        |                      화면이 눌렸을 경우                      |
  |     onShowPress()      |                 화면이 눌렸다 떼어지는 경우                  |
  |    onSingleTapUp()     |          화면이 한 손가락으로 눌렸다 떼어지는 경우           |
  | onSingleTapConfirmed() |              화면이 한 손가락으로 눌려지는 경우              |
  |     onDoubleTap()      |              화면이 두 손가락으로 눌려지는 경우              |
  |   onDoubleTapEvent()   | 화면이 두 손가락으로 눌려진 상태에서 세부적인 액션을 취하는 경우 |
  |       onScroll()       |   화면이 눌린 채 일정한 속도와 방향으로 움직였다 떼는 경우   |
  |       onFling()        |   화면이 눌린 채 가속도를 붙여 손가락을 움직였다 떼는 경우   |
  |     onLongPress()      |              화면을 손가락으로 오래 누르는 경우              |

* 이벤트 처리 방식

  ![chap02-3_7](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_7.png?raw=true)

* 제스처 이벤트 처리하기

  ![chap02-3_8](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_8.png?raw=true)

* 키를 눌렀을 때 전달되는 대표적인 키 값

  |              키 코드               |                  설명                   |
  | :--------------------------------: | :-------------------------------------: |
  | KEYCODE_DRAD_LEFT, RIGHT, UP, DOWN |    왼쪽, 오른쪽, 위쪽, 아래쪽 화살표    |
  |        KEYCODE_DRAD_CENTER         |               [중앙] 버튼               |
  |    KEYCODE_CALL, ENDCALL, BACK     |  [통화], [통화 종료], [뒤로 가기] 버튼  |
  |      KEYCODE_VOLUME_UP, DOWN       | [소리 크기 증가], [소리 크기 감소] 버튼 |
  |       KEYCODE_0 ~ KEYCODE_9        |        숫자 0부터 9까지의 키 값         |
  |       KEYCODE_A ~ KEYCODE_Z        |       알파벳 A부터 Z까지의 키 값        |

* 키 이벤트 처리하기

  ![chap02-3_9](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_9.png?raw=true)

* 단말 방향을 전환했을 때 이벤트 처리하기

  ![chap02-3_10](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_10.png?raw=true)
  
* 단말 방향이 바뀔 때 액티비티를 유지하는 방법

  ![chap02-3_11](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_11.png?raw=true)

### 03-4 토스트, 스낵바 그리고 대화상자 사용하기

* 토스트: 간단한 메시지를 잠깐 보여주었다가 없어지는 뷰로 사용자에게 필요한 정보를 알려주는 역할을 하는 대표적인 위젯

* 토스트 메시지를 만들어서 보여주는 전형적인 방법

  ```java
  Toast.makeText(Context context, String message, int duration).show();
  ```

* 토스트의 위치와 여백을 지정하는 방법

  ```java
  public void setGravity(int gravity, int xOffset, int yOffset)
  public void setMargin(float horizontalMargin, float verticalMargin)
  ```

* 토스트 모양 바꿔 보여주기

  ![chap02-3_12](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_12.png?raw=true)

* 스낵바 보여주기

  ![chap02-3_13](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_13.png?raw=true)

* 알림 대화상자 보여주기

  ![chap02-3_14](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_14.png?raw=true)

### 03-5 프로그레스바 사용하기

* 프로그레스바: 어떤 일의 진행 상태를 중간 중간 보여줄 수 있는 가장 좋은 방법 중 하나로 작업의 진행 정도나 진행 상태를 사용자에게 알려줌

  |   속성    |                             설명                             |
  | :-------: | :----------------------------------------------------------: |
  | 막대 모양 | 작업의 진행 정도를 알려줄 수 있도록 막대 모양으로 표시하고 style 속성 값을 '?android:attr/progressBarStyleHorizontal'로 설정함 |
  |  원 모양  | 작업이 진행 중임을 아려주고 원 모양으로 된 프로그레스바가 반복적으로 표시됨 |

* 프로그레스바의 현재 값을 바꿀 때 사용하는 대표적인 메서드

  ```java
  void setProgress (int progress)
  void incrementProgressBy (int diff)
  ```

* 화면에서 차지하는 공간을 줄일 수 있도록 타이틀바에 프로그레스바를 표시하는 메서드

  ```java
  requestWindowFeature(Window.FEATURE_PROGRESS);
  ```

* 화면에 추가된 막대형 프로그레스바와 대화상자로 띄운 원형 프로그레스바

  ![chap02-3_15](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section3/github/chap02-3_15.png?raw=true)