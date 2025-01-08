Los objetivos concretos de la práctica son:
● Profundizar en los modelos de comunicación síncrona/asíncrona para procesos
distribuidos.
● Asentar en los conceptos aprendidos a lo largo de la asignatura sobre la
programación concurrente y distribuida.
● Aprender a trabajar en grupo.

se implementa 3 operaciones 
PostNote (PN)
RemoveNote (RN)
ReadNote (ReadN)

Las tuplas del sistema a desarrollar tendrán un tamaño variable, que nunca superará la
longitud máxima de seis elementos, y siempre todos ellos serán de tipo String.

A continuación se muestra una esquema de la arquitectura que debe tener el sistema
de coordinación distribuido LINDA. Los clientes que se conecten a él, podrán realizar
cualquiera de las siguientes cinco operaciones:
● Conectarse al servicio.
● Desconectarse del servicio.
● Cualquiera de las tres operaciones básicas para trabajar con tuplas.
