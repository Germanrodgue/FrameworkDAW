# Framework 1º DAW

**Leer Readme en [**Ingles**](README_ENG.md)**

Proyecto para el segundo trimestre de el modulo de Programación creado por **Germán Rodríguez**. 


#Función
Consiste en un menú CRUD realizado en java.
La aplicación principalmente permite [**Crear**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_create.java), [**Leer**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_read.java), [**Actualizar**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_update.java) y [**Borrar**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_delete.java) tres tipos de usuarios: 

1.  Administradores
2.  Clientes 
3.  Usuarios normales

Cada uno tiene sus propios atributos y algunos de ellos se recalculan automaticamente, como por ejemplo el Usuario normal tiene puntuacion dependiendo de sus comentarios. Los usuarios se guardan en tres archivos (JSON, XML, TXT) cada vez que se cierra la aplicación y se cargan automaticamente cada vez que se abre.

#Caracteristicas del menú

**1) Crear**
 1. La opción de crear usuarios es un formulario con varios campos, cada uno de ellos controlados por una expresión regular.
 2. No se pueden crear dos usuarios con el mismo DNI, nombre de usuario o correo electronico.

**2) Leer**
 1. La opción de leer usuarios permite ver los datos de todos los usuarios o de un usuario en concreto.
 2. Muestra el avatar de el usuario con un objeto de la clase ImageIcon (3 avatares para elegir en la aplicación).
 3. Recalcula el salario de el Administrador y los puntos de el Cliente y el Usuario normal.

**3) Actualizar**
 1. Mediante un combobox permite seleccionar que usuario queremos actualizar y al seleccionarlo con otro combobox nos da a elegir que         atributo cambiar.
 2. Expresiones regulares para controlar que el cambio de datos sea correcto.
 3. Recalcula el salario de el Administrador y los puntos de el Cliente y el Usuario normal.
 
**4) Borrar**
 1. Permite borrar todos o un usuario en concreto.

**5) Obtener**
 1. Muestra un atributo en concreto de el usuario que seleccionemos.
 
**6) Ordenar**
 1. Permite ordenar los usuarios dependiendo de el atributo que seleccionemos.

**7 y 8) Abrir y cerrar**
 1. Permite abrir y guardar un archivo JSON, XML  o TXT con información de los usuarios.
 2. Por defecto abre y guarda archivos JSON.

 
#Menu de Ajustes

Formulario que utiliza elementos como Jspinner, combobox y checkbox.                                                                  Este menú permite cambiar algunas preferencias del usuario como puede ser (La primera opción es la que está por defecto):

1. Formato de la fecha: dd/mm/yyyy, yyyy/mm/dd, dd-mm-yyyy, yyyy-mm-dd
2. Formato de la moneda:  Euros, Libras o Dolares.
3. Formato de los decimales: .0, .00, .000
4. Formato de los archivos: JSON, XML o TXT.
5. Idioma: Ingles, Español o Valenciano.
6. Tema: GTK, Motif, Metal o Ninbus
7. Activar o desactivar la creación automatica de usuarios.
8. Boton de Reset para volver a la configuración por defecto.

**El menu de ajustes guarda automáticamente en un archivo JSON las preferencias del usuario y se cargan cada vez que entra en la aplicación, además si el usuario esta utilizando la aplicación y vuelve a entrar a este menú, se cargan automaticamente las preferencias.**

#Javadoc

Este proyecto cuenta con la documentación escrita en javadoc para que cualquier persona pueda consultarla, las tres clases del módulo de usuarios estan comentadas y explicadas en el mismo archivo.
