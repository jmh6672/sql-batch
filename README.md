# AB180-SVC

- 기본 포트 : 8080
- API 문서화 경로 : /swagger-ui
- H2 Database Console : /h2-console
  - JDBC URL: jdbc:h2:./dbdata/ab180
  - User Name: mh
  - Password: mh


# Build And Run

## build

- bootJar   
  ~~~
  gradlew :api-user:bootJar
  ~~~
  빌드가 완료되면 `build/ab180.jar` 파일이 생성됩니다.

## Run   

- bootRun   
  ~~~
  gradlew :api-user:bootRun
  ~~~
- jar run

  `bootJar` 로 빌드후에 `build/ab180.jar` 를 실행합니다.

  ~~~
  java -jar ./build/ab180.jar
  ~~~



## 프로젝트 구조
```bash
ab180
├── src         
│   ├── main
│   └── test
├── settings.gradle
└── build.gradle
```

<br><br><br>

# 요구사항

아래 요구사항 테스트 케이스를 문서화 하려고 했으나, 시간이 부족하여 swagger 문서로 작성했습니다..

Swagger 문서 경로는 README 상단에 입력해 두었습니다.

---



**1) URL을 입력하면 random한 ID를 가지는 Short Link를 생성해주는 API 개발**

- shortId(Random한 ID) 정의
  - 3글자 이상의 alphanumeric 문자열
  - 반드시 unique 해야함
  - 가능한 짧아야 함
- POST /short-links
- Request Body
  - url : Short Link를 통해서 Landing이 될 URL
- Sample
  - Request
    ```
    {
      "url": "https://airbridge.io"
    }
    ```
  - Response
    ```
    {
      "data": {
        "shortId": "abcde",
        "url": "https://airbridge.io",
        "createdAt": "2021-06-07T11:38:16+0000"
      }
    }
    ```

<br><br>

**2) Short Link 1개를 조회하는 API 개발** 

- GET /short-links/{short_id}
- Sample
  ```
  GET /short-links/abcde

  {
    "data": {
      "shortId": "abcde",
      "url": "https://airbridge.io",
      "createdAt": "2021-06-07T11:38:16+0000"
    }
  }
  ```

<br><br>

**3) Short Link를 통해 접속했을 때 원래 입력했던 URL로 redirect 해주는 API 개발**

- GET /r/{short_id}
- 302 redirect

<br><br>

**4) Test Code 작성**

- 위 요구 사항들이 만족하는 것을 검증할 수 있는 Test case들을 Test framework를 사용하여 작성해주세요.
- Test case들에 대해 이후 기술 면접에서 논의할 예정입니다







## 아쉬운점

- url 축소 부분에서 고민하다가 시간이 많이 흘렀는데, 결국 10억 건 데이터 처리할 때 완전히 유니크한 short_id 는 생각하지 못했습니다.

- 테스트 코드 작성후 케이스를 모두 실행 못해보고 마무리 하게 되었네요.. 아쉽지만 좋은 경험이었습니다.