# TypeScript + Jest

목 함수에 대한 테스트를 작성 할때, 타입을 어떻게 써야하는지 실험.

## 구상
### 구성
사용자 정보를 받아와서, 나이가 40세 미만인 사람만을 반환하는 함수를 작성한다. 

- 사용자 정보는 외부에 존재한다. - https://dummyjson.com/docs/users
	
### 실험하고자 하는 것
mock 함수에 대한 타입을 어떻게 잡아야 하는지

## 환경 설정
### 프로젝트 시작
```bash
npm init -y
```

### Jest
@swc/jest
```bash
npm i -D jest @swc/core @swc/jest
```

`jest.config.js`:
```typescript
module.exports = {
  transform: {
    '^.+\\.(t|j)sx?$': '@swc/jest',
  },
  extensionsToTreatAsEsm: ['.ts', '.tsx'],
}

```

타입 정보 추가
```bash
npm install --save-dev @types/jest
```

### EsLint
```bash
npx eslint --init
```

### ESLint 오류:
> ESLint: Error while loading rule '@typescript-eslint/dot-notation': You have used a rule which requires parserServices to be generated. You must therefore provide a value for the "parserOptions.project" property for @typescript-eslint/parser. Occurred while linting /Users/jin/study/coding-life/20220816/typescript-jest/sample.test.ts. Please see the 'ESLint' output channel for details.

해결 - https://stackoverflow.com/questions/64116378/error-while-loading-rule-typescript-eslint-dot-notation

```bash
npx tsc --init
```

`.eslintrc.js`:
```javascript

    parserOptions: {
        // ...
        project: ["path/to/your/tsconfig/file"]
        // ...
    },
```


