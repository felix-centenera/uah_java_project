# uah_java_project

1. Introducción, objetivos y justificación del proyecto
2. Metodologías utilizadas.
3. Arquitectura y desarrollo:
  - Diagrama de la arquitectura del sistema.
  - Tecnologías utilizadas.
  - Flujos de información.
  - Lenguajes utilizados.
  - Herramientas.
  - Pruebas.
4. Características
5. Bibliografía


Ejemplos sintaxis básicos:


* Tabla:

```
| Syntax | Description |
| --- | ----------- |
| Header | Title |
| Paragraph | Text |
```

* Doc: dummy example:

```
  float operador1, operador2;
  System.out.println("Introduzca el primer operador");
  operador1 = Float.parseFloat(sc.nextLine());

  System.out.println("Introduzca el segundo operador");
  operador2 = Float.parseFloat(sc.nextLine());
  System.out.println("\n");
  float resultado = 0;
  switch (opcion) {
      case 1 : resultado = operador1 + operador2;
          break;
      case 2 : resultado = operador1 - operador2;
          break;
      case 3: resultado = operador1 * operador2;
          break;
      case 4: resultado = operador1 / operador2;
          break;
      case 5: resultado = (float) Math.pow(operador1, operador2 );
          break;
        }
        System.out.println(resultado);
```
