# uah_java_project

1. Introducción, objetivos y justificación del proyecto
2. Metodologías utilizadas.
3. Arquitectura y desarrollo:
  3.4 Diagrama de la arquitectura del sistema.
  3.5 Tecnologías utilizadas.
  3.6 Flujos de información.
  3.7 Lenguajes utilizados.
  3.8 Herramientas.
  3.9 Pruebas.
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
