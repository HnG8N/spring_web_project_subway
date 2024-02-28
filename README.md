# spring_web_project_subway

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
