# spring_web_project_subway

<h1>팀원 : 김수진, 김소리, 원도현, 기태우</h1>
<h2>프로젝트 기획</h2>
<ul>
  <li>클론 사이트 리스트업</li>
  <li>ERD 회의 및 SFD 작성</li>
  <li>업무 분배 및 개별 RND</li>
</ul>
  
<h2>프로젝트 개요</h2>

JSP에서 구현된 프로젝트를 SPRING으로 변환하는 작업을 수행. JSP에서 사용했던 AJAX와 servlet을 사용하기 위해 Gson을 dependency에 추가하고, `@ServletComponentScan` 어노테이션을 main의 Application 클래스에 추가함.

<h2>ERD</h2>
<img width="865" alt="스크린샷 2024-02-08 오전 10 37 39" src="https://github.com/HnG8N/web_project_subway/assets/151720731/ff76684f-3ae4-4eb3-9f5b-a6ce1c79a8e4">
<h2>개발 일정(ASANA)</h2>
<img width="909" alt="스크린샷 2024-02-08 오전 10 45 11" src="https://github.com/HnG8N/web_project_subway/assets/151720731/9a8c9463-855e-4511-b3fb-a9a9996b480b">
<img width="909" alt="스크린샷 2024-02-08 오전 10 45 22" src="https://github.com/HnG8N/web_project_subway/assets/151720731/a5f83cc5-e093-46df-b26c-14af910fbd1a">
<img width="909" alt="스크린샷 2024-02-08 오전 10 45 30" src="https://github.com/HnG8N/web_project_subway/assets/151720731/6ef039e9-3484-49d3-8b2a-f8cf17d699cb">
<h2>개별 개발 현황</h2>
<h3>원도현</h3>
<details>
  <summary><strong>관리자 페이지</strong></summary>

### 로그인
1. 아이디가 정규식에 맞는지 확인
2. 아이디가 정규식에 맞을 경우 ajax를 통해 아이디와 비밀번호를 servlet으로 전송
3. servlet에서 받아온 아이디와 비밀번호가 DB에서 불러온 아이디, 비밀번호와 같은지 확인 후 같으면 로그인

### 매출 현황
1. chart.js를 이용해 차트를 구현
2. 차트의 데이터를 ajax를 통해 JSON 형식으로 받아옴.
3. 받아온 데이터를 ArrayList로 만들어서 차트의 데이터 부분에 넣어줌.

### 일일 매출 현황 (Line Chart와 Pie Chart)
1. 시작 날짜와 마지막 날짜를 설정하여 차트를 확인할 수 있도록 구현.
2. 시작 날짜와 마지막 날짜를 클릭하면 달력이 나타남.
3. 달력은 API를 통해 구현.

