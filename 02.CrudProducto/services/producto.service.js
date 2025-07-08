const productos = [];
let idActual = 1;

exports.obtenerTodos = () => productos;

exports.obtenerPorId = (id) => productos.find(p => p.id === Number(id));

exports.crear = ({ nombre, precio, stock }) => {
  const nuevo = { id: idActual++, nombre, precio, stock };
  productos.push(nuevo);
  return nuevo;
};

exports.actualizar = (id, datos) => {
  const index = productos.findIndex(p => p.id === Number(id));
  if (index === -1) return null;
  productos[index] = { ...productos[index], ...datos };
  return productos[index];
};

exports.eliminar = (id) => {
  const index = productos.findIndex(p => p.id === Number(id));
  if (index === -1) return false;
  productos.splice(index, 1);
  return true;
};
