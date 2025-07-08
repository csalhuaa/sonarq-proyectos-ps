const express = require('express');
const router = express.Router();
const productoController = require('../controllers/producto.controller');
const {
  validarProducto,
  validarProductoParcial
} = require('../middlewares/validacionesProducto');
const validarId = require('../middlewares/validarId');

router.get('/', productoController.obtenerTodos);
router.get('/:id', validarId, productoController.obtenerPorId);
router.post('/', validarProducto, productoController.crear);
router.put('/:id', validarId, validarProductoParcial, productoController.actualizar);
router.delete('/:id', validarId, productoController.eliminar);

router.get('/stock/bajo', productoController.obtenerConStockBajo);


module.exports = router;
