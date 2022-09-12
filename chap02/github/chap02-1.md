# chap 02-1 안드로이드 스튜디오와 친숙해지기

2021.02.22

<br>

### 01-1 안드로이드 스튜디오 제대로 익히기

### 01-2 뷰와 뷰의 크기 속성 이해하기

* 뷰의 속성

  * 뷰 (View): 일반적으로 컨트롤이나 위젯으로 불리는 UI 구성 요소, 사용자의 눈에 보이는 화면의 구성 요소

* 위젯과 레이아웃으로 구별되는 뷰

  * 위젯 (Widget): 일반적인 컨트롤의 역할을 하는 뷰
  * 레이아웃 (Layout): 내부에 뷰들을 포함하고 있으면서 그것들을 배치하는 역할을 하는 뷰그룹

* 뷰의 크기 속성

  * layout_width와 layout_height는 뷰의 폭과 높이를 설정

  * 뷰 가로와 세로 크기의 값

    |       구분       |                             설명                             |
    | :--------------: | :----------------------------------------------------------: |
    |   wrap_content   |         뷰에 들어 있는 내용물의 크기에 자동으로 맞춤         |
    |   match_parent   |         뷰를 담고 있는 뷰그룹의 여유 공간을 꽉 채움          |
    | 숫자로 크기 지정 | 숫자를 사용해 크기를 지정, 크기는 dp나 px와 같은 단위가 꼭 있어야 함 |


<br>

### 01-3 레이아웃 기초 익히기

* 제약 조건 이해하기
  * 제약 레이아웃은 뷰의 크기와 위치를 결정할 때 제약 조건 (Constraint)을 사용
  * 제약 조건이란 뷰가 레이아웃 안의 다른 요소와 어떻게 연결되는지 알려주는 것으로, 뷰의 연결점 (Anchor Point)과 대상 (Target)을 연결함
  * 뷰의 대상 (Target)이 될 수 있는 것
    1. 같은 부모 레이아웃 안에 들어 있는 다른 뷰의 연결점
    2. 부모 레이아웃의 연결점
    3. 가이드라인
  * 뷰의 연결점 (Anchor Point)이 될 수 있는 것
    1. 위쪽, 아래쪽, 왼쪽, 오른쪽
    2. 가로축의 가운데, 세로축의 가운데
    3. 베이스라인 (텍스트를 보여주는 뷰인 경우에만 적용됨)

* 크기를 표시하는 단위와 마진

  |    단위     |    단위 표현     |                             설명                             |
  | :---------: | :--------------: | :----------------------------------------------------------: |
  |     px      |       픽셀       |                        화면 픽셀의 수                        |
  | dp 또는 dip | 밀도 독립적 픽셀 | 160dpi 화면을 기준으로 한 픽셀 (320dpi 일 경우 1dp는 2px와 같음 ) |
  | sp 또는 sip | 축척 독립적 픽셀 | 텍스트 크기를 지정할 때 사용하는 단위 (가변 글꼴을 기준으로 dp와 유사하지만 글꼴의 설정에 따라 픽셀수가 다름) |
  |     in      |       인치       |                    1인치로 된 물리적 길이                    |
  |     mm      |     밀리미터     |                  1밀리미터로 된 물리적 길이                  |
  |     em      |   텍스트 크기    |           글꼴과 상관없이 동일한 텍스트 크기 표시            |

* 마진 (Margin)의 종류

  |               속성 이름               |                            설명                             |
  | :-----------------------------------: | :---------------------------------------------------------: |
  | layout_marginTop, Bottom, Left, Right |   뷰의 위쪽, 아래쪽, 왼쪽, 오른쪽을 얼마나 띄울지 지정함    |
  |             layout_margin             | 뷰의 위, 아래, 왼쪽, 오른쪽을 얼마나 띄울지 한꺼번에 지정함 |

* 실습

  * 도전! 안드로이드 미션 01 - 02 (화면 아래쪽에 두개의 버튼 추가하기 - 위, 아래, 중앙의 공간을 차지하는 전형적인 화면 구성하기
  
    ![chap02-1/image01](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section1/image01.png?raw=true)