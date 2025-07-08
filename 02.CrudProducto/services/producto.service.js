// services/producto.service.js

const fs = require('fs/promises');
const path = require('path');

const archivoPath = path.join(__dirname, '..', 'data', 'productos.json');

const leerProductos = async () => {
  const datos = await fs.readFile(archivoPath, 'utf-8');
  return JSON.parse(datos);
};

const guardarProductos = async (productos) => {
  await fs.writeFile(archivoPath, JSON.stringify(productos, null, 2));
};

exports.obtenerTodos = async () => {
  return await leerProductos();
};

exports.obtenerPorId = async (id) => {
  const productos = await leerProductos();
  return productos.find(p => p.id === Number(id));
};

exports.crear = async ({ nombre, precio, stock }) => {
  const productos = await leerProductos();
  const nuevo = {
    id: productos.length > 0 ? productos[productos.length - 1].id + 1 : 1,
    nombre,
    precio,
    stock
  };
  productos.push(nuevo);
  await guardarProductos(productos);
  return nuevo;
};

exports.actualizar = async (id, datos) => {
  const productos = await leerProductos();
  const index = productos.findIndex(p => p.id === Number(id));
  if (index === -1) return null;
  productos[index] = { ...productos[index], ...datos };
  await guardarProductos(productos);
  return productos[index];
};

exports.eliminar = async (id) => {
  const productos = await leerProductos();
  const index = productos.findIndex(p => p.id === Number(id));
  if (index === -1) return false;
  productos.splice(index, 1);
  await guardarProductos(productos);
  return true;
};

exports.obtenerConStockBajo = async (limite = 5) => {
  const productos = await leerProductos();
  return productos.filter(p => p.stock < limite);
};
