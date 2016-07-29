# 알림톡 자동화 모듈
 >Start Date: 2016/07/26

 >1st Prototype: 완료 - 2016/07/27
 - 사전알림신청내역/알림톡 서버 연결 
 - CSV 파일 변환 및 자료구조 정의
 - INSERT하는 두 테이블(pre_order_coupon, MZSENDTRAN)과 동일한 환경의 테스트 테이블에 입력

 >2nd Prototype: 진행중 
 - 1st Prototype의 코드 다듬기 작업
 - CSV파일 변환코드 개선
 - Web형식으로 변환/구현 => Servlet 관련 공부 진행중


## Purpose
알림톡을 보내는 과정에 있어 여러번의 Query작성과 파일 변환을 해야 되는 과정을 간소화시키기 위해 제작.


### 기존의 알림톡 발송과정
>1. 사전알림신청내역서버/GAME DB 내의 pre_order_genre_reserve(장르별 자동알림 신청자)테이블과 pre_order_reserve_game(특정 게임 알림 신청자)테이블을 UNION
>2. UNION 한 사전알림 사용자 정보를 CSV 파일 형식으로 추출
>3. 회원DB 서버 접속
>4. 회원데이터에서 사전알림 신청자들의 휴대전화번호, MemerID 추출
>5. 회원데이터 내용 CSV 파일에 추가
>6. 사업팀으로부터 받은 쿠폰번호와 내용 CSV파일에 추가/완료
>7. 알림톡DB 서버 접속
>8. alimtalk DB 내 MZSENDTRAN 테이블에 완성된 CSV파일 INSERT
>9. 사전알림신청내역/GAME/pre_order_coupon 테이블에 지급된 쿠폰내역 INSERT

이러한 여러 과정을 하나의 모듈로 통합하게 되면 시간 및 자원을 크게 절감


## 1st Prototype: 완료 - 2016/07/27


# 제한사항
1. 회원DB로의 접근권한 및 방법

