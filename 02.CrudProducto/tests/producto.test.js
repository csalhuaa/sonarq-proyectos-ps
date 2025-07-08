const request = require('supertest');
const app = require('../app');
const fs = require('fs/promises');
const path = require('path');

const dataPath = path.join(__dirname, '..', 'data', 'productos.json');

describe('API Productos', () => {
  let id;

  // Limpiar el archivo antes de comenzar
  beforeAll(async () => {
    await fs.writeFile(dataPath, '[]');
  });

  it('Crea un producto', async () => {
    const res = await request(app)
      .post('/api/productos')
      .send({ nombre: 'Manzana', precio: 1.5, stock: 10 });
    expect(res.statusCode).toBe(201);
    expect(res.body.nombre).toBe('Manzana');
    id = res.body.id;
  });

  it('Obtiene todos los productos', async () => {
    const res = await request(app).get('/api/productos');
    expect(res.statusCode).toBe(200);
    expect(Array.isArray(res.body)).toBe(true);
    expect(res.body.length).toBeGreaterThan(0);
  });

  it('Obtiene producto por ID', async () => {
    const res = await request(app).get(`/api/productos/${id}`);
    expect(res.statusCode).toBe(200);
    expect(res.body.id).toBe(id);
  });

  it('Actualiza un producto', async () => {
    const res = await request(app)
      .put(`/api/productos/${id}`)
      .send({ precio: 2.0 });
    expect(res.statusCode).toBe(200);
    expect(res.body.precio).toBe(2.0);
  });

  it('Elimina un producto', async () => {
    const res = await request(app).delete(`/api/productos/${id}`);
    expect(res.statusCode).toBe(200);
    expect(res.body.mensaje).toBe('Producto eliminado');
  });
});
