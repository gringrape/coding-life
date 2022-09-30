const servor = require('servor');

servor({
  root: '.',
  fallback: 'index.html',
  module: false,
  static: false,
  reload: false,
  port: process.env.PORT || 8080,
});
