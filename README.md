# Practica2
Nombre del Equipo: 
                      Los hijos de Korhal

Integrantes del Equipo:                                    Numero de cuenta

                      Pedro Yamil Salazar Gonzalez            306037445
                      Gabriel Diaz Payne                      317097560
                      Isaac Rivera Jimenez                    321225087

Practica: Practica2

Sistema operativo utilizado:

Se ha ocupado Linux para realizar la práctica, con la versión de Java "21.0.4"

Patrones de diseño a utilizar:

Template: Define el comportamietno de cada automovil en movimiento, como recargar combustible y seguir ruta. El flujo básico será el mismo para todos los automoviles, pero cada uno puede tener variaciones específicas según la ruta y las funciones que este utilice durante su trayecto.

State: Cambia el comportamiento del robot dependiendo de su estado. Los estados son: en espera, en movimiento, recarga de combustible. Las transiciones entre estos estados deben actualizar el seguimiento de la ruta y la visualización en la terminal.

Iterator: Recorre la lista de de los "tuneos" o modifiaciones disponibles  y permite al usuario seleccionar 6 de los 12 aditamentos propuestos. Además, recorre el mapeo de coordenadas para que el usuario los seleccione la ruta que seguira.

Decorator: Permite agregar accesorios a los vehiculos de Vehemos sin modificar su estructura original. Los accesorios, como los dados de peluche, el aleron y el aromatizador se pueden aplicar al vehiculo de manera dinámica y decorativa.



