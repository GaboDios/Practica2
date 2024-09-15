Nombre del Equipo: Los hijos de Korhal
Integrantes del Equipo:

Pedro Yamil Salazar González - 306037445
Gabriel Díaz Payne - 317097560
Isaac Rivera Jiménez - 321225087
Práctica: Práctica 2

Sistema operativo utilizado:
Se ha utilizado Linux para realizar la práctica, con la versión de Java "21.0.4".

Para ejecutar el programa escriba en la terminal javac *.java y luego java SimuladorViaje.

Patrones de diseño a utilizar:
Template: Este patrón define el flujo general de acciones en un vehículo, como recargar combustible y seguir una ruta. Todos los vehículos comparten un flujo básico, pero cada uno tiene implementaciones específicas que dependen del tipo de vehículo. Además, se utiliza un método hook, llamado clienteRequiereTerraceria(), para preguntar al usuario si el trayecto será por terracería o por carretera. Este comportamiento personalizado se implementa en las clases concretas que heredan de VehMos, como Carro, Motocicleta, Vehiculo4x4, Autobus y Scooter.

State: Este patrón gestiona los distintos estados del simulador de vehículos autónomos. Los estados incluyen: EnEspera, ComenzarViaje, EnMovimiento, AlertaDeCombustible, y ViajeFinalizado. Las transiciones entre estos estados dependen de eventos, como la verificación de ID, el estado del combustible, o la llegada a destino. El comportamiento del vehículo cambia dependiendo del estado actual, y las transiciones son manejadas mediante métodos específicos en la interfaz State, como verificaID(), seguirRuta(), sinCombustible(), recargar(), verificarUbicacion(), y finalizaViaje().

Iterator: Este patrón se utiliza para recorrer la lista de "tuneos" o modificaciones disponibles en el simulador, permitiendo al usuario seleccionar hasta 6 de los 12 aditamentos propuestos. Además, el Iterator se usa para recorrer y seleccionar el mapeo de coordenadas de las rutas que los vehículos autónomos seguirán durante el trayecto.

Decorator: El patrón Decorator permite agregar características adicionales a los vehículos sin modificar su estructura original. Cada componente se puede usar solo o envuelto por un decorador. Cada decorador envuelve un componente, lo que significa que el decorador tiene una variable de instancia que contiene una referencia a ese componente. Ejemplos de estos "tuneos" incluyen accesorios decorativos como dados de peluche, alerones, y aromatizadores. Estas características pueden aplicarse dinámicamente a los vehículos de VehMos, extendiendo su funcionalidad y personalización de forma flexible.
