# kotlin-problem-test
코딩테스트 레포지토리

## 프로젝트 구조
```
├── buildSrc/                 # gradle 파일 공통 모듈 빌드 설정 모음 
├── domains/                 # 도메인 모델      
│   ├── domain-도메인명/               # 도메인 추상체       
│   │   ├── servicebus (domain-client 서비스 구현체 접근을 위한 인터페이스)      
│   │   │   ├── query (조회 관련 in port)       
│   │   │   ├── command (Create,Update,Delete 관련 in port)       
│   │   ├── repositorybus (domain-client db 접근을 위한 repository 구현체 접근을 위한 인터페이스)      
│   │   │   ├── query (조회 관련 out port)       
│   │   │   ├── command (Create,Update,Delete 관련 out port)       
│   │   ├── dto (request, response등이 담겨있는 dto)       
│   │   │   ├── request (request dto)       
│   │   │   ├── response (response dto)       
│   ├── domain-도메인명-client/               # 도메인 구현체     
│   │   ├── service (domain-client 서비스 구현체)      
│   │   │   ├── query (조회 관련 in port)       
│   │   │   ├── command (Create,Update,Delete 관련 in port)       
│   │   ├── repository (domain-client db 접근을 위한 repository 구현체)
│   │   │   ├── query (조회 관련 out port)       
│   │   │   ├── command (Create,Update,Delete 관련 out port)       
│   │   ├── entity (도메인에 쓰일 entity(orm) 모아놓는 곳)      
│   │   ├── exception (에러 코드 모으는 곳)       
│   │   ├── util (유틸성 파일 모아놓는 곳)       
├── commons/                 # 공통 모듈       
│   ├── exception       exception 핸들러, exception 모음 + 에러코드 인터페이스       
│   ├── util ApiResponse 정의 되어있음.        
├── gradle/                 # 그래들 관리를  위한 libs.version.toml 모음        
├── modules/                 # 모듈로 관리할 폴더 모음
│   ├──  adapter-testfixture-db/   # 테스트에 공통으로 사용할 db 모듈            
├── project-프로젝트명-api/ # 프로젝트 api      
│   ├──  adapter-data-jpa/   # jpa 및 db 접근 설정         
│   ├──  appliction/   # 요청을 토대로 도메인을 호출하는 비즈니스 로직이 담긴 service 구현체 및 추상체 관련 내용       
│   ├──  bootstrap   # springboot 실행         
│   ├──  connector/   # rest api 엔드포인트 및 관련 설정 모음      
│├── build.gradle            # Gradle 설정      
```

## 서버 실행 후 swagger를 통해 request parameter, response 결과 값을 쉽게 볼 수 있음
```
http://localhost:8081/swagger-ui/index.html
```

## project-beyond-medicine-backend-api의 adapter-data-jpa의 resources에 동봉된 application-adapter-data-jpa-env.yml 파일 넣어야함.
```
제가 운영하고 있는 서버 db에 올려서 민감한 정보라 db접근 값들을 따로 env파일로 뻈습니다.
```

## modules의 adapter-testfixture-db src/testFixtures/resources에 동봉된 application-adapter-testfixture-env.yml 파일 넣어야함.
```
제가 운영하고 있는 서버 db에 올려서 민감한 정보라 db접근 값들을 따로 env파일로 뻈습니다.
```

## exception Handler를 이용한 도메인 별 exception 처리

### USER 도메인 EXCEPTION ENUM
```
    USER_NOT_EXIST(8001, "해당 유저가 존재하지 않습니다.", 404),
    HASH_NOT_VALID(8002, "유효한 해시가 아닙니다."),
    PRESCRIPTION_CODE_NOT_REGIST(8003, "해당 유저의 처방코드가 등록 되지 않았습니다."),
    VERSION_NOT_VALID(8004, "유효한 버전이 아닙니다."),
    USER_ID_NOT_EXIST(8005, "해당 유저 ID가 존재하지 않습니다.", 404),
```

### PRESCRIPTION 도메인 EXCEPTION ENUM
```
    PRESCRIPTION_NOT_EXIST(9001, "해당 처방 코드가 존재하지 않습니다.", 404),
    ACTIVATE_CONDITION_NOT_SATISFIED(9002, "사용자의 기존 만료 되지 않은 처방코드가 이미 등록 되어 있습니다."),
    PRESCRIPTION_CODE_EXPIRED(9003, "해당 처방 코드가 만료 되었습니다."),
    PRESCRIPTION_CODE_NOT_REGISTER(9004, "해당 코드가 등록되지 않았습니다"),
```
