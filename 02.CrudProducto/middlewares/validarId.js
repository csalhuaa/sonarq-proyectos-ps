module.exports = (req, res, next) => {
  if (isNaN(req.params.id)) {
    return res.status(400).json({ mensaje: 'ID inválido' });
  }
  next();
};
