module.exports = (req, res, next) => {
  const ahora = new Date().toISOString();
  console.log(`[${ahora}] ${req.method} ${req.originalUrl}`);
  next();
};
