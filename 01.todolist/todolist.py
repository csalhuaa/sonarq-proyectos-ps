"""
todolist.py - Lista de tareas desde consola.
Permite agregar, listar y marcar tareas como completadas.
"""

def mostrar_menu():
    """Muestra el menú principal."""
    print("\n--- Lista de Tareas ---")
    print("1. Ver tareas")
    print("2. Agregar tarea")
    print("3. Marcar tarea como completada")
    print("4. Salir")


def mostrar_tareas(tareas):
    """
    Muestra las tareas con su estado.
    
    Args:
        tareas (list): Lista de diccionarios con las tareas.
    """
    if not tareas:
        print("No hay tareas.")
        return

    for i, tarea in enumerate(tareas, start=1):
        estado = "✔" if tarea["completada"] else "✘"
        print(f"{i}. [{estado}] {tarea['descripcion']}")


def agregar_tarea(tareas, descripcion):
    """
    Agrega una nueva tarea a la lista.

    Args:
        tareas (list): Lista de tareas existentes.
        descripcion (str): Descripción de la nueva tarea.
    """
    tareas.append({"descripcion": descripcion, "completada": False})


def completar_tarea(tareas, indice):
    """
    Marca una tarea como completada.

    Args:
        tareas (list): Lista de tareas.
        indice (int): Índice (base 1) de la tarea a completar.
    """
    if 1 <= indice <= len(tareas):
        tareas[indice - 1]["completada"] = True
    else:
        print("Índice no válido.")


def main():
    tareas = []
    while True:
        mostrar_menu()
        opcion = input("Selecciona una opción (1-4): ")

        if opcion == "1":
            mostrar_tareas(tareas)
        elif opcion == "2":
            desc = input("Ingresa la descripción de la tarea: ").strip()
            if desc:
                agregar_tarea(tareas, desc)
            else:
                print("La descripción no puede estar vacía.")
        elif opcion == "3":
            mostrar_tareas(tareas)
            try:
                idx = int(input("Ingresa el número de la tarea completada: "))
                completar_tarea(tareas, idx)
            except ValueError:
                print("Por favor, ingresa un número válido.")
        elif opcion == "4":
            print("¡Hasta pronto!")
            break
        else:
            print("Opción inválida. Intenta nuevamente.")


if __name__ == "__main__":
    main()
