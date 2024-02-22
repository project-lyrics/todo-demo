# TODO APP DEMO

이 프로젝트는 project-lyrics의 BE파트 컨벤션과 아키텍쳐 협의를 위한 레포지토리입니다.

이 프로젝트는 formatter로 checkstyle을 사용하고, google style을 약간 수정하여 사용합니다.

커밋 전 반드시 `./gradlew checkstyleMain`을 실행해주세요.

```shell
echo "./gradlew checkstyleMain; git add ." > .git/hooks/pre-commit
chmod +x .git/hooks/pre-commit
```