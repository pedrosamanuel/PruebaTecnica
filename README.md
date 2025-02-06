# README - Tienda de Productos

## Consignas

El proyecto debe implementar la funcionalidad básica de una tienda de productos con las siguientes características:

- Se podrán almacenar productos (código, nombre, precio, categoría), y vendedores (código, nombre, sueldo).
- Al registrar una venta, se debe relacionar el producto con el vendedor que realizó la venta.
- Se debe calcular la comisión de ventas por cada vendedor, que se obtiene del 5% de las ventas realizadas en el caso de vender hasta dos productos y un 10% al vender más de dos productos.
- Se implementarán distintos tipos de buscadores de productos, por ejemplo, por categoría.
- La aplicación debe manejar excepciones correctamente.
- Se deberá diseñar un Diagrama de Entidad Relación (ER) para la solución. Este diagrama se encuentra en el archivo PDF de cómo resolví el problema mediante clases.

## Introducción
 El programa se basa en un Punto de Venta (POS), en el cual tiene productos cargados como ejemplo, que se muestran a continuación:

| codProduct | name      | price | category |
|------------|-----------|-------|----------|
| 1          | CocaCola  | 1000  | Bebida   |
| 2          | Fanta     | 500   | Bebida   |
| 3          | Manzana   | 1     | Comida   |
  
- El código para todas las entidades es autogenerado.

## Implementación

La solución implementa una tienda de productos con los siguientes aspectos clave:

### 1. Registro de Ventas

- Al registrar una venta, se registra la relación entre el producto vendido y el vendedor que realizó la venta.
- Se calcula la comisión del vendedor al final de cada venta.

### 2. Cálculo de Comisión (Patrón Strategy)

- Se utiliza el patrón de diseño **Strategy** para calcular la comisión de los vendedores.
- La comisión depende de la cantidad de productos vendidos:
  - 5% si se venden hasta dos productos.
  - 10% si se venden más de dos productos.

### 3. Aplicación de Descuentos (Patrón Factory)

- Se utiliza el patrón de diseño **Factory** para determinar qué tipo de descuento aplicar a los productos.
- Los descuentos se determinan basándose en la cantidad de productos de una venta.

### 4. Búsqueda de Productos

- La aplicación implementa distintos tipos de buscadores de productos:
  - **Por categoría**: Permite filtrar productos por su categoría.
  - **Por nombre**: Permite buscar productos por su nombre.
  - **Por código**: Permite buscar productos por su código.

### 5. Manejo de Excepciones

- Se ha implementado un manejo de excepciones adecuado para cada tipo de error que pueda ocurrir durante la ejecución del sistema.

### 6. Diagrama de Entidad Relación (ER)

- El diagrama de entidad-relación se encuentra en el archivo PDF que describe cómo se resolvió el problema mediante clases. Este diagrama muestra la relación entre las entidades **Producto**, **Vendedor**, y **Venta**.

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Descarga el archivo `PruebaTecnica-1.0-SNAPSHOT.jar`.
2. Navega al directorio donde se encuentra el archivo JAR.
3. Ejecuta el siguiente comando en la terminal:

    ```bash
    java -jar PruebaTecnica-1.0-SNAPSHOT.jar
    ```
