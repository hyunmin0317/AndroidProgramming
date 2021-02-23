# chap 02-2 레이아웃 익히기

​																																																												2021.02.23



### 02-1 안드로이드에 포함된 대표적인 레이아웃 살펴보기

* 대표적인 안드로이드 레이아웃

  |  레이아웃 이름  |        모델         |                             설명                             |
  | :-------------: | :-----------------: | :----------------------------------------------------------: |
  |  제약 레이아웃  | 제약 조건 기반 모델 | 제약 조건을 사용하여 화면을 구성하며 안드로이드 스튜디오의 디폴트 레이아웃 |
  | 리니어 레이아웃 |      박스 모델      | 한 쪽 방향으로 차례대로 뷰를 추가하여 화면을 구성하며 뷰가 차지할 수 있는 사각형 영역을 할당 |
  |  상대 레이아웃  |   규칙 기반 모델    | 부모 컨테이너나 다른 뷰와의 상대적 위치로 화면을 구성하며 제약 레이아웃을 사용 |
  | 프레임 레이아웃 |      싱글 모델      | 가장 상위에 있는 하나의 뷰 또는 뷰그룹만 보여주며 여러 개의 뷰를 중첩한 후 각 뷰를 전환하여 보여줌 |
  | 테이블 레이아웃 |      격자 모델      | 격자 모양의 배열을 사용하여 화면을 구성하며 HTML의 방식과 유사하지만 많이 사용하지는 않음 |

  

### 02-2 리니어 레이아웃 사용하기

* 내용물 정렬 속성 gravity

  |            정렬 속성 값            |                             설명                             |
  | :--------------------------------: | :----------------------------------------------------------: |
  |      top, bottom, left, right      |       대상 객체를 위, 아래, 왼쪽, 오른쪽 끝에 배치하기       |
  | center_vertical, center_horizontal |       대상 객체를 수직, 수평 방향으로 중앙에 배치하기        |
  |   fill_vertical, fill_horizontal   |        대상 객체를 수직, 수평 방향의 중앙에 배치하기         |
  |            center, fill            | 대학 객체를 수직 방향과 수평 방향의 중앙에 배치하기, 여유 공간만큼 확대하여 채우기 |
  |           clip_vertical            | 대상 객체의 상하 길이가 여유 공간보다 클 경우에 남는 부분을 잘라내기 |

  

* gravity 속성으로 텍스트뷰 안의 글자 편집 (chap02-2_1.png)

  ![chap02-2_1](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_1.png?raw=true)

  

* 텍스트뷰와 버튼의 크기를 다르게 한 경우 (chap02-2_1.png)

  ![chap02-2_2](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_2.png?raw=true)

  

* 뷰의 마진과 패딩 설정 (chap02-2_3.png)

  ![chap02-2_3](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_3.png?raw=true)

  

* 여유 공간을 분할하는 layout_weight 속성 (chap02-2_4.png)

  ![chap02-2_4](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_4.png?raw=true)

  

### 02-3 상대 레이아웃 사용하기

* 상대 레이아웃 사용 (chap02-2_5.png)

  ![chap02-2_5](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_5.png?raw=true)

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

### 02-4 테이블 레이아웃

* 테이블 레이아웃 사용 (chap02-2_6.png)

  ![chap02-2_6](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_6.png?raw=true)

### 02-5 프레임 레이아웃과 뷰의 전환

* 프레임 레이아웃을 이용해 이미지뷰 전환 (chap02-2_7.png)

  ![chap02-2_7](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_7.png?raw=true)

### 02-6 스크롤뷰 사용하기

* 스크롤뷰 사용 (chap02-2_8.png)

  ![chap02-2_8](https://github.com/hyunmin0317/AndroidProgramming/blob/master/chap02/section2/github/chap02-2_8.png?raw=true)
  
  