### 상품 리스트
1. 페이징 기능을 구현. (ajax - servlet)
2. DB에서 data를 가져 올 때 limit과 offset을 사용
3. servlet에서 총 상품 개수(listCount), limit, offset, 현재 페이지(buttonNum), 페이지 개수(buttonCount)를 변수로 설정
4. limit은 페이지에 보여줄 상품의 개수로 설정. (5로 설정)
5. offset은 해당 페이지의 시작 상품으로 ((페이지-1)*limit으로 설정
6. 페이지는 버튼을 클릭했을 때 버튼의 값을 ajax를 통해 받아옴
7. 페이지 개수는 DB에서 총 상품 개수를 가져온 후 limit으로 나눈 뒤 올림을 취하여 설정 ((int)Math.ceil((double)listCount / limit)
8. 검색기능 구현 (ajax - servlet)
9. 제품명 검색에서 한글과 영문 모두 검색 가능

### 새 상품 등록과 수정
1. 정규식을 통해 형식에 맞는 data만 입력 가능
2. 이미지 파일 업로드 구현
3. 이미지 파일을 선택하면 미리보기가 나타남

### 회원정보 조회
1. 탈퇴 회원만 조회되는 기능 구현, 가입 순서대로 정렬되는 기능을 구현

</details>

<details>
  <summary><strong>게시판</strong></summary>

### 게시판 기능
1. DB에서 data를 가져와 보여줌
2. 글 제목과 작성자로 검색 기능을 구현
3. 글 등록 버튼을 누를 시 게시물을 작성
4. 게시물의 제목을 클릭하면 게시물을 확인할 수 있으며, 작성자와 로그인 아이디가 동일할 경우 수정이 가능(삭제 포함)
5. 게시물에는 댓글 기능이 존재 (대댓글 포함)
6. 댓글과 대댓글을 구현하기 위해 DB comment 테이블의 열을 추가
7. commentid(PK,AI), parentid(댓글의 댓글을 달 시 윗댓글의 commentid를 참조해 insert), groupid(댓글의 댓글이 여러개 달릴 시 제일 상위 레벨의 groupid를 참조해 insert), commentlevel(한 단계 상위 댓글의 level을 참조해 +1)<br>
<img width="300" alt="댓글 달기 답글 수정" src="https://github.com/HnG8N/spring_web_project_subway/assets/151720731/89a08eeb-41f9-48dc-94d1-104cd0328ecc"><img width="300" alt="스크린샷 2024-02-28 오후 11 01 38" src="https://github.com/HnG8N/spring_web_project_subway/assets/151720731/c01a6b99-13da-45fa-a0c0-26bd75f90d84"><br>
8. 댓글 작성자와 로그인 아이디가 동일할
 경우 수정과 삭제가 가능
9. 삭제 시 "삭제되었습니다."라는 메시지가 출력 (DB에서는 삭제되지 않음)

</details>

<h3>김소리</h3>
<details>
  <summary>회원가입 기능</summary>
  
  1. **아이디 중복 체크**
      - 아이디 입력 후 중복체크 버튼 클릭
      - ajax로 입력받은 id 데이터를 전송
      - CheckId.servlet 에서 전송 받은 아이디를 @autowired로 연결한 Signupservice의 checkId메소드에 삽입하여 중복 아이디가 있는지 확인
          - 중복 아이디가 있을 시 count = 1
          - 중복 아이디가 없을 시 count = 0
      - json으로 count 값을 Signup.js로 전송
      - json으로 받은 데이터 값 비교
          - 0일 때 : “사용가능한 아이디 입니다.” 출력
          - 1일 때 : “이미 사용중인 아이디입니다.”출력
      - 중복된 아이디로 회원가입 진행 시 회원가입 안되게 설정
  2. **비밀번호 일치 확인**
      - 비밀번호 입력창과 비밀번호 확인 입력창에 입력한 값을 Signup.js에서 비교
          - 입력 값이 다를 때 : “비밀번호 불일치” 출력
          - 입력 값이 같을 때 : “비밀번호 일치” 출력
  3. **주소 입력**
      - 우편번호 찾기 버튼 클릭
      - 다음(Daum) 우편번호 서비스를 사용하여 우편번호, 주소를 Signup.jsp에 출력
  4. **생년월일 입력**
      - 선택한 년, 월을 이용하여 윤년을 계산
          - 년, 월에 따라 2월의 일수가 28일 또는 29일로 출력되도록 설정
  5. **이메일 입력**
      - 이메일 입력 후 인증번호 발송버튼 클릭
          - 데이터베이스에 저장 된 이메일일 때 : 이메일이 전송되지 않으며, “이미 사용중인 이메일 입니다.” 출력
          - 데이터베이스에 저장되지 않은 이메일일 때 : 이메일이 전송되며, “이메일을 성공적으로 전송하였습니다.” 출력
          - 어떠한 이유로 문제가 생겼을 때 : “이메일 전송에 실패하였습니다.” 출력
      - 4자리의 확인코드를 랜덤으로 생성 후 session에 저장
      - 확인코드를 이메일로 전송
  6. **이메일 확인 코드 입력**
      - 입력 받은 이메일 확인 코드를 EmailCheckCode.servlet으로 전송
      - 입력 받은 이메일 확인 코드를 session에 저장된 확인코드와 비교
          - 입력 받은 값이 session에 저장된 확인코드와 같을 때 : json으로 “true” 전송
          - 입력 받은 값이 session에 저장된 확인코드와 다를 때 : json으로 “false” 전송
      - json으로 받은 데이터 값을 확인
          - 데이터 값이 “true” 일 때 : "인증 되었습니다.”를 Signup.jsp에 출력
          - 데이터 값이 “false” 일 때 : "인증번호를 다시 확인해주세요.”를 Signup.jsp에 출력
  7. **유효성 검사**
      - 유효성 검사가 다 확인되어야 회원가입 진행
          - 아이디 중복 검사가 진행 되어야 함
          - 이메일 인증이 진행 되어야 함
          - 이메일 확인 코드가 인증 되어야 함
          - ID는 영어 소문자와 숫자만 사용 가능하며, 최대 15자까지 입력 가능
          - PW는 영어, 숫자, 특수문자만 사용 가능하며, 8자부터 15자까지 입력 가능
          - 이름은 한글 또는 영어만 사용 가능하며, 최대 10자까지 입력 가능
          - 주소 관련 필드는 모두 입력되어야 함
          - 전화번호는 숫자만 입력 가능하며, 각각 4자리여야 함
</details>
<details>
  <summary>로그인 기능</summary>
  
  1. **아이디, 비밀번호 입력 후 로그인 버튼 클릭**
      - ajax 입력받은 pw 데이터를 전송
      - Checkpw.servlet 에서 전송 받은 아이디를 @autowired로 연결한 Signupservice의 checkpw메소드에 삽입하여입력한 pw의 아이디 데이터를 찾음
      - json으로 찾은 id 데이터를 Login.js로 전송
      - json으로 받은 id 데이터를 입력받은 id 데이터와 비교
          - json으로 받은 id 데이터와 입력받은 id 데이터가 같을 때 : 로그인 성공, index.jsp로 이동
          - json으로 받은 id 데이터와 입력받은 id 데이터가 다를 때 : “비밀번호가 일치하지 않습니다.” 출력
          - 입력 받은 id 데이터가 회원탈퇴된 id 일 때 : “탈퇴한 아이디 입니다. 회원가입을 진행해주세요.” 출력
</details>
<details>
  <summary>아이디 찾기 기능</summary>
  
  1. **이름, 생년월일, 이메일을 입력 후 아이디찾기 버튼 클릭**
  2. **ajax로 입력받은 이름,생년월일,이메일 데이터를 전송**
  3. **FindId.servlet 에서 전송 받은 데이터들을 @autowired로 연결한 Signupservice의 checkIdInfo메소드에 삽입하여 존재하는 회원 정보인지 확인**
      - 존재하는 회원 정보일 때 : count = 1
      - 존재하지 않는 회원 정보일 때 : count = 2
  4. **json으로 count값을 전송**
  5. **전송 받은 데이터 값을 비교**
      - 0일 때 : “회원 정보가 없습니다. 회원가입을 진행해주세요.” 출력
      - 1일 때 : 입력한 이메일로 아이디 정보 전송 및 "이메일을 성공적으로 전송했습니다.” 출력
      - 어떠한 이유로 문제가 생겼을 때 : “이메일 전송에 실패하였습니다.” 출력
  6. **이메일이 정상적으로 전송 되었다면 로그인 화면으로 이동**
</details>

<details>
  <summary>비밀번호 찾기 기능</summary>
  
  1. **아이디, 이름, 생년월일, 이메일을 입력 후 아이디찾기 버튼 클릭**
  2. **ajax로 입력받은 아이디, 이름,생년월일,이메일 데이터를 전송**
  3. **FindPw.servlet 에서 전송 받은 데이터들을 @autowired로 연결한 Signupservice의 checkPwInfo메소드에 삽입하여 존재하는 회원 정보인지 확인**
      - 존재하는 회원 정보일 때 : count = 1
      - 존재하지 않는 회원 정보일 때 : count = 2
  4. **json으로 count값을 전송**
  5. **전송 받은 데이터 값을 비교**
      - 0일 때 : “회원 정보가 없습니다. 회원가입을 진행해주세요.” 출력
      - 1일 때 : 입력한 이메일로 비밀번호 정보 전송 및 "이메일을 성공적으로 전송했습니다.” 출력
      - 어떠한 이유로 문제가 생겼을 때 : “이메일 전송에 실패하였습니다.” 출력
  6. **이메일이 정상적으로 전송 되었다면 로그인 화면으로 이동**
</details>

<details>
  <summary>마이페이지 수정 기능</summary>
  
  1. **로그인 하면서 session에 저장한 회원정보를 아이디를 사용하여 회원 정보를 dto에 담음**
  2. **마이페이지에 dto에 담은 정보들 출력**
  3. **비밀번호 수정**
      1. 현재 비밀번호를 입력
      2. 비밀번호 확인 버튼을 클릭
      3. dto에서 불러와 hidden으로 숨겨놓은 비밀번호 값과 입력한 비밀번호 값을 비교
          - 두 값이 같을 때 : "비밀번호가 맞습니다. 비밀번호 수정을 진행하세요.” 출력 및 비밀번호 수정 폼 출력
          - 두 값이 다를 때 : "비밀번호가 아닙니다. 다시 입력해주세요.” 출력
  4. **주소 수정**
      1. 우편번호 찾기 버튼 클릭
      2. 다음(Daum) 우편번호 서비스를 사용하여 우편번호, 주소를 MyPage.jsp에 출력
  5. **유효성 검사**
      - 유효성 검사가 다 확인되어야 회원가입 진행
          - PW는 영어, 숫자, 특수문자만 사용 가능하며, 8자부터 15자까지 입력 가능
          - 주소 관련 필드는 모두 입력되어야 함
</details>

<h3>김태우</h3>
<ul>
  <li>게시판 글 쓰기, 글 수정, 글 지우기 기능 구현</li>
  <li>글 읽기 기능
  <li>사용자 ID로 글 수정 가능</li>
  <li>페이지 구분 기능과 페이지 넘기는 기능 구현</li>
  <li>Ajax 사용으로 글 제목 검색 기능 구현</li>
  <li>댓글 및 대댓글 기능 구현</li>
</ul>

![Anurag's GitHub stats](https://github-readme-stats.vercel.app/api?username=HnG8N&show_icons=true&theme=dracula)
![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=spring_web_project_subway&layout=compact&theme=dracula)
