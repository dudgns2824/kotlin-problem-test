# kotlin-problem-test
코딩테스트 레포지토리

## 프로젝트 구조
```
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
│   │   ├── port # port      
│   │   │   ├── servicebus (domain-client 서비스 구현체 접근을 위한 인터페이스)      
│   │   │   │   ├── query (조회 관련 in port)       
│   │   │   │   ├── command (Create,Update,Delete 관련 in port)       
│   │   │   ├── repositorybus (domain-client db 접근을 위한 repository 구현체 접근을 위한 인터페이스)
│   │   │   │   ├── query (조회 관련 out port)       
│   │   │   │   ├── command (Create,Update,Delete 관련 out port)       
├── project-프로젝트명-api/ # 프로젝트 api      
│├── build.gradle            # Gradle 설정      
```

## 엑셀 산출물이 따로 존재하나 서버 실행 후 swagger를 통해 request parameter, response 결과 값을 쉽게 볼 수 있음
```
http://localhost:8081/swagger-ui/index.html
```

## project-beyond-medicine-backend-api의 adapter-data-jpa의 resources에 동봉된 -env.yml 파일 넣어야함.
```
제가 운영하고 있는 서버 db에 올려서 민감한 정보라 db접근 값들을 따로 env파일로 뻈습니다.
```

## exception Handler를 이용한 도메인 별 exception 처리

### USER 도메인 EXCEPTION ENUM
```

```

### PRESCRIPTION 도메인 EXCEPTION ENUM
```
```