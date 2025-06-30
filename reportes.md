REPORTE SEMANAL 1

Número de grupo: 
12

Link repositorio: 
https://github.com/byNoRx/proyecto

¿Qué han avanzado?: 
Se diseño el diagrama de casos de uso para el sistema de gestión de torneos a 
mano. Se implementaron las clases Torneo, TorneoBuilder, Participante, Jugador 
y Equipo. Para la clase TorneoBuilder se aplicó el patrón de diseño 
"Builder". Jugador y Equipo son subclases de la clase abstracta Participante.

¿Qué planean avanzar?:
Se planea implementar métodos para añadir y remover participantes de un torneo, 
implementar diferentes formatos para el torneo, una clase builder para los 
Participantes (jugadores y equipos) e implementar la generación del calendario 
de encuentros o brackets.

Dudas:
¿Hay algún otro patrón de diseño recomendado para el sistema de gestión de 
torneos?

................................................................................

REPORTE SEMANAL 2

Número de grupo: 
12

Link repositorio: 
https://github.com/byNoRx/proyecto

¿Qué han avanzado?: 
Se digitalizó el diagrama de casos de uso, se implementaron métodos para añadir 
y remover participantes de un torneo, se comenzó a usar el patrón Strategy para 
próximamente implementar los formatos del torneo, como eliminatoria directa, 
eliminatoria doble y liga simple. También se implementó una clase builder para 
la clase Jugador y Equipo.

¿Qué planean avanzar?:
Implementar la clase Partido, implementar la generación de partidos y 
fechas para los tres formatos del torneo. Añadir más métodos para el torneo, 
excepciones personalizadas, la interfaz de usuario y los tests unitarios.

Dudas:
¿Usar el patrón de diseño "Strategy" para hacer los formatos del torneo es
una buena idea?