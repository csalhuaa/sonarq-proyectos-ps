const { validationResult } = require('express-validator');
const servicio = require('../services/producto.service');

exports.obtenerTodos = async (req, res, next) => {
  try {
    const productos = await servicio.obtenerTodos();
    res.json(productos);
  } catch (err) {
    next(err);
  }
};

exports.obtenerPorId = async (req, res, next) => {
  try {
    const producto = await servicio.obtenerPorId(req.params.id);
    if (!producto) return res.status(404).json({ mensaje: 'Producto no encontrado' });
    res.json(producto);
  } catch (err) {
    next(err);
  }
};

exports.crear = async (req, res, next) => {
  try {
    const errores = validationResult(req);
    if (!errores.isEmpty()) return res.status(400).json({ errores: errores.array() });
    const nuevo = await servicio.crear(req.body);
    res.status(201).json(nuevo);
  } catch (err) {
    next(err);
  }
};

exports.actualizar = async (req, res, next) => {
  try {
    const errores = validationResult(req);
    if (!errores.isEmpty()) return res.status(400).json({ errores: errores.array() });
    const actualizado = await servicio.actualizar(req.params.id, req.body);
    if (!actualizado) return res.status(404).json({ mensaje: 'Producto no encontrado' });
    res.json(actualizado);
  } catch (err) {
    next(err);
  }
};

exports.eliminar = async (req, res, next) => {
  try {
    const eliminado = await servicio.eliminar(req.params.id);
    if (!eliminado) return res.status(404).json({ mensaje: 'Producto no encontrado' });
    res.json({ mensaje: 'Producto eliminado' });
  } catch (err) {
    next(err);
  }
};

exports.obtenerConStockBajo = async (req, res, next) => {
  try {
    const limite = Number(req.query.limite) || 5;
    const resultado = await servicio.obtenerConStockBajo(limite);
    res.json(resultado);
  } catch (err) {
    next(err);
  }
};
