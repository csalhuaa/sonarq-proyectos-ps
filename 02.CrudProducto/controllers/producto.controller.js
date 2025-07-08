const { validationResult } = require('express-validator');
const servicio = require('../services/producto.service');

exports.obtenerTodos = (req, res) => {
  res.json(servicio.obtenerTodos());
};

exports.obtenerPorId = (req, res) => {
  const producto = servicio.obtenerPorId(req.params.id);
  if (!producto) return res.status(404).json({ mensaje: 'Producto no encontrado' });
  res.json(producto);
};

exports.crear = (req, res) => {
  const errores = validationResult(req);
  if (!errores.isEmpty()) return res.status(400).json({ errores: errores.array() });
  const nuevo = servicio.crear(req.body);
  res.status(201).json(nuevo);
};

exports.actualizar = (req, res) => {
  const errores = validationResult(req);
  if (!errores.isEmpty()) return res.status(400).json({ errores: errores.array() });
  const actualizado = servicio.actualizar(req.params.id, req.body);
  if (!actualizado) return res.status(404).json({ mensaje: 'Producto no encontrado' });
  res.json(actualizado);
};

exports.eliminar = (req, res) => {
  const eliminado = servicio.eliminar(req.params.id);
  if (!eliminado) return res.status(404).json({ mensaje: 'Producto no encontrado' });
  res.json({ mensaje: 'Producto eliminado' });
};
