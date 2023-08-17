![Wordle](assets/WORDLE2.png)

Bienvenido a Wordle, un juego de adivinar palabras basado en Java creado para un proyecto universitario. 
Este juego permite a dos jugadores participar en un desafío de adivinanzas de palabras. El Jugador 1 selecciona una palabra secreta de 3, 4 o 5 letras, y el Jugador 2 intenta adivinar la palabra. 
El Jugador 2 recibe 8 intentos sobre sus suposiciones, y en cada uno de esos intentos se recibe un feedback: las letras correctas se muestran verdes, las letras mal ubicadas naranja y las letras incorrectas grises. 
Además, se lleva un registro de los intentos exitosos del Jugador 2 en un tablero de clasificación. Ten en cuenta que el tablero de clasificación se reinicia cuando se cierra la aplicación.

## Características

- **Dos Jugadores:** Disfruta de una experiencia multijugador, no esta basado en un servidor que proporciona una palabra diaria como el juego original, si no que es el jugador 1 quien proporciona la palabra a adivinar al jugador 2.
- **Selección de Palabra:** El Jugador 1 elige una palabra secreta de 3, 4 o 5 letras.
- **Adivina la palabra:** El Jugador 2 adivina la palabra y recibe feedback sobre sus suposiciones.
- **Ranking:** Lleva un registro de las adivinanzas exitosas y muestra los nombres de los Jugadores 2 en un tablero de clasificación.
- **Ventana de Victoria:** Cuando el Jugador 2 gana, puede ingresar su nombre para ser reconocido en el tablero de clasificación, acceder al ranking, volver a jugar o salir de la aplicación.
- **Ventana de Derrota:** Cuando el Jugador 2 gana, puede ingresar su nombre para ser reconocido en el tablero de clasificación, acceder al ranking, volver a jugar o salir de la aplicación.

## Cómo Jugar

1. **Pantalla principal**
   - Inicia la aplicación y dale al botón JUGAR.
     
2. **Jugador 1:**
   - Elige una palabra de 3, 4 o 5 letras.
   - Dale al botón JUGAR.
     
3. **Jugador 2:**
   - Ingresa una suposición de palabra en el campo de texto proporcionado y dale al botón ENTER.
   - Recibe feedback sobre tu suposición:
     - Letras Correctas: Letras que están presentes en la posición correcta se mostrarán en color verde.
     - Letras Incorrectas: Letras que no están en la palabra secreta se mostrarán en color gris.
     - Letras Mal Ubicadas: Letras que están presentes en la palabra secreta pero en la posición incorrecta se mostrarán en color amarillo.
   - Continúa adivinando hasta que adivines correctamente la palabra secreta o se te acaben los intentos.
   
4. **Victoria:**
   - Cuando el Jugador 2 adivina correctamente la palabra secreta, aparecerá una ventana de "Victoria".
   - Ingresa tu nombre para ser incluido en el ranking.
   
5. **Derrota:**
   - Si el Jugador 2 agota sus intentos, aparecerá una ventana de "Derrota".
   - Elige entre cerrar la aplicación o comenzar un nuevo juego.
   
6. **Tablero de Clasificación:**
   - El tablero de clasificación muestra los nombres de los Jugadores 2 que adivinaron correctamente.
   - El tablero de clasificación se reinicia al cerrar la aplicación.

## Inicio Rápido

1. Clona el repositorio en tu máquina local.

2. Abre el proyecto en NetBeans.

3. Ejecuta la aplicación y sigue las instrucciones en las ventanas respectivas para el Jugador 1 y el Jugador 2.

## Dependencias

- Java (JDK 17)
- Apache NetBeans IDE 18

## Colaboradores

Este proyecto fue desarrollado como un proyecto universitario por [Jordi Beltran] y [Alberto Játiva] con Java utilizando la arquitectura Modelo - Vista - Controlador.

## Licencia

Este proyecto está bajo la [Licencia MIT](LICENSE).
