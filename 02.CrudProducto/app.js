const express = require('express');
const path = require('path');
const app = express();

const logger = require('./middlewares/logger');
const errorHandler = require('./middlewares/errorHandler');

const productoRoutes = require('./routes/producto.routes');

app.get('/api', (req, res) => {
  res.json({ mensaje: 'API de Productos', version: '1.0.0' });
});

app.use(express.json());
app.use(logger);

app.use(express.static(path.join(__dirname, 'public')));

app.use('/api/productos', productoRoutes);
app.use(errorHandler);

module.exports = app;
