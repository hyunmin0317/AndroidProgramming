# chap 02-2 레이아웃 익히기

2021.02.23

<br>

### 02-1 안드로이드에 포함된 대표적인 레이아웃 살펴보기

* 대표적인 안드로이드 레이아웃

  |  레이아웃 이름  |        모델         |                             설명                             |
  | :-------------: | :-----------------: | :----------------------------------------------------------: |
  |  제약 레이아웃  | 제약 조건 기반 모델 | 제약 조건을 사용하여 화면을 구성하며 안드로이드 스튜디오의 디폴트 레이아웃 |
  | 리니어 레이아웃 |      박스 모델      | 한 쪽 방향으로 차례대로 뷰를 추가하여 화면을 구성하며 뷰가 차지할 수 있는 사각형 영역을 할당 |
  |  상대 레이아웃  |   규칙 기반 모델    | 부모 컨테이너나 다른 뷰와의 상대적 위치로 화면을 구성하며 제약 레이아웃을 사용 |
  | 프레임 레이아웃 |      싱글 모델      | 가장 상위에 있는 하나의 뷰 또는 뷰그룹만 보여주며 여러 개의 뷰를 중첩한 후 각 뷰를 전환하여 보여줌 |
  | 테이블 레이아웃 |      격자 모델      | 격자 모양의 배열을 사용하여 화면을 구성하며 HTML의 방식과 유사하지만 많이 사용하지는 않음 |

* 안드로이드 레이아웃 추가 설명

  * 제약 레이아웃 (ConstraintLayout): 제약 조건을 사용해 그 안에 들어 있는 뷰를 배치하며 안드로이드 스튜디오의 디폴트 레이아웃
  * 리니어 레이아웃 (LinearLayout): 레이아웃 방향을 기준으로 뷰들이 차례대로 쌓이는 레이아웃
    * 세로 방향으로 설정 (Vertical) - 뷰를 추가할 때마다 위쪽에서 아래쪽으로 쌓임
    * 가로 방향으로 설정 (Horizontal) - 뷰를 추가할 때마다 왼쪽에서 오른쪽으로 쌓임 
  * 상대 레이아웃 (RelativeLayout): 부모 레이아웃과의 상대적 위치 또는 같은 레이아웃의 다른 뷰와 상대적 위치를 이용해 화면을 배치하는 레이아웃
    * 안드로이드 스튜디오의 전 디폴트 레이아웃으로 지금은 특성이 같고 더 많은 기능을 제공하는 제약 레이아웃을 권장함
  * 프레임 레이아웃 (FrameLayout): 뷰나 뷰그룹을 중첩하여 쌓으며 가장 위에 있는 하나의 뷰만 화면에 보여지는 레이아웃
  * 테이블 레이아웃 (TableLayout):  안에 들어가는 뷰들을 격자 형태로 만들어 주는 레이아웃

<br>

### 02-2 리니어 레이아웃 사용하기

* 뷰 정렬하기

  * 레이아웃에서 정렬 기능이 필요한 경우

    |   정렬 속성    |                             설명                             |
    | :------------: | :----------------------------------------------------------: |
    | layout_gravity | 부모 컨테이너의 여유 공간에 뷰가 모두 채워지지 않아 여유 공간이 생겼을 때 여유 공간 안에서 뷰를 정렬함 |
    |    gravity     | 뷰 안에 표시하는 내용물을 정렬함 (텍스트뷰의 경우 내용물은 글자가 되고, 이미지뷰의 경우 내용물은 이미지가 됨) |

  * 내용물 정렬 속성 (gravity)

    |            정렬 속성 값            |                             설명                             |
    | :--------------------------------: | :----------------------------------------------------------: |
    |      top, bottom, left, right      |       대상 객체를 위, 아래, 왼쪽, 오른쪽 끝에 배치하기       |
    | center_vertical, center_horizontal |       대상 객체를 수직, 수평 방향으로 중앙에 배치하기        |
    |   fill_vertical, fill_horizontal   |        대상 객체를 수직, 수평 방향의 중앙에 배치하기         |
    |            center, fill            | 대학 객체를 수직 방향과 수평 방향의 중앙에 배치하기, 여유 공간만큼 확대하여 채우기 |
    |           clip_vertical            | 대상 객체의 상하 길이가 여유 공간보다 클 경우에 남는 부분을 잘라내기 |

* gravity 속성으로 텍스트뷰 안의 글자 편집

  ![chap02-2/image01](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image01.png?raw=true)

  

* 텍스트뷰와 버튼의 크기를 다르게 한 경우

  ![chap02-2/image02](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image02.png?raw=true)

  

* 뷰의 마진과 패딩 설정

  ![chap02-2/image03](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image03.png?raw=true)

  

* 여유 공간을 분할하는 layout_weight 속성

  ![chap02-2/image04](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image04.png?raw=true)


<br>

### 02-3 상대 레이아웃 사용하기

* 상대 레이아웃 사용

  ![chap02-2/image05](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image05.png?raw=true)

* 상대 레이아웃에서 부모 컨테이너와의 상대적 위치를 이용하는 속성

  |                    속성                     |                             설명                             |
  | :-----------------------------------------: | :----------------------------------------------------------: |
  | layout_alignParentTop, Bottom, Left, Right  | 부모 컨테이너의 위쪽, 아래쪽, 왼쪽 끝, 오른쪽 끝과 뷰를 맞춤 |
  | layout_centerHorizontal, Vertical, InParent |  부모 컨테이너의 수평, 수직, 수평과 수직 방향 중앙에 배치함  |

* 상대 레이아웃에서 다른 뷰와의 상대적 위치를 이용하는 속성

  |                        속성                         |                        설명                         |
  | :-------------------------------------------------: | :-------------------------------------------------: |
  |      layout_above, below, toLeftOf, toRightOf       |   지정한 뷰의 위쪽, 아래쪽, 왼쪽, 오른쪽에 배치함   |
  | layout_alignTop, alignBottom, alignLeft, alignRight |    지정한 뷰의 위쪽, 아래쪽, 왼쪽, 오른쪽과 맞춤    |
  |                layout_alignBaseline                 | 지정한 뷰와 내용물의 아래쪽 기준선(baseline)을 맞춤 |

<br>

### 02-4 테이블 레이아웃

* 테이블 레이아웃 사용

  ![chap02-2/image06](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image06.png?raw=true)

<br>

### 02-5 프레임 레이아웃과 뷰의 전환

* 프레임 레이아웃을 이용해 이미지뷰 전환

  ![chap02-2/image07](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image07.png?raw=true)

<br>

### 02-6 스크롤뷰 사용하기

* 스크롤뷰 사용

  ![chap02-2/image08](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/github/image/section2/image08.png?raw=true)
