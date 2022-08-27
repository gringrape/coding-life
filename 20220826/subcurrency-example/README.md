## Subcurrency example
- source - https://docs.soliditylang.org/en/v0.8.16/introduction-to-smart-contracts.html

## 환경 설정
### Initialize
```
truffle init
```

`truffle-config.js`:
```javascript
module.exports = {
  networks: {
    development: {
     host: "127.0.0.1",  
     port: 8545,         
     network_id: "*",    
    },    
  },
  compilers: {
    solc: {
      version: "0.8.16",
    }
  },
};

```

```
npm init -y
```

`package.json`:
```javascript
{
  "name": "subcurrency-example",
  "version": "1.0.0",
  "scripts": {}
}

```

### ESLint
```bash
npx eslint --init
```

`.eslintrc.js`:
```javascript
module.exports = {
  env: {
    es2021: true,
    node: true,
  },
  extends: 'airbnb-base',
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
  },
  rules: {
    indent: ['error', 2],
    'no-trailing-spaces': 'error',
    curly: 'error',
    'brace-style': 'error',
    'no-multi-spaces': 'error',
    'space-infix-ops': 'error',
    'space-unary-ops': 'error',
    'no-whitespace-before-property': 'error',
    'func-call-spacing': 'error',
    'space-before-blocks': 'error',
    'keyword-spacing': ['error', { before: true, after: true }],
    'comma-spacing': ['error', { before: false, after: true }],
    'comma-style': ['error', 'last'],
    'comma-dangle': ['error', 'always-multiline'],
    'space-in-parens': ['error', 'never'],
    'block-spacing': 'error',
    'array-bracket-spacing': ['error', 'never'],
    'object-curly-spacing': ['error', 'always'],
    'key-spacing': ['error', { mode: 'strict' }],
    'arrow-spacing': ['error', { before: true, after: true }],
    'import/no-extraneous-dependencies': ['error', {
      devDependencies: [
        '**/*.test.js',
      ],
    }],
    'import/extensions': ['error', 'ignorePackages', {
      js: 'never',
    }],
  },
};

```

