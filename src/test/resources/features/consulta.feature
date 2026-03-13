# language: es
Característica: Consulta y creación de tickets

  Escenario: Crear un ticket exitosamente como administrador
    Dado que el administrador abre la aplicación
    Y inicia sesión con credenciales válidas
    Cuando navega al formulario de creación de ticket
    Y completa los campos obligatorios del ticket
    Y guarda el ticket
    Entonces debe regresar al panel de tickets
    Y debe ver el ticket recién creado en el listado
