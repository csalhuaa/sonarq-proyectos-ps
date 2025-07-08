const lista = document.getElementById('lista-productos');
const form = document.getElementById('formulario');

const modalEditar = new bootstrap.Modal(document.getElementById('modalEditar'));
const formEditar = document.getElementById('formEditar');

const cargarProductos = async () => {
  const res = await fetch('/api/productos');
  const productos = await res.json();
  lista.innerHTML = '';

  productos.forEach(p => {
    const li = document.createElement('li');
    li.className = 'list-group-item d-flex justify-content-between align-items-center';
    li.innerHTML = `
      <div>
        <strong>${p.nombre}</strong><br>
        Precio: $${p.precio} - Stock: ${p.stock}
      </div>
      <div>
        <button class="btn btn-sm btn-warning me-2" onclick="editarProducto(${p.id})">Editar</button>
        <button class="btn btn-sm btn-danger" onclick="eliminarProducto(${p.id})">Eliminar</button>
      </div>
    `;
    lista.appendChild(li);
  });
};

form.addEventListener('submit', async e => {
  e.preventDefault();
  const nombre = document.getElementById('nombre').value;
  const precio = parseFloat(document.getElementById('precio').value);
  const stock = parseInt(document.getElementById('stock').value);

  const res = await fetch('/api/productos', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ nombre, precio, stock })
  });

  if (res.ok) {
    form.reset();
    cargarProductos();
  } else {
    const data = await res.json();
    alert(data.errores?.[0]?.msg || 'Error al crear producto');
  }
});

// Eliminar
window.eliminarProducto = async (id) => {
  if (confirm('¿Deseas eliminar este producto?')) {
    const res = await fetch(`/api/productos/${id}`, { method: 'DELETE' });
    if (res.ok) cargarProductos();
    else alert('Error al eliminar');
  }
};

// Editar
window.editarProducto = async (id) => {
  const res = await fetch(`/api/productos/${id}`);
  if (!res.ok) return alert('Producto no encontrado');

  const prod = await res.json();
  document.getElementById('edit-id').value = prod.id;
  document.getElementById('edit-nombre').value = prod.nombre;
  document.getElementById('edit-precio').value = prod.precio;
  document.getElementById('edit-stock').value = prod.stock;

  modalEditar.show();
};

// Guardar edición
formEditar.addEventListener('submit', async e => {
  e.preventDefault();
  const id = document.getElementById('edit-id').value;
  const nombre = document.getElementById('edit-nombre').value;
  const precio = parseFloat(document.getElementById('edit-precio').value);
  const stock = parseInt(document.getElementById('edit-stock').value);

  const res = await fetch(`/api/productos/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ nombre, precio, stock })
  });

  if (res.ok) {
    modalEditar.hide();
    cargarProductos();
  } else {
    const data = await res.json();
    alert(data.errores?.[0]?.msg || 'Error al actualizar');
  }
});

cargarProductos();
