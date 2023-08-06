module.exports = {
    "env": {
        "browser": true,
        "es2021": true
    },
    "overrides": [
    ],
    "parser": "@typescript-eslint/parser", // if not already added
    "plugins": ["solid"],
    "extends": [
      'airbnb-base',
      'airbnb-typescript/base',
      "eslint:recommended", 
      "plugin:solid/typescript"
    ],
    "parserOptions": {
        "ecmaVersion": "latest",
        "sourceType": "module",
        "project": "tsconfig.json"
    },
    "ignorePatterns": ["**/*.cjs", "**/*.js"],
    "rules": {
        "import/extensions": ["error", {
            "ts | tsx": "always",
        }],
    },    
}
