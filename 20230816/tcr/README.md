# Test && Commit || Revert

TCR 실습하기.

(TCR: 테스트가 성공하면 커밋, 실패하면 되돌리는 개발 방법)

## VSCode 설정
실습을 위한 설정을 한다.

`.vscode/settings.json`:
```json
{
  "runOnSave.commands": [
    {
      "match": ".*\\.py",
      "command": "clear; python ${file} && git commit -am working || git reset --hard",
      "runIn": "terminal"
    }
  ]
}
```

## 참고
https://www.youtube.com/watch?v=tnO2Mos0RjU

