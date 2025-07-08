import pytest
from todolist import agregar_tarea, completar_tarea

def test_agregar_tarea():
    tareas = []
    agregar_tarea(tareas, "Estudiar para el examen")
    assert len(tareas) == 1
    assert tareas[0]["descripcion"] == "Estudiar para el examen"
    assert tareas[0]["completada"] is False

def test_completar_tarea_valido():
    tareas = [{"descripcion": "Comprar pan", "completada": False}]
    completar_tarea(tareas, 1)
    assert tareas[0]["completada"] is True

def test_completar_tarea_invalido():
    tareas = [{"descripcion": "Leer libro", "completada": False}]
    completar_tarea(tareas, 5)  # índice inválido, no debe lanzar error
    assert tareas[0]["completada"] is False
