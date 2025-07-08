const { body } = require('express-validator');

exports.validarProducto = [
  body('nombre').notEmpty().withMessage('El nombre es obligatorio'),
  body('precio')
    .isFloat({ gt: 0 }).withMessage('El precio debe ser un número positivo'),
  body('stock')
    .isInt({ min: 0 }).withMessage('El stock debe ser un entero no negativo'),
];

exports.validarProductoParcial = [
  body('nombre').optional().notEmpty().withMessage('El nombre no puede estar vacío'),
  body('precio').optional().isFloat({ gt: 0 }).withMessage('El precio debe ser un número positivo'),
  body('stock').optional().isInt({ min: 0 }).withMessage('El stock debe ser un entero no negativo'),
];
