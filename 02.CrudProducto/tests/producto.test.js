const request = require('supertest');
const app = require('../app');

describe('API Productos', () => {
  let id;

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
    expect(res.body.length).toBeGreaterThan(0);
  });

  it('Obtiene producto por ID', async () => {
    const res = await request(app).get(`/api/productos/${id}`);
    expect(res.statusCode).toBe(200);
    expect(res.body.id).toBe(id);
  });
});
