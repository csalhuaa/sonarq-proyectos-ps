const express = require('express');
const { body } = require('express-validator');
const router = express.Router();
const productoController = require('../controllers/producto.controller');

router.get('/', productoController.obtenerTodos);
router.get('/:id', productoController.obtenerPorId);
router.post(
  '/',
  [
    body('nombre').notEmpty().withMessage('El nombre es obligatorio'),
    body('precio').isFloat({ gt: 0 }).withMessage('El precio debe ser positivo'),
    body('stock').isInt({ min: 0 }).withMessage('El stock debe ser un entero positivo'),
  ],
  productoController.crear
);
router.put(
  '/:id',
  [
    body('nombre').optional().notEmpty(),
    body('precio').optional().isFloat({ gt: 0 }),
    body('stock').optional().isInt({ min: 0 }),
  ],
  productoController.actualizar
);
router.delete('/:id', productoController.eliminar);

module.exports = router;
