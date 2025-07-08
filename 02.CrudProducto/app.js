const express = require('express');
const app = express();
const productoRoutes = require('./routes/producto.routes');
const errorHandler = require('./middlewares/errorHandler');

app.use(express.json());
app.use('/api/productos', productoRoutes);
app.use(errorHandler);

module.exports = app;
