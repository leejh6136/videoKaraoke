# VideoKaraoke
현재 노래방 기기 회사들이 노래방 반주의 동영상을 Youtube 채널을 통해서 업로드 하고 있습니다.  
이러한 동영상을 실제 노래방 UI에 맞게 재생해주는 단순한 동영상 플레이어입니다.

## 개발동기
라즈베리파이와 같은 싱글보드 컴퓨터의 보급으로 많은 사람들이 RetroArch, Recalbox 등과 같은 오픈소스를 활용하여 레트로 게임기를 제작합니다.  
이러한 방식으로 레트로 게임기 뿐만 아니라 노래방 기기를 제작하고자 하는 사람들이 있지만 레트로 게임기와 같은 사용할 수 있는 오픈소스가 없어 개인사용 용도의 가정용 노래방 기기를 제작 할 때 노래방 동영상들을 이용해서 실제 노래방 환경처럼 구성하는데 도움을 줄 수 있는 오픈소스를 시작하게 되었습니다.

## 구성파일 
| 이름 | 설명 |
|--------|-------|
| VideoKaraoke.jar | 실행파일 |
| intro.mp4 | 시작한 노래가 없을 때 나오는 기본 동영상 파일 |
| playlist.txt | 노래목록을 구성할 설정파일 |
| setting.ini | 사용자 설정 파일 |

## 사용방법
먼저 구성파일은 모두 같은 폴더에 존재해야 합니다.  
setting.ini를 열어 아래와 같이 상단바의 배경색과 노래방 이름을 설정합니다.  
배경색은 10진수 RGB 코드로 작성합니다.
  
>introVideo=./intro.mp4  
KaraokeName=재성노래방  
TopBK_R=0  
TopBK_G=0  
TopBK_B=0  
  
다음으로 playlist.txt를 열어 아래를 참고하여 노래목록을 구성합니다.  
행의 첫 문자가 &#35;인 경우 주석입니다.
  
>&#35;노래방 번호  
&#35;제목  
&#35;가수  
&#35;동영상 파일 경로 또는 Youtube URL  
430  
비처럼 음악처럼  
김현식  
./song/430.mp4  
49920  
여행  
볼빨간 사춘기  
https://www.youtube.com/watch?v=z-c-q88xrb0  
  
동영상 파일은 저작권이 있으며 제공하지 않고 사용자가 직접 다운로드 해야합니다.  
이제 모든 준비를 마치고 실행파일을 실행시켜 아래의 조작법을 참고하여 사용할 수 있습니다.  
  
| 동작 | 키 |
|--------|-------|
| 번호입력 | 0-9 |
| 번호삭제 | Backspace |
| 시작 | Enter |
| 취소 | Esc |
| 예약 | Ctrl |
| 우선예약 | Shift |

## 배포
[videoKaraoke-0.0.1-dist.zip](https://www.mediafire.com/file/b1kmk8jkm1fjz90/videoKaraoke-0.0.1-dist.zip/file)

## 라이센스
GPLv3(GNU General Public License v3)  
  
Copyright (c) 2020 LEE Jae-Sung

## 외부 라이브러리
[VLCJ 3.12.1](https://github.com/caprica/vlcj/tree/vlcj-3.x/) (GPLv3)
