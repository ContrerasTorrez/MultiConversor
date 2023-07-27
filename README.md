# Nombre del Repositorio: MultiConversor

### Descripción:
Este repositorio contiene una aplicación de escritorio desarrollada en Java utilizando Swing. La aplicación tiene la función de convertir monedas entre DOP, USD, EUR, JPY y KRW, así como también permite realizar conversiones de temperaturas entre Kelvin, Celsius y Fahrenheit.

* Características:
  * ***Conversor de Monedas :***
    Permite convertir entre las siguientes monedas: DOP (Peso Dominicano), USD (Dólar Estadounidense), EUR (Euro), JPY (Yen Japonés) y KRW (Won Surcoreano).
  * ***Conversor de Temperatura :*** Permite convertir entre las siguientes escalas de temperatura: Kelvin, Celsius y Fahrenheit.

### Instrucciones de Uso:

1. Clona o descarga el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE de Java preferido (por ejemplo, Eclipse, IntelliJ, NetBeans) preferiblemente IntelliJ.
3. Ejecuta la aplicación desde la clase principal src/main/java/com/contrerastorrez/Main.java.


  1. En el campo "Tipo de conversion" seleccione la opcion "MONEDAS" o "TEMPERATURA" dependiendo de lo que necesites convertir.
     ![tipo de conversion](assets/seccion-tipo-convercion.png)
  2. Ingrese la cantidad en el campo "Cantidad". 
     ![tipo de conversion](assets/seccion-cantidad.png)
  3. seleccione la moneda de origen y la moneda de destino en los menús desplegables correspondientes.
     ![tipo de conversion](assets/seccion-desplegables_from_to.png)
  4. Haga clic en el botón "Convertir" para obtener el resultado de la conversión.
     ![tipo de conversion](assets/seccion-boton_convertir.png)

### Estructura del proyecto: 
    MultiConversor/
    ├── src/main/java/com/contrerastorrez/
    │   ├── entitys/
    │   │   ├── Conversiones.java
    │   │   ├── Monedas.java
    │   │   └── Temperatura.java
    │   ├── views/
    │   │   ├── MainFrame.java
    │   │   └── MainFrame.form
    │   └── ...
    ├── assets/
    │   ├── seccion-boton_convertir.png
    │   └── seccion-cantidad.png
    │   └── seccion-desplegables_from_to.png
    │   └── seccion-tipo-convercion.png
    │   └── arrows.png
    ├── README.md
    ├── pom.xml
    └── ...
