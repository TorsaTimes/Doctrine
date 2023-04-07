const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  if (process.env.NODE_ENV !== 'development') {
    return;
  }
  app.use(
    '/backend',
    createProxyMiddleware({
      target: 'http://localhost:29101',
      secure: false,
      changeOrigin: true,
      logLevel: 'debug',
      pathRewrite: {
        '^/backend': '',
      },
    })
  );
};
